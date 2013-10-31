package br.com.locadora.mongodb.dao;

import java.util.List;

import br.com.locadora.factory.ConnectionFactoryMongoDb;
import br.com.locadora.mongodb.model.Staff;

import com.google.code.morphia.AdvancedDatastore;
import com.google.code.morphia.query.Query;

public class StaffDAO extends ConnectionFactoryMongoDb {
	private static StaffDAO instance;
	private static AdvancedDatastore db;

	public static StaffDAO getInstance() {
		if (instance == null) {
			instance = new StaffDAO();
		}if (db == null) {
			db = criarConexao();
		}
		return instance;
	}

	public void novoFuncionario(Staff funcionario) {
		try {
			db.save(funcionario);
		} catch (Exception e) {
			System.out.println("Erro ao adicionar novo funcionario: " + e);
			e.printStackTrace();
		}
	}

	public List<Staff> buscarTodosFuncionarios() {
		List<Staff> funcionarios = null;

		try {
			Query <Staff> q = db.find(Staff.class);

			funcionarios = q.asList();
		} catch (Exception e) {
			System.out.println("Erro ao buscar todss os funcionarios: " + e);
			e.printStackTrace();
		}

		return funcionarios;
	}

	public List<Staff> buscarFuncionarioByStatus(boolean status) {
		List<Staff> funcionarios = null;

		try {
			Query <Staff> q = db.find(Staff.class).field("active").equal(status);

			funcionarios = q.asList();
		} catch (Exception e) {
			System.out.println("Erro ao buscar funcionarios: " + e);
			e.printStackTrace();
		}

		return funcionarios;
	}

	public List<Staff> buscarFuncionariosByStore(String loja) {
		List<Staff> funcionarios = null;

		try {
			Query <Staff> q = db.find(Staff.class).field("storeId").equal(loja);

			funcionarios = q.asList();

		} catch (Exception e) {
			System.out.println("Erro ao buscar funcionarios: " + e);
			e.printStackTrace();
		}
		return funcionarios;
	}
	
	public Staff buscarFuncionarioByEmail(String email) {
		Staff funcionario = null;

		try {
			Query <Staff> q = db.find(Staff.class).field("email").equal(email);

			funcionario = q.get();

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
	public Staff buscarFuncionarioById(int id) {
		Staff funcionario = null;

		try {
			Query <Staff> q = db.find(Staff.class).field("_id").equal(id);

			funcionario = q.get();

		} catch (Exception e) {
			System.out.println("Erro ao buscar funcionario: " + e);
			e.printStackTrace();
		}
		return funcionario;

	}
}
