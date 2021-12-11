package edu.pe.idat.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.pe.idat.Model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>{
	
	@Query(value="{call sp_MantListarUsuario()}", nativeQuery = true)
	List<Usuario> listarUsuario();
	
	@Transactional
	@Modifying
	@Query(value="{call sp_MantRegistrarUsuario(:usunom, :usucla, :usucar, :usucli, :usupet)}",
			nativeQuery = true)
	void registrarUsuario(@Param("usunom") String nombreusu,
			              @Param("usucla") String clave,
			              @Param("usucar") String cargo,
						  @Param("usucli") String cliente,
						  @Param("usupet") String peticion);
	
	@Transactional
	@Modifying
	@Query(value = "{call sp_MantActualizarUsuario(:usucod, :usunom, :usucla, :usucar, :usucli, :usupet)}",
	nativeQuery = true)
	void actualizarUsuario(@Param("usucod") String codigo,
						   @Param("usunom") String nombreusu,
  						   @Param("usucla") String clave,
  						   @Param("usucar") String cargo,
  						   @Param("usucli") String cliente,
  						   @Param("usupet") String peticion);
	
	
	@Transactional 
	@Modifying
	@Query(value = "{call sp_MantEliminarUsuario(:usucod)}", nativeQuery = true)
	void eliminarUsuario(@Param("usucod") String codigo);
}
