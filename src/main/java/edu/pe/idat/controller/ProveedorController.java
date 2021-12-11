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
import edu.pe.idat.Model.Proveedor;
import edu.pe.idat.Model.Response.ResultadoResponse;
import edu.pe.idat.service.ProveedorService;

 

@Controller
@RequestMapping("/Proveedor")
public class ProveedorController {
    
    @Autowired
    private ProveedorService servicio;
    
    @GetMapping("/vistaproveedor")
    public String list(Model model) {
        model.addAttribute("formulario", servicio.listar());
        return "Proveedor/vistaproveedor";
    }
    
    
    @PostMapping("/registrarProveedorjs")
    @ResponseBody
    public ResultadoResponse registrarProveedor(@RequestBody Proveedor objProveedor) {
        String mensaje = "Proveedor registrado correctamente";
        Boolean respuesta = true;
        try {
            servicio.registrarProveedor(objProveedor);
        }catch(Exception ex) {
            mensaje = "Proveedor no registrado";
            respuesta = false;
        }
        return new ResultadoResponse(respuesta, mensaje);
    }
    
    @GetMapping("/listarProveedorjs")
    @ResponseBody
    public List<Proveedor> listarProveedor(){
        return servicio.listar();
    }
    
    
    @DeleteMapping("/eliminarProveedorjs")
    @ResponseBody
    public ResultadoResponse eliminarProveedor(@RequestBody Proveedor objProveedor) {
        String mensaje = "Proveedor eliminado correctamente";
        Boolean respuesta = true;
        try {
            servicio.eliminarProveedor(objProveedor);
        }catch(Exception ex) {
            mensaje = "Proveedor no eliminado";
            respuesta = false;
        }
        return new ResultadoResponse(respuesta, mensaje);
    }
}