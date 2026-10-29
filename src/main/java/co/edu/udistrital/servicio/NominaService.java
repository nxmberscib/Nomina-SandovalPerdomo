package co.edu.udistrital.servicio;

import java.util.List;

import co.edu.udistrital.modelo.Empleado;
import co.edu.udistrital.modelo.Nomina;

public interface NominaService {

	Nomina calcular(Empleado empleado);

	List<Nomina> listarNominas();

	List<Double> getSalariosPermitidos();
}
