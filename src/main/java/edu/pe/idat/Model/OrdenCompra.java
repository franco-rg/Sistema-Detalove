package edu.pe.idat.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="ordencompra")
public class OrdenCompra 
{
	@Id
	private String CodOrdenCompra;
	
	@Column
	private String Descripcion;
		
	@DateTimeFormat(pattern="yyyy-MM-dd",iso=ISO.DATE)
	private Date Fecha;
	
	@Column
	private Double IGV;
	
	@Column
	private Double Total;
	
	@Column
	private String CodUsuario;
	
	@Column
	private String CodProveedor;
	
	public OrdenCompra() {		
	}

	public OrdenCompra(String codOrdenCompra, String descripcion, Date fecha, Double iGV, Double total,
			String codUsuario, String codProveedor) {
		CodOrdenCompra = codOrdenCompra;
		Descripcion = descripcion;
		Fecha = fecha;
		IGV = iGV;
		Total = total;
		CodUsuario = codUsuario;
		CodProveedor = codProveedor;
	}

	public String getCodOrdenCompra() {
		return CodOrdenCompra;
	}

	public void setCodOrdenCompra(String codOrdenCompra) {
		CodOrdenCompra = codOrdenCompra;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	public Double getIGV() {
		return IGV;
	}

	public void setIGV(Double iGV) {
		IGV = iGV;
	}

	public Double getTotal() {
		return Total;
	}

	public void setTotal(Double total) {
		Total = total;
	}

	public String getCodUsuario() {
		return CodUsuario;
	}

	public void setCodUsuario(String codUsuario) {
		CodUsuario = codUsuario;
	}

	public String getCodProveedor() {
		return CodProveedor;
	}

	public void setCodProveedor(String codProveedor) {
		CodProveedor = codProveedor;
	}
}
