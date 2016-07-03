package com.basededatos.service.implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basededatos.domain.EncuestaUsuario;
import com.basededatos.reporitory.EncuestaUsuarioRepository;
import com.basededatos.service.EncuestaUsuarioServicio;

@Service
public class EncuestaUsuarioServiceImpl implements EncuestaUsuarioServicio{
	
	@Autowired
	private EncuestaUsuarioRepository encuestaUsuarioRepository;

	
	@Override
	public EncuestaUsuario save(EncuestaUsuario pEncuestaUsuario) {
		pEncuestaUsuario.setFecha(new Date());
		return encuestaUsuarioRepository.save(pEncuestaUsuario);
	}

	@Override
	public EncuestaUsuario update(EncuestaUsuario pEncuestaUsuario) {

		return encuestaUsuarioRepository.save(pEncuestaUsuario);
	}

	@Override
	public void delete(EncuestaUsuario pEncuestaUsuario) {
		
		encuestaUsuarioRepository.delete(pEncuestaUsuario);
		
	}

	@Override
	public EncuestaUsuario get(Long pId) {
		
		return encuestaUsuarioRepository.findOne(pId);
	}

	@Override
	public List<EncuestaUsuario> getAll() {
		Iterable<EncuestaUsuario> source = encuestaUsuarioRepository.findAll();
		List<EncuestaUsuario> target = new ArrayList<>();
		source.forEach(target::add);
		return target;
	}
	


}
