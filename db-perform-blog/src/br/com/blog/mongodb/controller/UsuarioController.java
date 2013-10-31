package br.com.blog.mongodb.controller;


import java.util.List;

import br.com.blog.mongodb.dao.UsuarioDAO;
import br.com.blog.mongodb.model.Usuario;

/**
 * 
 * @author ESMAEL
 *
 */
public class UsuarioController {

	/**
	 * 
	 * @param usuario
	 */
    public void novoUsuario(Usuario usuario) {
        UsuarioDAO.getInstance().novoUsuario(usuario);
    }
    
    /**
     * 
     * @return
     */
    public List<Usuario> listarTodos() {
        return UsuarioDAO.getInstance().listarTodos();
    }

    /**
     * 
     * @param email
     * @return
     */
    public Usuario buscarUsuarioByMail(String email) {
	return UsuarioDAO.getInstance().buscarUsuarioByMail(email);
    }

    /**
     * 
     * @param nome
     * @return
     */
	public Usuario buscarUsuarioByNome(String nome) {
		return UsuarioDAO.getInstance().buscarUsuarioByNome(nome);
	}

	/**
	 * 
	 * @param nome
	 * @return
	 */
	public List<Usuario> buscarUsuariosByNome(String nome) {
		return UsuarioDAO.getInstance().buscarUsuariosByNome(nome);
	}

}
