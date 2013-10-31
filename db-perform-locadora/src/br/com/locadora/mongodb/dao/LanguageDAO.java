package br.com.locadora.mongodb.dao;


import br.com.locadora.factory.ConnectionFactoryMongoDb;
import br.com.locadora.mongodb.model.Language;

import com.google.code.morphia.AdvancedDatastore;
import com.google.code.morphia.query.Query;

public class LanguageDAO extends ConnectionFactoryMongoDb{
	private static LanguageDAO instance;
	private static AdvancedDatastore db;

	public static LanguageDAO getInstance() {
		if (instance == null) {
			instance = new LanguageDAO();
		}if (db == null) {
			db = criarConexao();
		}
		return instance;
	}

	public void novoIdioma(Language idioma) {
		try {
			db.save(idioma);
		} catch (Exception e) {
			System.out.println("Erro ao adicionar novo idioma: " + e);
			e.printStackTrace();
		}
	}
	
	public Language buscarIdiomaByName(String nome) {
		Language idioma = null;

		try {
			Query <Language> q = db.find(Language.class).filter("nome =", nome);
			idioma = (Language) q.get();
		} catch (Exception e) {
			System.out.println("Erro ao buscar idioma: " + e);
			e.printStackTrace();
		}

		return idioma;
	}
	
	public Language buscarIdiomaById(int id) {
		Language idioma = null;

		try {
			Query <Language> q = db.find(Language.class).filter("_id =", id);
			idioma = (Language) q.get();
		} catch (Exception e) {
			System.out.println("Erro ao buscar idioma: " + e);
			e.printStackTrace();
		}

		return idioma;
	}
}
