package br.com.locadora.mongodb.controller;

import br.com.locadora.mongodb.dao.AddressDAO;
import br.com.locadora.mongodb.model.Address;

public class AddressController {
	
	public void novoEndereco(Address endereco) {
		AddressDAO.getInstance().novoEndereco(endereco);
	}
	
	public Address buscarEnderecoByPostalCode(String codigoPostal) {
		return AddressDAO.getInstance().buscarEnderecoByPostalCode(codigoPostal);
	}
}
