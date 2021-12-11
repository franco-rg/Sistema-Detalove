package edu.pe.idat.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.pe.idat.Model.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, String>{
	
	@Transactional
    @Modifying
    @Query(value="{call sp_MantRegistrarCargo(:carnom, :carest)}",
            nativeQuery = true)
    void registrarCargo(@Param("carnom") String nombre,
    						@Param("carest") String estado);
                           
	
	@Transactional
    @Modifying
    @Query(value = "{call sp_MantActualizarCargo(:carcod, :carnom, :carest)}",
    nativeQuery = true)
    void actualizarCargo(@Param("carcod") String codigo,
    						@Param("carnom") String nombre,
    						@Param("carest") String estado);
	
	@Transactional
    @Modifying
    @Query(value = "{call sp_MantEliminarCargo(:carcod)}", nativeQuery = true)
    void eliminarCargo(@Param("carcod") String codigo);
	
}
