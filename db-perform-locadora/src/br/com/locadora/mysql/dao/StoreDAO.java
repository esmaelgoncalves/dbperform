package br.com.locadora.mysql.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.locadora.factory.ConnectionFactoryMySql;
import br.com.locadora.mysql.model.Store;

public class StoreDAO extends ConnectionFactoryMySql {
	private static StoreDAO instance;
	private static EntityManager em;

	public static StoreDAO getInstance() {
		if (instance == null) {
			instance = new StoreDAO();
		}
		return instance;
	}

	public void novaLoja(Store loja) {
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.merge(loja);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro ao adicionar novo loja: " + e);
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Store> buscarTodasLojas() {
		List<Store> lojas = null;

		try {
			em = getEntityManager();

			Query q = em.createQuery("select l from Store as l");

			lojas = q.getResultList();
		} catch (Exception e) {
			System.out.println("Erro ao buscar todas as lojas: " + e);
			e.printStackTrace();
		}

		return lojas;
	}

	public Store buscarLojaByAddress(String endereco) {
		Store loja = null;

		try {
			em = getEntityManager();

			Query q = em
					.createQuery("select l from Store as l where l.addressId = (Select e.addressId from Address as e where e.address = :address");
			q.setParameter("address", endereco);

			loja = (Store) q.getResultList().get(0);
		} catch (Exception e) {
			System.out.println("Erro ao buscar loja: " + e);
			e.printStackTrace();
		}

		return loja;
	}

	public Store buscarLojaByManager(String email) {
		Store loja = null;

		try {
			em = getEntityManager();

			Query q = em
					.createQuery("select l from Store as l where l.managerStaffId = (Select f.staffId from Staff as f where f.email = :email)");
			q.setParameter("email", email);

			loja = (Store) q.getResultList().get(0);
		} catch (Exception e) {
			System.out.println("Erro ao buscar loja: " + e);
			e.printStackTrace();
		}

		return loja;
	}
	
	public Store buscarLojaById(short id) {
		Store loja = null;

		try {
			em = getEntityManager();

			Query q = em
					.createQuery("select l from Store as l where l.storeId = :id");
			q.setParameter("id", id);

			loja = (Store) q.getResultList().get(0);
		} catch (Exception e) {
			System.out.println("Erro ao buscar loja: " + e);
			e.printStackTrace();
		}

		return loja;
	}
	
}
