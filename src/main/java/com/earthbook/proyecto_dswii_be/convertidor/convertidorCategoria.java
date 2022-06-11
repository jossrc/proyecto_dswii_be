package com.earthbook.proyecto_dswii_be.convertidor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.earthbook.proyecto_dswii_be.jpa.entity.CategoriaJPA;
import com.earthbook.proyecto_dswii_be.model.dto.CategoriaDTO;

@Component("convertidorCategoria")
public class convertidorCategoria {
	public List<CategoriaDTO> convertirLista(List<CategoriaJPA> listaJPA){
		List<CategoriaDTO> lstCategoriaModel = new ArrayList<>();
		
		for(CategoriaJPA categoria: listaJPA){
			lstCategoriaModel.add(new CategoriaDTO(categoria));
		}
		
		return lstCategoriaModel;
	}
	
	public CategoriaDTO convertirDTO(CategoriaJPA nota){
		return new CategoriaDTO(nota);
	}
}
