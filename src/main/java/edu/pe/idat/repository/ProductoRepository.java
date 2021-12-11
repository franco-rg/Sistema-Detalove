package edu.pe.idat.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.pe.idat.Model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, String>{
	
	@Query(value= "{call sp_MantFiltrarPRDxCATGeneral(:catcod)}", nativeQuery = true)
	List<Producto> listarProductosxCategoria(
			@Param("catcod")String codcategoria);
	
	// Camisetas
	@Query(value= "{call sp_MantFiltrarPRDxCAT_Camisetas()}", nativeQuery = true)
	List<Producto> listarCatCamisetas();
	
	// Tazas
	@Query(value= "{call sp_MantFiltrarPRDxCAT_Tazas()}", nativeQuery = true)
	List<Producto> listarCatTazas();
	
	// Almohadas
	@Query(value= "{call sp_MantFiltrarPRDxCAT_Almohadas()}", nativeQuery = true)
	List<Producto> listarCatAlmohadas();
	
	// Tomatodos
	@Query(value= "{call sp_MantFiltrarPRDxCAT_Tomatodos()}", nativeQuery = true)
	List<Producto> listarCatTomatodos();
	
	// Javas Cheleras
	@Query(value= "{call sp_MantFiltrarPRDxCAT_Javas()}", nativeQuery = true)
	List<Producto> listarCatJavas();
	
	// Chops
	@Query(value= "{call sp_MantFiltrarPRDxCAT_Chops()}", nativeQuery = true)
	List<Producto> listarCatChops();
	
	// Jardineria / Floral
	@Query(value= "{call sp_MantFiltrarPRDxCAT_Jardineria()}", nativeQuery = true)
	List<Producto> listarCatFloral();
	
	// UBICAR PRODUCTO
	@Query(value= "{call sp_buscar_producto_id(:codpro)}", nativeQuery = true)
	Producto buscar_producto(@Param("codpro") String codigo); 
	
	@Transactional
	@Modifying
	@Query(value="{call sp_MantRegistrarProducto(:pronom, :propre, :prodet, :proimg, :protam, :propub, :proest, :procat)}",
			nativeQuery = true)
	void registrarProducto(@Param("pronom") String nombre,
			               @Param("propre") Double preciouni,
			               @Param("prodet") String detalle,
			               @Param("proimg") String imagen,
				           @Param("protam") String tamano,
				           @Param("propub") String publico,
				           @Param("proest") String estado,
				           @Param("procat") String codcategoria);
	
	@Transactional
	@Modifying
	@Query(value = "{call sp_MantActualizarProducto(:procod, :pronom, :propre, :prodet, :proimg, :protam, :propub, :proest, :procat)}",
	nativeQuery = true)
	void actualizarProducto(@Param("procod") String codigo,
							@Param("pronom") String nombre,
				            @Param("propre") Double preciouni,
				            @Param("prodet") String detalle,
				            @Param("proimg") String imagen,
				            @Param("protam") String tamano,
				            @Param("propub") String publico,
				            @Param("proest") String estado,
				            @Param("procat") String codcategoria);
	
	@Transactional
	@Modifying
	@Query(value = "{call sp_MantActualizarProducto_NotImage(:procod, :pronom, :propre, :prodet, :protam, :propub, :proest, :procat)}",
	nativeQuery = true)
	void actualizarProducto_sinFoto(@Param("procod") String codigo,
							@Param("pronom") String nombre,
				            @Param("propre") Double preciouni,
				            @Param("prodet") String detalle,
				            @Param("protam") String tamano,
				            @Param("propub") String publico,
				            @Param("proest") String estado,
				            @Param("procat") String codcategoria);
	
	
	// INHABILITAR PRODUCTO
	@Transactional
	@Modifying
	@Query(value = "{call sp_inhabilitar_producto(:procod)}", nativeQuery = true)
	void inhabilitar_Producto(@Param("procod") String codigo);
	
	
	
	// ELIMINAR PRODUCTO
	@Transactional 
	@Modifying
	@Query(value="{call sp_MantEliminarProducto(:id)}",nativeQuery = true)
	String eliminarProducto(@Param("id") String codigo);
	
	
	@Transactional 
	@Modifying
	@Query(value = "{call sp_MantObtenerProducto(:procod)}", nativeQuery = true)
	void buscarProducto(@Param("procod") String codigo);
}
