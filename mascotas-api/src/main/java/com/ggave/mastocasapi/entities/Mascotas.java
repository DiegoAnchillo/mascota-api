package com.ggave.mastocasapi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mascotas")
public class Mascotas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombres;
	
	private	String raza;
	
	private String edad;
	
	private String imagen;
	
	private Long usuario_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public Long getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(Long usuario_id) {
		this.usuario_id = usuario_id;
	}

	@Override
	public String toString() {
		return "Mascotas [id=" + id + ", nombres=" + nombres + ", raza=" + raza + ", edad=" + edad + ", imagen="
				+ imagen + ", usuario_id=" + usuario_id + "]";
	}

	
	
	
}	