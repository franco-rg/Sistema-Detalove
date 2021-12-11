package edu.pe.idat.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.pe.idat.Model.FacturaCompra;
import edu.pe.idat.service.FacturaCompraService;

@Controller
@RequestMapping("/FacturaCompra")
public class FacturaCompraController {

	@Autowired
	FacturaCompraService facturaCompraService;

	@GetMapping("/listar")
	public ResponseEntity<List<FacturaCompra>>lista(){
		List<FacturaCompra> lista = facturaCompraService.listarFacturaCompra();
		return new ResponseEntity(lista, HttpStatus.OK);
	}
	
	
	@GetMapping("/search/{id}")
	public ResponseEntity<FacturaCompra> search(@PathVariable("id") String id){
		Optional<FacturaCompra> facturaCompra = facturaCompraService.getById(id);
		return new ResponseEntity(facturaCompra, HttpStatus.OK);
	}

	@PostMapping("/register")
	public ResponseEntity<?> save(@RequestBody FacturaCompra facturaCompra){
		facturaCompraService.saveProcedure(facturaCompra);
		return new ResponseEntity("Factura registrada", HttpStatus.CREATED);
	}


	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") String id){
		String mensaje = "Factura Elimnada";
		boolean respuesta = true;
		try {
			facturaCompraService.deleteFacturaCompra(id);
		}catch(Exception ex) {
			mensaje = "Factura Elimnada";
			respuesta = false;
		}
		return new ResponseEntity(mensaje, HttpStatus.OK);
	}

}
