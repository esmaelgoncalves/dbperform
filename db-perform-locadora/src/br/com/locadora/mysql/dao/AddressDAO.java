package br.com.locadora.mysql.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.locadora.factory.ConnectionFactoryMySql;
import br.com.locadora.mysql.model.Address;

public class AddressDAO extends ConnectionFactoryMySql {
	private static AddressDAO instance;
	private static EntityManager em;

	public static AddressDAO getInstance() {
		if (instance == null) {
			instance = new AddressDAO();
		}
		return instance;
	}
	
	public void novoEndereco(Address endereco) {
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.merge(endereco);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro ao adicionar novo endereco: " + e);
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Address> buscarEnderecoByPostalCode(String codigoPostal) {
		List<Address> enderecos = null;

		try {
			em = getEntityManager();

			Query q = em.createQuery("select e from Address as e where e.postalCode = :postalCode");
			q.setParameter("postalCode", codigoPostal);

			enderecos = q.getResultList();
		} catch (Exception e) {
			System.out.println("Erro ao buscar enderecos: " + e);
			e.printStackTrace();
		}

		return enderecos;
	}
	
	public Address buscarEnderecoById(short id) {
		Address endereco = null;

		try {
			em = getEntityManager();

			Query q = em
					.createQuery("select e from Address as e where e.addressId = :address");
			q.setParameter("address", id);

			endereco = (Address) q.getResultList().get(0);
		} catch (Exception e) {
			System.out.println("Erro ao buscar endereco: " + e);
			e.printStackTrace();
		}

		return endereco;
	}
}
