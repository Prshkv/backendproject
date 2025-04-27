package com.prshkv.backendproject.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(exported = false) //App users not visible in api
public interface AppUserRepository extends CrudRepository<AppUser, Long>{
    AppUser findByUsername(String username);

}
