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
@Table(name="GuiaSalida")
public class GuiaSalida {
    
    @Id
    private String codguiasalida;
    
    @Column(name = "Descripcion")
    private String descripcion;
    
    
    @Temporal(TemporalType.DATE)
   	@DateTimeFormat(iso = ISO.DATE)
    @Column(name = "FechaSalida")
    private Date fechasalida;

 
    @Column(name = "Solicitado")
    private String solicitado;
    
    @Column(name = "Aprobado")
    private String aprobado;
    
    @Column(name = "Entregado")
    private String entregado;
    
    @Column(name = "Recibido")
    private String recibido;
    
    @Column(name = "CodVenta")
    private String codventa;

    
    public String getCodGuiaSalida() {
        return codguiasalida;
    }

    public void setCodGuiaSalida(String codguiasalida) {
        this.codguiasalida = codguiasalida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaSalida() {
        return fechasalida;
    }

    public void setFechaSalida(Date fechasalida) {
        this.fechasalida = fechasalida;
    }

    public String getSolicitado() {
        return solicitado;
    }
    public void setSolicitado(String solicitado) {
        this.solicitado = solicitado;
    }
    
    
    public String getAprobado() {
        return aprobado;
    }
    public void setAprobado(String aprobado) {
        this.aprobado = aprobado;
    }
    
    public String getEntregado() {
        return entregado;
    }
    public void setEntregado(String entregado) {
        this.entregado = entregado;
    }

    public String getRecibido() {
        return recibido;
    }
    public void setRecibido(String recibido) {
        this.recibido = recibido;
    }

    public String getCodVenta() {
        return codventa;
    }

    public void setCodVenta(String codventa) {
        this.codventa = codventa;
    }


    public GuiaSalida(String descripcion, Date fechasalida, String solicitado, String aprobado, String entregado, String recibido, String codventa) {
        super();
        this.descripcion = descripcion;
        this.fechasalida = fechasalida;
        this.solicitado = solicitado;
        this.aprobado = aprobado;
        this.entregado = entregado;
        this.recibido = recibido;
        this.codventa = codventa;
    }

    public GuiaSalida() {
        super();
        // TODO Auto-generated constructor stub
    }

}