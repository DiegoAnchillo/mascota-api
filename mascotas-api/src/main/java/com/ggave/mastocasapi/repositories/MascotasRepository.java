package com.ggave.mastocasapi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ggave.mastocasapi.entities.Mascotas;

public interface MascotasRepository extends CrudRepository<Mascotas, Long> {
	
	
	List<Mascotas> findAll();
}
