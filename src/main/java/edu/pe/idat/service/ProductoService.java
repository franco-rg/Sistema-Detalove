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
	
	public List<Producto> listar(){
		return llamar.findAll();
	}
	
	public void registrarProducto(Producto producto) {
		if(producto.getCodProducto()==null) {
			llamar.registrarProducto(producto.getNombre(), producto.getPreciouni(), producto.getDetalle(), producto.getImagen(), producto.getCodcategoria());
		}
		else {
			llamar.actualizarProducto(producto.getCodProducto(), producto.getNombre(), producto.getPreciouni(), producto.getDetalle(), producto.getImagen(), producto.getCodcategoria());
		}
		
	}
	public void eliminarProducto(Producto producto) {
		llamar.eliminarProducto(producto.getCodProducto());
	}
}
