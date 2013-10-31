package br.com.locadora.mongodb.dao;

import java.util.List;

import br.com.locadora.factory.ConnectionFactoryMongoDb;
import br.com.locadora.mongodb.model.Category;
import br.com.locadora.mongodb.model.Film;

import com.google.code.morphia.AdvancedDatastore;
import com.google.code.morphia.query.Query;

public class FilmDAO extends ConnectionFactoryMongoDb {
	private static FilmDAO instance;
	private static AdvancedDatastore db;

	public static FilmDAO getInstance() {
		if (instance == null) {
			instance = new FilmDAO();
		}if (db == null) {
			db = criarConexao();
		}
		return instance;
	}

	public void novoFilme(Film filme) {
		try {
			db.save(filme);
		} catch (Exception e) {
			System.out.println("Erro ao adicionar novo filme: " + e);
			e.printStackTrace();
		}

	}

	public List<Film> buscarTodosFilmes() {
		List<Film> filmes = null;

		try {
			Query <Film> q = db.find(Film.class);

			filmes = q.asList();
		} catch (Exception e) {
			System.out.println("Erro ao buscar todos os filmes: " + e);
			e.printStackTrace();
		}

		return filmes;
	}

	public Film buscarFilmeByTitle(String titulo) {
		Film filme = null;

		try {
			Query <Film> q = db.find(Film.class).filter("title", titulo);

			filme = (Film) q.get();
		} catch (Exception e) {
			System.out.println("Erro ao buscar filme: " + e);
			e.printStackTrace();
		}

		return filme;
	}

	public List<Film> buscarFilmeByCategory(String _categoria) {
		List<Film> filmes = null;
		Category categoria;

		try {
			Query <Category> q = db.find(Category.class).filter("name =", _categoria);
			categoria = (Category) q.get();
			
			Query <Film> q2 = db.find(Film.class).filter("Category =", categoria);
			filmes = q2.asList();

		} catch (Exception e) {
			System.out.println("Erro ao buscar publicacao: " + e);
			e.printStackTrace();
		}
		return filmes;
	}

	public Film buscarFilmeById(int id) {
		Film filme = null;

		try {
			Query <Film> q = db.find(Film.class).filter("_id", id);

			filme = (Film) q.get();
		} catch (Exception e) {
			System.out.println("Erro ao buscar filme: " + e);
			e.printStackTrace();
		}

		return filme;
	}

}
