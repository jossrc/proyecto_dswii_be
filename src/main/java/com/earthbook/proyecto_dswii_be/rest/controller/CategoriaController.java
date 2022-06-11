package com.earthbook.proyecto_dswii_be.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.earthbook.proyecto_dswii_be.jpa.entity.CategoriaJPA;
import com.earthbook.proyecto_dswii_be.service.CategoriaService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
	
	@Autowired
    private CategoriaService service;

    @GetMapping
    public ResponseEntity<List<CategoriaJPA>> listadoCategorias(){
        List<CategoriaJPA> lista = service.listar();
        return ResponseEntity.ok(lista);
    }


}
