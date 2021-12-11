package edu.pe.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.idat.Model.GuiaEntrada;
import edu.pe.idat.Model.GuiaEntrada_Register;
import edu.pe.idat.repository.GuiaEntradaRegisterRepository;
import edu.pe.idat.repository.GuiaEntradaRepository;


@Service
public class GuiaEntradaRegisterService {
	
	@Autowired
	private GuiaEntradaRegisterRepository guiaEntradaRepository;
		
	public List<GuiaEntrada_Register> listarGuiaEntrada(){
		return guiaEntradaRepository.listarGuiaEntrada();
	}

}
