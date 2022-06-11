package com.earthbook.proyecto_dswii_be.rest.controller;

import com.earthbook.proyecto_dswii_be.jpa.entity.RolJPA;
import com.earthbook.proyecto_dswii_be.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RolController {

	@Autowired
	private RolService service;

	@GetMapping
	public ResponseEntity<List<RolJPA>> listadoRoles() {
		List<RolJPA> lista = service.listar();
		return ResponseEntity.ok(lista);
	}

}
