package co.edu.udistrital.repositorio;

import java.util.List;

import co.edu.udistrital.modelo.Nomina;

public interface NominaRepository {

	void guardar(Nomina nomina);

	List<Nomina> listarTodas();
}
