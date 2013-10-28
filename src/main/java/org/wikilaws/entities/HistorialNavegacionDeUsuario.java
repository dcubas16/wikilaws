package org.wikilaws.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ley_sesion_url")
public class HistorialNavegacionDeUsuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_ley_sesion_url")
	private Long id_ley_sesion_url;
	
	@Column(name="id_normas")
	private Long id_normas;
	
	@Column(name="fecha_acceso")
	private Date fecha_acceso;
	
	@ManyToOne
    @JoinColumn(name="id_usuario", nullable = false)
    private Usuario usuario;
	
	public HistorialNavegacionDeUsuario(Long id_ley_sesion_url, Long id_normas,
			Date fecha_acceso, Usuario usuario) {
		super();
		this.id_ley_sesion_url = id_ley_sesion_url;
		this.id_normas = id_normas;
		this.fecha_acceso = fecha_acceso;
		this.usuario = usuario;
	}

	public Long getId_ley_sesion_url() {
		return id_ley_sesion_url;
	}

	public void setId_ley_sesion_url(Long id_ley_sesion_url) {
		this.id_ley_sesion_url = id_ley_sesion_url;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario get_usuario() {
		return usuario;
	}

	public void set_usuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getId_normas() {
		return id_normas;
	}

	public void setId_normas(Long id_normas) {
		this.id_normas = id_normas;
	}
	
	public Date getFecha_acceso() {
		return fecha_acceso;
	}

	public void setFecha_acceso(Date fecha_acceso) {
		this.fecha_acceso = fecha_acceso;
	}
}
