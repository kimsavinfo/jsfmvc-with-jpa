package fr.epsi.individu;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;


public class EntityManagerUtil 
{
	private static EntityManagerFactory entityManagerFactory;
	
	@BeforeClass
	public static void createEntityManagerFactory() {
		entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
	}
	
	@AfterClass
	public static void closeEntityManagerFactory() {
		entityManagerFactory.close();
	}

	public static EntityManager getEntityManager() 
	{
		return entityManagerFactory.createEntityManager();
	}
}