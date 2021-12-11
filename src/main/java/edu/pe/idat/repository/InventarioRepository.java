package edu.pe.idat.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.pe.idat.Model.Inventario;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, String>{
	
	@Query(value= "{call sp_MantListarInventario()}", nativeQuery = true)
	List<Inventario> listarInventario();
	
	@Transactional
	@Modifying
	@Query(value="{call sp_MantRegistrarInventario(:indes, :insi, :ints, :inest, :inguiasalida, :inguiaentrada)}", nativeQuery = true)
	void registrarInventario(@Param("indes") String descripcion,
			                 @Param("insi") Integer stockinicial,
			                 @Param("ints") Integer totalstock,
			                 @Param("inest") String estado,
			                 @Param("inguiasalida") String codguiasalida,
			                 @Param("inguiaentrada") String codguiaentrada);
	
	
	@Transactional
	@Modifying
	@Query(value="{call sp_MantActualizarInventario(:codin, :indes, :insi, :ints, :inest, :inguiasalida, :inguiaentrada)}", nativeQuery = true)
	void actualizarInventario(@Param("codin") String codinventario,
							  @Param("indes") String descripcion,
			                  @Param("insi") Integer stockinicial,
			                  @Param("ints") Integer totalstock,
			                  @Param("inest") String estado,
			                  @Param("inguiasalida") String codguiasalida,
			                  @Param("inguiaentrada") String codguiaentrada);
	
	
	@Transactional 
	@Modifying
	@Query(value = "{call sp_MantEliminarInventario(:codin)}", nativeQuery = true)
	void eliminarInventario(@Param("codin") String codinventario);
	
	// INHABILITAR INVENTARIO
	@Transactional
	@Modifying
	@Query(value = "{call sp_MantInhabilitarInventario(:codin)}", nativeQuery = true)
	void inhabilitar_inventario(@Param("codin") String codinventario);
	
	
}
