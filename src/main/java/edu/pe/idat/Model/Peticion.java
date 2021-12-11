package edu.pe.idat.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "peticion")
public class Peticion {
	
	@Id
	private String codpeticion;
	
	@Column(name = "Asunto")
	private String asunto;
	
	@Column(name = "Descripcion")
	private String descripcion;
	
	@Column(name = "Imagen")
	private String imagen;
	
	@Column(name = "CodCliente")
	private String codcliente;

	public String getCodpeticion() {
		return codpeticion;
	}

	public void setCodpeticion(String codpeticion) {
		this.codpeticion = codpeticion;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getCodcliente() {
		return codcliente;
	}

	public void setCodcliente(String codcliente) {
		this.codcliente = codcliente;
	}

	public Peticion(String asunto, String descripcion, String imagen, String codcliente) {
		super();
		this.asunto = asunto;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.codcliente = codcliente;
	}

	public Peticion() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
