package edu.pe.idat.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Producto {
	@Id
	private String codproducto;
	
	@Column(name="Nombre")
	private String nombre;
	
	@Column(name="PrecioUni")
	private Double preciouni;
	
	@Column(name="Detalle")
	private String detalle;
	
	@Column(name="Imagen")
	private String imagen;

	@Column(name="Tamano")
	private String tamano;
	
	@Column(name="Publico")
	private String publico;
	
	@Column(name="Estado")
	private String estado;
	
	@Column(name="CodCategoria")
	private String codcategoria;

	public String getCodproducto() {
		return codproducto;
	}

	public void setCodproducto(String codproducto) {
		this.codproducto = codproducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPreciouni() {
		return preciouni;
	}

	public void setPreciouni(Double preciouni) {
		this.preciouni = preciouni;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getTamano() {
		return tamano;
	}

	public void setTamano(String tamano) {
		this.tamano = tamano;
	}

	public String getPublico() {
		return publico;
	}

	public void setPublico(String publico) {
		this.publico = publico;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCodcategoria() {
		return codcategoria;
	}

	public void setCodcategoria(String codcategoria) {
		this.codcategoria = codcategoria;
	}

	public Producto(String nombre, Double preciouni, String detalle, String imagen, String tamano, String publico,
			String estado, String codcategoria) {
		super();
		this.nombre = nombre;
		this.preciouni = preciouni;
		this.detalle = detalle;
		this.imagen = imagen;
		this.tamano = tamano;
		this.publico = publico;
		this.estado = estado;
		this.codcategoria = codcategoria;
	}

	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
