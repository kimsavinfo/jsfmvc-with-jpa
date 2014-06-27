package fr.epsi.individu;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

@Named
@RequestScoped
public class IndividuController {
	
	@EJB
	private IndividuDAO individuDAO = new IndividuDAO();
	private Individu individu = new Individu();
	
	

	public String create() throws NotSupportedException, SystemException, IllegalStateException, SecurityException, HeuristicMixedException, HeuristicRollbackException, RollbackException 
	{
		individuDAO.create(individu);
		return "individu?faces-redirect=true";
	}

	public void delete(long individuId) throws NotSupportedException, SystemException, IllegalStateException, SecurityException, HeuristicMixedException, HeuristicRollbackException, RollbackException 
	{

			individuDAO.delete(individuId);
	}

	public List<Individu> getAll() throws IllegalStateException, SecurityException, NotSupportedException, SystemException, HeuristicMixedException, HeuristicRollbackException, RollbackException {

		return individuDAO.getAll();
		
	}

	public Individu getIndividu() {
		return individu;
	}
}
