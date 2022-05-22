package com.earthbook.proyecto_dswii_be.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.earthbook.proyecto_dswii_be.entity.Categoria;
import com.earthbook.proyecto_dswii_be.service.CategoriaService;

import java.util.List;

@Controller
@RequestMapping("/api/categorias")
public class CategoriaController {
	
	@Autowired
    private CategoriaService service;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Categoria>> listadoCategorias(){
        List<Categoria> lista = service.listar();
        return ResponseEntity.ok(lista);
    }


}
