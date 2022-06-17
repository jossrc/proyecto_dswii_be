package com.earthbook.proyecto_dswii_be.service.impl;

import com.earthbook.proyecto_dswii_be.convertidor.ConvertidorRol;
import com.earthbook.proyecto_dswii_be.jpa.repository.RolRepository;
import com.earthbook.proyecto_dswii_be.model.dto.RolDTO;
import com.earthbook.proyecto_dswii_be.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    @Qualifier("convertidorRol")
    private ConvertidorRol convertidor;

    @Autowired
    private RolRepository repository;

    @Override
    public List<RolDTO> listar() {
        return convertidor.convertirLista(repository.findAll());
    }

}
