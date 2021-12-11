package edu.pe.idat.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import edu.pe.idat.Model.Venta;
import edu.pe.idat.Model.Response.ResultadoResponse;
import edu.pe.idat.service.VentaService;

 

@Controller
@RequestMapping("/Venta")
public class VentaController {
    
    @Autowired
    private VentaService servicio;
    
    @GetMapping("/vistaventa")
    public String list(Model model) {
        model.addAttribute("formulario", servicio.listar());
        return "Venta/vistaventa";
    }
    
    
    @PostMapping("/registrarVentajs")
    @ResponseBody
    public ResultadoResponse registrarVenta(@RequestBody Venta objVenta) {
        String mensaje = "Venta registrado correctamente";
        Boolean respuesta = true;
        try {
            servicio.registrarVenta(objVenta);
        }catch(Exception ex) {
            mensaje = "Venta no registrado";
            respuesta = false;
        }
        return new ResultadoResponse(respuesta, mensaje);
    }
    
    @GetMapping("/listarVentajs")
    @ResponseBody
    public List<Venta> listarVenta(){
        return servicio.listar();
    }
    
    
    @DeleteMapping("/eliminarVentajs")
    @ResponseBody
    public ResultadoResponse eliminarVenta(@RequestBody Venta objVenta) {
        String mensaje = "Venta eliminada correctamente";
        Boolean respuesta = true;
        try {
            servicio.eliminarVenta(objVenta);
        }catch(Exception ex) {
            mensaje = "Venta no eliminada";
            respuesta = false;
        }
        return new ResultadoResponse(respuesta, mensaje);
    }
}