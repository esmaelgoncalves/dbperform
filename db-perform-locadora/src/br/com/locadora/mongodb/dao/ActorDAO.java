package br.com.locadora.mongodb.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.locadora.factory.ConnectionFactoryMongoDb;
import br.com.locadora.mongodb.model.Actor;
import br.com.locadora.mongodb.model.Film;

import com.google.code.morphia.AdvancedDatastore;
import com.google.code.morphia.query.Query;

public class ActorDAO extends ConnectionFactoryMongoDb {
	private static ActorDAO instance;
	private static AdvancedDatastore db;

	public static ActorDAO getInstance() {
		if (instance == null) {
			instance = new ActorDAO();
		}if (db == null) {
			db = criarConexao();
		}
		return instance;
	}

	public void novoAtor(Actor ator) {
		try {
			db.save(ator);
		} catch (Exception e) {
			System.out.println("Erro ao adicionar novo ator: " + e);
			e.printStackTrace();
		}

	}

	public List<Actor> buscarTodosAtores() {
		List<Actor> atores = null;

		try {
			Query<Actor> q = db.find(Actor.class);
			atores = q.asList();
		} catch (Exception e) {
			System.out.println("Erro ao buscar todos os atores: " + e);
			e.printStackTrace();
		}

		return atores;
	}

	public Actor buscarAtorByName(String nome) {
		Actor ator = null;

		try {
			Query<Actor> q = db.find(Actor.class).filter("firstName =", nome);
			ator = (Actor) q.get();
		} catch (Exception e) {
			System.out.println("Erro ao buscar ator: " + e);
			e.printStackTrace();
		}

		return ator;
	}

	public List<Actor> buscarAtoresByFilm(String filme) {
		List<Actor> atores = new ArrayList<Actor>();
		Film _filme = null;
		
		try {
			Query<Film> q = db.find(Film.class).filter("title =", filme);
			_filme = (Film)q.asList();			
			atores = _filme.getFilmActorList();

		} catch (Exception e) {
			System.out.println("Erro ao buscar atores: " + e);
			e.printStackTrace();
		}
		return atores;
	}

}
