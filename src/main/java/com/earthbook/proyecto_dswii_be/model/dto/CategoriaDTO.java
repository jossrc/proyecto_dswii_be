package com.earthbook.proyecto_dswii_be.model.dto;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.earthbook.proyecto_dswii_be.jpa.entity.CategoriaJPA;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String descripcion;
	private String imagen;
	
	public CategoriaDTO() {
	}

	public CategoriaDTO(int id, String nombre, String descripcion, String imagen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
	}
	
	public CategoriaDTO(CategoriaJPA cate) {
		this.id = cate.getId();
		this.nombre = cate.getNombre();
		this.descripcion = cate.getDescripcion();
		this.imagen = cate.getImagen();
		
	}
	
}
