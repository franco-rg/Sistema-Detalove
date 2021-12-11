package edu.pe.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.idat.Model.GuiaSalida;
import edu.pe.idat.repository.GuiaSalidaRepository;


@Service
public class GuiaSalidaService {
	
	@Autowired
	private GuiaSalidaRepository GuiaSalidaRepository;
		
	public List<GuiaSalida> listarGuiaSalida(){
		return GuiaSalidaRepository.findAll();
	}
	
	public void registrarGuiaSalida(GuiaSalida g) {
		if(g.getCodGuiaSalida()==null) {
			GuiaSalidaRepository.registrarGuiaSalida(g.getDescripcion(), g.getFechaSalida(), g.getSolicitado(), g.getAprobado(), g.getEntregado(), g.getRecibido(), g.getCodVenta());
		}
		else {
			GuiaSalidaRepository.actualizarGuiaSalida(g.getCodGuiaSalida(), g.getDescripcion(), g.getFechaSalida(), g.getSolicitado(), g.getAprobado(), g.getEntregado(), g.getRecibido(), g.getCodVenta());
		}
		
	}
	public void eliminarGuiaSalida(GuiaSalida guiaSalida) {
		GuiaSalidaRepository.eliminarGuiaSalida(guiaSalida.getCodGuiaSalida());
	}
}
