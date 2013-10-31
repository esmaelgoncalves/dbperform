package br.com.locadora.mysql.controller;

import java.util.List;

import br.com.locadora.mysql.dao.CustomerDAO;
import br.com.locadora.mysql.model.Customer;

public class CustomerController {

	public void novoCliente(Customer cliente) {
		CustomerDAO.getInstance().novoCliente(cliente);
	}

	public List<Customer> buscarTodosClientes() {
		return CustomerDAO.getInstance().buscarTodosClientes();
	}

	public List<Customer> buscarClienteByStatus(boolean status) {
		return CustomerDAO.getInstance().buscarClienteByStatus(status);
	}

	public List<Customer> buscarClienteByStore(short loja) {
		return CustomerDAO.getInstance().buscarClienteByStore(loja);
	}
	
	public Customer buscarClienteByEmail(String email) {
		return CustomerDAO.getInstance().buscarClienteByEmail(email);
	}
	
	public List<Customer> buscarClienteByTotalPayment(double valor) {
		return CustomerDAO.getInstance().buscarClienteByTotalPayment(valor);
	}

	public void atualizarClienteByStatus(boolean statusAtual, boolean statusPosterior) {
		CustomerDAO.getInstance().atualizarClienteByStatus(statusAtual, statusPosterior);	
	}

	public void removeClienteByEmail(String email) {
		CustomerDAO.getInstance().excluiClienteByEmail(email);
	}
}
