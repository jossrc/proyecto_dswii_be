package com.earthbook.proyecto_dswii_be.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class RolDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private String nombre;
    private String descripcion;

}