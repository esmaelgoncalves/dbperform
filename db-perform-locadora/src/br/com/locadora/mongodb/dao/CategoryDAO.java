package br.com.locadora.mongodb.dao;

import java.util.List;

import br.com.locadora.factory.ConnectionFactoryMongoDb;
import br.com.locadora.mongodb.model.Category;

import com.google.code.morphia.AdvancedDatastore;
import com.google.code.morphia.query.Query;



public class CategoryDAO extends ConnectionFactoryMongoDb {
	private static CategoryDAO instance;
	private static AdvancedDatastore db;

	public static CategoryDAO getInstance() {
		if (instance == null) {
			instance = new CategoryDAO();
		}if (db == null) {
			db = criarConexao();
		}
		return instance;
	}

	public void novaCategoria(Category categoria) {
		try {
			db.save(categoria);
		} catch (Exception e) {
			System.out.println("Erro ao adicionar nova categoria: " + e);
			e.printStackTrace();
		}

	}

	public List<Category> buscarTodasCategorias() {
		List<Category> categorias = null;

		try {
			Query<Category> q = db.find(Category.class);
			categorias = q.asList();
		} catch (Exception e) {
			System.out.println("Erro ao buscar todas as categorias: " + e);
			e.printStackTrace();
		}

		return categorias;
	}

	public Category buscarCategoriaByName(String nome) {
		Category categoria = null;

		try {
			Query<Category> q = db.find(Category.class).filter("name =", nome);
			categoria = (Category) q.get();
		} catch (Exception e) {
			System.out.println("Erro ao buscar categoria: " + e);
			e.printStackTrace();
		}

		return categoria;
	}
}
