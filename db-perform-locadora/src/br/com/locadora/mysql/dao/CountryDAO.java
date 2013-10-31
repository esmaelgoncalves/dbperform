package br.com.locadora.mysql.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.locadora.factory.ConnectionFactoryMySql;
import br.com.locadora.mysql.model.Country;

public class CountryDAO extends ConnectionFactoryMySql {
	private static CountryDAO instance;
	private static EntityManager em;

	public static CountryDAO getInstance() {
		if (instance == null) {
			instance = new CountryDAO();
		}
		return instance;
	}
	
	public void novoPais(Country pais) {
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.merge(pais);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro ao adicionar novo endereco: " + e);
			e.printStackTrace();
		}
	}
	
	public Country buscarPaisByName(String nome) {
		Country cidade = null;
		
		
		try {
			em = getEntityManager();
			Query q = em
					.createQuery("select c from Country as c where c.country = :country");
			q.setParameter("country", nome);

			cidade = (Country) q.getResultList().get(0);
		} catch (Exception e) {
			System.out.println("Erro ao buscar pais: " + e);
			e.printStackTrace();
		}

		return cidade;
	}
	
	public Country buscarPaisById(short id) {
		Country cidade = null;

		try {
			em = getEntityManager();

			Query q = em
					.createQuery("select c from Country as c where c.countryId = :country");
			q.setParameter("country", id);

			cidade = (Country) q.getResultList().get(0);
		} catch (Exception e) {
			System.out.println("Erro ao buscar pais: " + e);
			e.printStackTrace();
		}

		return cidade;
	}
}
