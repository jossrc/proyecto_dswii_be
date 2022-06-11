package com.earthbook.proyecto_dswii_be.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.earthbook.proyecto_dswii_be.jpa.entity.UsuarioJPA;

import java.io.Serializable;

public interface UsuarioRepository extends JpaRepository<UsuarioJPA, Serializable> {

}
