package edu.pe.idat.Model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.sun.istack.NotNull;

@Entity
public class GuiaEntrada_Register {
	
	@Id
	private String codguiaentrada;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")			
	@Column(name ="fechaentrada")
	private LocalDate fechaentrada;
	
	@Column(name="codproveedor")
	private String codproveedor;
	
	@Column(name="codfacturaCompra")
	private String codfacturacompra;
	
	@Column(name="codusuario")
	private String codusuario;

	@Column(name="estado")
	private String estado;
	
	@Column(name="cantidad")
	private Integer cantidad;
	
	@Column(name="codproducto")
	private String codproducto;

	public String getCodguiaentrada() {
		return codguiaentrada;
	}

	public void setCodguiaentrada(String codguiaentrada) {
		this.codguiaentrada = codguiaentrada;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDate getFechaentrada() {
		return fechaentrada;
	}

	public void setFechaentrada(LocalDate fechaentrada) {
		this.fechaentrada = fechaentrada;
	}

	public String getCodproveedor() {
		return codproveedor;
	}

	public void setCodproveedor(String codproveedor) {
		this.codproveedor = codproveedor;
	}

	public String getCodfacturacompra() {
		return codfacturacompra;
	}

	public void setCodfacturacompra(String codfacturacompra) {
		this.codfacturacompra = codfacturacompra;
	}

	public String getCodusuario() {
		return codusuario;
	}

	public void setCodusuario(String codusuario) {
		this.codusuario = codusuario;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getCodproducto() {
		return codproducto;
	}

	public void setCodproducto(String codproducto) {
		this.codproducto = codproducto;
	}

	public GuiaEntrada_Register(String descripcion, LocalDate fechaentrada, String codproveedor,
			String codfacturacompra, String codusuario, String estado, Integer cantidad, String codproducto) {
		super();
		this.descripcion = descripcion;
		this.fechaentrada = fechaentrada;
		this.codproveedor = codproveedor;
		this.codfacturacompra = codfacturacompra;
		this.codusuario = codusuario;
		this.estado = estado;
		this.cantidad = cantidad;
		this.codproducto = codproducto;
	}

	public GuiaEntrada_Register() {
		super();
		// TODO Auto-generated constructor stub
	}

}
