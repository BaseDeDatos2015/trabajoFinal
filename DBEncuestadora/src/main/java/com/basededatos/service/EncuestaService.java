package com.basededatos.service;

import java.util.List;

import com.basededatos.domain.Encuesta;

public interface EncuestaService {
	
	public Encuesta save(Encuesta pEncuesta);
	
	public Encuesta update(Encuesta pEncuesta);
	
	public void delete(Encuesta pEncuesta);
	
	public Encuesta get(Long pId);
	
	public List<Encuesta> getAll();
	


}
