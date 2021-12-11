package edu.pe.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.idat.repository.InventarioRepository;
import edu.pe.idat.Model.*;

@Service
public class InventarioService {

	@Autowired
	private InventarioRepository inventarioRepository;
		
	public List<Inventario> listarInventario(){
		return inventarioRepository.listarInventario();
	}
	
	public void registrarInventario(Inventario inventario) {
		if(inventario.getCodinventario()==null) {
			inventarioRepository.registrarInventario(inventario.getDescripcion(), inventario.getStockinicial(), inventario.getTotalstock(), inventario.getEstado(), inventario.getCodguiasalida(), inventario.getCodguiaentrada());
		}
		else {
			inventarioRepository.actualizarInventario(inventario.getCodinventario(), inventario.getDescripcion(), inventario.getStockinicial(), inventario.getTotalstock(), inventario.getEstado(), inventario.getCodguiasalida(), inventario.getCodguiaentrada());
		}
		
	}
	public void eliminarInventario(Inventario inventario) {
		inventarioRepository.eliminarInventario(inventario.getCodinventario());
	}
	
	public void inhabilitar_inventario(Inventario inventario) {
		inventarioRepository.inhabilitar_inventario(inventario.getCodguiaentrada());
	}
}