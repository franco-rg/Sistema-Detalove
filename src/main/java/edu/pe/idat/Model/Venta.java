package edu.pe.idat.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="venta")
public class Venta {
    
    @Id
    private String codventa;
    
    @Column(name = "TipoDocumento")
    private String tipodocumento;
    
    @Column(name = "FormaPago")
    private String formapago;

    @Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
    @Column(name = "Fecha")
    private Date fecha;
    
    @Column(name = "IGV")
    private Double igv;
    
    @Column(name = "SubTotal")
    private Double subtotal;
    
   
    @Column(name = "Total")
    private Double total;

    @Column(name = "Estado")
    private String estado;
    
    @Column(name = "CodCliente")
    private String codcliente;

	public String getCodventa() {
		return codventa;
	}

	public void setCodventa(String codventa) {
		this.codventa = codventa;
	}

	public String getTipodocumento() {
		return tipodocumento;
	}

	public void setTipodocumento(String tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	public String getFormapago() {
		return formapago;
	}

	public void setFormapago(String formapago) {
		this.formapago = formapago;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Double getIgv() {
		return igv;
	}

	public void setIgv(Double igv) {
		this.igv = igv;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCodcliente() {
		return codcliente;
	}

	public void setCodcliente(String codcliente) {
		this.codcliente = codcliente;
	}

	public Venta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Venta(String tipodocumento, String formapago, Date fecha, Double igv, Double subtotal, Double total,
			String estado, String codcliente) {
		super();
		this.tipodocumento = tipodocumento;
		this.formapago = formapago;
		this.fecha = fecha;
		this.igv = igv;
		this.subtotal = subtotal;
		this.total = total;
		this.estado = estado;
		this.codcliente = codcliente;
	}
    
}

