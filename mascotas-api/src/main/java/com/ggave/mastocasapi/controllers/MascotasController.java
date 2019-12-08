package com.ggave.mastocasapi.controllers;

import java.awt.Image;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ggave.mastocasapi.entities.Mascotas;
import com.ggave.mastocasapi.services.MascotasService;

@RestController
public class MascotasController {
	private static final Logger logger = LoggerFactory.getLogger(MascotasController.class);

	@Value("${app.storage.path}")
	private String STORAGEPATH;

	@Autowired
	private MascotasService mascotaservice;

	@GetMapping("/mascotas")
	public List<Mascotas> mascotas() {
		logger.info("call mascotas");
		List<Mascotas> mascotas = mascotaservice.findAll();
		logger.info("mascotas" + mascotas);
		return mascotas;
	}

	@GetMapping("/mascotas/images/{filename:.+}")
	public ResponseEntity<Resource> files(@PathVariable String filename) throws Exception {
		logger.info("call images: " + filename);
		Path path = Paths.get(STORAGEPATH).resolve(filename);
		logger.info("Path: " + path);
		if (!Files.exists(path)) {
			return ResponseEntity.notFound().build();
		}

		Resource resource = new UrlResource(path.toUri());
		logger.info("Resource: " + resource);

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
				.header(HttpHeaders.CONTENT_TYPE, Files.probeContentType(Paths.get(STORAGEPATH).resolve(filename)))
				.header(HttpHeaders.CONTENT_LENGTH, String.valueOf(resource.contentLength())).body(resource);
	}

	@PostMapping("/mascotas")
	public Mascotas crear(@RequestParam(name = "imagen", required = false) MultipartFile imagen,
			@RequestParam("nombre") String nombre, @RequestParam("raza") String raza, @RequestParam("edad") String edad,
			@RequestParam("id_usu") Long usuario_id) throws Exception {
		logger.info("call crear (" + nombre + "," + raza + "," + edad + "," + imagen + ")");
		Mascotas mascota = new Mascotas();
		mascota.setNombres(nombre);
		mascota.setRaza(raza);
		mascota.setEdad(edad);
		mascota.setUsuario_id(usuario_id);

		if (imagen != null && !imagen.isEmpty()) {
			String filename = System.currentTimeMillis()
					+ imagen.getOriginalFilename().substring(imagen.getOriginalFilename().lastIndexOf("."));
			mascota.setImagen(filename);
			if (Files.notExists(Paths.get(STORAGEPATH))) {
				Files.createDirectories(Paths.get(STORAGEPATH));
			}
			Files.copy(imagen.getInputStream(), Paths.get(STORAGEPATH).resolve(filename));
		}
		mascotaservice.save(mascota);
		return mascota;
	}

	@GetMapping("/mascotas/{id}")
	public Mascotas obtener(@PathVariable Long id) {
		logger.info("call obtener: " + id);

		Mascotas mascota = mascotaservice.findById(id);

		return mascota;
	}
	@DeleteMapping("/mascotas/{id}")
	public ResponseEntity<String> eliminar(@PathVariable Long id) {
		logger.info("call eliminar: " + id);
		
		mascotaservice.deleteById(id);
		
		return ResponseEntity.ok().body("Registro eliminado");
	}
}
