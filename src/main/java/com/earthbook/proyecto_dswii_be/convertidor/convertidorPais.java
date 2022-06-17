package com.earthbook.proyecto_dswii_be.convertidor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.earthbook.proyecto_dswii_be.jpa.entity.PaisJPA;
import com.earthbook.proyecto_dswii_be.model.dto.PaisDTO;

@Component("convertidorPais")
public class convertidorPais {
	public List<PaisDTO> convertirLista(List<PaisJPA> listaJPA){
		List<PaisDTO> lstPaisModel = new ArrayList<>();
		
		for(PaisJPA pais: listaJPA){
			lstPaisModel.add(new PaisDTO(pais));
		}
		
		return lstPaisModel;
	}
	
	public PaisDTO convertirDTO(PaisJPA nota){
		return new PaisDTO(nota);
	}
}
