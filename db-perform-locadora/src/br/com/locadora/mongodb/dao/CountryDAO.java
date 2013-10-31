package br.com.locadora.mongodb.dao;

import br.com.locadora.factory.ConnectionFactoryMongoDb;
import br.com.locadora.mongodb.model.Country;

import com.google.code.morphia.AdvancedDatastore;
import com.google.code.morphia.query.Query;

public class CountryDAO extends ConnectionFactoryMongoDb {
	private static CountryDAO instance;
	private static AdvancedDatastore db;

	public static CountryDAO getInstance() {
		if (instance == null) {
			instance = new CountryDAO();
		}if (db == null) {
			db = criarConexao();
		}
		return instance;
	}
	
	public void novoPais(Country pais) {
		try {
			
			db.save(pais);
		} catch (Exception e) {
			System.out.println("Erro ao adicionar novo endereco: " + e);
			e.printStackTrace();
		}
	}
	
	public Country buscarPaisByName(String nome) {
		Country cidade = null;
		
		
		try {
			
			Query<Country> q = db.find(Country.class).filter("nome =", nome);
			cidade = q.get();
			
		} catch (Exception e) {
			System.out.println("Erro ao buscar pais: " + e);
			e.printStackTrace();
		}

		return cidade;
	}
	
	public Country buscarPaisById(int id) {
		Country cidade = null;

		try {
			Query<Country> q = db.find(Country.class).filter("_id =", id);
			cidade = q.get();
		} catch (Exception e) {
			System.out.println("Erro ao buscar pais: " + e);
			e.printStackTrace();
		}

		return cidade;
	}
}
