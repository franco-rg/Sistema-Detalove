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
import edu.pe.idat.Model.Cargo;
import edu.pe.idat.Model.Response.ResultadoResponse;
import edu.pe.idat.service.CargoService;

 

@Controller
@RequestMapping("/Cargo")
public class CargoController {
    
    @Autowired
    private CargoService servicio;
    
    @GetMapping("/vistacargo")
    public String list(Model model) {
        model.addAttribute("formulario", servicio.listar());
        return "Cargo/vistacargo";
    }
    
    
    @PostMapping("/registrarCargojs")
    @ResponseBody
    public ResultadoResponse registrarCargo(@RequestBody Cargo objCargo) {
        String mensaje = "Cargo registrado correctamente";
        Boolean respuesta = true;
        try {
            servicio.registrarCargo(objCargo);
        }catch(Exception ex) {
            mensaje = "Cargo no registrado";
            respuesta = false;
        }
        return new ResultadoResponse(respuesta, mensaje);
    }
    
    @GetMapping("/listarCargojs")
    @ResponseBody
    public List<Cargo> listarCargo(){
        return servicio.listar();
    }
    
    
    @DeleteMapping("/eliminarCargojs")
    @ResponseBody
    public ResultadoResponse eliminarCargo(@RequestBody Cargo objCargo) {
        String mensaje = "Cargo eliminado correctamente";
        Boolean respuesta = true;
        try {
            servicio.eliminarCargo(objCargo);
        }catch(Exception ex) {
            mensaje = "Cargo no eliminado";
            respuesta = false;
        }
        return new ResultadoResponse(respuesta, mensaje);
    }
}