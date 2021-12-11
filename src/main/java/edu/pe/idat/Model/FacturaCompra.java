package edu.pe.idat.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="facturacompra")
public class FacturaCompra {

	@Id
	private String codfacturacompra;

	@Column(name="Fecha")
	private Date fecha;

	@Column(name="FormaPago")
	private String formapago;

	@Column(name="SubTotal")
	private Double subtotal;

	@Column(name="IGV")
	private Double igv;

	@Column(name="Descuento")
	private Double descuento;

	@Column(name="MontoFactura")
	private Double montofactura;

	@Column(name="Estado")
	private String estado;

	@Column(name="CodOrdenCompra")
	private String codordencompra;

	public String getCodfacturacompra() {
		return codfacturacompra;
	}

	public void setCodfacturacompra(String codfacturacompra) {
		this.codfacturacompra = codfacturacompra;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getFormapago() {
		return formapago;
	}

	public void setFormapago(String formapago) {
		this.formapago = formapago;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Double getIgv() {
		return igv;
	}

	public void setIgv(Double igv) {
		this.igv = igv;
	}

	public Double getDescuento() {
		return descuento;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}

	public Double getMontofactura() {
		return montofactura;
	}

	public void setMontofactura(Double montofactura) {
		this.montofactura = montofactura;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCodordencompra() {
		return codordencompra;
	}

	public void setCodordencompra(String codordencompra) {
		this.codordencompra = codordencompra;
	}

	public FacturaCompra(Date fecha, String formapago, Double subtotal, Double igv, Double descuento,
			Double montofactura, String estado, String codordencompra) {
		super();
		this.fecha = fecha;
		this.formapago = formapago;
		this.subtotal = subtotal;
		this.igv = igv;
		this.descuento = descuento;
		this.montofactura = montofactura;
		this.estado = estado;
		this.codordencompra = codordencompra;
	}

	public FacturaCompra() {
		super();
		// TODO Auto-generated constructor stub
	}



}
