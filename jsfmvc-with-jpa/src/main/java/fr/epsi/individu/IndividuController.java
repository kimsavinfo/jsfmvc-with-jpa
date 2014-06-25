package fr.epsi.individu;

import java.util.List;

import javax.ejb.*;
import javax.annotation.Resource;
import javax.ejb.TransactionManagement;
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
@Dependent
//Il s'agit de la valeur par défaut
@TransactionManagement(TransactionManagementType.BEAN)
//Il s'agit de la valeur par défaut
//@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class IndividuController {

	//private Individu individu = new Individu();
	@PersistenceContext(unitName="individuPersistenceUnit")
	private EntityManager entityManager;
	@Resource
	UserTransaction ut;

	public String create(Individu individu) throws NotSupportedException, SystemException, IllegalStateException, SecurityException, HeuristicMixedException, HeuristicRollbackException, RollbackException 
	{
		ut.begin();
		/*boolean transactionOk = false;
		try 
		{*/
			entityManager.persist(individu);
		/*	transactionOk = true;
		}
		finally 
		{
			if(transactionOk) 
			{*/
				ut.commit();/*
			}
			else 
			{
				ut.rollback();
			}
		}*/

		return "individu?faces-redirect=true";
	}

	public void delete(long individuId) throws NotSupportedException, SystemException, IllegalStateException, SecurityException, HeuristicMixedException, HeuristicRollbackException, RollbackException 
	{
		ut.begin();
		boolean transactionOk = false;
		/*try 
		{*/
			entityManager.createNativeQuery("delete from INDIVIDUS where ID_INDIVIDU = ?")
	            .setParameter(1, individuId)
	            .executeUpdate();

		/*	transactionOk = true;
		}
		finally 
		{
			if(transactionOk) 
			{*/
				ut.commit();/*
			}
			else 
			{
				ut.rollback();
			}
		}*/
	}

	public List<Individu> getAll() {

		List<Individu> individus = null;
		individus = entityManager.createNativeQuery("select * from INDIVIDUS", Individu.class)
				.getResultList();
		return individus;
	}

	
}
