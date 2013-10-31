package br.com.locadora.mongodb.controller;

import java.util.List;

import br.com.locadora.mongodb.dao.StaffDAO;
import br.com.locadora.mongodb.model.Staff;

public class StaffController {

	public void novoFuncionario(Staff funcionario) {
		StaffDAO.getInstance().novoFuncionario(funcionario);
	}

	public List<Staff> buscarTodosFuncionarios() {
		return StaffDAO.getInstance().buscarTodosFuncionarios();
	}

	public List<Staff> buscarFuncionarioByStatus(boolean status) {
		return StaffDAO.getInstance().buscarFuncionarioByStatus(status);
	}

	public List<Staff> buscarFuncionariosByStore(String loja) {
		return StaffDAO.getInstance().buscarFuncionariosByStore(loja);
	}
	
	public Staff buscarFuncionarioByEmail(String email) {
		return StaffDAO.getInstance().buscarFuncionarioByEmail(email);
	}
}
