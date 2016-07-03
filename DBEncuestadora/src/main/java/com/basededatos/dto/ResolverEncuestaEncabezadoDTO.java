package com.basededatos.dto;

import java.util.Map;

import com.basededatos.domain.Encuesta;
import com.basededatos.domain.EncuestaUsuario;
import com.basededatos.domain.Pregunta;
import com.basededatos.domain.Respuesta;
import com.basededatos.domain.Usuario;


public class ResolverEncuestaEncabezadoDTO {
	
	private Usuario usuario;
	private Encuesta encuesta;

	 
	
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
	
	
	
}
