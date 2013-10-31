package br.com.locadora.mysql.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.locadora.factory.ConnectionFactoryMySql;
import br.com.locadora.mysql.model.Inventory;

public class InventoryDAO extends ConnectionFactoryMySql{
	private static InventoryDAO instance;
	private static EntityManager em;

	public static InventoryDAO getInstance() {
		if (instance == null) {
			instance = new InventoryDAO();
		}
		return instance;
	}

	public void novoInventario(Inventory inventario) {
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.merge(inventario);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro ao adicionar novo inventario: " + e);
			e.printStackTrace();
		}
	}
	
	public Inventory buscarInventarioById(int id) {
		Inventory inventario = null;

		try {
			em = getEntityManager();

			Query q = em
					.createQuery("select i from Inventory as i where i.inventoryId = :id");
			q.setParameter("id", id);

			inventario = (Inventory) q.getResultList().get(0);
		} catch (Exception e) {
			System.out.println("Erro ao buscar inventario: " + e);
			e.printStackTrace();
		}

		return inventario;
	}
}
