package com.earthbook.proyecto_dswii_be.model.dto;

import com.earthbook.proyecto_dswii_be.jpa.entity.RolJPA;
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

    public RolDTO() {
    }

    public RolDTO(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public RolDTO(RolJPA jpa) {
        this.id = jpa.getId();
        this.nombre = jpa.getNombre();
        this.descripcion = getDescripcion();
    }

}