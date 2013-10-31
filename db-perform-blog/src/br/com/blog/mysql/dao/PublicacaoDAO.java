package br.com.blog.mysql.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.blog.factory.ConnectionFactoryMySql;
import br.com.blog.mysql.model.Publicacao;
import br.com.blog.mysql.model.Tag;

/**
 * @author ESMAEL
 * 
 */
public class PublicacaoDAO extends ConnectionFactoryMySql {
	private static PublicacaoDAO instance;
	public static EntityManager em;

	/**
	 * 
	 * @return
	 */
	public static PublicacaoDAO getInstance() {
		if (instance == null) {
			instance = new PublicacaoDAO();
		}
		return instance;
	}

	/**
	 * 
	 * @param publicacao
	 */
	public void novaPublicacao(Publicacao publicacao) {

		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.persist(publicacao);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro ao adicionar publicacao: " + e);
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Publicacao> listarTodas() {
		List<Publicacao> publicacoes = null;
		em = getEntityManager();
		try {

			em.getTransaction().begin();

			Query query = em.createQuery("select p from Publicacao as p");
			publicacoes = query.getResultList();
		} catch (Exception e) {
			System.out.println("Erro ao buscar todas publicacoes: " + e);
			e.printStackTrace();
		}

		return publicacoes;
	}

	/**
	 * 
	 * @param idUsuario
	 * @return
	 */
	public Publicacao buscarPublicacaoByUsuarioId(String idUsuario) {
		Publicacao publicacao = null;
		em = getEntityManager();

		try {

			Query query = em
					.createQuery("select p from Publicacao p where usuario_id_usuario = :id");
			query.setParameter("id", idUsuario);

			publicacao = (Publicacao) query.getResultList().get(0);

		} catch (Exception e) {
			System.out.println("Erro ao buscar publicacao: " + e);
			e.printStackTrace();
		}
		return publicacao;
	}

	@SuppressWarnings("unchecked")
	public List<Publicacao> buscarPublicacoesByUsuarioId(String idUsuario) {
		List<Publicacao> publicacoes = null;
		em = getEntityManager();
		try {

			Query query = em
					.createQuery("select p from Publicacao p where usuario_id_usuario = :id");

			query.setParameter("id", idUsuario);

			publicacoes = query.getResultList();

		} catch (Exception e) {
			System.out.println("Erro ao buscar publicacao: " + e);
			e.printStackTrace();
		}
		return publicacoes;
	}

	@SuppressWarnings({"unchecked"})
	public List<Publicacao> buscarPublicacoesByTag(String tag) {
		List<Publicacao> publicacoes = new ArrayList<Publicacao>();
		em = getEntityManager();

		try {
			Tag t = TagDAO.getInstance().buscarTagByName(tag);
			
			Query q = em.createQuery("select p from Publicacao p where id_publicacao IN (select a.id_publicacao from PublicacaoTag a where a.id_tag = :tag)");
			q.setParameter("tag", t.getId());
			publicacoes = q.getResultList();

		} catch (Exception e) {
			System.out.println("Erro ao buscar publicacao: " + e);
			e.printStackTrace();
		}
		return publicacoes;
	}

	/**
	 * @param tag
	 * @return
	 */
	public Publicacao buscarPublicacaoByTag(String tag) {
		Publicacao publicacao = null;
		em = getEntityManager();

		try {
			Tag t = TagDAO.getInstance().buscarTagByName(tag);

			Query q = em.createQuery("select p from Publicacao p where id_publicacao IN (select a.id_publicacao from PublicacaoTag a where a.id_tag = :tag)");
			q.setParameter("tag", t.getId());
			publicacao = (Publicacao) q.getResultList().get(0);

		} catch (Exception e) {
			System.out.println("Erro ao buscar publicacao: " + e);
			e.printStackTrace();
		}
		return publicacao;
	}

	/**
	 * @param publicacao
	 */
	public void novaPublicacaoComComentarios(Publicacao publicacao) {
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.persist(publicacao);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro ao adicionar publicacao: " + e);
			e.printStackTrace();
		}

	}
}
