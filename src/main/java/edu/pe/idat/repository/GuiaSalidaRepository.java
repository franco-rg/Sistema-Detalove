package edu.pe.idat.repository;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.pe.idat.Model.GuiaSalida;

@Repository
public interface GuiaSalidaRepository extends JpaRepository<GuiaSalida, String>{
	
	@Transactional
    @Modifying
    @Query(value="{call sp_MantRegistrarGuiaSalida(:guidesc, :guifech, :guisoli, :guiapro, :guient, :guirec, :guicodv)}",
            nativeQuery = true)
    void registrarGuiaSalida(@Param("guidesc") String descripcion,
                           @Param("guifech") Date fechasalida,
                           @Param("guisoli") String solicitado,
                           @Param("guiapro") String aprobado,
	                       @Param("guient") String entregado,
                           @Param("guirec") String recibido,
                           @Param("guicodv") String codventa);	  
	
	
	@Transactional
    @Modifying
    @Query(value = "{call sp_MantActualizarGuiaSalida(:guiasali, :guidesc, :guifech, :guisoli, :guiapro, :guient, :guirec, :guicodv)}",
    nativeQuery = true)
    void actualizarGuiaSalida(@Param("guiasali") String codguiasalida,
    		                @Param("guidesc") String descripcion,
    		                @Param("guifech") Date fechasalida,
                            @Param("guisoli") String solicitado,
                            @Param("guiapro") String aprobado,
                            @Param("guient") String entregado,
                            @Param("guirec") String recibido,
                            @Param("guicodv") String codventa);
	@Transactional
    @Modifying
    @Query(value = "{call sp_MantEliminarGuiaSalida(:guiasali)}", nativeQuery = true)
    void eliminarGuiaSalida(@Param("guiasali") String codguiasalida);
	
}
