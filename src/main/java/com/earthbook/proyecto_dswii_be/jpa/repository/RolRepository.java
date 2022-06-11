package com.earthbook.proyecto_dswii_be.jpa.repository;

import com.earthbook.proyecto_dswii_be.jpa.entity.RolJPA;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface RolRepository extends JpaRepository<RolJPA, Serializable> {
}
