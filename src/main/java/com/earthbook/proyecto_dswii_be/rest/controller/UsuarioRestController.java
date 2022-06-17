package com.earthbook.proyecto_dswii_be.rest.controller;

import java.util.HashMap;
import java.util.List;

import com.earthbook.proyecto_dswii_be.model.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.earthbook.proyecto_dswii_be.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioRestController {
	
	@Autowired
	private UsuarioService service;

	@PostMapping
	public ResponseEntity<HashMap<String, Object>> insertarUsuario(@RequestBody UsuarioDTO usuario ) {
		// HashMap<String, Object> data = new HashMap<>();
		usuario.setEstado(1);
		boolean exitoso = service.crear(usuario);
		if (exitoso) {
			return new ResponseEntity<>(HttpStatus.OK) ;
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}

	@PutMapping
	public ResponseEntity<HashMap<String, Object>> actualizarUsuario(@RequestBody UsuarioDTO usuario ) {
		boolean exitoso = service.actualizar(usuario);
		if (usuario.getPassword() == null) {
			UsuarioDTO usuarioExistente = service.getUsuarioById(usuario.getId());
			if (usuarioExistente != null ) {
				usuario.setPassword(usuarioExistente.getPassword());
			}
		}
		if (exitoso) {
			return new ResponseEntity<>(HttpStatus.OK) ;
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HashMap<String, Object>> eliminarUsuario(@PathVariable("id") int id ) {
		boolean exitoso = service.borrar(id);
		if (exitoso) {
			return new ResponseEntity<>(HttpStatus.OK) ;
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}

	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> listadoUsuarios() {
		List<UsuarioDTO> lista = service.listar();
		return ResponseEntity.ok(lista);
	}


}
