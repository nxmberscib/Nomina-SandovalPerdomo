package co.edu.udistrital.modelo;

import java.io.Serializable;

public abstract class Persona implements Serializable {

	private static final long serialVersionUID = -6875647038194916908L;
	private String identificacion;
	private String nombres;
	private String apellidos;

	public Persona() {
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombreCompleto() {
		return nombres + " " + apellidos;
	}
}
