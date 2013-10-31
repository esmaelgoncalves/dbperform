package br.com.blog.mongodb.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.blog.factory.ConnectionFactoryMongoDb;
import br.com.blog.mongodb.model.Usuario;

import com.google.code.morphia.AdvancedDatastore;
import com.google.code.morphia.query.Query;

/**
 * 
 * @author ESMAEL
 *
 */
public class UsuarioDAO extends ConnectionFactoryMongoDb {

	private static UsuarioDAO instance;
	private static AdvancedDatastore conexao;

	/**
	 * 
	 * @return
	 */
	public static UsuarioDAO getInstance() {
		if (instance == null) {
			instance = new UsuarioDAO();
		}
		if (conexao == null) {
			conexao = criarConexao();
		}
		return instance;
	}

	/**
	 * 
	 * @param usuario
	 */
	public void novoUsuario(Usuario usuario) {
		try {
			conexao.save(usuario);
		} catch (Exception e) {
			System.out.println("Erro ao criar novo usuario: " + e);
			e.printStackTrace();
		} 

	}

	/**
	 * 
	 * @return
	 */
	public List<Usuario> listarTodos() {
		List<Usuario> usuarios = null;

		usuarios = new ArrayList<Usuario>();
		try {
			Query<Usuario> query = conexao.find(Usuario.class);

			usuarios = query.asList();

		} catch (Exception e) {
			System.out.println("Erro ao listar todas os usuario: " + e);
			e.printStackTrace();
		}
		return usuarios;
	}

	/**
	 * 
	 * @param email
	 * @return
	 */
	public Usuario buscarUsuarioByMail(String email) {
		Usuario usuario = null;

		try {
			conexao.ensureIndexes(true);

			Query<Usuario> query = conexao.find(Usuario.class).filter(
					"email = ", email);

			usuario = (Usuario) query.get();

		} catch (Exception e) {
			System.out.println("Erro ao buscar usuario: " + e);
			e.printStackTrace();
		} 
		return usuario;
	}

	/**
	 * 
	 * @param nome
	 * @return
	 */
	public Usuario buscarUsuarioByNome(String nome) {
		Usuario usuario = null;

		try {
			conexao.ensureIndexes(true);

			Query<Usuario> query = conexao.find(Usuario.class)
					.filter("nome = ", nome).limit(1);

			usuario = (Usuario) query.get();

		} catch (Exception e) {
			System.out.println("Erro ao buscar usuario: " + e);
			e.printStackTrace();
		}
		return usuario;
	}

	/**
	 * 
	 * @param nome
	 * @return
	 */
	public List<Usuario> buscarUsuariosByNome(String nome) {
		List<Usuario> usuarios = null;

		try {
			conexao.ensureIndexes(true);

			Query<Usuario> query = conexao.find(Usuario.class).filter(
					"nome = ", nome);

			usuarios = query.asList();

		} catch (Exception e) {
			System.out.println("Erro ao buscar usuario: " + e);
			e.printStackTrace();
		}
		return usuarios;
	}

	/**
	 * 
	 * @param usuarios
	 */
	public void inserirUsuarios(List<Usuario> usuarios) {

		try {

			for (Usuario usuario : usuarios) {
				conexao.save(usuario);
			}

		} catch (Exception e) {
			System.out.println("Erro ao criar novos usuario: " + e);
			e.printStackTrace();
		} 

	}
}
