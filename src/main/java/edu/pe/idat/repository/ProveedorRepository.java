package edu.pe.idat.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.pe.idat.Model.Proveedor;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, String>{
	
	@Transactional
    @Modifying
    @Query(value="{call sp_MantRegistrarProveedor(:pronom, :prodir, :protel, :procor)}",
            nativeQuery = true)
    void registrarProveedor(@Param("pronom") String nombre,
                           @Param("prodir") String direccion,
                           @Param("protel") Integer telefono,
                           @Param("procor") String correo);
	
	@Transactional
    @Modifying
    @Query(value = "{call sp_MantActualizarProveedor(:procod, :pronom, :prodir, :protel, :procor)}",
    nativeQuery = true)
    void actualizarProveedor(@Param("procod") String codigo,
                            @Param("pronom") String nombre,
                            @Param("prodir") String direccion,
                            @Param("protel") Integer telefono,
                            @Param("procor") String correo);
	
	@Transactional
    @Modifying
    @Query(value = "{call sp_MantEliminarProveedor(:procod)}", nativeQuery = true)
    void eliminarProveedor(@Param("procod") String codigo);
	
}
