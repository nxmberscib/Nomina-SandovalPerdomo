package co.edu.udistrital.repositorio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import co.edu.udistrital.modelo.Nomina;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class NominaRepositoryImpl implements NominaRepository {

	private final List<Nomina> nominas = new CopyOnWriteArrayList<>();

	@Override
	public void guardar(Nomina nomina) {
		nominas.add(nomina);
	}

	@Override
	public List<Nomina> listarTodas() {
		List<Nomina> copia = new ArrayList<>(nominas);
		Collections.reverse(copia);
		return copia;
	}
}
