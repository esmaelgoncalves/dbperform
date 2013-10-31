package br.com.locadora.mongodb.controller;

import br.com.locadora.mongodb.dao.CountryDAO;
import br.com.locadora.mongodb.model.Country;

public class CountryController {
	
	public void novoPais(Country pais) {
		CountryDAO.getInstance().novoPais(pais);
	}
	
	public Country buscarPaisByName(String nome) {
		return CountryDAO.getInstance().buscarPaisByName(nome);
	}
}
