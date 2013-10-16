package org.wikilaws.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ley_normas")
public class LeyNorma {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_normas")
	private Long id_normas;

	@Column(name="pais")
	private String pais;
	
	@Column(name="tipo")
	private String tipo;

	@Column(name="numero_norma")
	private String numero_norma;

	@Column(name="descripcion")
	private String descripcion;

	@Column(name="contenido")
	private String contenido;

	@Column(name="fecha_dacion")
	private String fecha_dacion;

	@Column(name="fecha_promulgacion")
	private String fecha_promulgacion;

	@Column(name="fecha_publicacion")
	private String fecha_publicacion;

	@Column(name="estado")
	private String estado;
	
	@Column(name="url")
	private String url;
	

	public Long getId_normas() {
		return id_normas;
	}

	public void setId_normas(Long id_normas) {
		this.id_normas = id_normas;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNumero_norma() {
		return numero_norma;
	}

	public void setNumero_norma(String numero_norma) {
		this.numero_norma = numero_norma;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getFecha_dacion() {
		return fecha_dacion;
	}

	public void setFecha_dacion(String fecha_dacion) {
		this.fecha_dacion = fecha_dacion;
	}

	public String getFecha_promulgacion() {
		return fecha_promulgacion;
	}

	public void setFecha_promulgacion(String fecha_promulgacion) {
		this.fecha_promulgacion = fecha_promulgacion;
	}

	public String getFecha_publicacion() {
		return fecha_publicacion;
	}

	public void setFecha_publicacion(String fecha_publicacion) {
		this.fecha_publicacion = fecha_publicacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
