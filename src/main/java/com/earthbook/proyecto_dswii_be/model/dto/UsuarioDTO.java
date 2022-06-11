package com.earthbook.proyecto_dswii_be.model.dto;


import com.earthbook.proyecto_dswii_be.jpa.entity.UsuarioJPA;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UsuarioDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    public UsuarioDTO() {
    }

    public UsuarioDTO(int id, String nombres, String apellidos, String direccion, String email, String password, int estado, String imagen, RolDTO rol, int id_pais) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.email = email;
        this.password = password;
        this.estado = estado;
        this.imagen = imagen;
        this.rol = rol;
        this.id_pais = id_pais;
    }

    public UsuarioDTO(UsuarioJPA jpa) {
        this.id = jpa.getId();
        this.nombres = jpa.getNombres();
        this.apellidos = jpa.getApellidos();
        this.direccion = jpa.getDireccion();
        this.email = jpa.getEmail();
        this.password = jpa.getPassword();
        this.estado = jpa.getEstado();
        this.imagen = jpa.getImagen();
        this.rol = new RolDTO(jpa.getRol());
        this.id_pais = jpa.getId_pais();
    }

    private int id;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String email;
    private String password;
    private int estado;
    private String imagen;
    private RolDTO rol;
    private int id_pais;

}
