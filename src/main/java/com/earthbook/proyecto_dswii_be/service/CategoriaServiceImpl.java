package com.earthbook.proyecto_dswii_be.service;


import com.earthbook.proyecto_dswii_be.entity.Categoria;
import com.earthbook.proyecto_dswii_be.repository.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService{

    @Autowired
    private CategoriaRepository repoCategoria;

    @Override
    public List<Categoria> listar() {
        return repoCategoria.findAll();
    }

}
