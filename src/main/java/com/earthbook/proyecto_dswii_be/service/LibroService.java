package com.earthbook.proyecto_dswii_be.service;

import java.util.List;

import com.earthbook.proyecto_dswii_be.model.dto.LibroDTO;

public interface LibroService {

	public List<LibroDTO> listar();

	public LibroDTO libroId(int id);

	public boolean insert(LibroDTO libro);

	public boolean update(LibroDTO libro);

	public boolean delete(int id);
	
	public List<LibroDTO> listarPorAutorCategoria(int idAutor, int idCategoria);
}
