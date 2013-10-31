package br.com.locadora.mysql.controller;

import br.com.locadora.mysql.dao.CountryDAO;
import br.com.locadora.mysql.model.Country;

public class CountryController {
	
	public void novoPais(Country pais) {
		CountryDAO.getInstance().novoPais(pais);
	}
	
	public Country buscarPaisByName(String nome) {
		return CountryDAO.getInstance().buscarPaisByName(nome);
	}
}
