package br.com.locadora.mysql.controller;

import java.util.List;

import br.com.locadora.mysql.dao.CityDAO;
import br.com.locadora.mysql.model.City;

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
