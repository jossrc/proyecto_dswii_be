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

import com.earthbook.proyecto_dswii_be.model.dto.LibroDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "LIBRO")
public class LibroJPA implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String ISBN;
	private String SKU;
	private String titulo;
	private String descripcion;
	private int paginas;
	private String imagen;
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_autor")
	private AutorJPA autor;
	private String editorial;
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_categoria")
	private CategoriaJPA categoria;

	public LibroJPA() {
	}

	public LibroJPA(int id, String iSBN, String sKU, String titulo, String descripcion, int paginas, String imagen,
			AutorJPA autor, String editorial, CategoriaJPA categoria) {
		this.id = id;
		this.ISBN = iSBN;
		this.SKU = sKU;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.paginas = paginas;
		this.imagen = imagen;
		this.autor = autor;
		this.editorial = editorial;
		this.categoria = categoria;
	}

	public LibroJPA(LibroDTO lib) {
		this.id = lib.getId();
		this.ISBN = lib.getISBN();
		this.SKU = lib.getSKU();
		this.titulo = lib.getTitulo();
		this.descripcion = lib.getDescripcion();
		this.paginas = lib.getPaginas();
		this.imagen = lib.getImagen();
		this.autor = new AutorJPA(lib.getAutor());
		this.editorial = lib.getEditorial();
		this.categoria = new CategoriaJPA(lib.getCategoria());

	}

}
