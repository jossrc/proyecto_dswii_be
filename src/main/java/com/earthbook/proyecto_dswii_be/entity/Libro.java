package com.earthbook.proyecto_dswii_be.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "libro")
public class Libro implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String ISBN;
	private String SKU;
	private String titulo;
	private String descripcion;
	private int paginas;
	private String imagen;
	private int id_autor;
	private int id_editorial;
	private int id_categoria;
	
}
