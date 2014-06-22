package fr.epsi.individu;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class IndividuController {

	private final Individu individu = new Individu();

	public String create() {
		return "individu?faces-redirect=true";
	}

	public void delete(long id) {
	}

	public List<Individu> getAll() {
		return null;
	}

	public Individu getIndividu() {
		return individu;
	}
}
