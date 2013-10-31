package br.com.locadora.mongodb.controller;

import br.com.locadora.mongodb.dao.LanguageDAO;
import br.com.locadora.mongodb.model.Language;

public class LanguageController {
	
	public void novoIdioma(Language idioma) {
		LanguageDAO.getInstance().novoIdioma(idioma);
	}
	
	public Language buscarIdiomaByName(String nome) {
		return LanguageDAO.getInstance().buscarIdiomaByName(nome);
	}
}
