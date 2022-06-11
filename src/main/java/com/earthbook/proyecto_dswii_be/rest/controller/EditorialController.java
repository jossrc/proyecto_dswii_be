package com.earthbook.proyecto_dswii_be.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.earthbook.proyecto_dswii_be.jpa.entity.EditorialJPA;
import com.earthbook.proyecto_dswii_be.service.EditorialService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/editoriales")
public class EditorialController {
	@Autowired
	private EditorialService service;
	
	@GetMapping
    public ResponseEntity<List<EditorialJPA>> listadoEditoriales(){
		List<EditorialJPA> lista = service.listar();
		return ResponseEntity.ok(lista);
	}

}
