package edu.pe.idat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.pe.idat.Model.GuiaEntrada;
import edu.pe.idat.Model.GuiaEntrada_Register;

@Repository
public interface GuiaEntradaRegisterRepository extends JpaRepository<GuiaEntrada_Register, String>{
	
	@Query(value="{call sp_MantListarGuiaEntrada_Simple()}", nativeQuery = true)
	List<GuiaEntrada_Register> listarGuiaEntrada();
	

	
}
