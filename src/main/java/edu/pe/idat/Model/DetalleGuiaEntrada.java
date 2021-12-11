package edu.pe.idat.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DetalleGuiaEntrada {
	
	@Id
	private String codguiaentrada;
	
	@Column(name="CodProducto")
	private String codproducto;
	
	@Column(name="Cantidad")
	private Integer cantidad;

	public String getCodguiaentrada() {
		return codguiaentrada;
	}

	public void setCodguiaentrada(String codguiaentrada) {
		this.codguiaentrada = codguiaentrada;
	}

	public String getCodproducto() {
		return codproducto;
	}

	public void setCodproducto(String codproducto) {
		this.codproducto = codproducto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public DetalleGuiaEntrada(String codproducto, Integer cantidad) {
		super();
		this.codproducto = codproducto;
		this.cantidad = cantidad;
	}

	public DetalleGuiaEntrada() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
}
