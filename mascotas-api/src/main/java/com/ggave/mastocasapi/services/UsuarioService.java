package com.ggave.mastocasapi.services;

import java.util.List;

import com.ggave.mastocasapi.entities.Usuario;

public interface UsuarioService {
	
	public List<Usuario> findAll();
	
	public Usuario findById(Long id);
	
	public void save(Usuario usuario);
	
	public void deleteById(Long id);
}
