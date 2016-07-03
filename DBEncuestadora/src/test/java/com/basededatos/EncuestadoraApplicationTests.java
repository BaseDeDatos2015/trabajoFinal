package com.basededatos;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.basededatos.domain.Rol;
import com.basededatos.domain.Usuario;
import com.basededatos.reporitory.RolRepository;
import com.basededatos.reporitory.UsuarioReporsitory;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = EncuestadoraApplication.class)
@WebAppConfiguration
public class EncuestadoraApplicationTests {

	@Autowired
	public RolRepository rolRepository;
	
	@Autowired
	public UsuarioReporsitory UsuarioRepository;
	
	@Test
	public void contextLoads() {
		
		Rol r = new Rol();
		r.setId(1);
		
		Usuario usuario = new Usuario();
		usuario.setNombre("Facu");
		usuario.setRol(r);
		UsuarioRepository.save(usuario);
	}

	

}
