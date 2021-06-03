package edu.pe.idat.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.pe.idat.Model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, String>{
	
	@Transactional
	@Modifying
	@Query(value="{call sp_MantRegistrarProducto(:pronom, :propre, :prodet, :proimg, :procat)}",
			nativeQuery = true)
	void registrarProducto(@Param("pronom") String nombre,
			               @Param("propre") Double preciouni,
			               @Param("prodet") String detalle,
			               @Param("proimg") String imagen,
			               @Param("procat") String codcategoria);
	
	@Transactional
	@Modifying
	@Query(value = "{call sp_MantActualizarProducto(:procod, :pronom, :propre, :prodet, :proimg, :procat)}",
	nativeQuery = true)
	void actualizarProducto(@Param("procod") String codigo,
							@Param("pronom") String nombre,
				            @Param("propre") Double preciouni,
				            @Param("prodet") String detalle,
				            @Param("proimg") String imagen,
				            @Param("procat") String codcategoria);
	
	
	@Transactional 
	@Modifying
	@Query(value = "{call sp_MantEliminarProducto(:procod)}", nativeQuery = true)
	void eliminarProducto(@Param("procod") String codigo);
}
