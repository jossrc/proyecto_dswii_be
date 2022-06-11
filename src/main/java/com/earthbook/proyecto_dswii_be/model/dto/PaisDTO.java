package com.earthbook.proyecto_dswii_be.model.dto;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.earthbook.proyecto_dswii_be.jpa.entity.PaisJPA;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaisDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	
	public PaisDTO() {
	}

	public PaisDTO(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	public PaisDTO(PaisJPA pais) {
		this.id = pais.getId();
		this.nombre = pais.getNombre();
	}

}
