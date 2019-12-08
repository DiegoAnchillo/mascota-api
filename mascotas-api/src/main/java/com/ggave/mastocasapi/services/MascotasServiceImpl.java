package com.ggave.mastocasapi.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggave.mastocasapi.entities.Mascotas;
import com.ggave.mastocasapi.repositories.MascotasRepository;

@Service
@Transactional
public class MascotasServiceImpl implements MascotasService {
	
	
	@Autowired
	private MascotasRepository mrepository;

	@Override
	public List<Mascotas> findAll() {
		return mrepository.findAll();
	}

	@Override
	public Mascotas findById(Long id) {
		return mrepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No existe registro"));
	}

	@Override
	public void save(Mascotas mascota) {
		mrepository.save(mascota);
		
	}

	@Override
	public void deleteById(Long id) {
		mrepository.deleteById(id);
		
	}
	

	
}
