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

import edu.pe.idat.Model.Categoria;
import edu.pe.idat.Model.Response.ResultadoResponse;

import edu.pe.idat.service.CategoriaService;

@Controller
@RequestMapping("/Categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/vistacategoria")
	public String list(Model model) {
		model.addAttribute("formulario", categoriaService.listarCategoria());
		return "Categoria/vistacategoria";
	}
	
	@PostMapping("/registrarCategoriajs")
	@ResponseBody
	public ResultadoResponse registrarCategoria(@RequestBody Categoria objCategoria) {
		String mensaje = "Categoria registrada correctamente";
		Boolean respuesta = true;
		try {
			categoriaService.registrarCategoria(objCategoria);
		}catch(Exception ex) {
			mensaje = "Categoria no registrado";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}
	
	
	@GetMapping("/listarCategoriajs")
	@ResponseBody
	public List<Categoria> listarCategoria(){
		return categoriaService.listarCategoria();
	}
	
	
	@DeleteMapping("/eliminarCategoriajs")
	@ResponseBody
	public ResultadoResponse eliminarCategoria(@RequestBody Categoria objCategoria) {
		String mensaje = "Categoria eliminada correctamente";
		Boolean respuesta = true;
		try {
			categoriaService.eliminarCategoria(objCategoria);
		}catch(Exception ex) {
			mensaje = "Categoria no eliminado";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}
}