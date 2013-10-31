package br.com.blog.mysql.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.blog.factory.ConnectionFactoryMySql;
import br.com.blog.mysql.model.Tag;

/**
 * @author ESMAEL
 * 
 */
public class TagDAO extends ConnectionFactoryMySql {
	private static TagDAO instance;
	public static EntityManager em;

	/**
	 * 
	 * @return
	 */
	public static TagDAO getInstance() {
		if (instance == null) {
			instance = new TagDAO();
		}
		return instance;
	}

	/**
	 * 
	 * @param tag
	 */
	public void novaTag(Tag tag) {
		em = getEntityManager();
		em.getTransaction().begin();
		em.persist(tag);
		em.getTransaction().commit();
	}

	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Tag> buscarTodasTags() {
		List<Tag> tags = null;
		em = getEntityManager();
		em.getTransaction().begin();

		Query q = em.createQuery("select t from Tag as t");
		tags = q.getResultList();

		return tags;
	}
	
	public Tag buscarTagByName(String _tag) {
		Tag tag = null;
		em = getEntityManager();
		try {

			Query q = em.createQuery("select t from Tag as t where t.tag = :tag");
			q.setParameter("tag", _tag);
			
			tag = (Tag) q.getSingleResult();

		} catch (Exception e) {
			System.out.println("Erro ao buscar publicacao: " + e);
			e.printStackTrace();
		}
		return tag;
	}

}
