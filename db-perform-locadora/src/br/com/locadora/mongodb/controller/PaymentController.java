package br.com.locadora.mongodb.controller;

import java.util.List;

import br.com.locadora.mongodb.dao.PaymentDAO;
import br.com.locadora.mongodb.model.Payment;

public class PaymentController {

	public void novoPagemento(Payment pagamento) {
		PaymentDAO.getInstance().novoPagamento(pagamento);
	}
	
	public List<Payment> buscarPagamentosByUser(String email) {
		return PaymentDAO.getInstance().buscarPagamentosByUser(email);
	}
	
	
}
