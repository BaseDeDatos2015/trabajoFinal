package com.basededatos.reporitory;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.basededatos.domain.Encuesta;

@RepositoryRestResource(collectionResourceRel = "encuesta", path = "encuesta")
public interface EncuestaRepository extends PagingAndSortingRepository<Encuesta, Long> {
	
	


}
