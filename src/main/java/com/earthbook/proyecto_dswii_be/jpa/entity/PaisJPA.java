package com.earthbook.proyecto_dswii_be.jpa.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.earthbook.proyecto_dswii_be.model.dto.PaisDTO;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "PAIS")
public class PaisJPA implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;

	public PaisJPA() {
	}

	public PaisJPA(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public PaisJPA(PaisDTO pais) {
		this.id = pais.getId();
		this.nombre = pais.getNombre();

	}

}
