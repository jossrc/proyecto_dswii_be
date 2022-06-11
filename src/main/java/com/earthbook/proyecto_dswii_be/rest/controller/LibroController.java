package com.earthbook.proyecto_dswii_be.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.earthbook.proyecto_dswii_be.jpa.entity.LibroJPA;
import com.earthbook.proyecto_dswii_be.service.LibroService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/libros")
public class LibroController {
	@Autowired
	private LibroService service;
	
	@GetMapping
	public ResponseEntity<List<LibroJPA>> listadoLibros(){
		List<LibroJPA> lista = service.listar();
		return ResponseEntity.ok(lista);
	}
	
}
