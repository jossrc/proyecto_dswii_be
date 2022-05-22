package com.earthbook.proyecto_dswii_be.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.earthbook.proyecto_dswii_be.entity.Usuario;
import com.earthbook.proyecto_dswii_be.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
    @Autowired
    private UsuarioRepository repoUsuario;

    @Override
    public List<Usuario> listar() {
        return repoUsuario.findAll();
    }

}
