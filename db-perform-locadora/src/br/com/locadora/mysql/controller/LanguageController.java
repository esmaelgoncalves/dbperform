package br.com.locadora.mysql.controller;

import br.com.locadora.mysql.dao.LanguageDAO;
import br.com.locadora.mysql.model.Language;

public class LanguageController {
	
	public void novoIdioma(Language idioma) {
		LanguageDAO.getInstance().novoIdioma(idioma);
	}
	
	public Language buscarIdiomaByName(String nome) {
		return LanguageDAO.getInstance().buscarIdiomaByName(nome);
	}
}
