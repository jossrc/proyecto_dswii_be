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
import org.springframework.web.bind.annotation.RequestParam;

import com.earthbook.proyecto_dswii_be.model.dto.LibroDTO;
import com.earthbook.proyecto_dswii_be.service.LibroService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/libros")
public class LibroRestController {

	@Autowired
	@Qualifier("libroService")
	private LibroService service;

	@GetMapping("/listar")
	public List<LibroDTO> listadoLibros() {

		return service.listar();
	}
	
	@GetMapping("/listar/filtros")
	public List<LibroDTO> listarTodoOPorFiltros(
            @RequestParam(name = "autorId", required = false, defaultValue = "-1") int autorId,
            @RequestParam(name = "categoriaId", required = false, defaultValue = "-1") int  categoriaId){
            	return service.listarPorAutorCategoria(autorId, categoriaId);
    }

	@GetMapping("/obtener/{id}")
	public LibroDTO libroId(@PathVariable("id") int id) {

		return service.libroId(id);
	}

	@PostMapping("/agregar")
	public ResponseEntity<?> insertLibro(@RequestBody LibroDTO libro) {

		boolean flag = service.insert(libro);

		if (flag) {

			return new ResponseEntity<>(HttpStatus.OK);

		} else {

			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}

	@PutMapping("/actualizar")
	public ResponseEntity<?> updateLibro(@RequestBody LibroDTO libro) {

		boolean flag = service.update(libro);

		if (flag) {

			return new ResponseEntity<>(HttpStatus.OK);

		} else {

			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> deleteLibro(@PathVariable("id") int id) {

		boolean flag = service.delete(id);

		if (flag) {

			return new ResponseEntity<>(HttpStatus.OK);

		} else {

			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
}
