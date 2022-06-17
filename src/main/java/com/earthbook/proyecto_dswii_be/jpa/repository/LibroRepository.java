package com.earthbook.proyecto_dswii_be.jpa.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.earthbook.proyecto_dswii_be.jpa.entity.LibroJPA;

@Repository("repositorioLibro")
public interface LibroRepository extends JpaRepository<LibroJPA, Serializable> {

}
