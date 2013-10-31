package br.com.locadora.mysql.controller;

import java.util.List;

import br.com.locadora.mysql.dao.AddressDAO;
import br.com.locadora.mysql.model.Address;

public class AddressController {
	
	public void novoEndereco(Address endereco) {
		AddressDAO.getInstance().novoEndereco(endereco);
	}
	
	public List<Address> buscarEnderecoByPostalCode(String codigoPostal) {
		return AddressDAO.getInstance().buscarEnderecoByPostalCode(codigoPostal);
	}
}
