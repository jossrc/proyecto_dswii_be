package com.earthbook.proyecto_dswii_be.jpa.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.earthbook.proyecto_dswii_be.jpa.entity.LibroJPA;

@Repository("repositorioLibro")
public interface LibroRepository extends JpaRepository<LibroJPA, Serializable> {
	
	@Query("select l from LibroJPA l where (?1 = -1 or l.autor.id = ?1) and (?2 = -1 or l.categoria.id = ?2)")
	public List<LibroJPA> listarLibrosPorAutorCategoria(int idAutor, int idCategoria);
}
