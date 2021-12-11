package edu.pe.idat.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.pe.idat.Model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, String>{
	
	@Query(value="{call sp_MantListarCategoria()}", nativeQuery = true)
	List<Categoria> listarCategoria();
	
	@Transactional
	@Modifying
	@Query(value="{call sp_MantRegistrarCategoria(:catnom, :catdes)}",
			nativeQuery = true)
	void registrarCategoria(@Param("catnom") String nombre,
			                @Param("catdes") String descripcion);
	
	@Transactional
	@Modifying
	@Query(value = "{call sp_MantActualizarCategoria(:catcod, :catnom, :catdes)}",
	nativeQuery = true)
	void actualizarCategoria(@Param("catcod") String codigo,
							 @Param("catnom") String nombre,
				             @Param("catdes") String descripcion);
	
	
	@Transactional 
	@Modifying
	@Query(value = "{call sp_MantEliminarCategoria(:catcod)}", nativeQuery = true)
	void eliminarCategoria(@Param("catcod") String codigo);
}
