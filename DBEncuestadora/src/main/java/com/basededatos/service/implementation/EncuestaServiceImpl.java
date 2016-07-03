package com.basededatos.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basededatos.domain.Encuesta;
import com.basededatos.reporitory.EncuestaRepository;
import com.basededatos.reporitory.RolRepository;
import com.basededatos.service.EncuestaService;

@Service
public class EncuestaServiceImpl implements EncuestaService{
	
	@Autowired
	private EncuestaRepository encuestaReporsitory;

	
	@Override
	public Encuesta save(Encuesta pEncuesta) {
		
		return encuestaReporsitory.save(pEncuesta);
	}

	@Override
	public Encuesta update(Encuesta pEncuesta) {

		return encuestaReporsitory.save(pEncuesta);
	}

	@Override
	public void delete(Encuesta pEncuesta) {
		
		encuestaReporsitory.delete(pEncuesta);
		
	}

	@Override
	public Encuesta get(Long pId) {
		
		return encuestaReporsitory.findOne(pId);
	}

	@Override
	public List<Encuesta> getAll() {
		Iterable<Encuesta> source = encuestaReporsitory.findAll();
		List<Encuesta> target = new ArrayList<>();
		source.forEach(target::add);
		return target;
	}
	


}
