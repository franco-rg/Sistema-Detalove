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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import edu.pe.idat.Model.Producto;
import edu.pe.idat.Model.Response.ResultadoResponse;
import edu.pe.idat.service.CategoriaService;
import edu.pe.idat.service.ProductoService;

@Controller
@RequestMapping("/Producto")
public class ProductoController {

	@Autowired
	private ProductoService servicio;

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping("/vistaproducto")
	public String listarProductoxCategoria(Model model) {

		model.addAttribute("formulario", servicio.listar());
		model.addAttribute("listcategoria", categoriaService.listarCategoria());
		return "Producto/vistaproducto";
	}

	// VER PRODUCTO
	@GetMapping("/vistaproducto/ver-producto/{id}")
	public String buscar_pro(@PathVariable("id") String codpro, Model model) {

		Producto product = servicio.buscar_producto(codpro);
		model.addAttribute("formulario", servicio.listar());
		model.addAttribute("product_select", product);
		model.addAttribute("listcategoria", categoriaService.listarCategoria());
		return "Producto/ver-producto";
	}

	// INHABILITAR GET
	@GetMapping("/vistaproducto/ver-producto/inhabilitar-producto/{id}")
	public String eliminar_pro(@PathVariable("id") String codigo, Model model) {

		Producto product = servicio.buscar_producto(codigo);
		model.addAttribute("mostrar", product);
		return "Producto/inhabilitar-producto";
	}

	// INHABILITAR POST
	@PostMapping("/eliminar-producto")
	public String eliminar_pro(Producto producto) {
		servicio.inhabilitar_Producto(producto);
		return "redirect:/Producto/vistaproducto";
	}

	@GetMapping("/listarProductosxCategoria")
	@ResponseBody
	public List<Producto> listarProductos(@RequestParam("catcod") String codcategoria) {
		return servicio.listarProductosxCategoria(codcategoria);
	}

	// listar productos de la categoria: Camisetas
	@GetMapping("/camisetas")
	public String listarCatCamisetas(Model model) {
		model.addAttribute("listcamisetas", servicio.listarCatCamisetas());
		model.addAttribute("listcategoria", categoriaService.listarCategoria());
		return "Producto/camisetas";
	}

	// listar productos de la categoria: Tazas
	@GetMapping("/tazas")
	public String listarCatTazas(Model model) {
		model.addAttribute("listtazas", servicio.listarCatTazas());
		model.addAttribute("listcategoria", categoriaService.listarCategoria());
		return "Producto/tazas";
	}

	// listar productos de la categoria: Almohadas
	@GetMapping("/almohadas")
	public String listarCatAlmohadas(Model model) {
		model.addAttribute("listalmohadas", servicio.listarCatAlmohadas());
		model.addAttribute("listcategoria", categoriaService.listarCategoria());
		return "Producto/almohadas";
	}

	// listar productos de la categoria: Tomatodos
	@GetMapping("/tomatodos")
	public String listarCatTomatodos(Model model) {
		model.addAttribute("listtomatodos", servicio.listarCatTomatodos());
		model.addAttribute("listcategoria", categoriaService.listarCategoria());
		return "Producto/tomatodos";
	}

	// listar productos de la categoria: Javas
	@GetMapping("/javas")
	public String listarCatJavas(Model model) {
		model.addAttribute("listjavas", servicio.listarCatJavas());
		model.addAttribute("listcategoria", categoriaService.listarCategoria());
		return "Producto/javas";
	}

	// listar productos de la categoria: Chops
	@GetMapping("/chops")
	public String listarCatChops(Model model) {
		model.addAttribute("listchops", servicio.listarCatChops());
		model.addAttribute("listcategoria", categoriaService.listarCategoria());
		return "Producto/chops";
	}

	// listar productos de la categoria: Froral
	@GetMapping("/floral")
	public String listarCatFloral(Model model) {
		model.addAttribute("listfloral", servicio.listarCatFloral());
		model.addAttribute("listcategoria", categoriaService.listarCategoria());
		return "Producto/floral";
	}

	@GetMapping("/registrarproducto")
	public String registrarProducto(Model model) {
		model.addAttribute("regproducto", new Producto());
		model.addAttribute("listcategoria", categoriaService.listarCategoria());
		return "Producto/registrarproducto";
	}

	@PostMapping("/registrarproducto")
	public String registrarProducto(@RequestParam("file") MultipartFile foto, Producto objProducto) throws IOException {

		if (!foto.isEmpty()) {

			StringBuilder builder = new StringBuilder();
			builder.append("D:");
			builder.append(File.separator);
			builder.append("imagen-detalove");
			builder.append(File.separator);
			builder.append(foto.getOriginalFilename());

			byte[] bytes = foto.getBytes();
			Path path = Paths.get(builder.toString());
			Files.write(path, bytes);
			objProducto.setImagen(foto.getOriginalFilename());
		}

		servicio.registrarProducto(objProducto);
		return "redirect:/Producto/vistaproducto";
	}

	// ACTUALIZAR PRODUCTO
	@GetMapping("/vistaproducto/ver-producto/actualizar-producto/{id}")
	public String editar_producto(@PathVariable("id") String codpro, Model model) {

		Producto pro = servicio.buscar_producto(codpro);
		model.addAttribute("ubicar_producto", pro);
		model.addAttribute("listcategoria", categoriaService.listarCategoria());

		return "Producto/actualizar-producto";
	}
	

	@PostMapping("/actualizar_pro")
	public String editar_Producto_post(@RequestParam("file") MultipartFile foto, Producto objProducto) throws IOException {

		if (!foto.isEmpty()) {

			StringBuilder builder = new StringBuilder();
			builder.append("D:");
			builder.append(File.separator);
			builder.append("imagen-detalove");
			builder.append(File.separator);
			builder.append(foto.getOriginalFilename());

			byte[] bytes = foto.getBytes();
			Path path = Paths.get(builder.toString());
			Files.write(path, bytes);
			objProducto.setImagen(foto.getOriginalFilename());
		}
		
		if(foto.isEmpty()) {
			servicio.actualizarProducto(objProducto);
		}
		else {
			servicio.actualizarProducto_sinFoto(objProducto);
		}

		return "redirect:/Producto/vistaproducto";
	}


	@GetMapping("/listarProductojs")
	@ResponseBody
	public List<Producto> listarproducto() {
		return servicio.listar();
	}
	
	
	@DeleteMapping("/inhabilitarProductojs")
	@ResponseBody
	public ResultadoResponse inhabilitarProducto(@RequestBody Producto objProducto) {
		String mensaje = "Producto inhabilitado correctamente";
		Boolean respuesta = true;
		try {
			servicio.inhabilitar_Producto(objProducto);
		}catch(Exception ex) {
			mensaje = "Producto no inhabilitado";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}
	
	
	
	
	
	
	
	

}
