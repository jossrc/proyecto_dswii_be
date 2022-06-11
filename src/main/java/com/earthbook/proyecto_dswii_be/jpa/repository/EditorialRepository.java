package com.earthbook.proyecto_dswii_be.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.earthbook.proyecto_dswii_be.jpa.entity.EditorialJPA;

@Repository("repositorioEditoriales")
public interface EditorialRepository extends JpaRepository<EditorialJPA, Integer>{

}
