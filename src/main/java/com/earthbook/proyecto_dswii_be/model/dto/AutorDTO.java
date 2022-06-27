package com.earthbook.proyecto_dswii_be.model.dto;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.earthbook.proyecto_dswii_be.jpa.entity.AutorJPA;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutorDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre_completo;
	private String biografia;
	private String imagen;
	private PaisDTO pais;

	public AutorDTO() {
		super();
	}

	public AutorDTO(int id, String nombre_completo, String biografia, String imagen, PaisDTO pais) {
		this.id = id;
		this.nombre_completo = nombre_completo;
		this.biografia = biografia;
		this.imagen = imagen;
		this.pais = pais;
	}

	public AutorDTO(AutorJPA autor) {
		this.id = autor.getId();
		this.nombre_completo = autor.getNombre_completo();
		this.biografia = autor.getBiografia();
		this.imagen = autor.getImagen();
		this.pais = new PaisDTO(autor.getPais());
	}

}
