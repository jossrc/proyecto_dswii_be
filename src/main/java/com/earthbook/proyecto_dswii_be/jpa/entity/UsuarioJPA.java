package com.earthbook.proyecto_dswii_be.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "USUARIO")
public class UsuarioJPA implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombres;
	private String apellidos;
	private String direccion;
	private String email;
	private String password;
	private int estado;
	private String imagen;
	private int id_rol;
	private int id_pais;	

}
