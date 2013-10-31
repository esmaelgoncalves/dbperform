package br.com.blog.mysql.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.blog.factory.ConnectionFactoryMySql;
import br.com.blog.mysql.model.Usuario;

/**
 * @author ESMAEL
 * 
 */
public class UsuarioDAO extends ConnectionFactoryMySql {
	private static UsuarioDAO instance;
	public static EntityManager em;

	/**
	 * 
	 * @return
	 */
	public static UsuarioDAO getInstance() {
		if (instance == null) {
			instance = new UsuarioDAO();
		}
		return instance;
	}

	/**
	 * 
	 * @param usuario
	 */
	public void novoUsuario(Usuario usuario) {
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.persist(usuario);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro ao adicionar novo usuario: " + e);
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Usuario> buscarTodosUsuarios() {
		List<Usuario> usuarios = null;

		try {
			em = getEntityManager();
			Query q = em.createQuery("select u from Usuario as u");

			usuarios = q.getResultList();
		} catch (Exception e) {
			System.out.println("Erro ao buscar todos usuarios: " + e);
			e.printStackTrace();
		}

		return usuarios;
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> buscarUsuariosByName(String nome) {
		List<Usuario> usuarios = null;

		try {
			em = getEntityManager();
			Query q = em.createQuery("select u from Usuario as u where u.nome = :nome");
			q.setParameter("nome", nome);

			usuarios = q.getResultList();
		} catch (Exception e) {
			System.out.println("Erro ao buscar usuarios: " + e);
			e.printStackTrace();
		}

		return usuarios;
	}
	
	public Usuario buscarUsuarioByMail(String email) {
		Usuario usuario = null;

		try {
			em = getEntityManager();
			Query q = em.createQuery("select u from Usuario as u where u.email = :email");
			q.setParameter("email", email);

			usuario = (Usuario) q.getResultList().get(0);

		} catch (Exception e) {
			System.out.println("Erro ao buscar usuario: " + e);
			e.printStackTrace();
		} 
		return usuario;
	}

	/**
	 * @param nome
	 * @return
	 */
	public Usuario buscarUsuarioByName(String nome) {
		Usuario usuario = null;

		try {
			em = getEntityManager();
			Query q = em.createQuery("select u from Usuario as u where u.nome = :nome");
			q.setParameter("nome", nome);

			usuario = (Usuario)q.getResultList().get(0);

		} catch (Exception e) {
			System.out.println("Erro ao buscar usuario: " + e);
			e.printStackTrace();
		} 
		return usuario;
	}

}
