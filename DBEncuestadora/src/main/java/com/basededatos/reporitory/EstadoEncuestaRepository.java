package com.basededatos.reporitory;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.basededatos.domain.EstadoEncuesta;

@RepositoryRestResource(collectionResourceRel = "estadoEncuesta", path = "estadoEncuesta")
public interface EstadoEncuestaRepository extends PagingAndSortingRepository<EstadoEncuesta, Long> {
	
	


}
