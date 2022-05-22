package com.earthbook.proyecto_dswii_be.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.earthbook.proyecto_dswii_be.entity.Editorial;
import com.earthbook.proyecto_dswii_be.service.EditorialService;

@Controller
@RequestMapping("/api/editoriales")
public class EditorialController {
	@Autowired
	private EditorialService service;
	
	@GetMapping
    @ResponseBody
    public ResponseEntity<List<Editorial>> listadoEditoriales(){
		List<Editorial> lista = service.listar();
		return ResponseEntity.ok(lista);
	}

}
