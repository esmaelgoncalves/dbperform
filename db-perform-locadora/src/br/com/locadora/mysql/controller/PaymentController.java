package br.com.locadora.mysql.controller;

import java.util.Date;
import java.util.List;

import br.com.locadora.mysql.dao.PaymentDAO;
import br.com.locadora.mysql.model.Payment;

public class PaymentController {

	public void novoPagemento(Payment pagamento) {
		PaymentDAO.getInstance().novoPagamento(pagamento);
	}
	
	public List<Payment> buscarPagamentosByUser(String email) {
		return PaymentDAO.getInstance().buscarPagamentosByUser(email);
	}
	
	public List<Payment> buscarPagamentosByDate(Date data) {
		return PaymentDAO.getInstance().buscarPagamentosByDate(data);
	}
	
}
