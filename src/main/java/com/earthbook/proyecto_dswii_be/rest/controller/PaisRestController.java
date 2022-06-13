package com.earthbook.proyecto_dswii_be.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.earthbook.proyecto_dswii_be.model.dto.PaisDTO;
import com.earthbook.proyecto_dswii_be.service.PaisService;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pais")
public class PaisRestController {

	@Autowired
	@Qualifier("paisService")
	private PaisService service;

	@GetMapping("/listar")
	public List<PaisDTO> listadopais() {

		return service.listar();
	}
}
