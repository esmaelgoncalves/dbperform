package br.com.locadora.mysql.controller;

import java.util.Date;
import java.util.List;

import br.com.locadora.mysql.dao.RentalDAO;
import br.com.locadora.mysql.model.Rental;

public class RentalController {

	public void novaLocacao(Rental locacao) {
		RentalDAO.getInstance().novaLocacao(locacao);
	}

	public List<Rental> buscarLocacaoByUser(String email) {
		return RentalDAO.getInstance().buscarLocacaoByUser(email);
	}

	public List<Rental> buscarLocacoesByDate(Date data) {
		return RentalDAO.getInstance().buscarLocacoesByDate(data);
	}
	
	public List<Rental> buscarLocacoesByReturnDate(Date data) {
		return RentalDAO.getInstance().buscarLocacoesByReturnDate(data);
	}

}
