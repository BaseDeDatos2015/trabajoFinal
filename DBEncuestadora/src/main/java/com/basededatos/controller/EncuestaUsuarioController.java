package com.basededatos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.basededatos.domain.EncuestaUsuario;
import com.basededatos.service.EncuestaUsuarioServicio;


@Controller
public class EncuestaUsuarioController {

	@Autowired
	EncuestaUsuarioServicio encuestaUsuarioServicio;

	public EncuestaUsuarioController() {

	}
	
	@RequestMapping(value="/encuestas/resueltas", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("encuestaUsuarios", encuestaUsuarioServicio.getAll());
		return "encuestaUsuarios/encuestaUsuarioList";
	}

	
	@RequestMapping("/encuestas/resueltas/show/{id}")
	public String show(Model model, @PathVariable Long id) {
		EncuestaUsuario encuestaUsuario = encuestaUsuarioServicio.get(id);
		model.addAttribute("encuestaUsuario", encuestaUsuario);
		return "encuestaUsuarios/encuestaUsuario";
	}


}