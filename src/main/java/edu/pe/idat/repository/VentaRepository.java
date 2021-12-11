package edu.pe.idat.repository;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.pe.idat.Model.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, String>{
	
	@Transactional
    @Modifying
    @Query(value="{call sp_MantRegistrarVenta(:ventip, :venfor, :venfec, :venigv, :vensubt, :ventot, :venestad, :vencodc)}",
            nativeQuery = true)
    void registrarVenta(@Param("ventip") String tipodocumento,
                           @Param("venfor") String formapago,
                           @Param("venfec") Date fecha,
                           @Param("venigv") Double igv,
                           @Param("vensubt") Double subtotal,
                           @Param("ventot") Double total,
                           @Param("venestad")String estado,
                           @Param("vencodc") String codcliente);
	
	@Transactional
    @Modifying
    @Query(value = "{call sp_MantActualizarVenta(:ventip, :venfor, :venfec, :venigv, :vensubt, :ventot, :venestad, :vencodc)}",
    nativeQuery = true)
    void actualizarVenta(@Param("vencod") String venta,
                            @Param("ventip") String tipodocumento,
                            @Param("venfor") String formapago,
                            @Param("venfec") Date fecha,
                            @Param("venigv") Double igv,
                            @Param("vensubt") Double subtotal,
                            @Param("ventot") Double total,
                            @Param("venestad")String estado,
                            @Param("vencodc") String codcliente);
	
	@Transactional
    @Modifying
    @Query(value = "{call sp_MantEliminarVenta(:vencod)}", nativeQuery = true)
    void eliminarVenta(@Param("vencod") String codigo);
	
}

