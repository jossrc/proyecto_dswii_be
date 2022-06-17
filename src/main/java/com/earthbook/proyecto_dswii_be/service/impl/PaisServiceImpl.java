package com.earthbook.proyecto_dswii_be.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.earthbook.proyecto_dswii_be.convertidor.convertidorPais;
import com.earthbook.proyecto_dswii_be.jpa.entity.PaisJPA;
import com.earthbook.proyecto_dswii_be.jpa.repository.PaisRepository;
import com.earthbook.proyecto_dswii_be.model.dto.PaisDTO;
import com.earthbook.proyecto_dswii_be.service.PaisService;

@Service("paisService")
public class PaisServiceImpl implements PaisService {

	@Autowired
    @Qualifier("repositorioPais")
    private PaisRepository repositorio;
    
    @Autowired
    @Qualifier("convertidorPais")
    private convertidorPais convertidor;
	
	@Override
	public List<PaisDTO> listar() {
		List<PaisJPA> pais = repositorio.findAll();

		return convertidor.convertirLista(pais);
	}

}
