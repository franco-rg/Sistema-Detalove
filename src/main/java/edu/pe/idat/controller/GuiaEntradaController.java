package edu.pe.idat.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.pe.idat.Model.GuiaEntrada;
import edu.pe.idat.Model.Producto;
import edu.pe.idat.Model.Response.ResultadoResponse;
import edu.pe.idat.service.FacturaCompraService;
import edu.pe.idat.service.GuiaEntradaRegisterService;
import edu.pe.idat.service.GuiaEntradaService;
import edu.pe.idat.service.ProductoService;
import edu.pe.idat.service.ProveedorService;
import edu.pe.idat.service.UsuarioService;

@Controller
@RequestMapping("/GuiaEntrada")
public class GuiaEntradaController {

	@Autowired
	private GuiaEntradaService guiaEntradaService;

	@Autowired
	private ProveedorService proveedorService;

	@Autowired
	private FacturaCompraService facturaCompraService;
	
	@Autowired
	private GuiaEntradaRegisterService listsimple;
	
	@Autowired 
	private ProductoService productoService;

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/vistaguiaentrada")
	public String list(Model model) {
		model.addAttribute("listSimple", listsimple.listarGuiaEntrada());
		model.addAttribute("listprovee", proveedorService.listar());
		model.addAttribute("listfactcompra", facturaCompraService.listarFacturaCompra());
		model.addAttribute("listusuario", usuarioService.listar());
		return "GuiaEntrada/vistaguiaentrada";
	}

	@GetMapping("/listarGuiaEntradajs")
	@ResponseBody
	public List<GuiaEntrada> listarguiaentrada() {
		return guiaEntradaService.listarGuiaEntrada();
	}

	@DeleteMapping("/inhabilitarGuiaEntradajs")
	@ResponseBody
	public ResultadoResponse inhabilitarGuiaEntrada(@RequestBody GuiaEntrada objGuiaEntrada) {
		String mensaje = "Guia de Entrada inhabilitada correctamente";
		Boolean respuesta = true;
		try {
			guiaEntradaService.inhabilitar_GuiaEntrada(objGuiaEntrada);
		}catch(Exception ex) {
			mensaje = "Guia de Entrada no inhabilitada";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}

	@GetMapping("/vistaguiaentrada/registrar-guia-entrada")
	public String registrarGuiaEntrada(Model model) {

		GuiaEntrada ge = new GuiaEntrada();
		model.addAttribute("regguiaentrada", ge);
		model.addAttribute("listp", productoService.listar());
		model.addAttribute("listprovee", proveedorService.listar());
		model.addAttribute("listfactcompra", facturaCompraService.listarFacturaCompra());
		model.addAttribute("listusuario", usuarioService.listar());
		return "GuiaEntrada/registrar-guia-entrada";
	}

	@PostMapping("/registrar_entrada")
	public String registrar_post(@ModelAttribute GuiaEntrada objGuiaEntrada) {
		guiaEntradaService.registrarGuiaEntrada(objGuiaEntrada);
		return "redirect:/GuiaEntrada/vistaguiaentrada";
	}

	
	
	
	// ACTUALIZACION DE GUIAS DE ENTRADA
	@GetMapping("/vistaguiaentrada/actualizar-guia-entrada/{id}")
	public String editar_guiaentrada(@PathVariable("id") String gecod, Model model) {

		GuiaEntrada ge = guiaEntradaService.encontrar_guiaentrada(gecod);

		model.addAttribute("entrada_ubicada", ge);
		model.addAttribute("listprovee", proveedorService.listar());
		model.addAttribute("listfactcompra", facturaCompraService.listarFacturaCompra());
		model.addAttribute("listusuario", usuarioService.listar());

		return "GuiaEntrada/actualizar-guia-entrada";
	}

	@PostMapping("/actualizar_entrada")
	public String actualizar_entrada_post(@ModelAttribute GuiaEntrada guiaEntrada) {

		guiaEntradaService.registrarGuiaEntrada(guiaEntrada);
		return "redirect:/GuiaEntrada/vistaguiaentrada";
	}
	
	// ACTUALIZACION DE GUIAS DE ENTRADA
		@GetMapping("/vistaguiaentrada/informe-guia-entrada/{id}")
		public String informe_guiaentrada(@PathVariable("id") String gecod, Model model) {

			GuiaEntrada ge = guiaEntradaService.encontrar_guiaentrada(gecod);

			model.addAttribute("entrada_ubicada", ge);
			model.addAttribute("listprovee", proveedorService.listar());
			model.addAttribute("listfactcompra", facturaCompraService.listarFacturaCompra());
			model.addAttribute("listusuario", usuarioService.listar());

			return "GuiaEntrada/informe-guia-entrada";
		}
	
	
}
