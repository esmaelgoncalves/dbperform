package br.com.locadora.mongodb.controller;

import java.util.List;

import br.com.locadora.mongodb.dao.RentalDAO;
import br.com.locadora.mongodb.model.Rental;

public class RentalController {

	public void novaLocacao(Rental locacao) {
		RentalDAO.getInstance().novaLocacao(locacao);
	}

	public List<Rental> buscarLocacaoByUser(String email) {
		return RentalDAO.getInstance().buscarLocacaoByUser(email);
	}


}
