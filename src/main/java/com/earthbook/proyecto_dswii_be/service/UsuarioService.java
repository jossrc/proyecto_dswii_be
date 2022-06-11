package com.earthbook.proyecto_dswii_be.service;

import java.util.List;

import com.earthbook.proyecto_dswii_be.jpa.entity.UsuarioJPA;
import com.earthbook.proyecto_dswii_be.model.dto.UsuarioDTO;

public interface UsuarioService {

	public boolean crear(UsuarioDTO usuario);
	public boolean actualizar(UsuarioDTO usuario);
	public boolean borrar(int id);
	public List<UsuarioDTO> listar();
	public UsuarioDTO getUsuarioById(int id);

}
