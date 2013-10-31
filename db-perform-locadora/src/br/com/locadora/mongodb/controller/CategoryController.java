package br.com.locadora.mongodb.controller;

import java.util.List;

import br.com.locadora.mongodb.dao.CategoryDAO;
import br.com.locadora.mongodb.model.Category;

public class CategoryController {

	public void novaCategoria(Category categoria) {
		CategoryDAO.getInstance().novaCategoria(categoria);
	}

	public List<Category> buscarTodasCategorias() {
		return CategoryDAO.getInstance().buscarTodasCategorias();
	}

	public Category buscarCategoriaByName(String nome) {
		return CategoryDAO.getInstance().buscarCategoriaByName(nome);
	}
}
