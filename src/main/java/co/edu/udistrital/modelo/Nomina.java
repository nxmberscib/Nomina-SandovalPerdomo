package co.edu.udistrital.modelo;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Nomina implements Serializable {
	private static final long serialVersionUID = -6710909594394434354L;
	
	private Empleado empleado;
	private double salario;
	private double auxilioTransporte;
	private double salud;
	private double pension;
	private double netoPagar;
	private LocalDateTime fechaCalculo;

	public Nomina() {
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public double getAuxilioTransporte() {
		return auxilioTransporte;
	}

	public void setAuxilioTransporte(double auxilioTransporte) {
		this.auxilioTransporte = auxilioTransporte;
	}

	public double getSalud() {
		return salud;
	}

	public void setSalud(double salud) {
		this.salud = salud;
	}

	public double getPension() {
		return pension;
	}

	public void setPension(double pension) {
		this.pension = pension;
	}

	public double getNetoPagar() {
		return netoPagar;
	}

	public void setNetoPagar(double netoPagar) {
		this.netoPagar = netoPagar;
	}

	public LocalDateTime getFechaCalculo() {
		return fechaCalculo;
	}

	public void setFechaCalculo(LocalDateTime fechaCalculo) {
		this.fechaCalculo = fechaCalculo;
	}

	public boolean isTieneAuxilio() {
		return auxilioTransporte > 0;
	}
}
