package com.earthbook.proyecto_dswii_be.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.earthbook.proyecto_dswii_be.entity.Usuario;
import com.earthbook.proyecto_dswii_be.service.UsuarioService;

@Controller
@RequestMapping("/api/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Usuario>> listadoUsuarios() {
		List<Usuario> lista = service.listar();
		return ResponseEntity.ok(lista);
	}


}
