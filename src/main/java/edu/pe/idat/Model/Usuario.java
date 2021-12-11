package edu.pe.idat.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Usuario {

	@Id
	private String codusuario;
	
	@Column(name = "NombreUsuario")
	private String nombreusuario;
	
	@Column(name = "Clave")
	private String clave;
	
	@Column(name = "CodCargo")
	private String codcargo;
	
	@Column(name = "CodCliente")
	private String codcliente;
	
	@Column(name = "CodPeticion")
	private String codpeticion;

	public String getCodusuario() {
		return codusuario;
	}

	public void setCodusuario(String codusuario) {
		this.codusuario = codusuario;
	}

	public String getNombreusuario() {
		return nombreusuario;
	}

	public void setNombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getCodcargo() {
		return codcargo;
	}

	public void setCodcargo(String codcargo) {
		this.codcargo = codcargo;
	}

	public String getCodcliente() {
		return codcliente;
	}

	public void setCodcliente(String codcliente) {
		this.codcliente = codcliente;
	}

	public String getCodpeticion() {
		return codpeticion;
	}

	public void setCodpeticion(String codpeticion) {
		this.codpeticion = codpeticion;
	}

	public Usuario(String nombreusuario, String clave, String codcargo, String codcliente, String codpeticion) {
		super();
		this.nombreusuario = nombreusuario;
		this.clave = clave;
		this.codcargo = codcargo;
		this.codcliente = codcliente;
		this.codpeticion = codpeticion;
	}

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
