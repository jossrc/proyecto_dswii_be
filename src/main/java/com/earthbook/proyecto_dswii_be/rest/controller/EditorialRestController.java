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

import com.earthbook.proyecto_dswii_be.model.dto.EditorialDTO;
import com.earthbook.proyecto_dswii_be.service.impl.EditorialServiceImpl;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/editoriales")
public class EditorialRestController {

	@Autowired
	@Qualifier("editorialService")
	private EditorialServiceImpl service;

	// request
	/*
	 * El formato JSON es el siguiente:
	 * 
	 * { "nombre" : "Terror", "descripcion" : "Libros que te causaran miedo", "imagen" : "Terror" }
	 */
	// Servicio rest - Tipo Post
	// endpoint: http://localhost:8090/api/categorias/agregar
	@PostMapping("/agregar")
	public ResponseEntity<?> agregarEditorial(@RequestBody EditorialDTO editorial) {
		System.out.println("ini: insertarEditorial()");

		boolean flag = service.crear(editorial);

		if (flag) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}

	// request
	/*
	 * El formato JSON es el siguiente:
	 * 
	 * { "id" : 1, "nombre" : "Terror", "descripcion" : "gaaaaaa", "imagen" : "gaaaaaaa" }
	 */
	// Servicio rest - Tipo PUT
	// endpoint: http://localhost:8090/api/categorias/actualizar
	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizarEditorial(@RequestBody EditorialDTO editorial) {
		System.out.println("ini: actualizarEditorial()");

		boolean flag = service.actualizar(editorial);

		if (flag) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}

	// Servicio rest - Tipo DELETE
	// endpoint: http://localhost:8090/api/categorias/eliminar/1
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminarEditorial(@PathVariable("id") int id) {
		System.out.println("ini: eliminarEditorial()");

		boolean flag = service.borrar(id);

		if (flag) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}

	// Servicio rest - Tipo GET
	// endpoint: http://localhost:8090/api/categorias/listar
	@GetMapping("/listar")
	public List<EditorialDTO> listadoEditorial() {
		System.out.println("ini: listadoEditorial()");
		return service.listar();
	}

	// Servicio rest - Tipo GET
	// endpoint: http://localhost:8090/api/categorias/obtener/1
	@GetMapping("/obtener/{id}")
	public EditorialDTO obtenerEditorial(@PathVariable("id") int id) {
		System.out.println("ini: obtenerEditorial()");
		return service.editorialPorId(id);
	}
	
}
