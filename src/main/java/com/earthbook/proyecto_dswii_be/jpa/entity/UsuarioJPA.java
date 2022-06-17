package com.earthbook.proyecto_dswii_be.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;

import com.earthbook.proyecto_dswii_be.model.dto.UsuarioDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "USUARIO")
public class UsuarioJPA implements Serializable {

	private static final long serialVersionUID = 1L;

	public UsuarioJPA() {
	}

	public UsuarioJPA(int id, String nombres, String apellidos, String direccion, String email, String password, int estado, String imagen, RolJPA rol, int id_pais) {
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

	public UsuarioJPA(UsuarioDTO dto) {
		this.id = dto.getId();
		this.nombres = dto.getNombres();
		this.apellidos = dto.getApellidos();
		this.direccion = dto.getDireccion();
		this.email = dto.getEmail();
		this.password = dto.getPassword();
		this.estado = dto.getEstado();
		this.imagen = dto.getImagen();
		this.rol = new RolJPA(dto.getRol());
		this.id_pais = dto.getId_pais();
	}

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

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_rol")
	private RolJPA rol;
	private int id_pais;	

}
