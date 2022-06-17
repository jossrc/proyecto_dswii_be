package com.earthbook.proyecto_dswii_be.convertidor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.earthbook.proyecto_dswii_be.jpa.entity.LibroJPA;
import com.earthbook.proyecto_dswii_be.model.dto.LibroDTO;

@Component("convertidorLibro")
public class convertidorLibro {
	public List<LibroDTO> convertirLista(List<LibroJPA> listaJPA) {
		List<LibroDTO> lstLibroModel = new ArrayList<>();

		for (LibroJPA libro : listaJPA) {
			lstLibroModel.add(new LibroDTO(libro));
		}

		return lstLibroModel;
	}

	public LibroDTO convertirDTO(LibroJPA nota) {
		return new LibroDTO(nota);
	}
}
