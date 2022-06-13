package com.earthbook.proyecto_dswii_be.convertidor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.earthbook.proyecto_dswii_be.jpa.entity.AutorJPA;
import com.earthbook.proyecto_dswii_be.model.dto.AutorDTO;

@Component("convertidorAutor")
public class convertidorAutor {
	public List<AutorDTO> convertirLista(List<AutorJPA> listaJPA) {
		List<AutorDTO> lstLAutorModel = new ArrayList<>();

		for (AutorJPA autor : listaJPA) {
			lstLAutorModel.add(new AutorDTO(autor));
		}

		return lstLAutorModel;
	}

	public AutorDTO convertirDTO(AutorJPA nota) {
		return new AutorDTO(nota);
	}
}
