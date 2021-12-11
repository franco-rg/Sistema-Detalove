package edu.pe.idat.service;

import java.util.Collection;

import edu.pe.idat.Model.OrdenCompra;

public interface OrdenCompraService 
{
	public abstract void insert(OrdenCompra ordenCompra);
	public abstract void update(OrdenCompra ordenCompra);
	public abstract void delete(String CodOrdenCompra);
	public abstract OrdenCompra findById(String CodOrdenCompra);
	public abstract Collection<OrdenCompra> findAll();
}
