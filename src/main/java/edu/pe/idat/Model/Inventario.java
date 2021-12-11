package edu.pe.idat.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="inventario")
public class Inventario {

	@Id
	private String codinventario;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="stockinicial")
	private Integer stockinicial;
	
	@Column(name="totalstock")
	private Integer totalstock;
	
	@Column(name="estado")
	private String estado;
	
	@Column(name="codguiasalida")
	private String codguiasalida;
	
	@Column(name="codguiaentrada")
	private String codguiaentrada;
	
	@Column(name="CodProducto")
	private String codproducto;
	
	@Column(name="cantidad")
	private String cantidad;

	public String getCodinventario() {
		return codinventario;
	}

	public void setCodinventario(String codinventario) {
		this.codinventario = codinventario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getStockinicial() {
		return stockinicial;
	}

	public void setStockinicial(Integer stockinicial) {
		this.stockinicial = stockinicial;
	}

	public Integer getTotalstock() {
		return totalstock;
	}

	public void setTotalstock(Integer totalstock) {
		this.totalstock = totalstock;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCodguiasalida() {
		return codguiasalida;
	}

	public void setCodguiasalida(String codguiasalida) {
		this.codguiasalida = codguiasalida;
	}

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

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public Inventario(String descripcion, Integer stockinicial, Integer totalstock, String estado, String codguiasalida,
			String codguiaentrada, String codproducto, String cantidad) {
		super();
		this.descripcion = descripcion;
		this.stockinicial = stockinicial;
		this.totalstock = totalstock;
		this.estado = estado;
		this.codguiasalida = codguiasalida;
		this.codguiaentrada = codguiaentrada;
		this.codproducto = codproducto;
		this.cantidad = cantidad;
	}

	public Inventario() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	
}
