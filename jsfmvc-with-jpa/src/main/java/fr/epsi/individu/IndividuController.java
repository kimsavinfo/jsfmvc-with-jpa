package fr.epsi.individu;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;

@Named
@RequestScoped
public class IndividuController {

	private final Individu individu = new Individu();
	private EntityManager entityManager;

	public String create() {
		return "individu?faces-redirect=true";
	}

	public void delete(long individuId) 
	{
		entityManager.createNativeQuery("delete from individu where individuId = ?")
		.setParameter(1, individuId)
		.executeUpdate();
	}

	public List<Individu> getAll() {
		List<Individu> individus = null;
		individus = entityManager.createQuery("select i from Individu i", Individu.class)
				.getResultList();

		return individus;
	}

	public Individu getIndividu() {
		return individu;
	}
}
