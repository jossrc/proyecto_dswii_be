package com.earthbook.proyecto_dswii_be.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.earthbook.proyecto_dswii_be.model.dto.PaisDTO;
import com.earthbook.proyecto_dswii_be.service.impl.PaisServiceImpl;

@RestController
@RequestMapping("/api/pais")
public class PaisRestController {

	@Autowired
	@Qualifier("paisService")
	private PaisServiceImpl service;

	// Servicio rest - Tipo GET
	// endpoint: http://localhost:8090/api/pais/listar
	@GetMapping("/listar")
	public List<PaisDTO> listadoPais() {
		System.out.println("ini: listadoPais()");

		return service.listar();
	}

}
