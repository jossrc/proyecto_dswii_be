package com.earthbook.proyecto_dswii_be.service;

import java.util.List;

import com.earthbook.proyecto_dswii_be.jpa.entity.LibroJPA;

public interface LibroService {
	public List<LibroJPA> listar();
}
