package edu.pe.idat.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="producto")  
public class Producto {
	@Id
	private String CodProducto;
	
	@Column(name="Nombre")
	private String nombre;
	
	@Column(name="PrecioUni")
	private Double preciouni;
	
	@Column(name="Detalle")
	private String detalle;
	
	@Column(name="Imagen")
	private String imagen;
	
	@Column(name="CodCategoria")
	private String codcategoria;

	
	public String getCodProducto() {
		return CodProducto;
	}

	public void setCodProducto(String codProducto) {
		CodProducto = codProducto;
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

	public String getCodcategoria() {
		return codcategoria;
	}

	public void setCodcategoria(String codcategoria) {
		this.codcategoria = codcategoria;
	}

	public Producto(String nombre, Double preciouni, String detalle, String imagen, String codcategoria) {
		super();
		this.nombre = nombre;
		this.preciouni = preciouni;
		this.detalle = detalle;
		this.imagen = imagen;
		this.codcategoria = codcategoria;
	}

	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
