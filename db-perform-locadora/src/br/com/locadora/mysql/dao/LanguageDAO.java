package br.com.locadora.mysql.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.locadora.factory.ConnectionFactoryMySql;
import br.com.locadora.mysql.model.Language;

public class LanguageDAO extends ConnectionFactoryMySql{
	private static LanguageDAO instance;
	private static EntityManager em;

	public static LanguageDAO getInstance() {
		if (instance == null) {
			instance = new LanguageDAO();
		}
		return instance;
	}

	public void novoIdioma(Language idioma) {
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.merge(idioma);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro ao adicionar novo idioma: " + e);
			e.printStackTrace();
		}
	}
	
	public Language buscarIdiomaByName(String nome) {
		Language idioma = null;

		try {
			em = getEntityManager();

			Query q = em
					.createQuery("select i from Language as i where i.name = :nome");
			q.setParameter("nome", nome);

			idioma = (Language) q.getResultList().get(0);
		} catch (Exception e) {
			System.out.println("Erro ao buscar idioma: " + e);
			e.printStackTrace();
		}

		return idioma;
	}
	
	public Language buscarIdiomaById(short id) {
		Language idioma = null;

		try {
			em = getEntityManager();

			Query q = em
					.createQuery("select i from Language as i where i.languageId = :id");
			q.setParameter("id", id);

			idioma = (Language) q.getResultList().get(0);
		} catch (Exception e) {
			System.out.println("Erro ao buscar idioma: " + e);
			e.printStackTrace();
		}

		return idioma;
	}
}
