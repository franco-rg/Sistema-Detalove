package edu.pe.idat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.pe.idat.Model.GuiaEntrada;
import edu.pe.idat.Model.Inventario;
import edu.pe.idat.Model.Response.ResultadoResponse;
import edu.pe.idat.service.GuiaEntradaRegisterService;
import edu.pe.idat.service.GuiaEntradaService;
import edu.pe.idat.service.InventarioService;

@Controller
@RequestMapping("/Inventario")
public class InventarioController {
	
	@Autowired
	private InventarioService inventarioService;
	
	@Autowired
	private GuiaEntradaRegisterService listsimple;
	
	@Autowired
	private GuiaEntradaService guiaEntradaService;
	
	@Autowired
	private GuiaEntradaRegisterService guiasimple;

	@GetMapping("/vistainventario")
	public String list(Model model) {
		model.addAttribute("listinventario", inventarioService.listarInventario());
		// aqui debe ir el servicio de guiasalida
		model.addAttribute("listguiaentrada", guiasimple.listarGuiaEntrada());
		model.addAttribute("listSimple", listsimple.listarGuiaEntrada());
		return "Inventario/vistainventario";
	}


	@GetMapping("/listarInventariojs")
	@ResponseBody
	public List<Inventario> listarinventario(Model model) {
		model.addAttribute("listguiaentrada", guiaEntradaService.listarGuiaEntrada());
		return inventarioService.listarInventario();
	}
	
	
	// REGISTRO DE INVENTARIO
	
	@GetMapping("/vistainventario/registrar-inventario")
	public String registrarInventario_get(Model model) {
		
		Inventario inve = new Inventario();
		model.addAttribute("inventario_new", inve);
		model.addAttribute("list_guiaentrada", guiasimple.listarGuiaEntrada());
		return "Inventario/registrar-inventario";
	}

	@PostMapping("/registrar_inventario")
	public String registrar_inventario_post(@ModelAttribute Inventario objInventario) {
		inventarioService.registrarInventario(objInventario);
		return "redirect:/Inventario/vistainventario";
	}
	
	// FIN REGISTRO DE INVENTARIO
	
	
	@DeleteMapping("/inhabilitarInventariojs")
	@ResponseBody
	public ResultadoResponse inhabilitarInventario(@RequestBody Inventario inventario) {
		String mensaje = "Inventario inhabilitado correctamente";
		Boolean respuesta = true;
		try {
			inventarioService.inhabilitar_inventario(inventario);
		}catch(Exception ex) {
			mensaje = "Inventario no inhabilitado";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}
	
	

	@DeleteMapping("/eliminarInventariojs")
	@ResponseBody
	public ResultadoResponse eliminarInventario(@RequestBody Inventario objInventario) {
		String mensaje = "Inventario suspendido correctamente";
		Boolean respuesta = true;
		try {
			inventarioService.eliminarInventario(objInventario);
		} catch (Exception ex) {
			mensaje = "Inventario no suspendido";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}
	

	 @PostMapping("/registrarInventariojs")
	 @ResponseBody 
	 public ResultadoResponse registrarInventario(@RequestBody Inventario objInventario) { 
		 String mensaje = "Inventario registrado correctamente";
		 Boolean respuesta = true; 
		 try { 
			 inventarioService.registrarInventario(objInventario);
	 } catch(Exception ex) { 
		 mensaje = "Inventario no registrado"; 
		 respuesta = false;
	 } 
	   return new ResultadoResponse(respuesta, mensaje); 
	 }
}