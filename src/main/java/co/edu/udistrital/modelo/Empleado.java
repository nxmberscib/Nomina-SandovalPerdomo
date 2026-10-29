package co.edu.udistrital.modelo;

public class Empleado extends Persona {

	private static final long serialVersionUID = -7087100244696213736L;
	private String cargo;
	private Double salarioBasico;
	private Integer diasTrabajados;

	public Empleado() {
	}

	public Empleado(Empleado otro) {
		setIdentificacion(otro.getIdentificacion());
		setNombres(otro.getNombres());
		setApellidos(otro.getApellidos());
		this.cargo = otro.cargo;
		this.salarioBasico = otro.salarioBasico;
		this.diasTrabajados = otro.diasTrabajados;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Double getSalarioBasico() {
		return salarioBasico;
	}

	public void setSalarioBasico(Double salarioBasico) {
		this.salarioBasico = salarioBasico;
	}

	public Integer getDiasTrabajados() {
		return diasTrabajados;
	}

	public void setDiasTrabajados(Integer diasTrabajados) {
		this.diasTrabajados = diasTrabajados;
	}
}
