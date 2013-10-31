package br.com.locadora.mongodb.dao;

import java.util.List;

import br.com.locadora.factory.ConnectionFactoryMongoDb;
import br.com.locadora.mongodb.model.City;

import com.google.code.morphia.AdvancedDatastore;
import com.google.code.morphia.query.Query;

public class CityDAO extends ConnectionFactoryMongoDb{
	private static CityDAO instance;
	private static AdvancedDatastore db;

	public static CityDAO getInstance() {
		if (instance == null) {
			instance = new CityDAO();
		}if (db == null) {
			db = criarConexao();
		}
		return instance;
	}
	
	public void novaCidade(City cidade) {
		try {
			db.save(cidade);
		} catch (Exception e) {
			System.out.println("Erro ao adicionar nova cidade: " + e);
			e.printStackTrace();
		}
	}
	
	public List<City> buscarTodasCidades() {
		List<City> cidades = null;

		try {
			Query<City> q = db.find(City.class);
			cidades = q.asList();
		} catch (Exception e) {
			System.out.println("Erro ao buscar todas as cidades: " + e);
			e.printStackTrace();
		}

		return cidades;
	}
	
	public City buscarCidadeById(int id) {
		City cidade = null;

		try {
			Query<City> q = db.find(City.class).filter("_id =", id);
			cidade = q.get();

		} catch (Exception e) {
			System.out.println("Erro ao buscar cidade: " + e);
			e.printStackTrace();
		}

		return cidade;
	}

	public City buscarCidadeByName(String nome) {
		City cidade = null;

		try {
			Query<City> q = db.find(City.class).filter("city =",nome);
			cidade = q.get();
		} catch (Exception e) {
			System.out.println("Erro ao buscar cidade: " + e);
			e.printStackTrace();
		}

		return cidade;
	}
	
	
}
