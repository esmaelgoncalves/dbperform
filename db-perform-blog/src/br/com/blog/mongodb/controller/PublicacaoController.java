package br.com.blog.mongodb.controller;


import java.util.List;

import br.com.blog.mongodb.dao.PublicacaoDAO;
import br.com.blog.mongodb.model.Publicacao;

/**
 * 
 * @author ESMAEL
 *
 */
public class PublicacaoController {

    /**
     * 
     * @return list
     */
    public List<Publicacao> listarTodas() {
        return PublicacaoDAO.getInstance().listarTodas();
    }
    
    /**
     * 
     * @param tag
     * @return
     */
    public Publicacao buscarPublicacaoByTag(String tag) {
    	return PublicacaoDAO.getInstance().buscarPublicacaoByTag(tag);
    }
    
    /**
     * 
     * @param tag
     * @return
     */
    public List<Publicacao> buscarPublicacoesByTag(String tag) {
    	return PublicacaoDAO.getInstance().buscarPublicacoesByTag(tag);
    }
    
    /**
     * 
     * @param userReference
     * @return
     */
    public List<Publicacao> buscarPublicacoesByUserReference(String userReference) {
    	return PublicacaoDAO.getInstance().buscarPublicacoesByUserReference(userReference);
	}

    /**
     * 
     * @param publicacao
     * @param email
     */
    public void novaPublicacaoDBREF(Publicacao publicacao, String email) {
    	PublicacaoDAO.getInstance().novaPublicacaoDBREF(publicacao,email);
    }

    /**
     * 
     * @param publicacao
     */
	public void novaPublicacao(Publicacao publicacao) {
		PublicacaoDAO.getInstance().novaPublicacao(publicacao);
	}
	
	public void novaPublicacaoComComentários(Publicacao publicacao) {
		PublicacaoDAO.getInstance().novaPublicacaoComComentarios(publicacao);
	}

	public void removePublicacaoByUserEmail(String email) {
		PublicacaoDAO.getInstance().removePublicacaoByUserEmail(email);
	}
	
	public void atualizaUsuarioByEmail(String email, String novoApelido){
		PublicacaoDAO.getInstance().atualizaUsuarioByUserEmail(email, novoApelido);
	}
	
}
