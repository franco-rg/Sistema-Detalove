package edu.pe.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.pe.idat.Model.Cliente;
import edu.pe.idat.repository.ClienteRepository;


@Service
public class ClienteService {
    @Autowired
    private ClienteRepository llamar;
    
    public List<Cliente> listar(){
        return llamar.findAll();
    }
    
    public void registrarCliente(Cliente p) {
        if(p.getCodcliente()==null) {
            llamar.registrarCliente(p.getNombre(), p.getApellido(), p.getEdad(), p.getCelular(), p.getGenero(), p.getDireccion());
        }
        else {
            llamar.actualizarCliente(p.getCodcliente(), p.getNombre(), p.getApellido(), p.getEdad(), p.getCelular(), p.getGenero(), p.getDireccion());
        }
        
    }
    public void eliminarCliente(Cliente p) {
        llamar.eliminarCliente(p.getCodcliente());
    }
}