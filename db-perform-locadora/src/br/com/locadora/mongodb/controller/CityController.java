package br.com.locadora.mongodb.controller;

import java.util.List;

import br.com.locadora.mongodb.dao.CityDAO;
import br.com.locadora.mongodb.model.City;

public class CityController {
	
	public void novaCidade(City cidade) {
		CityDAO.getInstance().novaCidade(cidade);
	}
	
	public List<City> buscarTodasCidades() {
		return CityDAO.getInstance().buscarTodasCidades();
	}

	public City buscarCidadeByName(String nome) {
		return CityDAO.getInstance().buscarCidadeByName(nome);
	}
	
	
}
