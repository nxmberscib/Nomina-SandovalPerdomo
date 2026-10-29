package co.edu.udistrital.controlador;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import co.edu.udistrital.modelo.Empleado;
import co.edu.udistrital.modelo.Nomina;
import co.edu.udistrital.servicio.NominaService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.model.SelectItem;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("nominaBean")
@ViewScoped
public class NominaBean implements Serializable {

	private static final long serialVersionUID = -4927628173993038608L;

	@Inject
	private NominaService nominaService;

	private Empleado empleado;
	private Nomina nomina;
	private List<SelectItem> opcionesSalario;

	@PostConstruct
	public void init() {
		empleado = new Empleado();

		NumberFormat formato = NumberFormat.getCurrencyInstance(Locale.of("es", "CO"));
		formato.setMaximumFractionDigits(0);
		opcionesSalario = new ArrayList<>();
		for (Double salario : nominaService.getSalariosPermitidos()) {
			opcionesSalario.add(new SelectItem(salario, formato.format(salario)));
		}
	}

	public void calcular() {
		try {
			nomina = nominaService.calcular(empleado);
		} catch (IllegalArgumentException e) {
			nomina = null;
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
	}

	public void limpiar() {
		empleado = new Empleado();
		nomina = null;
	}

	public List<Nomina> getHistorial() {
		return nominaService.listarNominas();
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Nomina getNomina() {
		return nomina;
	}

	public List<SelectItem> getOpcionesSalario() {
		return opcionesSalario;
	}
}
