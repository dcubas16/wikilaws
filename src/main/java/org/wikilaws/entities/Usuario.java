package org.wikilaws.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long id_usuario;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "password")
	private String password;

	@OneToMany(mappedBy="usuario")
	private Set<HistorialNavegacionDeUsuario> historialNavegacionDeUsuarios;
	
	public Set<HistorialNavegacionDeUsuario> getHistorialNavegacionDeUsuarios() {
		return historialNavegacionDeUsuarios;
	}

	public void setHistorialNavegacionDeUsuarios(
			Set<HistorialNavegacionDeUsuario> historialNavegacionDeUsuarios) {
		this.historialNavegacionDeUsuarios = historialNavegacionDeUsuarios;
	}

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
