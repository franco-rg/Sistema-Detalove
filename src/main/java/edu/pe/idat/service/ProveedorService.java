package edu.pe.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.pe.idat.Model.Proveedor;
import edu.pe.idat.repository.ProveedorRepository;


@Service
public class ProveedorService {
    @Autowired
    private ProveedorRepository llamar;
    
    public List<Proveedor> listar(){
        return llamar.findAll();
    }
    
    public void registrarProveedor(Proveedor p) {
        if(p.getCodproveedor()==null) {
            llamar.registrarProveedor(p.getNombre(), p.getDireccion(), p.getTelefono(), p.getCorreo());
        }
        else {
            llamar.actualizarProveedor(p.getCodproveedor(), p.getNombre(), p.getDireccion(), p.getTelefono(), p.getCorreo());
        }
        
    }
    public void eliminarProveedor(Proveedor p) {
        llamar.eliminarProveedor(p.getCodproveedor());
    }
}