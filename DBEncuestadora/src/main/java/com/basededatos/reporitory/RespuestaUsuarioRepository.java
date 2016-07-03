package com.basededatos.reporitory;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.basededatos.domain.RespuestaUsuario;

@RepositoryRestResource(collectionResourceRel = "respuestaUsuario", path = "respuestaUsuario")
public interface RespuestaUsuarioRepository extends PagingAndSortingRepository<RespuestaUsuario, Long> {
	
	


}
