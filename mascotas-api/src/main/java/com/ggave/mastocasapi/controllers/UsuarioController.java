package com.ggave.mastocasapi.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ggave.mastocasapi.entities.Usuario;
import com.ggave.mastocasapi.services.UsuarioService;

@RestController
public class UsuarioController {


private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

	@Value("${app.storage.path}")
	private String STORAGEPATH;
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@GetMapping("/usuarios")
	public List<Usuario> usuarios(){
		
		List<Usuario> usuarios = usuarioService.findAll();
		
		logger.info("Usuarios: " + usuarios);
		
		return usuarios;
	}
	
	
	
}
