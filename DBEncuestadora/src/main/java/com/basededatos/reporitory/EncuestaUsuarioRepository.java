package com.basededatos.reporitory;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.basededatos.domain.EncuestaUsuario;

@RepositoryRestResource(collectionResourceRel = "encuestaUsuario", path = "encuestaUsuario")
public interface EncuestaUsuarioRepository extends PagingAndSortingRepository<EncuestaUsuario, Long> {
	
	


}
