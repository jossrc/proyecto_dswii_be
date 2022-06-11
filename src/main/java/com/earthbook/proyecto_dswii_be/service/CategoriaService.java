package com.earthbook.proyecto_dswii_be.service;

import java.util.List;

import com.earthbook.proyecto_dswii_be.model.dto.CategoriaDTO;

public interface CategoriaService {
	public boolean crear(CategoriaDTO categoria);
	
	public boolean actualizar(CategoriaDTO categoria);
	
	public boolean borrar(int id);
	
	public List<CategoriaDTO> listar();
	
	public CategoriaDTO categoriaPorId(int id);

}
