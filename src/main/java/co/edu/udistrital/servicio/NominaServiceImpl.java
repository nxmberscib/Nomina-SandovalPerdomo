package co.edu.udistrital.servicio;

import java.time.LocalDateTime;
import java.util.List;

import co.edu.udistrital.modelo.Empleado;
import co.edu.udistrital.modelo.Nomina;
import co.edu.udistrital.repositorio.NominaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class NominaServiceImpl implements NominaService {

	public static final double SMMLV = 1750000;
	public static final double AUXILIO_TRANSPORTE = 250000;
	public static final double PORCENTAJE_SALUD = 0.04;
	public static final double PORCENTAJE_PENSION = 0.04;
	public static final int DIAS_MES = 30;

	private static final List<Double> SALARIOS_PERMITIDOS = List.of(
			1750000.0, 2000000.0, 2500000.0, 3000000.0, 4000000.0, 5000000.0);

	@Inject
	private NominaRepository repositorio;

	@Override
	public Nomina calcular(Empleado empleado) {
		validar(empleado);

		double salario = calcularSalario(empleado);
		double salud = redondear(salario * PORCENTAJE_SALUD);
		double pension = redondear(salario * PORCENTAJE_PENSION);
		double auxilio = calcularAuxilioTransporte(empleado);

		Nomina nomina = new Nomina();
		nomina.setEmpleado(new Empleado(empleado));
		nomina.setSalario(salario);
		nomina.setSalud(salud);
		nomina.setPension(pension);
		nomina.setAuxilioTransporte(auxilio);
		nomina.setNetoPagar(salario - salud - pension + auxilio);
		nomina.setFechaCalculo(LocalDateTime.now());

		repositorio.guardar(nomina);
		return nomina;
	}

	@Override
	public List<Nomina> listarNominas() {
		return repositorio.listarTodas();
	}

	@Override
	public List<Double> getSalariosPermitidos() {
		return SALARIOS_PERMITIDOS;
	}

	private double calcularSalario(Empleado empleado) {
		return redondear(empleado.getSalarioBasico() / DIAS_MES * empleado.getDiasTrabajados());
	}

	private double calcularAuxilioTransporte(Empleado empleado) {
		if (empleado.getSalarioBasico() <= 2 * SMMLV) {
			return redondear(AUXILIO_TRANSPORTE / DIAS_MES * empleado.getDiasTrabajados());
		}
		return 0;
	}

	private void validar(Empleado empleado) {
		if (empleado == null) {
			throw new IllegalArgumentException("No hay datos del empleado.");
		}
		if (estaVacio(empleado.getIdentificacion()) || estaVacio(empleado.getNombres())
				|| estaVacio(empleado.getApellidos()) || estaVacio(empleado.getCargo())) {
			throw new IllegalArgumentException("Todos los datos del empleado son obligatorios.");
		}
		if (empleado.getSalarioBasico() == null || !SALARIOS_PERMITIDOS.contains(empleado.getSalarioBasico())) {
			throw new IllegalArgumentException("El salario básico no es una opción válida.");
		}
		Integer dias = empleado.getDiasTrabajados();
		if (dias == null || dias < 1 || dias > DIAS_MES) {
			throw new IllegalArgumentException("Los días trabajados deben estar entre 1 y 30.");
		}
	}

	private boolean estaVacio(String texto) {
		return texto == null || texto.isBlank();
	}

	private double redondear(double valor) {
		return Math.round(valor);
	}
}
