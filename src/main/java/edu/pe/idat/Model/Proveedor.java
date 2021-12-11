package edu.pe.idat.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="proveedor")
public class Proveedor {
    
    @Id
    private String codproveedor;
    
    @Column(name = "Nombre")
    private String nombre;
    
    @Column(name = "Direccion")
    private String direccion;

 
    @Column(name = "Telefono")
    private Integer telefono;
    
    @Column(name = "Correo")
    private String correo;

    
    public String getCodproveedor() {
        return codproveedor;
    }

    public void setCodproveedor(String codproveedor) {
        this.codproveedor = codproveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getTelefono() {
        return telefono;
    }
    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

 

    public void setCorreo(String correo) {
        this.correo = correo;
    }



    public Proveedor(String nombre, String direccion, Integer telefono, String correo) {
        super();
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Proveedor() {
        super();
        // TODO Auto-generated constructor stub
    }

}