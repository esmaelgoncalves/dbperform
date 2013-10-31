package br.com.blog.mysql.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.blog.factory.ConnectionFactoryMySql;
import br.com.blog.mysql.model.Comentario;

/**
 * @author ESMAEL
 * 
 */
public class ComentarioDAO extends ConnectionFactoryMySql {
	private static ComentarioDAO instance;
	private static EntityManager em;

	/**
	 * 
	 * @return
	 */
	public static ComentarioDAO getInstance() {
		if (instance == null) {
			instance = new ComentarioDAO();
		}
		return instance;
	}

	/**
	 * 
	 * @param comentario
	 */
	public void novoComentario(Comentario comentario) {
		em = getEntityManager();
		em.getTransaction().begin();
		em.persist(comentario);
		em.getTransaction().commit();
	}

	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Comentario> buscarTodosComentarios() {
		List<Comentario> comentarios = null;
		em = getEntityManager();
		em.getTransaction().begin();

		Query q = em.createQuery("select c from Comentario as c");
		
		comentarios = q.getResultList();

		return comentarios;
	}

}
