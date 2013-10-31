package br.com.locadora.mysql.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.locadora.factory.ConnectionFactoryMySql;
import br.com.locadora.mysql.model.Rental;

public class RentalDAO extends ConnectionFactoryMySql {
	private static RentalDAO instance;
	private static EntityManager em;

	public static RentalDAO getInstance() {
		if (instance == null) {
			instance = new RentalDAO();
		}
		return instance;
	}

	public void novaLocacao(Rental locacao) {
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.merge(locacao);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro ao adicionar novo pagamento: " + e);
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Rental> buscarLocacaoByUser(String email) {
		List<Rental> locacoes = null;

		try {
			em = getEntityManager();

			Query q = em
					.createQuery("select l from Rental as l where l.customerId = (Select c from Customer as c where c.email = :email)");
			q.setParameter("email", email);

			locacoes = q.getResultList();
		} catch (Exception e) {
			System.out.println("Erro ao buscar locacoes: " + e);
			e.printStackTrace();
		}

		return locacoes;
	}

	@SuppressWarnings("unchecked")
	public List<Rental> buscarLocacoesByDate(Date data) {
		List<Rental> locacoes = null;

		try {
			em = getEntityManager();

			Query q = em
					.createQuery("select l from Rental as l where l.rentalDate = :date");
			q.setParameter("date", data);

			locacoes = q.getResultList();
		} catch (Exception e) {
			System.out.println("Erro ao buscar locacoes: " + e);
			e.printStackTrace();
		}

		return locacoes;
	}
	
	@SuppressWarnings("unchecked")
	public List<Rental> buscarLocacoesByReturnDate(Date data) {
		List<Rental> locacoes = null;

		try {
			em = getEntityManager();

			Query q = em
					.createQuery("select l from Rental as l where l.returnDate = :date");
			q.setParameter("date", data);

			locacoes = q.getResultList();
		} catch (Exception e) {
			System.out.println("Erro ao buscar locacoes: " + e);
			e.printStackTrace();
		}

		return locacoes;
	}
	
	public Rental buscarLocacaoById(int id) {
		Rental locacao = null;

		try {
			em = getEntityManager();

			Query q = em
					.createQuery("select l from Rental as l where l.rentalId = :id");
			q.setParameter("id", id);

			locacao = (Rental) q.getResultList().get(0);
		} catch (Exception e) {
			System.out.println("Erro ao buscar loccacao: " + e);
			e.printStackTrace();
		}

		return locacao;
	}

}
