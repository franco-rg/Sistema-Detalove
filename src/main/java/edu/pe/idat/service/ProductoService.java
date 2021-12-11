package edu.pe.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.idat.Model.Producto;
import edu.pe.idat.repository.ProductoRepository;

@Service
public class ProductoService {

	@Autowired
	private ProductoRepository llamar;

	public List<Producto> listarProductosxCategoria(String codcategoria) {
		return llamar.listarProductosxCategoria(codcategoria);
	}

	public List<Producto> listar() {
		return llamar.findAll();
	}

	public List<Producto> listarCatCamisetas() {
		return llamar.listarCatCamisetas();
	}

	public List<Producto> listarCatTazas() {
		return llamar.listarCatTazas();
	}

	public List<Producto> listarCatAlmohadas() {
		return llamar.listarCatAlmohadas();
	}

	public List<Producto> listarCatTomatodos() {
		return llamar.listarCatTomatodos();
	}

	public List<Producto> listarCatJavas() {
		return llamar.listarCatJavas();
	}

	public List<Producto> listarCatChops() {
		return llamar.listarCatChops();
	}

	public List<Producto> listarCatFloral() {
		return llamar.listarCatFloral();
	}

	// BUSCAR PRODUCTO
	public Producto buscar_producto(String codigo) {
		return llamar.buscar_producto(codigo);
	}

	public void registrarProducto(Producto producto) {
		if (producto.getCodproducto() == null) {
			llamar.registrarProducto(producto.getNombre(), producto.getPreciouni(), producto.getDetalle(),
					producto.getImagen(), producto.getTamano(), producto.getPublico(), producto.getEstado(),
					producto.getCodcategoria());
		} else {
			llamar.actualizarProducto(producto.getCodproducto(), producto.getNombre(), producto.getPreciouni(),
					producto.getDetalle(), producto.getImagen(), producto.getTamano(), producto.getPublico(),
					producto.getEstado(), producto.getCodcategoria());
		}

	}
	
	
	public void actualizarProducto(Producto producto){
		
		llamar.actualizarProducto(producto.getCodproducto(), producto.getNombre(), producto.getPreciouni(), producto.getDetalle(),
				producto.getImagen(), producto.getTamano(), producto.getPublico(), producto.getEstado(), producto.getCodcategoria());
		
	}
	
	public void actualizarProducto_sinFoto(Producto producto){
		
		llamar.actualizarProducto_sinFoto(producto.getCodproducto(), producto.getNombre(), producto.getPreciouni(), producto.getDetalle(),
					producto.getTamano(), producto.getPublico(), producto.getEstado(), producto.getCodcategoria());
		
	}
	

	
	
	public void eliminarProducto(String codigo){
		llamar.eliminarProducto(codigo);
	}
	
	
	public void buscarProducto(Producto producto) {
		llamar.buscarProducto(producto.getCodproducto());
	}
	
	public void inhabilitar_Producto(Producto producto) {
		llamar.inhabilitar_Producto(producto.getCodproducto());
	}


}
