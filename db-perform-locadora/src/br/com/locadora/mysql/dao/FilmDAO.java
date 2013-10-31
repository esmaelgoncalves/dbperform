package br.com.locadora.mysql.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.locadora.factory.ConnectionFactoryMySql;
import br.com.locadora.mysql.model.Film;

public class FilmDAO extends ConnectionFactoryMySql {
	private static FilmDAO instance;
	private static EntityManager em;

	public static FilmDAO getInstance() {
		if (instance == null) {
			instance = new FilmDAO();
		}
		return instance;
	}

	public void novoFilme(Film filme) {
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.merge(filme);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro ao adicionar novo filme: " + e);
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public List<Film> buscarTodosFilmes() {
		List<Film> filmes = null;

		try {
			em = getEntityManager();

			Query q = em.createQuery("select f from Film as f");

			filmes = q.getResultList();
		} catch (Exception e) {
			System.out.println("Erro ao buscar todos os filmes: " + e);
			e.printStackTrace();
		}

		return filmes;
	}

	public Film buscarFilmeByTitle(String titulo) {
		Film filme = null;

		try {
			em = getEntityManager();

			Query q = em
					.createQuery("select f from Film as f where f.title = :title");
			q.setParameter("title", titulo);

			filme = (Film) q.getResultList().get(0);
		} catch (Exception e) {
			System.out.println("Erro ao buscar filme: " + e);
			e.printStackTrace();
		}

		return filme;
	}

	@SuppressWarnings("unchecked")
	public List<Film> buscarFilmeByCategory(String categoria) {
		List<Film> filmes = null;

		try {
			em = getEntityManager();

			Query q = em
					.createQuery("select f from Film f where filmCategory_categoryId = (select c.categoryId from Category as c where c.name = :category)");
			q.setParameter("category", categoria);
			filmes = q.getResultList();

		} catch (Exception e) {
			System.out.println("Erro ao buscar publicacao: " + e);
			e.printStackTrace();
		}
		return filmes;
	}

	public Film buscarFilmeById(int id) {
		Film filme = null;

		try {
			em = getEntityManager();

			Query q = em
					.createQuery("select f from Film as f where f.filmId = :id");
			q.setParameter("id", id);

			filme = (Film) q.getResultList().get(0);
		} catch (Exception e) {
			System.out.println("Erro ao buscar filme: " + e);
			e.printStackTrace();
		}

		return filme;
	}

}
