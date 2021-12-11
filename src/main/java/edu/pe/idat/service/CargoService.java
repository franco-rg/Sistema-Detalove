package edu.pe.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.pe.idat.Model.Cargo;
import edu.pe.idat.repository.CargoRepository;


@Service
public class CargoService {
    @Autowired
    private CargoRepository llamar;
    
    public List<Cargo> listar(){
        return llamar.findAll();
    }
    
    public void registrarCargo(Cargo p) {
        if(p.getCodcargo()==null) {
            llamar.registrarCargo(p.getNombre(), p.getEstado());
        }
        else {
            llamar.actualizarCargo(p.getCodcargo(), p.getNombre(), p.getEstado());
        }
        
    }
    public void eliminarCargo(Cargo p) {
        llamar.eliminarCargo(p.getCodcargo());
    }
}