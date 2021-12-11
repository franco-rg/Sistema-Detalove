package edu.pe.idat.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.pe.idat.Model.GuiaEntrada;

@Repository
public interface GuiaEntradaRepository extends JpaRepository<GuiaEntrada, String>{
	
	@Query(value="{call sp_MantListarGuiaEntrada()}", nativeQuery = true)
	List<GuiaEntrada> listarGuiaEntrada();
	
	@Transactional
	@Modifying
	@Query(value="{call sp_MantRegistrarGuiaEntrada(:gedes, :gefecha, :geprovee, :gefactcomp, :geusu, :est, :cant, :codpro)}",
			nativeQuery = true)
	void registrarGuiaEntrada(@Param("gedes") String descripcion,
			              	  @Param("gefecha") LocalDate fechaentrada,
			                  @Param("geprovee") String codproveedor,
						      @Param("gefactcomp") String codfacturacompra,
						      @Param("geusu") String codusuario,
						      @Param("est") String estado,
						      @Param("cant") Integer cantidad,
						      @Param("codpro") String CodProducto);
	
	@Transactional
	@Modifying
	@Query(value = "{call sp_MantActualizarGuiaEntrada(:gecod, :gedes, :gefecha, :geprovee, :gefactcomp, :geusu)}",
	nativeQuery = true)
	void actualizarGuiaEntrada(@Param("gecod") String codguiaentrada,
						   	   @Param("gedes") String descripcion,
						       @Param("gefecha") LocalDate fechaentrada,
						       @Param("geprovee") String codproveedor,
						       @Param("gefactcomp") String codfacturacompra,
						       @Param("geusu") String codusuario);
	
	
	// INHABILITAR GUIA DE ENTRADA
	@Transactional
	@Modifying
	@Query(value = "{call sp_MantInhabilitarGuiaEntrada(:codge)}", nativeQuery = true)
	void inhabilitar_GuiaEntrada(@Param("codge") String codguiaentrada);




	@Query(value = "{call sp_MantObtenerGuiaEntrada(:gecod)}",nativeQuery = true)
	GuiaEntrada encontrar_guiaentrada(@Param("gecod")String codguiaentrada);



}
