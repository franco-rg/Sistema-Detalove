package edu.pe.idat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import edu.pe.idat.Model.OrdenCompra;

public interface OrdenCompraRepository extends JpaRepository<OrdenCompra, Integer> 
{
	@Modifying
	@Query(value="delete from OrdenCompra where CodOrdenCompra=?1",nativeQuery=true)
	public abstract void delete(String CodOrdenCompra);
	
	@Query(value="select * from OrdenCompra where CodOrdenCompra=?1",nativeQuery=true)
	public abstract OrdenCompra findById(String CodOrdenCompra);	
}
