package edu.pe.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.idat.Model.Usuario;
import edu.pe.idat.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
		
	public List<Usuario> listar(){
		return usuarioRepository.listarUsuario();
	}
	
	public void registrarUsuario(Usuario usuario) {
		if(usuario.getCodusuario()==null) {
			usuarioRepository.registrarUsuario(usuario.getNombreusuario(), usuario.getClave(), usuario.getCodcargo(), usuario.getCodcliente(), usuario.getCodpeticion());
		}
		else {
			usuarioRepository.actualizarUsuario(usuario.getCodusuario(), usuario.getNombreusuario(), usuario.getClave(), usuario.getCodcargo(), usuario.getCodcliente(), usuario.getCodpeticion());
		}
		
	}
	public void eliminarUsuario(Usuario usuario) {
		usuarioRepository.eliminarUsuario(usuario.getCodusuario());
	}
}
