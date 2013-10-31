package br.com.locadora.mongodb.dao;

import java.util.List;

import br.com.locadora.factory.ConnectionFactoryMongoDb;
import br.com.locadora.mongodb.model.Customer;
import br.com.locadora.mongodb.model.Rental;

import com.google.code.morphia.AdvancedDatastore;
import com.google.code.morphia.query.Query;

public class RentalDAO extends ConnectionFactoryMongoDb {
	private static RentalDAO instance;
	private static AdvancedDatastore db;

	public static RentalDAO getInstance() {
		if (instance == null) {
			instance = new RentalDAO();
		}if (db == null) {
			db = criarConexao();
		}
		return instance;
	}

	public void novaLocacao(Rental locacao) {
		try {
			db.save(locacao);
		} catch (Exception e) {
			System.out.println("Erro ao adicionar novo pagamento: " + e);
			e.printStackTrace();
		}
	}

	public List<Rental> buscarLocacaoByUser(String email) {
		List<Rental> locacoes = null;
		Customer cliente = null;

		try {

			Query <Customer> q = db.find(Customer.class).filter("email =", email);
			cliente = (Customer) q.get();
			
			Query <Rental> q2 = db.find(Rental.class).filter("Customer =", cliente);
			locacoes = q2.asList();
			
		} catch (Exception e) {
			System.out.println("Erro ao buscar locacoes: " + e);
			e.printStackTrace();
		}

		return locacoes;
	}

	
	public Rental buscarLocacaoById(int id) {
		Rental locacao = null;

		try {

			Query <Rental> q = db.find(Rental.class).filter("_id =", id);
			locacao = (Rental) q.get();
			
		} catch (Exception e) {
			System.out.println("Erro ao buscar loccacao: " + e);
			e.printStackTrace();
		}

		return locacao;
	}

}
