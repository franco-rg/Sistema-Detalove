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
import edu.pe.idat.Model.Cliente;
import edu.pe.idat.Model.Response.ResultadoResponse;
import edu.pe.idat.service.ClienteService;

 

@Controller
@RequestMapping("/Cliente")
public class ClienteController {
    
    @Autowired
    private ClienteService servicio;
    
    @GetMapping("/vistacliente")
    public String list(Model model) {
        model.addAttribute("formulario", servicio.listar());
        return "Cliente/vistacliente";
    }
    
    
    @PostMapping("/registrarClientejs")
    @ResponseBody
    public ResultadoResponse registrarCliente(@RequestBody Cliente objCliente) {
        String mensaje = "Cliente registrado correctamente";
        Boolean respuesta = true;
        try {
            servicio.registrarCliente(objCliente);
        }catch(Exception ex) {
            mensaje = "Cliente no registrado";
            respuesta = false;
        }
        return new ResultadoResponse(respuesta, mensaje);
    }
    
    @GetMapping("/listarClientejs")
    @ResponseBody
    public List<Cliente> listarCliente(){
        return servicio.listar();
    }
    
    
    @DeleteMapping("/eliminarClientejs")
    @ResponseBody
    public ResultadoResponse eliminarCliente(@RequestBody Cliente objCliente) {
        String mensaje = "Cliente eliminado correctamente";
        Boolean respuesta = true;
        try {
            servicio.eliminarCliente(objCliente);
        }catch(Exception ex) {
            mensaje = "Cliente no eliminado";
            respuesta = false;
        }
        return new ResultadoResponse(respuesta, mensaje);
    }
}