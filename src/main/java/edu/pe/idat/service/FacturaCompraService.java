package edu.pe.idat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.idat.Model.FacturaCompra;
import edu.pe.idat.repository.FacturaCompraRepository;

@Service
public class FacturaCompraService {

	@Autowired
	private FacturaCompraRepository facturaCompraRepository;

	public List<FacturaCompra> listarFacturaCompra(){
		return facturaCompraRepository.listarFacturaCompra();
	}
	
	public Optional<FacturaCompra>getById(String id){
		return facturaCompraRepository.idProcedure(id);
	}

	public void saveProcedure(FacturaCompra facturaCompra){
		facturaCompraRepository.saveFacturaCompra(facturaCompra.getCodfacturacompra(),facturaCompra.getFecha(),facturaCompra.getFormapago(), facturaCompra.getSubtotal(), facturaCompra.getIgv(), facturaCompra.getDescuento(), facturaCompra.getMontofactura(), facturaCompra.getEstado(), facturaCompra.getCodordencompra());
	}

	public void deleteFacturaCompra(String id) {
		facturaCompraRepository.deleteFacturaCompra(id);
	}
}
