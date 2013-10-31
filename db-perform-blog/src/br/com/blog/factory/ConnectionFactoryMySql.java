package br.com.blog.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 
 * @author ESMAEL
 * 
 */
public class ConnectionFactoryMySql {

	private static EntityManagerFactory factory = null;
	private static EntityManager em = null;

	/**
	 * 
	 * @return
	 */
	public static EntityManager getEntityManager() {

		if (factory == null) {
			factory = Persistence.createEntityManagerFactory("blogdb");
		}
		if (em == null) {
			em = factory.createEntityManager();
		}
		return em;
	}

	/**
	 * 
	 * @param em
	 */
	public static void fecharEntityManager(EntityManager em) {
		em.close();
	}
}
