package com.ggave.mastocasapi.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggave.mastocasapi.entities.Usuario;
import com.ggave.mastocasapi.repositories.UsuarioRepository;


@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository urepository;
	
	
	
	@Override
	public List<Usuario> findAll() {
		return urepository.findAll();
	}

	@Override
	public Usuario findById(Long id) {
		return urepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No existe registro"));
	}

	public void save(Usuario usuario) {
		urepository.save(usuario);
	}

	public void deleteById(Long id) {
		urepository.deleteById(id);
	}
	
}
