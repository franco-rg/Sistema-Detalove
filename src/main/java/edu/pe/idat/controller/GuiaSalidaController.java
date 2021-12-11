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
import edu.pe.idat.Model.GuiaSalida;
import edu.pe.idat.Model.Response.ResultadoResponse;
import edu.pe.idat.service.GuiaSalidaService;

 

@Controller
@RequestMapping("/GuiaSalida")
public class GuiaSalidaController {
    
    @Autowired
    private GuiaSalidaService servicio;
    
    @GetMapping("/vistaguiasalida")
    public String list(Model model) {
        model.addAttribute("formulario", servicio.listarGuiaSalida());
        return "GuiaSalida/vistaguiasalida";
    }
    
    
    @PostMapping("/registrarGuiaSalidajs")
    @ResponseBody
    public ResultadoResponse registrarGuiaSalida(@RequestBody GuiaSalida objGuiaSalida) {
        String mensaje = "GuiaSalida registrada correctamente";
        Boolean respuesta = true;
        try {
            servicio.registrarGuiaSalida(objGuiaSalida);
        }catch(Exception ex) {
            mensaje = "GuiaSalida no registrada";
            respuesta = false;
        }
        return new ResultadoResponse(respuesta, mensaje);
    }
    
    @GetMapping("/listarGuiaSalidajs")
    @ResponseBody
    public List<GuiaSalida> listarGuiaSalida(){
        return servicio.listarGuiaSalida();
    }
    
    
    @DeleteMapping("/eliminarGuiaSalidajs")
    @ResponseBody
    public ResultadoResponse eliminarGuiaSalida(@RequestBody GuiaSalida objGuiaSalida) {
        String mensaje = "GuiaSalida eliminada correctamente";
        Boolean respuesta = true;
        try {
            servicio.eliminarGuiaSalida(objGuiaSalida);
        }catch(Exception ex) {
            mensaje = "GuiaSalida no eliminada";
            respuesta = false;
        }
        return new ResultadoResponse(respuesta, mensaje);
    }
}