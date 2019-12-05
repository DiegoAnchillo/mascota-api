package com.ggave.mastocasapi.services;

import java.util.List;

import com.ggave.mastocasapi.entities.Mascotas;

public interface MascotasService {
	
	public List<Mascotas> findAll();
	
	public Mascotas findById(Long id);
	
	public void save(Mascotas mascotas);
	
	public void deletedById(Long id);
}
