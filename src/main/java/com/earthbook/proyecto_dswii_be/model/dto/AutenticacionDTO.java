package com.earthbook.proyecto_dswii_be.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AutenticacionDTO implements Serializable {

    private String usuario;
    private String clave;

}
