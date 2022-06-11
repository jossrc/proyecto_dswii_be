package com.earthbook.proyecto_dswii_be.rest.controller;

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

import com.earthbook.proyecto_dswii_be.model.dto.CategoriaDTO;
import com.earthbook.proyecto_dswii_be.service.impl.CategoriaServiceImpl;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaRestController {

	@Autowired
	@Qualifier("categoriaService")
	private CategoriaServiceImpl service;

	// request
	/*
	 * El formato JSON es el siguiente:
	 * 
	 * { "nombre" : "Terror", "descripcion" : "Libros que te causaran miedo", "imagen" : "Terror" }
	 */
	// Servicio rest - Tipo Post
	// endpoint: http://localhost:8090/api/categorias/agregar
	@PostMapping("/agregar")
	public ResponseEntity<?> agregarCategoria(@RequestBody CategoriaDTO categoria) {
		System.out.println("ini: insertarPokemon()");

		boolean flag = service.crear(categoria);

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
	public ResponseEntity<?> actualizarCategoria(@RequestBody CategoriaDTO categoria) {
		System.out.println("ini: actualizarCategoria()");

		boolean flag = service.actualizar(categoria);

		if (flag) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}

	// Servicio rest - Tipo DELETE
	// endpoint: http://localhost:8090/api/categorias/eliminar/1
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminarCategoria(@PathVariable("id") int id) {
		System.out.println("ini: eliminarCategoria()");

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
	public List<CategoriaDTO> listadoCategoria() {
		System.out.println("ini: listadoCategoria()");

		return service.listar();
	}

	// Servicio rest - Tipo GET
	// endpoint: http://localhost:8090/api/categorias/obtener/1
	@GetMapping("/obtener/{id}")
	public CategoriaDTO obtenerCategoria(@PathVariable("id") int id) {
		System.out.println("ini: obtenerCategoria()");

		return service.categoriaPorId(id);
	}

}
