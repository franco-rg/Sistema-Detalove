package edu.pe.idat.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.pe.idat.Model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String>{
	
	@Transactional
    @Modifying
    @Query(value="{call sp_MantRegistrarCliente(:clinom, :cliape, :clieda, :clicel, :cligen, :clidir)}",
            nativeQuery = true)
    void registrarCliente(@Param("clinom") String nombre,
    						@Param("cliape") String apellido,
    						@Param("clieda") Integer edad,
    						@Param("clicel") Integer celular,
    						@Param("cligen") String genero,
    						@Param("clidir") String direccion);
                           
	
	@Transactional
    @Modifying
    @Query(value = "{call sp_MantActualizarCliente(:clicod, :clinom, :cliape, :clieda, :clicel, :cligen, :clidir)}",
    nativeQuery = true)
    void actualizarCliente(@Param("clicod") String codigo,
    						@Param("clinom") String nombre,
    						@Param("cliape") String apellido,
    						@Param("clieda") Integer edad,
    						@Param("clicel") Integer celular,
    						@Param("cligen") String genero,
    						@Param("clidir") String direccion);
	
	@Transactional
    @Modifying
    @Query(value = "{call sp_MantEliminarCliente(:clicod)}", nativeQuery = true)
    void eliminarCliente(@Param("clicod") String codigo);
	
}
