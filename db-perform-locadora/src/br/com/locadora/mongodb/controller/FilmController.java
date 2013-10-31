package br.com.locadora.mongodb.controller;

import java.util.List;

import br.com.locadora.mongodb.dao.FilmDAO;
import br.com.locadora.mongodb.model.Film;

public class FilmController {

	public void novoFilme(Film filme) {
		FilmDAO.getInstance().novoFilme(filme);
	}

	public List<Film> buscarTodosFilmes() {
		return FilmDAO.getInstance().buscarTodosFilmes();
	}

	public Film buscarFilmeByTitle(String titulo) {
		return FilmDAO.getInstance().buscarFilmeByTitle(titulo);
	}

	public List<Film> buscarFilmeByCategory(String categoria) {
		return FilmDAO.getInstance().buscarFilmeByCategory(categoria);
	}

}
