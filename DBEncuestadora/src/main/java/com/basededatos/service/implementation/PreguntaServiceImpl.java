package com.basededatos.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basededatos.domain.Pregunta;
import com.basededatos.reporitory.PreguntaRepository;
import com.basededatos.service.PreguntaService;

@Service
public class PreguntaServiceImpl implements PreguntaService{
	
	@Autowired
	private PreguntaRepository PreguntaReporsitory;

	
	@Override
	public Pregunta save(Pregunta pPregunta) {
		
		return PreguntaReporsitory.save(pPregunta);
	}

	@Override
	public Pregunta update(Pregunta pPregunta) {

		return PreguntaReporsitory.save(pPregunta);
	}

	@Override
	public void delete(Pregunta pPregunta) {
		
		PreguntaReporsitory.delete(pPregunta);
		
	}

	@Override
	public Pregunta get(Long pId) {
		
		return PreguntaReporsitory.findOne(pId);
	}

	@Override
	public List<Pregunta> getAll() {
		Iterable<Pregunta> source = PreguntaReporsitory.findAll();
		List<Pregunta> target = new ArrayList<>();
		source.forEach(target::add);
		return target;
	}
	


}
