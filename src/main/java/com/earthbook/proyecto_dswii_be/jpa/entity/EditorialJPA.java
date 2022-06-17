package com.earthbook.proyecto_dswii_be.jpa.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.earthbook.proyecto_dswii_be.model.dto.EditorialDTO;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "editorial")
public class EditorialJPA implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String descripcion;
	
	public EditorialJPA() {
		
	}

	public EditorialJPA(int id, String nombre, String descripcion) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	public EditorialJPA(EditorialDTO edi) {
		this.id = edi.getId();
		this.nombre = edi.getNombre();
		this.descripcion = edi.getDescripcion();
	}
	
}