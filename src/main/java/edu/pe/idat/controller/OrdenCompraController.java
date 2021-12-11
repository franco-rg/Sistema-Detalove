package edu.pe.idat.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.pe.idat.Model.OrdenCompra;
import edu.pe.idat.service.OrdenCompraService;

@Controller
public class OrdenCompraController 
{
	@Autowired
	private OrdenCompraService ordenCompraService;
	
	@RequestMapping(value="/ordencompra_listar",method=RequestMethod.GET)
	public String listarGET(Map map)
	{
		map.put("bOrdenCompra",ordenCompraService.findAll());
		return "OrdenCompra/listar";
	}
	
	@RequestMapping(value="/ordencompra_registrar",method=RequestMethod.GET)
	public String registrarGET(Model model)
	{
		model.addAttribute("ordenCompra",new OrdenCompra());
		return "OrdenCompra/registrar";
	}
	
	@RequestMapping(value="/ordencompra_registrar",method=RequestMethod.POST)
	public String registrarPOST(OrdenCompra ordenCompra)
	{
		ordenCompraService.insert(ordenCompra);
		return "redirect:/ordencompra_listar";
	}
	
	@RequestMapping(value="/ordencompra_editar/{CodOrdenCompra}",method=RequestMethod.GET)
	public String editarGET(Model model,@PathVariable String CodOrdenCompra)
	{
		model.addAttribute("ordenCompra",ordenCompraService.findById(CodOrdenCompra));
		return "OrdenCompra/editar";
	}
	
	@RequestMapping(value="/ordencompra_editar/{CodOrdenCompra}",method=RequestMethod.POST)
	public String editarPOST(OrdenCompra ordenCompra)
	{
		ordenCompraService.update(ordenCompra);
		return "redirect:/ordencompra_listar";
	}
	
	@RequestMapping(value="/ordencompra_borrar/{CodOrdenCompra}",method=RequestMethod.GET)
	public String borrarGET(Model model,@PathVariable String CodOrdenCompra)
	{
		model.addAttribute("ordenCompra",ordenCompraService.findById(CodOrdenCompra));
		return "OrdenCompra/borrar";
	}
	
	@RequestMapping(value="/ordencompra_borrar/{CodOrdenCompra}",method=RequestMethod.POST)
	public String borrarPOST(OrdenCompra ordenCompra)
	{
		ordenCompraService.delete(ordenCompra.getCodOrdenCompra());
		return "redirect:/ordencompra_listar";
	}
	
	
	
	
}
