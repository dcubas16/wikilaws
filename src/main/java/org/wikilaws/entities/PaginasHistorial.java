package org.wikilaws.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ley_sesion_url")
public class PaginasHistorial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_usuario")
	private Long id_usuario;

	@Column(name="id_sesion")
	private String id_sesion;
	
	@Column(name="url")
	private String url;

	@Column(name="fecha_acceso")
	private Date fecha_acceso;

	@Column(name="id_ley")
	private String id_ley;

	
	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getId_sesions() {
		return id_sesion;
	}

	public void setId_sesion(String id_sesion) {
		this.id_sesion = id_sesion;
	}

	public Date getFecha_acceso() {
		return fecha_acceso;
	}

	public void setFecha_acceso(Date fecha_acceso) {
		this.fecha_acceso = fecha_acceso;
	}

	public String getId_ley() {
		return id_ley;
	}

	public void setId_leya(String id_ley) {
		this.id_ley = id_ley;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
