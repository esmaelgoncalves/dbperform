package br.com.locadora.mysql.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.locadora.factory.ConnectionFactoryMySql;
import br.com.locadora.mysql.model.Category;

public class CategoryDAO extends ConnectionFactoryMySql {
	private static CategoryDAO instance;
	private static EntityManager em;

	public static CategoryDAO getInstance() {
		if (instance == null) {
			instance = new CategoryDAO();
		}
		return instance;
	}

	public void novaCategoria(Category categoria) {
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.merge(categoria);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro ao adicionar nova categoria: " + e);
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public List<Category> buscarTodasCategorias() {
		List<Category> categorias = null;

		try {
			em = getEntityManager();

			Query q = em.createQuery("select c from Category as c");

			categorias = q.getResultList();
		} catch (Exception e) {
			System.out.println("Erro ao buscar todas as categorias: " + e);
			e.printStackTrace();
		}

		return categorias;
	}

	public Category buscarCategoriaByName(String nome) {
		Category categoria = null;

		try {
			em = getEntityManager();

			Query q = em
					.createQuery("select c from Category as c where c.name = :name");
			q.setParameter("name", nome);

			categoria = (Category) q.getResultList().get(0);
		} catch (Exception e) {
			System.out.println("Erro ao buscar categoria: " + e);
			e.printStackTrace();
		}

		return categoria;
	}
}
