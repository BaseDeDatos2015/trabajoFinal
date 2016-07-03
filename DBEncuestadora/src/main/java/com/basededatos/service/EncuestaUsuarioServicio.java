package com.basededatos.service;

import java.util.List;

import com.basededatos.domain.EncuestaUsuario;

public interface EncuestaUsuarioServicio {
	
	public EncuestaUsuario save(EncuestaUsuario pEncuestaUsuario);
	
	public EncuestaUsuario update(EncuestaUsuario pEncuestaUsuario);
	
	public void delete(EncuestaUsuario pEncuestaUsuario);
	
	public EncuestaUsuario get(Long pId);
	
	public List<EncuestaUsuario> getAll();
	


}
