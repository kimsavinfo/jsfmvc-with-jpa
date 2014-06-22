package fr.epsi.individu;

import java.util.Iterator;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;

@Named
@RequestScoped
public class IndividuController {

	private final Individu individu = new Individu();
	private EntityManager entityManager = EntityManagerUtil.getEntityManager();

	public String create() {
		return "individu?faces-redirect=true";
	}

	public void delete(long id) {
	}

	public List<Individu> getAll() 
	{
		try 
		{
			entityManager.getTransaction().begin();
			
			@SuppressWarnings("unchecked")
			List<Individu> individus = entityManager.createQuery("from Individu").getResultList();
			for (Iterator<Individu> iterator = individus.iterator(); iterator.hasNext();) 
			{
				Individu individu = (Individu) iterator.next();
			}
			
			entityManager.getTransaction().commit();
			return individus;
		} catch (Exception e) 
		{
			entityManager.getTransaction().rollback();
			return null;
		}
	}

	public Individu getIndividu() {
		return individu;
	}
}
