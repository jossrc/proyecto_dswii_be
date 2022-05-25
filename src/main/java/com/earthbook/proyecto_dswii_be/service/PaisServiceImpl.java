package com.earthbook.proyecto_dswii_be.service;


import com.earthbook.proyecto_dswii_be.entity.Pais;
import com.earthbook.proyecto_dswii_be.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisServiceImpl implements PaisService{

    @Autowired
    private PaisRepository repository;

    @Override
    public List<Pais> listar() {
        return repository.findAll();
    }

}
