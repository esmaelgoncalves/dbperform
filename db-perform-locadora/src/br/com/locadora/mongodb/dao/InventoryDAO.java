package br.com.locadora.mongodb.dao;



import br.com.locadora.factory.ConnectionFactoryMongoDb;
import br.com.locadora.mongodb.model.Inventory;

import com.google.code.morphia.AdvancedDatastore;
import com.google.code.morphia.query.Query;

public class InventoryDAO extends ConnectionFactoryMongoDb{
	private static InventoryDAO instance;
	private static AdvancedDatastore db;

	public static InventoryDAO getInstance() {
		if (instance == null) {
			instance = new InventoryDAO();
		}if (db == null) {
			db = criarConexao();
		}
		return instance;
	}

	public void novoInventario(Inventory inventario) {
		try {
			db.save(inventario);
		} catch (Exception e) {
			System.out.println("Erro ao adicionar novo inventario: " + e);
			e.printStackTrace();
		}
	}
	
	public Inventory buscarInventarioById(int id) {
		Inventory inventario = null;

		try {
			Query <Inventory> q = db.find(Inventory.class).filter("_id", id);

			inventario = (Inventory) q.get();
		} catch (Exception e) {
			System.out.println("Erro ao buscar inventario: " + e);
			e.printStackTrace();
		}

		return inventario;
	}
}
