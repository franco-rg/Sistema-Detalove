package edu.pe.idat.Model;

public class Login {
	
	private String Usuario;
	private String Contraseña;
	
	
	public String getUsuario() {
		return Usuario;
	}
	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
	public String getContraseña() {
		return Contraseña;
	}
	public void setContraseña(String contraseña) {
		Contraseña = contraseña;
	}
	
	
	public Login(String usuario, String contraseña) {
		super();
		Usuario = usuario;
		Contraseña = contraseña;
	}
	
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
