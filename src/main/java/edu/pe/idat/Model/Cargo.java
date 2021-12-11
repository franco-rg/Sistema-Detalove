package edu.pe.idat.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cargo")
public class Cargo {

	@Id
	private String codcargo;
	
	
	@Column(name = "Nombre")
	private String nombre;
	
	
	@Column(name = "Estado")
	private String estado;


	public String getCodcargo() {
		return codcargo;
	}


	public void setCodcargo(String codcargo) {
		this.codcargo = codcargo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public Cargo(String nombre, String estado) {
		super();
		this.nombre = nombre;
		this.estado = estado;
	}


	public Cargo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
