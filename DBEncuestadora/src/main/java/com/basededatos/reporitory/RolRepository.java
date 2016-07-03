package com.basededatos.reporitory;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.basededatos.domain.Rol;

@RepositoryRestResource(collectionResourceRel = "rol", path = "rol")
public interface RolRepository extends PagingAndSortingRepository<Rol, Long> {
	
	


}
