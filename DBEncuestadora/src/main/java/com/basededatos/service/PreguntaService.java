package com.basededatos.service;

import java.util.List;

import com.basededatos.domain.Pregunta;

public interface PreguntaService {
	
	public Pregunta save(Pregunta pPregunta);
	
	public Pregunta update(Pregunta pPregunta);
	
	public void delete(Pregunta pPregunta);
	
	public Pregunta get(Long pId);
	
	public List<Pregunta> getAll();
	


}
