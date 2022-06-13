package com.earthbook.proyecto_dswii_be.service.impl;

import java.util.List;

import com.earthbook.proyecto_dswii_be.service.PaisService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.earthbook.proyecto_dswii_be.convertidor.convertidorPais;
import com.earthbook.proyecto_dswii_be.jpa.entity.PaisJPA;
import com.earthbook.proyecto_dswii_be.jpa.repository.PaisRepository;
import com.earthbook.proyecto_dswii_be.model.dto.PaisDTO;

@Service("paisService")
public class PaisServiceImpl implements PaisService {

	@Autowired
	@Qualifier("repositorioPais")
	private PaisRepository repo;

	@Autowired
	@Qualifier("convertidorPais")
	private convertidorPais conv;

	@Override
	public List<PaisDTO> listar() {

		List<PaisJPA> lib = repo.findAll();

		return conv.convertirLista(lib);
	}

}
