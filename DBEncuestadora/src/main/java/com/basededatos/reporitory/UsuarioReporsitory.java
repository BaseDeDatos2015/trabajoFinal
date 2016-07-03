package com.basededatos.reporitory;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.basededatos.domain.Usuario;

@RepositoryRestResource(collectionResourceRel = "usuario", path = "usuario")
public interface UsuarioReporsitory extends PagingAndSortingRepository<Usuario, Long> {

	List<Usuario> findByNombre(@Param("nombre") String name);
	

}