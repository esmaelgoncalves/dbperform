package br.com.locadora.mongodb.dao;

import java.util.List;

import br.com.locadora.factory.ConnectionFactoryMongoDb;
import br.com.locadora.mongodb.model.Store;

import com.google.code.morphia.AdvancedDatastore;
import com.google.code.morphia.query.Query;

public class StoreDAO extends ConnectionFactoryMongoDb {
	private static StoreDAO instance;
	private static AdvancedDatastore db;

	public static StoreDAO getInstance() {
		if (instance == null) {
			instance = new StoreDAO();
		}if (db == null) {
			db = criarConexao();
		}
		return instance;
	}

	public void novaLoja(Store loja) {
		try {
			db.save(loja);
		} catch (Exception e) {
			System.out.println("Erro ao adicionar novo loja: " + e);
			e.printStackTrace();
		}
	}
	
	public List<Store> buscarTodasLojas() {
		List<Store> lojas = null;

		try {

			Query <Store> q = db.find(Store.class);
			
			lojas = q.asList();

		} catch (Exception e) {
			System.out.println("Erro ao buscar todas as lojas: " + e);
			e.printStackTrace();
		}

		return lojas;
	}

	
	public Store buscarLojaById(int id) {
		Store loja = null;

		try {
			
			Query <Store> q = db.find(Store.class).field("storeId").equal(id);
			
			loja = q.get();
			
		} catch (Exception e) {
			System.out.println("Erro ao buscar loja: " + e);
			e.printStackTrace();
		}

		return loja;
	}
	
}
