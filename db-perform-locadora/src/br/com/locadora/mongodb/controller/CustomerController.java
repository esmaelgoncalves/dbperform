package br.com.locadora.mongodb.controller;

import java.util.List;

import br.com.locadora.mongodb.dao.CustomerDAO;
import br.com.locadora.mongodb.model.Customer;

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

	public List<Customer> buscarClienteByStore(int loja) {
		return CustomerDAO.getInstance().buscarClienteByStore(loja);
	}
	
	public Customer buscarClienteByEmail(String email) {
		return CustomerDAO.getInstance().buscarClienteByEmail(email);
	}
	
	public List<Customer> buscarClienteByTotalPayment(double valor) {
		return CustomerDAO.getInstance().buscarClienteByTotalPayment(valor);
	}

	public void removeClienteByEmail(String email) {
		CustomerDAO.getInstance().removeClienteByEmail(email);
		
	}

	public void atualizarClienteByStatus(boolean statusAtual, boolean statusPosterior) {
		CustomerDAO.getInstance().atualizarClienteByStatus(statusAtual, statusPosterior);
		
	}
}
