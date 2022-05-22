package com.earthbook.proyecto_dswii_be.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.earthbook.proyecto_dswii_be.entity.Libro;
import com.earthbook.proyecto_dswii_be.service.LibroService;

@Controller
@RequestMapping("/api/libros")
public class LibroController {
	@Autowired
	private LibroService service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Libro>> listadoLibros(){
		List<Libro> lista = service.listar();
		return ResponseEntity.ok(lista);
	}
	
}
