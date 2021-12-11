package edu.pe.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.pe.idat.Model.Peticion;
import edu.pe.idat.repository.PeticionRepository;


@Service
public class PeticionService {
    @Autowired
    private PeticionRepository llamar;
    
    public List<Peticion> listar(){
        return llamar.findAll();
    }
    
    public void registrarPeticion(Peticion p) {
        if(p.getCodpeticion()==null) {
            llamar.registrarPeticion(p.getAsunto(), p.getDescripcion(), p.getImagen(), p.getCodcliente());
        }
        else {
            llamar.actualizarPeticion(p.getCodpeticion(), p.getAsunto(), p.getDescripcion(), p.getImagen(), p.getCodcliente());
        }
        
    }
    public void eliminarPeticion(Peticion p) {
        llamar.eliminarPeticion(p.getCodpeticion());
    }
    

}