package br.com.locadora.mongodb.controller;

import java.util.List;

import br.com.locadora.mongodb.dao.StoreDAO;
import br.com.locadora.mongodb.model.Store;

public class StoreController {

	public void novaLoja(Store loja) {
		StoreDAO.getInstance().novaLoja(loja);
	}
	
	public List<Store> buscarTodasLojas() {
		return StoreDAO.getInstance().buscarTodasLojas();
	}

	
}
