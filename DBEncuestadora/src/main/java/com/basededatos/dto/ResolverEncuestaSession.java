package com.basededatos.dto;

import java.util.Map;

import com.basededatos.domain.Encuesta;
import com.basededatos.domain.EncuestaUsuario;
import com.basededatos.domain.Pregunta;
import com.basededatos.domain.Respuesta;
import com.basededatos.domain.Usuario;


public class ResolverEncuestaSession {
	
	private Usuario usuario;
	private Encuesta encuesta;
	private Map<Integer,Pregunta> preguntas;
	private Pregunta preguntaActual;
	private Respuesta respuestaActual;
	private Integer numeroDePreguntaActual;
	private EncuestaUsuario encuestaUsuario; 
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Encuesta getEncuesta() {
		return encuesta;
	}
	public void setEncuesta(Encuesta encuesta) {
		this.encuesta = encuesta;
	}
	public Map<Integer, Pregunta> getPreguntas() {
		return preguntas;
	}
	public void setPreguntas(Map<Integer, Pregunta> preguntas) {
		this.preguntas = preguntas;
	}
	public Pregunta getPreguntaActual() {
		return preguntaActual;
	}
	public void setPreguntaActual(Pregunta preguntaActual) {
		this.preguntaActual = preguntaActual;
	}
	public Integer getNumeroDePreguntaActual() {
		return numeroDePreguntaActual;
	}
	public void setNumeroDePreguntaActual(Integer numeroDePReguntaActual) {
		this.numeroDePreguntaActual = numeroDePReguntaActual;
	}
	public Respuesta getRespuestaActual() {
		return respuestaActual;
	}
	public void setRespuestaActual(Respuesta respuestaActual) {
		this.respuestaActual = respuestaActual;
	}
	public EncuestaUsuario getEncuestaUsuario() {
		return encuestaUsuario;
	}
	public void setEncuestaUsuario(EncuestaUsuario encuestaUsuario) {
		this.encuestaUsuario = encuestaUsuario;
	}

	
	

}
