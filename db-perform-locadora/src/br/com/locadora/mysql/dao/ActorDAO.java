package br.com.locadora.mysql.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.locadora.factory.ConnectionFactoryMySql;
import br.com.locadora.mysql.model.Actor;

public class ActorDAO extends ConnectionFactoryMySql {
	private static ActorDAO instance;
	private static EntityManager em;

	public static ActorDAO getInstance() {
		if (instance == null) {
			instance = new ActorDAO();
		}
		return instance;
	}

	public void novoAtor(Actor ator) {
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.merge(ator);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro ao adicionar novo ator: " + e);
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public List<Actor> buscarTodosAtores() {
		List<Actor> atores = null;

		try {
			em = getEntityManager();

			Query q = em.createQuery("select a from Actor as a");

			atores = q.getResultList();
		} catch (Exception e) {
			System.out.println("Erro ao buscar todos os atores: " + e);
			e.printStackTrace();
		}

		return atores;
	}

	public Actor buscarAtorByName(String nome) {
		Actor ator = null;

		try {
			em = getEntityManager();

			Query q = em
					.createQuery("select a from Actor as a where a.firstname = :firstname");
			q.setParameter("firstname", nome);

			ator = (Actor) q.getResultList().get(0);
		} catch (Exception e) {
			System.out.println("Erro ao buscar ator: " + e);
			e.printStackTrace();
		}

		return ator;
	}

	@SuppressWarnings({ "unchecked" })
	public List<Actor> buscarAtoresByFilm(String filme) {
		List<Actor> atores = null;

		try {
			em = getEntityManager();

			Query q = em
					.createQuery("select a from Actor a where a.actorId IN (select f.actorId from FilmActor as f where f.filmId = (select film.filmId from Film as film where film.title = :film))");
			q.setParameter("film", filme);
			atores = q.getResultList();

		} catch (Exception e) {
			System.out.println("Erro ao buscar atores: " + e);
			e.printStackTrace();
		}
		return atores;
	}

}
