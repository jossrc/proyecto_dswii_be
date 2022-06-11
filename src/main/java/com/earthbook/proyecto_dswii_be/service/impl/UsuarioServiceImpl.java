package com.earthbook.proyecto_dswii_be.service.impl;

import java.util.List;

import com.earthbook.proyecto_dswii_be.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.earthbook.proyecto_dswii_be.jpa.entity.UsuarioJPA;
import com.earthbook.proyecto_dswii_be.jpa.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
    @Autowired
    private UsuarioRepository repoUsuario;

    @Override
    public List<UsuarioJPA> listar() {
        return repoUsuario.findAll();
    }

}
