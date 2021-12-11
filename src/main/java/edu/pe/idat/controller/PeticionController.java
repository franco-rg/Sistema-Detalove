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
import edu.pe.idat.Model.Peticion;
import edu.pe.idat.Model.Response.ResultadoResponse;
import edu.pe.idat.service.PeticionService;

 

@Controller
@RequestMapping("/Peticion")
public class PeticionController {
    
    @Autowired
    private PeticionService servicio;
    
    @GetMapping("/vistapeticion")
    public String list(Model model) {
        model.addAttribute("formulario", servicio.listar());
        return "Peticion/vistapeticion";
    }
    
    
    @PostMapping("/registrarPeticionjs")
    @ResponseBody
    public ResultadoResponse registrarPeticion(@RequestBody Peticion objPeticion) {
        String mensaje = "Peticion registrado correctamente";
        Boolean respuesta = true;
        try {
            servicio.registrarPeticion(objPeticion);
        }catch(Exception ex) {
            mensaje = "Peticion no registrado";
            respuesta = false;
        }
        return new ResultadoResponse(respuesta, mensaje);
    }
    
    @GetMapping("/listarPeticionjs")
    @ResponseBody
    public List<Peticion> listarPeticion(){
        return servicio.listar();
    }
    
    
    @DeleteMapping("/eliminarPeticionjs")
    @ResponseBody
    public ResultadoResponse eliminarPeticion(@RequestBody Peticion objPeticion) {
        String mensaje = "Peticion eliminado correctamente";
        Boolean respuesta = true;
        try {
            servicio.eliminarPeticion(objPeticion);
        }catch(Exception ex) {
            mensaje = "Peticion no eliminado";
            respuesta = false;
        }
        return new ResultadoResponse(respuesta, mensaje);
    }
}