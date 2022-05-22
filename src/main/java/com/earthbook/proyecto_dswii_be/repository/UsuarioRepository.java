package com.earthbook.proyecto_dswii_be.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.earthbook.proyecto_dswii_be.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
