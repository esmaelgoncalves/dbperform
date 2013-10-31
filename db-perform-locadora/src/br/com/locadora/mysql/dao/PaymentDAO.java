package br.com.locadora.mysql.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.locadora.factory.ConnectionFactoryMySql;
import br.com.locadora.mysql.model.Payment;

public class PaymentDAO extends ConnectionFactoryMySql{
	private static PaymentDAO instance;
	private static EntityManager em;

	public static PaymentDAO getInstance() {
		if (instance == null) {
			instance = new PaymentDAO();
		}
		return instance;
	}

	public void novoPagamento(Payment pagamento) {
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.merge(pagamento);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro ao adicionar novo pagamento: " + e);
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Payment> buscarPagamentosByUser(String email) {
		List<Payment> pagamentos = null;

		try {
			em = getEntityManager();

			Query q = em
					.createQuery("select p from Payment as p where p.customerId = (Select c from Customer as c where c.email = :email)");
			q.setParameter("email", email);

			pagamentos = q.getResultList();
		} catch (Exception e) {
			System.out.println("Erro ao buscar pagementos: " + e);
			e.printStackTrace();
		}

		return pagamentos;
	}
	
	@SuppressWarnings("unchecked")
	public List<Payment> buscarPagamentosByDate(Date data) {
		List<Payment> pagamentos = null;

		try {
			em = getEntityManager();

			Query q = em
					.createQuery("select p from Payment as p where p.paymentDate = :date");
			q.setParameter("date", data);

			pagamentos =  q.getResultList();
		} catch (Exception e) {
			System.out.println("Erro ao buscar pagamentos: " + e);
			e.printStackTrace();
		}

		return pagamentos;
	}
	
}
