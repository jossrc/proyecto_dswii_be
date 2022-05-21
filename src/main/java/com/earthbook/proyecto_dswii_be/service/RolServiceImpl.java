package com.earthbook.proyecto_dswii_be.service;


import com.earthbook.proyecto_dswii_be.entity.Rol;
import com.earthbook.proyecto_dswii_be.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImpl implements RolService{

    @Autowired
    private RolRepository repository;

    @Override
    public List<Rol> listar() {
        return repository.findAll();
    }

}
