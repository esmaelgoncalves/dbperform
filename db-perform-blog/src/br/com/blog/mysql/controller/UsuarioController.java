package br.com.blog.mysql.controller;

import java.util.List;

import br.com.blog.mysql.dao.UsuarioDAO;
import br.com.blog.mysql.model.Usuario;


/**
 * @author ESMAEL
 *
 */
public class UsuarioController {

	/**
	 * @param usuario
	 */
	public void novoUsuario(Usuario usuario) {
		UsuarioDAO.getInstance().novoUsuario(usuario);
	}

	/**
	 * @return
	 */
	public List<Usuario> listarTodos() {	
		return UsuarioDAO.getInstance().buscarTodosUsuarios();
	}

	/**
	 * @param email
	 * @return
	 */
	public Usuario buscarUsuarioByMail(String email) {
		return UsuarioDAO.getInstance().buscarUsuarioByMail(email);
	}

	/**
	 * @param nome
	 * @return
	 */
	public Usuario buscarUsuarioByNome(String nome) {
		return UsuarioDAO.getInstance().buscarUsuarioByName(nome);
	}

	/**
	 * @param nome
	 * @return
	 */
	public List<Usuario> buscarUsuariosByNome(String nome) {
		return UsuarioDAO.getInstance().buscarUsuariosByName(nome);
	}


	

}
