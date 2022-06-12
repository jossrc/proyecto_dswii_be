package com.earthbook.proyecto_dswii_be.service;

import java.util.List;

import com.earthbook.proyecto_dswii_be.model.dto.AutorDTO;

public interface AutorService {

	public List<AutorDTO> listar();

	public AutorDTO autorId(int id);

	public boolean insert(AutorDTO autor);

	public boolean update(AutorDTO autor);

	public boolean delete(int id);
}
