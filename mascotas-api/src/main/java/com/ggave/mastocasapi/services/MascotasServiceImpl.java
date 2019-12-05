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
	


	public void save(Mascotas mascotas) {
		mrepository.save(mascotas);
		
	}

	public void deletedById(Long id) {
		mrepository.deleteById(id);
	
	}

	public List<Mascotas> findAll() {
		return mrepository.findAll();
	}

	public Mascotas findById(Long id) {
		return mrepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No existe registro"));
	}
	
}
