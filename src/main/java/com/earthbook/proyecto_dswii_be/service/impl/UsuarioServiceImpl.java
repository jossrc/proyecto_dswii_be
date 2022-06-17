package com.earthbook.proyecto_dswii_be.service.impl;

import java.util.List;
import java.util.Optional;

import com.earthbook.proyecto_dswii_be.convertidor.ConvertidorUsuario;
import com.earthbook.proyecto_dswii_be.model.dto.UsuarioDTO;
import com.earthbook.proyecto_dswii_be.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;

import com.earthbook.proyecto_dswii_be.jpa.entity.UsuarioJPA;
import com.earthbook.proyecto_dswii_be.jpa.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    @Qualifier("convertidorUsuario")
    private ConvertidorUsuario convertidor;

    @Autowired
    private UsuarioRepository repoUsuario;

    @Override
    public boolean crear(UsuarioDTO usuario) {
        try {
            repoUsuario.save( new UsuarioJPA(usuario) );
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean actualizar(UsuarioDTO usuario) {
        try {
            repoUsuario.save( new UsuarioJPA(usuario) );
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean borrar(int id) {
        try {
            Optional<UsuarioJPA> usuario = repoUsuario.findById(id);
            if (usuario.isPresent()) {
                repoUsuario.delete(usuario.get());
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<UsuarioDTO> listar() {
        return convertidor.convertirLista(repoUsuario.findAll());
    }

    @Override
    public UsuarioDTO getUsuarioById(int id) {
        try {
            Optional<UsuarioJPA> usuario = repoUsuario.findById(id);
            return usuario.map(UsuarioDTO::new).orElse(null);
        } catch (Exception e) {
            return null;
        }
    }

}
