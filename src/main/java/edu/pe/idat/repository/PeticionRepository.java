package edu.pe.idat.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.pe.idat.Model.Peticion;

@Repository
public interface PeticionRepository extends JpaRepository<Peticion, String>{
	
	@Transactional
    @Modifying
    @Query(value="{call sp_MantRegistrarPeticion(:petasu, :petdes, :petima, :petcli)}",
            nativeQuery = true)
    void registrarPeticion(@Param("petasu") String asunto,
    						@Param("petdes") String descripcion,
    						@Param("petima") String imagen,
    						@Param("petcli") String cliente);
                           
	
	@Transactional
    @Modifying
    @Query(value = "{call sp_MantActualizarPeticion(:petcod, :petasu, :petdes, :petima, :petcli)}",
    nativeQuery = true)
    void actualizarPeticion(@Param("petcod") String codigo,
    						@Param("petasu") String asunto,
    						@Param("petdes") String descripcion,
    						@Param("petima") String imagen,
    						@Param("petcli") String cliente);
	
	@Transactional
    @Modifying
    @Query(value = "{call sp_MantEliminarPeticion(:petcod)}", nativeQuery = true)
    void eliminarPeticion(@Param("petcod") String codigo);
	
}
