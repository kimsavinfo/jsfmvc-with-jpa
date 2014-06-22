package fr.epsi.individu;

import java.util.Iterator;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

@Named
@RequestScoped
public class IndividuController {
	
  @PersistenceContext(unitName="oraclePU")
  private EntityManager entityManager;
	
	private final Individu individu = new Individu();

	public String create() {
		return "individu?faces-redirect=true";
	}

	public void delete(long id) {
	}

	public List<Individu> getAll() 
	{
		return null;
	}

	public Individu getIndividu() {
		return individu;
	}
}
