package edu.pe.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.pe.idat.Model.Venta;
import edu.pe.idat.repository.VentaRepository;


@Service
public class VentaService {
    @Autowired
    private VentaRepository llamar;
    
    public List<Venta> listar(){
        return llamar.findAll();
    }
    
    public void registrarVenta(Venta v) {
        if(v.getCodventa()==null) {
            llamar.registrarVenta(v.getTipodocumento(), v.getFormapago(), v.getFecha(), v.getIgv(), v.getSubtotal(), v.getTotal(), v.getEstado(), v.getCodcliente());
        }
        else {
            llamar.actualizarVenta(v.getCodventa(),v.getTipodocumento(), v.getFormapago(), v.getFecha(), v.getIgv(), v.getSubtotal(), v.getTotal(), v.getEstado(), v.getCodcliente());
        }
        
    }
    public void eliminarVenta(Venta v) {
        llamar.eliminarVenta(v.getCodventa());
    }
}