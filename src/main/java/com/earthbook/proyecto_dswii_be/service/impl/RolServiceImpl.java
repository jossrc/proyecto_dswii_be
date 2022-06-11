package com.earthbook.proyecto_dswii_be.service.impl;


import com.earthbook.proyecto_dswii_be.jpa.entity.RolJPA;
import com.earthbook.proyecto_dswii_be.jpa.repository.RolRepository;
import com.earthbook.proyecto_dswii_be.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolRepository repository;

    @Override
    public List<RolJPA> listar() {
        return repository.findAll();
    }

}
