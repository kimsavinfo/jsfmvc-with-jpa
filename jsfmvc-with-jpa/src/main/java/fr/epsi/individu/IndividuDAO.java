package fr.epsi.individu;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.*;
import javax.enterprise.context.Dependent;
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

@Stateless
//signale que la transaction est gérée dans le code de l'EJB
@TransactionManagement(TransactionManagementType.BEAN)
public class IndividuDAO{
		
	@Resource
	UserTransaction ut;
	
	@PersistenceContext(unitName="individuPersistenceUnit")
	private EntityManager entityManager;
	
	
	public void create(Individu individu) throws IllegalStateException, SecurityException, HeuristicMixedException, HeuristicRollbackException, RollbackException, SystemException, NotSupportedException{
		ut.begin();
		entityManager.persist(individu);
		ut.commit();
	}
	
	public List<Individu> getAll() throws NotSupportedException, SystemException, IllegalStateException, SecurityException, HeuristicMixedException, HeuristicRollbackException, RollbackException{
		List<Individu> individus = null;
		ut.begin();
		individus = entityManager.createNativeQuery("select * from INDIVIDUS", Individu.class)
				.getResultList();
		ut.commit();
		return individus;
	}
	
	public void delete(long individuId) throws NotSupportedException, SystemException, IllegalStateException, SecurityException, HeuristicMixedException, HeuristicRollbackException, RollbackException{
		ut.begin();
		entityManager.createNativeQuery("delete from INDIVIDUS where ID_INDIVIDU = ?")
        .setParameter(1, individuId)
        .executeUpdate();
		ut.commit();
	}
	
}
