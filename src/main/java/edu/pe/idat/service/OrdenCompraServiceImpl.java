package edu.pe.idat.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.pe.idat.Model.OrdenCompra;
import edu.pe.idat.repository.OrdenCompraRepository;

@Service
public class OrdenCompraServiceImpl implements OrdenCompraService
{
	@Autowired
	private OrdenCompraRepository repository;
	
	@Override
	@Transactional
	public void insert(OrdenCompra ordenCompra) {
		repository.save(ordenCompra);		
	}

	@Override
	@Transactional
	public void update(OrdenCompra ordenCompra) {
		repository.save(ordenCompra);		
	}

	@Override
	@Transactional
	public void delete(String CodOrdenCompra) {
		repository.delete(CodOrdenCompra);
	}
	
	@Override
	@Transactional(readOnly = true)
	public OrdenCompra findById(String CodOrdenCompra) {
		return repository.findById(CodOrdenCompra);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<OrdenCompra> findAll() {
		return repository.findAll();
	}
}
