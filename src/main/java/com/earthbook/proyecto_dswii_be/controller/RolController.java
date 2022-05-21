package com.earthbook.proyecto_dswii_be.controller;

import com.earthbook.proyecto_dswii_be.entity.Rol;
import com.earthbook.proyecto_dswii_be.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/roles")
public class RolController {

    @Autowired
    private RolService service;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Rol>> listadoRoles(){
        List<Rol> lista = service.listar();
        return ResponseEntity.ok(lista);
    }


}
