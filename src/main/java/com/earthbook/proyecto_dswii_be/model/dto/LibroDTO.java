package com.earthbook.proyecto_dswii_be.model.dto;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.earthbook.proyecto_dswii_be.jpa.entity.LibroJPA;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LibroDTO implements Serializable {

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
	private AutorDTO autor;
	private String editorial;
	private CategoriaDTO categoria;

	public LibroDTO() {
	}

	public LibroDTO(int id, String iSBN, String sKU, String titulo, String descripcion, int paginas, String imagen,
			AutorDTO autor, String editorial, CategoriaDTO categoria) {
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

	public LibroDTO(LibroJPA lib) {
		this.id = lib.getId();
		this.ISBN = lib.getISBN();
		this.SKU = lib.getSKU();
		this.titulo = lib.getTitulo();
		this.descripcion = lib.getDescripcion();
		this.paginas = lib.getPaginas();
		this.imagen = lib.getImagen();
		this.autor = new AutorDTO(lib.getAutor());
		this.editorial = lib.getEditorial();
		this.categoria = new CategoriaDTO(lib.getCategoria());

	}
	
	

}
