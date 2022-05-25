package com.earthbook.proyecto_dswii_be.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.earthbook.proyecto_dswii_be.entity.Autor;
import com.earthbook.proyecto_dswii_be.repository.AutorRepository;


@Service
public class AutorServiceImpl implements AutorService{
	
    @Autowired
    private AutorRepository repoAutor;

    @Override
    public List<Autor> listar() {
        return repoAutor.findAll();
    }

}
