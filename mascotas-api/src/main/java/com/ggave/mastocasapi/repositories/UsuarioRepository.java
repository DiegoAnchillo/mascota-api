package com.ggave.mastocasapi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ggave.mastocasapi.entities.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	
	@Override
	List<Usuario> findAll();
}
