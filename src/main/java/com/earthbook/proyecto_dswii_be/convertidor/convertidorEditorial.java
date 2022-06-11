package com.earthbook.proyecto_dswii_be.convertidor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.earthbook.proyecto_dswii_be.jpa.entity.EditorialJPA;
import com.earthbook.proyecto_dswii_be.model.dto.EditorialDTO;

@Component("convertidorEditorial")
public class convertidorEditorial {
	public List<EditorialDTO> convertirLista(List<EditorialJPA> listaJPA){
		List<EditorialDTO> lstEditorialModel = new ArrayList<>();
		
		for(EditorialJPA editorial: listaJPA){
			lstEditorialModel.add(new EditorialDTO(editorial));
		}
		return lstEditorialModel;
	}
	
	public EditorialDTO convertirDTO(EditorialJPA nota){
		return new EditorialDTO(nota);
	}
}
