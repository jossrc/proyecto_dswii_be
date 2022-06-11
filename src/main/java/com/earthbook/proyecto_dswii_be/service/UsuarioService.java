package com.earthbook.proyecto_dswii_be.service;

import java.util.List;

import com.earthbook.proyecto_dswii_be.jpa.entity.UsuarioJPA;

public interface UsuarioService {
	
	public List<UsuarioJPA> listar();

}
