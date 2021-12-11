package edu.pe.idat.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.pe.idat.Model.FacturaCompra;

@Repository
public interface FacturaCompraRepository extends JpaRepository<FacturaCompra, String>{

	@Query(value="{call sp_MantListarFacturaCompra()}", nativeQuery = true)
	List<FacturaCompra> listarFacturaCompra();
	
	
	@Query(value="{call sp_SearchFacturaCompra(:idIn)}", nativeQuery = true)
	Optional<FacturaCompra> idProcedure(@Param("idIn") String id);

	@Transactional
	@Modifying
	@Query(value="{call sp_SaveFacturaCompra(:codfacturacompraIn,:FechaIn,:FormaPagoIn,:SubTotalIn,:IGVIn,:DescuentoIn,:MontoFacturaIn,:EstadoIn,:CodOrdenCompraIn)}", nativeQuery = true)
	void saveFacturaCompra(
			@Param ("codfacturacompraIn") String codfacturacompra,
			@Param ("FechaIn") Date Fecha,
			@Param ("FormaPagoIn") String FormaPago,
			@Param ("SubTotalIn") Double SubTotal,
			@Param ("IGVIn") Double IGV,
			@Param ("DescuentoIn") Double Descuento,
			@Param ("MontoFacturaIn") Double MontoFactura,
			@Param ("EstadoIn") String Estado,
			@Param ("CodOrdenCompraIn") String CodOrdenCompra
			);


	@Query(value="{call sp_DeleteFacturaCompra(:idIn)}", nativeQuery = true)
	void deleteFacturaCompra(@Param("idIn") String id);
	
}
	
	
	