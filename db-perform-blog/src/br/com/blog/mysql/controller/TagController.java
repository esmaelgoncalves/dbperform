package br.com.blog.mysql.controller;

import br.com.blog.mysql.dao.TagDAO;
import br.com.blog.mysql.model.Tag;


/**
 * @author ESMAEL
 *
 */
public class TagController {
	
	public void novaTag(Tag tag){
		TagDAO.getInstance().novaTag(tag);
	}
	
	public Tag buscarTagByName(String tag){
		return TagDAO.getInstance().buscarTagByName(tag);
	}

}
