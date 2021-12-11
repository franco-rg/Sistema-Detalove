package edu.pe.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.idat.Model.GuiaEntrada;
import edu.pe.idat.repository.GuiaEntradaRepository;


@Service
public class GuiaEntradaService {
	
	@Autowired
	private GuiaEntradaRepository guiaEntradaRepository;
		
	public List<GuiaEntrada> listarGuiaEntrada(){
		return guiaEntradaRepository.listarGuiaEntrada();
	}
	
	public void registrarGuiaEntrada(GuiaEntrada guiaEntrada) {
		if(guiaEntrada.getCodguiaentrada()==null) {
			guiaEntradaRepository.registrarGuiaEntrada(guiaEntrada.getDescripcion(), guiaEntrada.getFechaentrada(), guiaEntrada.getCodproveedor(), guiaEntrada.getCodfacturacompra(), guiaEntrada.getCodusuario(), guiaEntrada.getEstado(), guiaEntrada.getCantidad(), guiaEntrada.getCodproducto());
		}
		else {
			guiaEntradaRepository.actualizarGuiaEntrada(guiaEntrada.getCodguiaentrada(), guiaEntrada.getDescripcion(), guiaEntrada.getFechaentrada(), guiaEntrada.getCodproveedor(), guiaEntrada.getCodfacturacompra(), guiaEntrada.getCodusuario());
		}
		
	}


	public void inhabilitar_GuiaEntrada(GuiaEntrada guiaEntrada) {
		guiaEntradaRepository.inhabilitar_GuiaEntrada(guiaEntrada.getCodguiaentrada());
	}
	
	
	public GuiaEntrada encontrar_guiaentrada(String codguiaentrada) {
		return guiaEntradaRepository.encontrar_guiaentrada(codguiaentrada);
	}
}
