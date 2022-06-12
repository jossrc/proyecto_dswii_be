package com.earthbook.proyecto_dswii_be.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.earthbook.proyecto_dswii_be.model.dto.AutorDTO;
import com.earthbook.proyecto_dswii_be.service.AutorService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/autor")
public class AutorRestController {

	@Autowired
	@Qualifier("autorService")
	private AutorService service;

	@GetMapping("/listar")
	public List<AutorDTO> listadoautor() {

		return service.listar();
	}

	@GetMapping("/obtener/{id}")
	public AutorDTO autorId(@PathVariable("id") int id) {

		return service.autorId(id);
	}

	@PostMapping("/agregar")
	public ResponseEntity<?> insertautor(@RequestBody AutorDTO autor) {

		boolean flag = service.insert(autor);

		if (flag) {

			return new ResponseEntity<>(HttpStatus.OK);

		} else {

			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}

	@PutMapping("/actualizar")
	public ResponseEntity<?> updateautor(@RequestBody AutorDTO autor) {

		boolean flag = service.update(autor);

		if (flag) {

			return new ResponseEntity<>(HttpStatus.OK);

		} else {

			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> deleteautor(@PathVariable("id") int id) {

		boolean flag = service.delete(id);

		if (flag) {

			return new ResponseEntity<>(HttpStatus.OK);

		} else {

			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
}
