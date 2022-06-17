package com.earthbook.proyecto_dswii_be.convertidor;
import com.earthbook.proyecto_dswii_be.jpa.entity.RolJPA;
import com.earthbook.proyecto_dswii_be.model.dto.RolDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("convertidorRol")
public class ConvertidorRol {

    public List<RolDTO> convertirLista(List<RolJPA> listaRolesJPA){
        List<RolDTO> listaRolesDTO = new ArrayList<>();

        for(RolJPA rol: listaRolesJPA){
            listaRolesDTO.add(new RolDTO(rol));
        }

        return listaRolesDTO;
    }

    public RolDTO convertirDTO(RolJPA rolJPA){
        return new RolDTO(rolJPA);
    }

}
