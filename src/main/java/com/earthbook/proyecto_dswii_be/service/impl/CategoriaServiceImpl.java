package com.earthbook.proyecto_dswii_be.service.impl;


import com.earthbook.proyecto_dswii_be.jpa.entity.CategoriaJPA;
import com.earthbook.proyecto_dswii_be.jpa.repository.CategoriaRepository;

import com.earthbook.proyecto_dswii_be.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository repoCategoria;

    @Override
    public List<CategoriaJPA> listar() {
        return repoCategoria.findAll();
    }

}
