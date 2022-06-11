package com.earthbook.proyecto_dswii_be.model.dto;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.earthbook.proyecto_dswii_be.jpa.entity.EditorialJPA;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditorialDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String descripcion;
	
	public EditorialDTO() {
	}

	public EditorialDTO(int id, String nombre, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	public EditorialDTO(EditorialJPA edi) {
		this.id = edi.getId();
		this.nombre = edi.getNombre();
		this.descripcion = edi.getDescripcion();
		
	}
	
}
