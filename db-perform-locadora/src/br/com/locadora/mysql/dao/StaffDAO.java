package br.com.locadora.mysql.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.locadora.factory.ConnectionFactoryMySql;
import br.com.locadora.mysql.model.Staff;

public class StaffDAO extends ConnectionFactoryMySql {
	private static StaffDAO instance;
	private static EntityManager em;

	public static StaffDAO getInstance() {
		if (instance == null) {
			instance = new StaffDAO();
		}
		return instance;
	}

	public void novoFuncionario(Staff funcionario) {
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.merge(funcionario);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro ao adicionar novo funcionario: " + e);
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Staff> buscarTodosFuncionarios() {
		List<Staff> funcionarios = null;

		try {
			em = getEntityManager();

			Query q = em.createQuery("select f from Staff as f");

			funcionarios = q.getResultList();
		} catch (Exception e) {
			System.out.println("Erro ao buscar todss os funcionarios: " + e);
			e.printStackTrace();
		}

		return funcionarios;
	}

	@SuppressWarnings("unchecked")
	public List<Staff> buscarFuncionarioByStatus(boolean status) {
		List<Staff> funcionarios = null;

		try {
			em = getEntityManager();

			Query q = em
					.createQuery("select f from Staff as f where f.active = :status");
			q.setParameter("status", status);

			funcionarios = q.getResultList();
		} catch (Exception e) {
			System.out.println("Erro ao buscar funcionarios: " + e);
			e.printStackTrace();
		}

		return funcionarios;
	}

	@SuppressWarnings("unchecked")
	public List<Staff> buscarFuncionariosByStore(String loja) {
		List<Staff> funcionarios = null;

		try {
			em = getEntityManager();
			Query q = em
					.createQuery("select f from Staff f where f.storeId = :store");
			q.setParameter("store", loja);
			funcionarios = q.getResultList();

		} catch (Exception e) {
			System.out.println("Erro ao buscar funcionarios: " + e);
			e.printStackTrace();
		}
		return funcionarios;
	}
	
	public Staff buscarFuncionarioByEmail(String email) {
		Staff funcionario = null;

		try {
			em = getEntityManager();
			Query q = em.createQuery("select f from Staff f where f.email = :email");
			q.setParameter("email", email);
			funcionario = (Staff) q.getResultList().get(0);

		} catch (Exception e) {
			System.out.println("Erro ao buscar funcionario: " + e);
			e.printStackTrace();
		}
		return funcionario;
	}

	/**
	 * @param string
	 * @return
	 */
	public Staff buscarFuncionarioById(short id) {
		Staff funcionario = null;

		try {
			em = getEntityManager();
			Query q = em.createQuery("select f from Staff f where f.staffId = :id");
			q.setParameter("id", id);
			funcionario = (Staff) q.getResultList().get(0);

		} catch (Exception e) {
			System.out.println("Erro ao buscar funcionario: " + e);
			e.printStackTrace();
		}
		return funcionario;

	}
}
