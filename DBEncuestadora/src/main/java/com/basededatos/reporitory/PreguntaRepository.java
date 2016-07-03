package com.basededatos.reporitory;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.basededatos.domain.Pregunta;

@RepositoryRestResource(collectionResourceRel = "pregunta", path = "pregunta")
public interface PreguntaRepository extends PagingAndSortingRepository<Pregunta, Long> {
	
	


}
