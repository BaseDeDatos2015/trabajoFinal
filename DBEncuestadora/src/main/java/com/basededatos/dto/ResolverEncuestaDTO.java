package com.basededatos.dto;

import java.util.Map;

import com.basededatos.domain.Encuesta;
import com.basededatos.domain.EncuestaUsuario;
import com.basededatos.domain.Pregunta;
import com.basededatos.domain.Respuesta;
import com.basededatos.domain.Usuario;


public class ResolverEncuestaDTO {
	
	private Pregunta preguntaActual;
	private Respuesta respuestaActual;
		
	
	
	public Pregunta getPreguntaActual() {
		return preguntaActual;
	}
	public void setPreguntaActual(Pregunta preguntaActual) {
		this.preguntaActual = preguntaActual;
	}
	
	public Respuesta getRespuestaActual() {
		return respuestaActual;
	}
	public void setRespuestaActual(Respuesta respuestaActual) {
		this.respuestaActual = respuestaActual;
	}
	
}
