package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory emf = null;
	
	static {
		
		emf = Persistence.createEntityManagerFactory("PozoristeVezbaJPA");
	}
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

}
