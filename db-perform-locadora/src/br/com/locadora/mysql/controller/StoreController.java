package br.com.locadora.mysql.controller;

import java.util.List;

import br.com.locadora.mysql.dao.StoreDAO;
import br.com.locadora.mysql.model.Store;

public class StoreController {

	public void novaLoja(Store loja) {
		StoreDAO.getInstance().novaLoja(loja);
	}
	
	public List<Store> buscarTodasLojas() {
		return StoreDAO.getInstance().buscarTodasLojas();
	}

	public Store buscarLojaByAddress(String endereco) {
		return StoreDAO.getInstance().buscarLojaByAddress(endereco);
	}

	public Store buscarLojaByManager(String email) {
		return StoreDAO.getInstance().buscarLojaByManager(email);
	}
	
}
