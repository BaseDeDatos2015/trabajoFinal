package com.basededatos.reporitory;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.basededatos.domain.Respuesta;

@RepositoryRestResource(collectionResourceRel = "respuesta", path = "respuesta")
public interface RespuestaRepository extends PagingAndSortingRepository<Respuesta, Long> {
	
	


}
