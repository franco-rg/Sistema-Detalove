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

import edu.pe.idat.Model.Producto;
import edu.pe.idat.Model.Response.ResultadoResponse;
import edu.pe.idat.service.ProductoService;

@Controller
@RequestMapping("/Producto")
public class ProductoController {
	
	@Autowired
	private ProductoService servicio;
	
	@GetMapping("/vistaproducto")
	public String list(Model model) {
		model.addAttribute("formulario", servicio.listar());
		return "Producto/vistaproducto";
	}
	
	@PostMapping("/registrarProductojs")
	@ResponseBody
	public ResultadoResponse registrarProducto(@RequestBody Producto objProducto) {
		String mensaje = "Producto registrado correctamente";
		Boolean respuesta = true;
		try {
			servicio.registrarProducto(objProducto);
		}catch(Exception ex) {
			mensaje = "Producto no registrado";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}
	
	
	@GetMapping("/listarProductojs")
	@ResponseBody
	public List<Producto> listarproducto(){
		return servicio.listar();
	}
	
	
	@DeleteMapping("/eliminarProductojs")
	@ResponseBody
	public ResultadoResponse eliminarProducto(@RequestBody Producto objProducto) {
		String mensaje = "Producto eliminado correctamente";
		Boolean respuesta = true;
		try {
			servicio.eliminarProducto(objProducto);
		}catch(Exception ex) {
			mensaje = "Producto no eliminado";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}
}
