package edu.pe.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.idat.repository.CategoriaRepository;
import edu.pe.idat.Model.*;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
		
	public List<Categoria> listarCategoria(){
		return categoriaRepository.listarCategoria();
	}
	
	public void registrarCategoria(Categoria categoria) {
		if(categoria.getCodcategoria()==null) {
			categoriaRepository.registrarCategoria(categoria.getNombre(), categoria.getDescripcion());
		}
		else {
			categoriaRepository.actualizarCategoria(categoria.getCodcategoria(), categoria.getNombre(), categoria.getDescripcion());
		}
		
	}
	public void eliminarCategoria(Categoria categoria) {
		categoriaRepository.eliminarCategoria(categoria.getCodcategoria());
	}
}
