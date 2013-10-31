package br.com.locadora.mongodb.dao;

import java.util.List;

import br.com.locadora.factory.ConnectionFactoryMongoDb;
import br.com.locadora.mongodb.model.Customer;

import com.google.code.morphia.AdvancedDatastore;
import com.google.code.morphia.query.Query;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;


public class CustomerDAO extends ConnectionFactoryMongoDb {
	private static CustomerDAO instance;
	private static AdvancedDatastore db;

	public static CustomerDAO getInstance() {
		if (instance == null) {
			instance = new CustomerDAO();
		}if (db == null) {
			db = criarConexao();
		}
		return instance;
	}

	public void novoCliente(Customer cliente) {
		try {
			db.save(cliente);
		} catch (Exception e) {
			System.out.println("Erro ao adicionar novo cliente: " + e);
			e.printStackTrace();
		}
	}

	public List<Customer> buscarTodosClientes() {
		List<Customer> clientes = null;

		try {

			Query <Customer> q = db.find(Customer.class);

			clientes = q.asList();
		} catch (Exception e) {
			System.out.println("Erro ao buscar todss os clientes: " + e);
			e.printStackTrace();
		}

		return clientes;
	}

	public List<Customer> buscarClienteByStatus(boolean status) {
		List<Customer> clientes = null;

		try {
			Query <Customer> q = db.find(Customer.class).filter("active =", status);
			
			clientes = q.asList();
		} catch (Exception e) {
			System.out.println("Erro ao buscar clientes: " + e);
			e.printStackTrace();
		}

		return clientes;
	}


	public List<Customer> buscarClienteByStore(int loja) {
		List<Customer> clientes = null;

		try {
			Query <Customer> q = db.find(Customer.class).filter("store =", loja);

			clientes = q.asList();

		} catch (Exception e) {
			System.out.println("Erro ao buscar clientes: " + e);
			e.printStackTrace();
		}
		return clientes;
	}

	public Customer buscarClienteByEmail(String email) {
		Customer cliente = null;

		try {
			Query <Customer> q = db.find(Customer.class).filter("email =", email);

			cliente = (Customer) q.get();
		} catch (Exception e) {
			System.out.println("Erro ao buscar cliente: " + e);
			e.printStackTrace();
		}
		return cliente;
	}

	public Customer buscarClienteById(int id) {
		Customer cliente = null;

		try {
			Query <Customer> q = db.find(Customer.class).filter("_id =", id);

			cliente = (Customer) q.get();

		} catch (Exception e) {
			System.out.println("Erro ao buscar cliente: " + e);
			e.printStackTrace();
		}
		return cliente;
	}

	public List <Customer> buscarClienteByTotalPayment(double valor) {
		List <Customer> clientes = null;

		try {
			
			Query <Customer> q = db.find(Customer.class);
			clientes = q.asList();
			
			Mongo mongo = db.getMongo();
			
			DB mongoDb= mongo.getDB(db.getDB().getName());
			DBCollection coll = mongoDb.getCollection("Customer");

			//AggregationOutput output = coll.aggregate(firstOp, additionalOps);

		} catch (Exception e) {
			System.out.println("Erro ao buscar clientes: " + e);
			e.printStackTrace();
		}

		return clientes;
	}

	public void atualizarClienteByStatus(boolean statusAtual,
			boolean statusPosterior) {
		Customer cliente = null;

		try {
				
			Mongo mongo = db.getMongo();
			
			DB mongoDb= mongo.getDB(db.getDB().getName());
			DBCollection coll = mongoDb.getCollection("Customer");
			
			/*
			coll.findAndModify(
					new BasicDBObject("active",statusAtual), 
					null, 
					null,
					false, 
					new BasicDBObject("$set", new BasicDBObject("active",statusPosterior)),
							true, 
							true);*/
			coll.update(
					new BasicDBObject("active",statusAtual), 
					new BasicDBObject("$set", new BasicDBObject("active",statusPosterior)),
							true, 
							true);

		} catch (Exception e) {
			System.out.println("Erro ao buscar cliente: " + e);
			e.printStackTrace();
		}
		
	}

	public void removeClienteByEmail(String email) {
		Mongo mongo = db.getMongo();
		
		db.delete(db.find(Customer.class).filter("email",email));
		/*
		DB mongoDb= mongo.getDB(db.getDB().getName());
		DBCollection coll = mongoDb.getCollection("Customer");
		
		coll.findAndRemove(new BasicDBObject("email",email));*/
		
	}
}
