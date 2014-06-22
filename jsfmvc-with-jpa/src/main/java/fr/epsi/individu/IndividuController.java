package fr.epsi.individu;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

@Named
@RequestScoped
public class IndividuController {

	@PersistenceContext(unitName="oraclePU", type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;

	private final Individu individu = new Individu();

	public String create() {
		return "individu?faces-redirect=true";
	}

	public void delete(long id) {
	}

	public List<Individu> getAll() throws Exception
	{	
		Query query = entityManager.createQuery("SELECT i from Individu as i");
        return query.getResultList();
	}

	public Individu getIndividu() {
		return individu;
	}
}
