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
public class GuiaEntrada {
	
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

	@Column(name="nombre_producto")
	private String nombre_producto;

	@Column(name="nombre_usuario")
	private String nombre_usuario;

	@Column(name="nombre_proveedor")
	private String nombre_proveedor;

	@Column(name="fecha_factura")
	private Date fecha_factura;
	
	@Column(name="monto_factura")
	private Double monto_factura;

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

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getNombre_proveedor() {
		return nombre_proveedor;
	}

	public void setNombre_proveedor(String nombre_proveedor) {
		this.nombre_proveedor = nombre_proveedor;
	}

	public Date getFecha_factura() {
		return fecha_factura;
	}

	public void setFecha_factura(Date fecha_factura) {
		this.fecha_factura = fecha_factura;
	}

	public Double getMonto_factura() {
		return monto_factura;
	}

	public void setMonto_factura(Double monto_factura) {
		this.monto_factura = monto_factura;
	}

	public GuiaEntrada(String descripcion, LocalDate fechaentrada, String codproveedor, String codfacturacompra,
			String codusuario, String estado, Integer cantidad, String codproducto, String nombre_producto,
			String nombre_usuario, String nombre_proveedor, Date fecha_factura, Double monto_factura) {
		super();
		this.descripcion = descripcion;
		this.fechaentrada = fechaentrada;
		this.codproveedor = codproveedor;
		this.codfacturacompra = codfacturacompra;
		this.codusuario = codusuario;
		this.estado = estado;
		this.cantidad = cantidad;
		this.codproducto = codproducto;
		this.nombre_producto = nombre_producto;
		this.nombre_usuario = nombre_usuario;
		this.nombre_proveedor = nombre_proveedor;
		this.fecha_factura = fecha_factura;
		this.monto_factura = monto_factura;
	}

	public GuiaEntrada() {
		super();
		// TODO Auto-generated constructor stub
	}	
		
}
