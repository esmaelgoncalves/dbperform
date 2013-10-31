package br.com.locadora.mysql.controller;

import br.com.locadora.mysql.dao.InventoryDAO;
import br.com.locadora.mysql.model.Inventory;

public class InventoryController {

	public void novoInventario(Inventory inventario) {
		InventoryDAO.getInstance().novoInventario(inventario);
	}
	
	public Inventory buscarInventarioById(int id) {
		return InventoryDAO.getInstance().buscarInventarioById(id);
	}
}
