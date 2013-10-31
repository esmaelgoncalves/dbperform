package br.com.locadora.mongodb.dao;

import java.util.List;

import br.com.locadora.factory.ConnectionFactoryMongoDb;
import br.com.locadora.mongodb.model.Customer;
import br.com.locadora.mongodb.model.Payment;

import com.google.code.morphia.AdvancedDatastore;
import com.google.code.morphia.query.Query;

public class PaymentDAO extends ConnectionFactoryMongoDb{
	private static PaymentDAO instance;
	private static AdvancedDatastore db;

	public static PaymentDAO getInstance() {
		if (instance == null) {
			instance = new PaymentDAO();
		}if (db == null) {
			db = criarConexao();
		}
		return instance;
	}

	public void novoPagamento(Payment pagamento) {
		try {
			db.save(pagamento);
		} catch (Exception e) {
			System.out.println("Erro ao adicionar novo pagamento: " + e);
			e.printStackTrace();
		}
	}
	
	public List<Payment> buscarPagamentosByUser(String email) {
		List<Payment> pagamentos = null;
		Customer cliente;

		try {
			Query <Customer> q = db.find(Customer.class).filter("email =", email);
			cliente = (Customer) q.get();
			
			Query <Payment> q2 = db.find(Payment.class).filter("Customer =", cliente);
			pagamentos = q2.asList();
			
		} catch (Exception e) {
			System.out.println("Erro ao buscar pagementos: " + e);
			e.printStackTrace();
		}

		return pagamentos;
	}
	

	
}
