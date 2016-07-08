package com.basededatos.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.basededatos.domain.Encuesta;
import com.basededatos.domain.EncuestaUsuario;
import com.basededatos.domain.Pregunta;
import com.basededatos.domain.Respuesta;
import com.basededatos.domain.RespuestaUsuario;
import com.basededatos.domain.Usuario;
import com.basededatos.dto.ResolverEncuestaDTO;
import com.basededatos.dto.ResolverEncuestaEncabezadoDTO;
import com.basededatos.dto.ResolverEncuestaSession;
import com.basededatos.service.EncuestaService;
import com.basededatos.service.EncuestaUsuarioServicio;
import com.basededatos.service.PreguntaService;
import com.basededatos.service.UsuarioService;


@Controller
public class EncuestaController {

	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	EncuestaService encuestaService;
	
	@Autowired
	PreguntaService preguntaService;
	
	@Autowired
	EncuestaUsuarioServicio encuestaUsuarioServicio;
	
	
	@RequestMapping(value="/encuestas/resolver", method = RequestMethod.GET)
	public String resolver(Model model) {
		
		model.addAttribute("usuarios", usuarioService.getAll());
		model.addAttribute("encuestas", encuestaService.getAll());
		model.addAttribute("resolverEncuestaEncabezadoDTO",new ResolverEncuestaEncabezadoDTO());
		
		return "encuestas/resolverEncuesta";
	}
	
	@RequestMapping(value="/encuestas/resolver/preguntas", method = RequestMethod.GET)
	public String resolverContinuacion(Model model,@ModelAttribute("resolverEncuestaEncabezadoDTO") ResolverEncuestaEncabezadoDTO resolverEncuestaEncabezadoDTO, HttpSession session) {
		
		setDatosSession(resolverEncuestaEncabezadoDTO, session);
		ResolverEncuestaSession resolverEncuestaSession = (ResolverEncuestaSession)session.getAttribute("resolverEncuestaSession");
		
		ResolverEncuestaDTO resolverEncuestaDTO = getPrimeraPregunta(resolverEncuestaSession);
		resolverEncuestaEncabezadoDTO = getEncabezado(resolverEncuestaSession);
		
		model.addAttribute("resolverEncuestaDTO",resolverEncuestaDTO);
		model.addAttribute("resolverEncuestaEncabezadoDTO",resolverEncuestaEncabezadoDTO);
		
		return "encuestas/resolverEncuestaContinuacion";
	}
	
	@RequestMapping(value="/encuestas/resolver/continuacion", method = RequestMethod.GET)
	public String resolverProximaPregunta(Model model,@ModelAttribute("resolverEncuestaDTO") ResolverEncuestaDTO resolverEncuestaDTO, HttpSession session) {

		ResolverEncuestaSession resolverEncuestaSession = (ResolverEncuestaSession)session.getAttribute("resolverEncuestaSession");
		addPreguntaActualAndProximaPregunta(resolverEncuestaDTO,resolverEncuestaSession);
		model.addAttribute("resolverEncuestaDTO",resolverEncuestaDTO);
		ResolverEncuestaEncabezadoDTO resolverEncuestaEncabezadoDTO = getEncabezado(resolverEncuestaSession);
		model.addAttribute("resolverEncuestaEncabezadoDTO",resolverEncuestaEncabezadoDTO);
		
		if (tieneProximaPregunta(resolverEncuestaDTO))
		{
			return "encuestas/resolverEncuestaContinuacion";
		}
		else
		{
			salvarEncuestaUsuario(resolverEncuestaSession);
			return "encuestas/resolverEncuestaFin";
		}
	}
	
	private void salvarEncuestaUsuario(ResolverEncuestaSession resolverEncuestaSession)
	{
		encuestaUsuarioServicio.save(resolverEncuestaSession.getEncuestaUsuario());
		
	}
	
	private boolean tieneProximaPregunta(ResolverEncuestaDTO resolverEncuestaDTO)
	{
		
		return resolverEncuestaDTO.getPreguntaActual() != null;
	}
	
	private void addPreguntaActualAndProximaPregunta( ResolverEncuestaDTO resolverEncuestaDTO,ResolverEncuestaSession resolverEncuestaSession )
	{
		
		RespuestaUsuario respuestaUsuario = crearUsuarioRespuesta(resolverEncuestaDTO);
	
		resolverEncuestaSession.getEncuestaUsuario().setPuntaje(resolverEncuestaSession.getEncuestaUsuario().getPuntaje() + resolverEncuestaDTO.getRespuestaActual().getPuntaje());
		resolverEncuestaSession.getEncuestaUsuario().getRespuestasUsuario().add(respuestaUsuario);
		
		Pregunta proxima =  resolverEncuestaSession.getPreguntas().get(resolverEncuestaSession.getNumeroDePreguntaActual());
		
		if (proxima != null)
		{
			proxima =  preguntaService.get(proxima.getId());
			resolverEncuestaDTO.setPreguntaActual(proxima);
			resolverEncuestaDTO.setRespuestaActual(proxima.getRespuestas().get(0));
			
		}else
		{
			resolverEncuestaDTO.setPreguntaActual(null);
		}
		resolverEncuestaSession.setNumeroDePreguntaActual(resolverEncuestaSession.getNumeroDePreguntaActual()+1);	
		
		resolverEncuestaSession.setPreguntaActual(resolverEncuestaDTO.getPreguntaActual());


	}

	private Map <Integer,Pregunta> getPreguntasMap(List<Pregunta> listPreguntas) {
		Map <Integer,Pregunta> map = (new TreeMap<Integer,Pregunta>());
		Integer i=0;
		for (Pregunta pregunta : listPreguntas) {
			map.put(i,pregunta);
			i++;
		}
		return map;
	}
	
	private RespuestaUsuario crearUsuarioRespuesta(ResolverEncuestaDTO resolverEncuestaDTO )
	{
		Respuesta respuestaActual = resolverEncuestaDTO.getRespuestaActual();
		RespuestaUsuario respuestaUsuario = new RespuestaUsuario();
		respuestaUsuario.setRespuesta(respuestaActual);
		respuestaUsuario.setPregunta(resolverEncuestaDTO.getPreguntaActual());
	
		return respuestaUsuario;
		
		
	}
	
	private void setDatosSession( ResolverEncuestaEncabezadoDTO resolverEncuestaEncabezadoDTO, HttpSession session)
	{
		ResolverEncuestaSession resolverEncuestaSession = new ResolverEncuestaSession();
		Encuesta encuesta = encuestaService.get(resolverEncuestaEncabezadoDTO.getEncuesta().getId());
		Usuario usuario = usuarioService.get(resolverEncuestaEncabezadoDTO.getUsuario().getId());
		
 	    // Pone los datos en la session 
		resolverEncuestaSession.setEncuesta(encuesta);
		resolverEncuestaSession.setUsuario(usuario);
		resolverEncuestaSession.setPreguntas(getPreguntasMap(encuesta.getPreguntas()));
		resolverEncuestaSession.setNumeroDePreguntaActual(1);
		resolverEncuestaSession.setEncuestaUsuario(new EncuestaUsuario());
		resolverEncuestaSession.getEncuestaUsuario().setEncuesta(encuesta);
		resolverEncuestaSession.getEncuestaUsuario().setPuntaje(0);
		resolverEncuestaSession.getEncuestaUsuario().setUsuario(usuario);
		resolverEncuestaSession.getEncuestaUsuario().setRespuestasUsuario(new ArrayList<RespuestaUsuario>());
		session.setAttribute("resolverEncuestaSession", resolverEncuestaSession);
		
	}

	private ResolverEncuestaDTO getPrimeraPregunta(ResolverEncuestaSession resolverEncuestaSession)
	{
		
		ResolverEncuestaDTO resolverEncuestaDTO = new ResolverEncuestaDTO(); 
		resolverEncuestaDTO.setPreguntaActual(resolverEncuestaSession.getPreguntas().get(0));
		resolverEncuestaDTO.setRespuestaActual(resolverEncuestaDTO.getPreguntaActual().getRespuestas().get(0));
		return resolverEncuestaDTO;

	}
	
	private ResolverEncuestaEncabezadoDTO getEncabezado(ResolverEncuestaSession resolverEncuestaSession)
	{
		
		ResolverEncuestaEncabezadoDTO resolverEncuestaEncabezadoDTO = new ResolverEncuestaEncabezadoDTO(); 
		resolverEncuestaEncabezadoDTO.setUsuario(resolverEncuestaSession.getUsuario());
		resolverEncuestaEncabezadoDTO.setEncuesta(resolverEncuestaSession.getEncuesta());
		
		return resolverEncuestaEncabezadoDTO;

	}
	

	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {

		ModelAndView model = new ModelAndView("errors");
		model.addObject("errMsg", "this is Exception.class");

		return model;

	}
}