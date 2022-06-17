package com.earthbook.proyecto_dswii_be.convertidor;

import com.earthbook.proyecto_dswii_be.jpa.entity.UsuarioJPA;
import com.earthbook.proyecto_dswii_be.model.dto.UsuarioDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("convertidorUsuario")
public class ConvertidorUsuario {

    public List<UsuarioDTO> convertirLista(List<UsuarioJPA> listaUsuariosJPA){
        List<UsuarioDTO> listaUsuariosDTO = new ArrayList<>();

        for(UsuarioJPA usuario: listaUsuariosJPA){
            listaUsuariosDTO.add(new UsuarioDTO(usuario));
        }

        return listaUsuariosDTO;
    }

    public UsuarioDTO convertirDTO(UsuarioJPA usuarioJPA){
        return new UsuarioDTO(usuarioJPA);
    }

}
