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
import edu.pe.idat.Model.Usuario;
import edu.pe.idat.Model.Response.ResultadoResponse;
import edu.pe.idat.service.UsuarioService;

 

@Controller
@RequestMapping("/Usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService servicio;
    
    @GetMapping("/vistausuario")
    public String list(Model model) {
        model.addAttribute("formulario", servicio.listar());
        return "Usuario/vistausuario";
    }
    
    
    @PostMapping("/registrarUsuariojs")
    @ResponseBody
    public ResultadoResponse registrarUsuario(@RequestBody Usuario objUsuario) {
        String mensaje = "Usuario registrado correctamente";
        Boolean respuesta = true;
        try {
            servicio.registrarUsuario(objUsuario);
        }catch(Exception ex) {
            mensaje = "Usuario no registrado";
            respuesta = false;
        }
        return new ResultadoResponse(respuesta, mensaje);
    }
    
    @GetMapping("/listarUsuariojs")
    @ResponseBody
    public List<Usuario> listarUsuario(){
        return servicio.listar();
    }
    
    
    @DeleteMapping("/eliminarUsuariojs")
    @ResponseBody
    public ResultadoResponse eliminarUsuario(@RequestBody Usuario objUsuario) {
        String mensaje = "Usuario eliminado correctamente";
        Boolean respuesta = true;
        try {
            servicio.eliminarUsuario(objUsuario);
        }catch(Exception ex) {
            mensaje = "Usuario no eliminado";
            respuesta = false;
        }
        return new ResultadoResponse(respuesta, mensaje);
    }
}