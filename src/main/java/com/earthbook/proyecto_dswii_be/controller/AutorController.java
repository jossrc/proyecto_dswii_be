package com.earthbook.proyecto_dswii_be.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.earthbook.proyecto_dswii_be.entity.Autor;
import com.earthbook.proyecto_dswii_be.service.AutorService;

@Controller
@RequestMapping("/api/autores")
public class AutorController {
	
	@Autowired
	private AutorService service;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Autor>> listadoAutores() {
		List<Autor> lista = service.listar();
		return ResponseEntity.ok(lista);
	}


}
