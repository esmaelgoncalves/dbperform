package br.com.locadora.mongodb.dao;

import br.com.locadora.factory.ConnectionFactoryMongoDb;
import br.com.locadora.mongodb.model.Address;

import com.google.code.morphia.AdvancedDatastore;
import com.google.code.morphia.query.Query;

public class AddressDAO extends ConnectionFactoryMongoDb {
	private static AddressDAO instance;
	private static AdvancedDatastore db;

	public static AddressDAO getInstance() {
		if (instance == null) {
			instance = new AddressDAO();
		}if (db == null) {
			db = criarConexao();
		}
		return instance;
	}
	
	public void novoEndereco(Address endereco) {
		try {
			db.save(endereco);
		} catch (Exception e) {
			System.out.println("Erro ao adicionar novo endereco: " + e);
			e.printStackTrace();
		}
	}
	
	public Address buscarEnderecoByPostalCode(String codigoPostal) {
		Address endereco = null;

		try {
			Query<Address> q = db.find(Address.class).filter("postalCode =", codigoPostal);
			endereco = (Address)q.get();
		} catch (Exception e) {
			System.out.println("Erro ao buscar enderecos: " + e);
			e.printStackTrace();
		}

		return endereco;
	}
	
	public Address buscarEnderecoById(int id) {
		Address endereco = null;

		try {
			Query<Address> q = db.find(Address.class).filter("_id =", id);
			endereco = (Address)q.get();
		} catch (Exception e) {
			System.out.println("Erro ao buscar endereco: " + e);
			e.printStackTrace();
		}

		return endereco;
	}
}
