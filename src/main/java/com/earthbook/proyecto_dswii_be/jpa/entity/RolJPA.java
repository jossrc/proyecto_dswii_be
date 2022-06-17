package com.earthbook.proyecto_dswii_be.jpa.entity;

import com.earthbook.proyecto_dswii_be.model.dto.RolDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "ROL")
public class RolJPA implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String descripcion;

    public RolJPA() {
    }

    public RolJPA(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public RolJPA(RolDTO dto) {
        this.id = dto.getId();
        this.nombre = dto.getNombre();
        this.descripcion = dto.getDescripcion();
    }

}
