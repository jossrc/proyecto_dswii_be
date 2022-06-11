package com.earthbook.proyecto_dswii_be.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.earthbook.proyecto_dswii_be.jpa.entity.UsuarioJPA;
import com.earthbook.proyecto_dswii_be.service.UsuarioService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;

	@GetMapping
	public ResponseEntity<List<UsuarioJPA>> listadoUsuarios() {
		List<UsuarioJPA> lista = service.listar();
		return ResponseEntity.ok(lista);
	}


}
