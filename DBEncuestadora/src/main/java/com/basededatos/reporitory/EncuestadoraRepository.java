package com.basededatos.reporitory;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.basededatos.domain.Encuestadora;

@RepositoryRestResource(collectionResourceRel = "encuestadora", path = "encuestadora")
public interface EncuestadoraRepository extends PagingAndSortingRepository<Encuestadora, Long> {
	
	


}
