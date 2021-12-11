package edu.pe.idat.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Categoria {
	
	@Id
	private String codcategoria;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="descripcion")
	private String Descripcion;

	public String getCodcategoria() {
		return codcategoria;
	}

	public void setCodcategoria(String codcategoria) {
		this.codcategoria = codcategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public Categoria(String codcategoria, String nombre, String descripcion) {
		super();
		this.nombre = nombre;
		Descripcion = descripcion;
	}

	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
