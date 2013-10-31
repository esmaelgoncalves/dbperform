package br.com.locadora.mongodb.controller;

import br.com.locadora.mongodb.dao.InventoryDAO;
import br.com.locadora.mongodb.model.Inventory;

public class InventoryController {

	public void novoInventario(Inventory inventario) {
		InventoryDAO.getInstance().novoInventario(inventario);
	}
	
	public Inventory buscarInventarioById(int id) {
		return InventoryDAO.getInstance().buscarInventarioById(id);
	}
}
