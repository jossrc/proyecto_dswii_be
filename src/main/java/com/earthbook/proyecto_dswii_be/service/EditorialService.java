package com.earthbook.proyecto_dswii_be.service;

import java.util.List;

import com.earthbook.proyecto_dswii_be.model.dto.EditorialDTO;

public interface EditorialService {
	
	public boolean crear(EditorialDTO editorial);
	
	public boolean actualizar(EditorialDTO editorial);
	
	public boolean borrar(int id);
	
	public List<EditorialDTO> listar();
	
	public EditorialDTO editorialPorId(int id);
	
}
