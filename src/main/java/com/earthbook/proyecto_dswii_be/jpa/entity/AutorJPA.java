package com.earthbook.proyecto_dswii_be.jpa.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.earthbook.proyecto_dswii_be.model.dto.AutorDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "AUTOR")
public class AutorJPA implements Serializable {

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
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pais")
	private PaisJPA pais;

	public AutorJPA() {
	}

	public AutorJPA(int id, String nombre_completo, String biografia, String imagen, PaisJPA pais) {
		this.id = id;
		this.nombre_completo = nombre_completo;
		this.biografia = biografia;
		this.imagen = imagen;
		this.pais = pais;
	}

	public AutorJPA(AutorDTO autor) {
		this.id = autor.getId();
		this.nombre_completo = autor.getNombre_completo();
		this.biografia = autor.getBiografia();
		this.imagen = autor.getImagen();
		this.pais = new PaisJPA(autor.getPais());
	}
}
