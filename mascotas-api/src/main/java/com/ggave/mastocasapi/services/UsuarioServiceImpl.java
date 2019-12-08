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
	public Usuario findByUsernameAndPassword(String correo_usu, String password_usu) {
		return urepository.findByUsernameAndPassword(correo_usu, password_usu);
	}

	@Override
	public Usuario findByUsername(String correo_usu) {
		return urepository.findByUsername(correo_usu);
	}

	@Override
	public List<Usuario> findAll() {
		return (List<Usuario>) urepository.findAll();
	}

	@Override
	public Usuario findById(Long id) {
		return urepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No existe registro"));
	}

	@Override
	public void save(Usuario usuarios) {
		urepository.save(usuarios);
		
	}

	@Override
	public void deleteById(Long id) {
		urepository.deleteById(id);
		
	}
	
}
