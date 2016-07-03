package com.basededatos.service;

import java.util.List;

import com.basededatos.domain.Rol;
import com.basededatos.domain.Usuario;

public interface UsuarioService {
	
	public Usuario save(Usuario pUsuario);
	
	public Usuario update(Usuario pUsuario);
	
	public void delete(Usuario pUsuario);
	
	public Usuario get(Long pId);
	
	public List<Usuario> getAll();
	
	public List<Rol> getRoles();

}
