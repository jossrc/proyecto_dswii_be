package com.earthbook.proyecto_dswii_be.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import com.earthbook.proyecto_dswii_be.model.dto.CategoriaDTO;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "CATEGORIA")
public class CategoriaJPA implements Serializable {

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
    
	public CategoriaJPA() {
	}

	public CategoriaJPA(int id, String nombre, String descripcion, String imagen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
	}
    
	public CategoriaJPA(CategoriaDTO cate) {
		this.id = cate.getId();
		this.nombre = cate.getNombre();
		this.descripcion = cate.getDescripcion();
		this.imagen = cate.getImagen();
	}
}
