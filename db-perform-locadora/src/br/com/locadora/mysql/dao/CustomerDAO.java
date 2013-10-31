package br.com.locadora.mysql.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.locadora.factory.ConnectionFactoryMySql;
import br.com.locadora.mysql.model.Customer;

public class CustomerDAO extends ConnectionFactoryMySql {
	private static CustomerDAO instance;
	private static EntityManager em;

	public static CustomerDAO getInstance() {
		if (instance == null) {
			instance = new CustomerDAO();
		}
		return instance;
	}

	public void novoCliente(Customer cliente) {
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.merge(cliente);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro ao adicionar novo cliente: " + e);
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Customer> buscarTodosClientes() {
		List<Customer> clientes = null;

		try {
			em = getEntityManager();

			Query q = em.createQuery("select c from Customer as c");

			clientes = q.getResultList();
		} catch (Exception e) {
			System.out.println("Erro ao buscar todss os clientes: " + e);
			e.printStackTrace();
		}

		return clientes;
	}

	@SuppressWarnings("unchecked")
	public List<Customer> buscarClienteByStatus(boolean status) {
		List<Customer> clientes = null;

		try {
			em = getEntityManager();

			Query q = em
					.createQuery("select c from Customer as c where c.active = :status");
			q.setParameter("status", status);

			clientes = q.getResultList();
		} catch (Exception e) {
			System.out.println("Erro ao buscar clientes: " + e);
			e.printStackTrace();
		}

		return clientes;
	}

	@SuppressWarnings("unchecked")
	public List<Customer> buscarClienteByStore(short loja) {
		List<Customer> clientes = null;

		try {
			em = getEntityManager();

			Query q = em
					.createQuery("select c from Customer c where storeId_storeId = :store");
			q.setParameter("store", loja);
			clientes = q.getResultList();

		} catch (Exception e) {
			System.out.println("Erro ao buscar clientes: " + e);
			e.printStackTrace();
		}
		return clientes;
	}

	public Customer buscarClienteByEmail(String email) {
		Customer cliente = null;

		try {
			em = getEntityManager();

			Query q = em
					.createQuery("select c from Customer c where c.email = :email");
			q.setParameter("email", email);
			cliente = (Customer) q.getResultList().get(0);

		} catch (Exception e) {
			System.out.println("Erro ao buscar cliente: " + e);
			e.printStackTrace();
		}
		return cliente;
	}

	public Customer buscarClienteById(short id) {
		Customer cliente = null;

		try {
			em = getEntityManager();

			Query q = em
					.createQuery("select c from Customer c where c.customerId = :id");
			q.setParameter("id", id);
			cliente = (Customer) q.getResultList().get(0);

		} catch (Exception e) {
			System.out.println("Erro ao buscar cliente: " + e);
			e.printStackTrace();
		}
		return cliente;
	}

	@SuppressWarnings("unchecked")
	public List <Customer> buscarClienteByTotalPayment(double valor) {
		List <Customer> clientes = null;

		try {
			em = getEntityManager();

			Query q = em
					.createQuery("select c from Customer as c where c.customerId in (select p.customerId from Payment as p group by p.customerId having sum(p.amount) > :valor)");
			q.setParameter("valor", BigDecimal.valueOf(valor));

			clientes = (q.getResultList());
		} catch (Exception e) {
			System.out.println("Erro ao buscar clientes: " + e);
			e.printStackTrace();
		}

		return clientes;
	}

	public void atualizarClienteByStatus(boolean statusAtual,
			boolean statusPosterior) {
		try {
			em = getEntityManager();
			
			em = getEntityManager();
			em.getTransaction().begin();

			Query q = em
					.createQuery("update Customer c set c.active = :statusPosterior where c.active = :statusAtual");
			
			q.setParameter("statusAtual",statusAtual);
			q.setParameter("statusPosterior",statusPosterior);
			
			q.executeUpdate();
			
			em.flush();
			em.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("Erro ao buscar clientes: " + e);
			e.printStackTrace();
		}

	}

	public void excluiClienteByEmail(String email) {
		try {
			em = getEntityManager();
			
			em = getEntityManager();
			em.getTransaction().begin();

			Query q = em
					.createQuery("delete Customer c from Customer where c.email = :email");
			
			q.setParameter("email",email);			
			q.executeUpdate();
			
			em.flush();
			em.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("Erro ao buscar clientes: " + e);
			e.printStackTrace();
		}
		
	}
}
