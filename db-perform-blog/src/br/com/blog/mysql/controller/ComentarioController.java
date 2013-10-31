package br.com.blog.mysql.controller;

import br.com.blog.mysql.dao.ComentarioDAO;
import br.com.blog.mysql.model.Comentario;


/**
 * @author ESMAEL
 *
 */
public class ComentarioController {

	/**
	 * @param comentario
	 */
	public void novoComentario(Comentario comentario) {
		ComentarioDAO.getInstance().novoComentario(comentario);
		
	}
	

}
