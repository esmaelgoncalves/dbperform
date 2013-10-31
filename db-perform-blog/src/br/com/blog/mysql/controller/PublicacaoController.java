package br.com.blog.mysql.controller;

import java.util.List;

import br.com.blog.mysql.dao.PublicacaoDAO;
import br.com.blog.mysql.dao.UsuarioDAO;
import br.com.blog.mysql.model.Publicacao;
import br.com.blog.mysql.model.Usuario;


/**
 * @author ESMAEL
 *
 */
public class PublicacaoController {

	/**
	 * @param publicacao
	 */
	public void novaPublicacao(Publicacao publicacao) {
		PublicacaoDAO.getInstance().novaPublicacao(publicacao);	
	}

	/**
	 * @return
	 */
	public List<Publicacao> listarTodas() {
		return PublicacaoDAO.getInstance().listarTodas();
	}

	/**
	 * @param tag
	 * @return
	 */
	public Publicacao buscarPublicacaoByTag(String tag) {
		return PublicacaoDAO.getInstance().buscarPublicacaoByTag(tag);
	}

	/**
	 * @param tag
	 * @return
	 */
	public List<Publicacao> buscarPublicacoesByTag(String tag) {
		return PublicacaoDAO.getInstance().buscarPublicacoesByTag(tag);
	}

	/**
	 * @param userReference
	 * @return
	 */
	public List<Publicacao> buscarPublicacoesByUser(String userReference) {
		Usuario user = UsuarioDAO.getInstance().buscarUsuarioByMail(userReference);
		String id = String.valueOf(user.getId());
		return PublicacaoDAO.getInstance().buscarPublicacoesByUsuarioId(id);
	}

	/**
	 * @param publicacao
	 */
	public void novaPublicacaoComComentarios(Publicacao publicacao) {
		PublicacaoDAO.getInstance().novaPublicacaoComComentarios(publicacao);			
	}
	
}
