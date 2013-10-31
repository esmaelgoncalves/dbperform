package br.com.locadora.mysql.controller;

import java.util.List;

import br.com.locadora.mysql.dao.ActorDAO;
import br.com.locadora.mysql.model.Actor;

public class ActorController {

	public void novoAtor(Actor ator) {
		ActorDAO.getInstance().novoAtor(ator);

	}

	public List<Actor> buscarTodosAtores() {
		return ActorDAO.getInstance().buscarTodosAtores();
	}

	public Actor buscarAtorByName(String nome) {
		return ActorDAO.getInstance().buscarAtorByName(nome);
	}

	public List<Actor> buscarAtoresByFilm(String filme) {
		return ActorDAO.getInstance().buscarAtoresByFilm(filme);
	}

}
