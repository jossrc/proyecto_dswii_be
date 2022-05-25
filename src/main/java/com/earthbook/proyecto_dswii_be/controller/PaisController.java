package com.earthbook.proyecto_dswii_be.controller;

import com.earthbook.proyecto_dswii_be.entity.Pais;
import com.earthbook.proyecto_dswii_be.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/paises")
public class PaisController {

	@Autowired
	private PaisService service;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Pais>> listadoPaises() {
		List<Pais> lista = service.listar();
		return ResponseEntity.ok(lista);
	}

}
