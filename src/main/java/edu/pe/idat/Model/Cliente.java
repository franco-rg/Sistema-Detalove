package edu.pe.idat.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	
	
	@Id
	private String codcliente;
	
	
	@Column(name = "Nombre")
	private String nombre;
	
	
	@Column(name = "Apellido")
	private String apellido;
	
	
	@Column(name = "Edad")
	private Integer edad;
	
	
	@Column(name = "Celular")
	private Integer celular;
	
	
	@Column(name = "Genero")
	private String genero;

	
	@Column(name = "Direccion")
	private String direccion;


	public String getCodcliente() {
		return codcliente;
	}


	public void setCodcliente(String codcliente) {
		this.codcliente = codcliente;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public Integer getEdad() {
		return edad;
	}


	public void setEdad(Integer edad) {
		this.edad = edad;
	}


	public Integer getCelular() {
		return celular;
	}


	public void setCelular(Integer celular) {
		this.celular = celular;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public Cliente(String nombre, String apellido, Integer edad, Integer celular, String genero, String direccion) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.celular = celular;
		this.genero = genero;
		this.direccion = direccion;
	}


	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
}
