package com.basededatos.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basededatos.domain.Rol;
import com.basededatos.domain.Usuario;
import com.basededatos.reporitory.RolRepository;
import com.basededatos.reporitory.UsuarioReporsitory;
import com.basededatos.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioReporsitory usuarioReporsitory;

	@Autowired
	private RolRepository rolReporsitory;
	
	@Override
	public Usuario save(Usuario pUsuario) {
		
		return usuarioReporsitory.save(pUsuario);
	}

	@Override
	public Usuario update(Usuario pUsuario) {

		return usuarioReporsitory.save(pUsuario);
	}

	@Override
	public void delete(Usuario pUsuario) {
		
		usuarioReporsitory.delete(pUsuario);
		
	}

	@Override
	public Usuario get(Long pId) {
		
		return usuarioReporsitory.findOne(pId);
	}

	@Override
	public List<Usuario> getAll() {
		Iterable<Usuario> source = usuarioReporsitory.findAll();
		List<Usuario> target = new ArrayList<>();
		source.forEach(target::add);
		return target;
	}
	
	@Override
	public List<Rol> getRoles() {
		Iterable<Rol> source = rolReporsitory.findAll();
		List<Rol> target = new ArrayList<>();
		source.forEach(target::add);
		return target;
	}

}
