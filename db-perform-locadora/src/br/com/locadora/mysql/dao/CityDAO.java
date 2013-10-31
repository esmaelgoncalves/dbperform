package br.com.locadora.mysql.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.locadora.factory.ConnectionFactoryMySql;
import br.com.locadora.mysql.model.City;

public class CityDAO extends ConnectionFactoryMySql{
	private static CityDAO instance;
	private static EntityManager em;

	public static CityDAO getInstance() {
		if (instance == null) {
			instance = new CityDAO();
		}
		return instance;
	}
	
	public void novaCidade(City cidade) {
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.merge(cidade);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro ao adicionar nova cidade: " + e);
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<City> buscarTodasCidades() {
		List<City> cidades = null;

		try {
			em = getEntityManager();

			Query q = em.createQuery("select c from City as c");

			cidades = q.getResultList();
		} catch (Exception e) {
			System.out.println("Erro ao buscar todas as cidades: " + e);
			e.printStackTrace();
		}

		return cidades;
	}
	
	public City buscarCidadeById(short id) {
		City cidade = null;

		try {
			em = getEntityManager();

			Query q = em
					.createQuery("select c from City as c where c.cityId = :city");
			q.setParameter("city", id);

			cidade = (City) q.getResultList().get(0);

		} catch (Exception e) {
			System.out.println("Erro ao buscar cidade: " + e);
			e.printStackTrace();
		}

		return cidade;
	}

	public City buscarCidadeByName(String nome) {
		City cidade = null;

		try {
			em = getEntityManager();

			Query q = em
					.createQuery("select c from City as c where c.city = :city");
			q.setParameter("city", nome);

			cidade = (City) q.getResultList().get(0);
		} catch (Exception e) {
			System.out.println("Erro ao buscar cidade: " + e);
			e.printStackTrace();
		}

		return cidade;
	}
	
	
}
