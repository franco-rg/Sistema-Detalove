package edu.pe.idat.Model;

public class Registro {
	
	private String Nombre;
	private String Apellido;
	private Integer Edad;
	private Integer Dni;
	private Integer Celular;
	private String Sexo;
	private String Correo;
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public Integer getEdad() {
		return Edad;
	}
	public void setEdad(Integer edad) {
		Edad = edad;
	}
	public Integer getDni() {
		return Dni;
	}
	public void setDni(Integer dni) {
		Dni = dni;
	}
	public Integer getCelular() {
		return Celular;
	}
	public void setCelular(Integer celular) {
		Celular = celular;
	}
	public String getSexo() {
		return Sexo;
	}
	public void setSexo(String sexo) {
		Sexo = sexo;
	}
	public String getCorreo() {
		return Correo;
	}
	public void setCorreo(String correo) {
		Correo = correo;
	}
	
	public Registro(String nombre, String apellido, Integer edad, Integer dni, Integer celular, String sexo,
			String correo) {
		super();
		Nombre = nombre;
		Apellido = apellido;
		Edad = edad;
		Dni = dni;
		Celular = celular;
		Sexo = sexo;
		Correo = correo;
	}
	
	public Registro() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
