/**
 * 
 */
package br.com.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.joda.time.DateTime;

import br.com.locadora.mongodb.dao.ActorDAO;
import br.com.locadora.mongodb.dao.AddressDAO;
import br.com.locadora.mongodb.dao.CityDAO;
import br.com.locadora.mongodb.dao.CountryDAO;
import br.com.locadora.mongodb.dao.CustomerDAO;
import br.com.locadora.mongodb.dao.FilmDAO;
import br.com.locadora.mongodb.dao.InventoryDAO;
import br.com.locadora.mongodb.dao.LanguageDAO;
import br.com.locadora.mongodb.dao.RentalDAO;
import br.com.locadora.mongodb.dao.StaffDAO;
import br.com.locadora.mongodb.dao.StoreDAO;
import br.com.locadora.mongodb.model.Actor;
import br.com.locadora.mongodb.model.Address;
import br.com.locadora.mongodb.model.Category;
import br.com.locadora.mongodb.model.City;
import br.com.locadora.mongodb.model.Country;
import br.com.locadora.mongodb.model.Customer;
import br.com.locadora.mongodb.model.Film;
import br.com.locadora.mongodb.model.Inventory;
import br.com.locadora.mongodb.model.Language;
import br.com.locadora.mongodb.model.Payment;
import br.com.locadora.mongodb.model.Rental;
import br.com.locadora.mongodb.model.Staff;
import br.com.locadora.mongodb.model.Store;

/**
 * @author ESMAEL
 * 
 */
public class LoadHelperMongoDB {

	/**
	 * Carrega uma lista de "Atores" a partir do arquivo "actors.csv"
	 * 
	 * @return List
	 */
	public static List<Actor> carregarAtores() {
		List<Actor> atores = new ArrayList<Actor>();
		Actor ator;
		File entrada = new File("actors.csv");
		Scanner leitor = null;
		String[] actorAux = null;

		try {
			leitor = new Scanner(entrada);

			while (leitor.hasNextLine()) {
				String stringAux = (String) leitor.nextLine();
				actorAux = stringAux.split(";");

				ator = new Actor();

				ator.setActorId(Integer.parseInt(actorAux[0]));
				ator.setFirstName(actorAux[1]);
				ator.setLastName(actorAux[2]);

				atores.add(ator);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		leitor.close();
		return atores;

	}

	/**
	 * Carrega uma lista de "Address" a partir do arquivo "address.csv"
	 * 
	 * @return List
	 */
	public static List<Address> carregarEnderecos() {
		List<Address> enderecos = new ArrayList<Address>();

		File entrada = new File("address.csv");
		Scanner leitor = null;
		String[] addressAux = null;

		try {
			leitor = new Scanner(entrada);

			while (leitor.hasNextLine()) {
				Address address = new Address();
				String aux = (String) leitor.nextLine();
				addressAux = aux.split(";");

				address.setAddressId(Integer.parseInt(addressAux[0]));
				address.setAddress(addressAux[1]);
				address.setCityId(CityDAO.getInstance().buscarCidadeById((short) Integer.parseInt(addressAux[2])));
				address.setPostalCode(addressAux[3]);

				enderecos.add(address);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		leitor.close();
		return enderecos;
	}

	/**
	 * Carrega uma lista de "Categorias" a partir do arquivo "category.csv"
	 * 
	 * @return List
	 */
	public static List<Category> carregarCategorias() {
		List<Category> categorias = new ArrayList<Category>();

		File entrada = new File("category.csv");
		Scanner leitor = null;
		String[] catAux = null;

		try {
			leitor = new Scanner(entrada);

			while (leitor.hasNextLine()) {
				Category category = new Category();
				String aux = (String) leitor.nextLine();
				catAux = aux.split(";");

				category.setCategoryId(Integer.parseInt(catAux[0]));
				category.setName(catAux[1]);

				categorias.add(category);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		leitor.close();
		return categorias;
	}

	/**
	 * * Carrega uma lista de "cidades" a partir do arquivo "city.csv"
	 * 
	 * @return List
	 */
	public static List<City> carregarCidades() {
		List<City> cidades = new ArrayList<City>();

		File entrada = new File("city.csv");
		Scanner leitor = null;
		String[] cityAux = null;

		try {
			leitor = new Scanner(entrada);

			while (leitor.hasNextLine()) {
				City cidade = new City();
				String aux = (String) leitor.nextLine();
				cityAux = aux.split(";");

				cidade.setCityId(Integer.parseInt(cityAux[0]));
				cidade.setCity(cityAux[1]);
				cidade.setCountryId(CountryDAO.getInstance().buscarPaisById(Integer.parseInt(cityAux[2])));

				cidades.add(cidade);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		leitor.close();
		return cidades;
	}

	/**
	 * * Carrega uma lista de "paises" a partir do arquivo "country.csv"
	 * 
	 * @return List
	 */
	public static List<Country> carregarPaises() {
		List<Country> paises = new ArrayList<Country>();

		File entrada = new File("country.csv");
		Scanner leitor = null;
		String[] paisAux = null;

		try {
			leitor = new Scanner(entrada);

			while (leitor.hasNextLine()) {
				Country pais = new Country();
				String aux = (String) leitor.nextLine();
				paisAux = aux.split(";");

				pais.setCountryId(Integer.parseInt(paisAux[0]));
				pais.setCountry(paisAux[1]);

				paises.add(pais);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		leitor.close();
		return paises;
	}
	
	/**
	 * * Carrega uma lista de "clientes" a partir do arquivo "customer.csv"
	 * 
	 * @return List
	 */
	public static List<Customer> carregarClientes() {
		List<Customer> clientes = new ArrayList<Customer>();

		File entrada = new File("customer.csv");
		Scanner leitor = null;
		String[] cliAux = null;
		
		try {
			leitor = new Scanner(entrada);

			while (leitor.hasNextLine()) {
				Customer cliente = new Customer();
				String aux = (String) leitor.nextLine();
				cliAux = aux.split(";");

				cliente.setCustomerId(Integer.parseInt(cliAux[0]));
				cliente.setFirstName(cliAux[1]);
				cliente.setLastName(cliAux[2]);
				cliente.setEmail(cliAux[3]);
				
				if(cliAux[4].toString().equals("1"))
					cliente.setActive(true);
				else
					cliente.setActive(false);
				
				cliente.setAddressId(AddressDAO.getInstance().buscarEnderecoById(Integer.parseInt(cliAux[5])));
				cliente.setStoreId(StoreDAO.getInstance().buscarLojaById(Integer.parseInt(cliAux[6])));
				

				clientes.add(cliente);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		leitor.close();
		return clientes;
	}
	
	
	/**
	 * * Carrega uma lista de "filmes" a partir do arquivo "film.csv"
	 * 
	 * @return List
	 */
	public static List<Film> carregarFilmes() {
		List<Film> filmes = new ArrayList<Film>();
		List<Actor> atores = ActorDAO.getInstance().buscarTodosAtores();
		List<Actor> auxAtores;
		List<Category> categorias = carregarCategorias();
		File entrada = new File("film.csv");
		Scanner leitor = null;
		String[] filmAux = null;
		Random random = new Random();
		

		try {
			leitor = new Scanner(entrada);

			while (leitor.hasNextLine()) {
				Film filme = new Film();
				String aux = (String) leitor.nextLine();
				filmAux = aux.split(";");

				filme.setFilmId(Integer.parseInt(filmAux[0]));
				filme.setTitle(filmAux[1]);
				filme.setDescription(filmAux[2]);
				filme.setLength(Integer.parseInt(filmAux[3]));
				filme.setLanguageId(LanguageDAO.getInstance().buscarIdiomaById(Integer.parseInt(filmAux[4])));
				filme.setRating(filmAux[6]);				
				filme.setReleaseYear(filmAux[7]);
				filme.setRentalDuration(Integer.parseInt((filmAux[8])));
				filme.setRentalRate(BigDecimal.valueOf(Double.parseDouble((filmAux[9]))));
				filme.setReplacementCost(BigDecimal.valueOf(Double.parseDouble((filmAux[10]))));
				filme.setSpecialFeatures(filmAux[11]);
				
				filme.setFilmCategory(categorias.get(random.nextInt(categorias.size())));
				
				auxAtores = new ArrayList<Actor>();
				
				for(int x=0; x < 10; x++){
					auxAtores.add(atores.get(random.nextInt(atores.size())));
				}
				
				filme.setFilmActorList(auxAtores);
				filmes.add(filme);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		leitor.close();
		return filmes;
	}
	
	/**
	 * * Carrega uma lista de "inventario" a partir do arquivo "inventory.csv"
	 * 
	 * @return List
	 */
	public static List<Inventory> carregarInventarios() {
		List<Inventory> inventarios = new ArrayList<Inventory>();

		File entrada = new File("inventory.csv");
		Scanner leitor = null;
		String[] invAux = null;
		
		try {
			leitor = new Scanner(entrada);

			while (leitor.hasNextLine()) {
				Inventory inventario = new Inventory();
				String aux = (String) leitor.nextLine();
				invAux = aux.split(";");

				inventario.setInventoryId(Integer.parseInt(invAux[0]));
				inventario.setFilmId(FilmDAO.getInstance().buscarFilmeById(Integer.parseInt(invAux[1])));
				inventario.setStoreId(StoreDAO.getInstance().buscarLojaById(Integer.parseInt(invAux[2])));

				inventarios.add(inventario);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		leitor.close();
		return inventarios;
	}
	
	/**
	 * * Carrega uma lista de "idiomas" a partir do arquivo "language.csv"
	 * 
	 * @return List
	 */
	public static List<Language> carregarIdiomas() {
		List<Language> idiomas = new ArrayList<Language>();

		File entrada = new File("language.csv");
		Scanner leitor = null;
		String[] idiomaAux = null;
		
		try {
			leitor = new Scanner(entrada);

			while (leitor.hasNextLine()) {
				Language idioma = new Language();
				String aux = (String) leitor.nextLine();
				idiomaAux = aux.split(";");

				idioma.setLanguageId(Integer.parseInt(idiomaAux[0]));
				idioma.setName(idiomaAux[1]);

				idiomas.add(idioma);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		leitor.close();
		return idiomas;
	}
	
	/**
	 * * Carrega uma lista de "pagamentos" a partir do arquivo "payment.csv"
	 * 
	 * @return List
	 */
	public static List<Payment> carregarPagamentos() {
		List<Payment> pagamentos = new ArrayList<Payment>();

		File entrada = new File("payment.csv");
		Scanner leitor = null;
		String[] pgtoAux = null;
		
		try {
			leitor = new Scanner(entrada);

			while (leitor.hasNextLine()) {
				Payment pagamento = new Payment();
				String aux = (String) leitor.nextLine();
				pgtoAux = aux.split(";");

				pagamento.setPaymentId(Integer.parseInt(pgtoAux[0]));
				pagamento.setPaymentDate(new Date());
				pagamento.setRentalId(RentalDAO.getInstance().buscarLocacaoById(Integer.parseInt(pgtoAux[2])));
				pagamento.setAmount(BigDecimal.valueOf(Double.parseDouble(pgtoAux[3])));
				pagamento.setCustomerId(CustomerDAO.getInstance().buscarClienteById(Integer.parseInt(pgtoAux[4])));
				
				pagamento.setStaffId(StaffDAO.getInstance().buscarFuncionarioById(Integer.parseInt(pgtoAux[5])));
				
				pagamentos.add(pagamento);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		leitor.close();
		return pagamentos;
	}
	
	/**
	 * * Carrega uma lista de "alugueis" a partir do arquivo "rental.csv"
	 * 
	 * @return List
	 */
	public static List<Rental> carregarLocacoes() {
		List<Rental> alugueis = new ArrayList<Rental>();

		File entrada = new File("rental.csv");
		Scanner leitor = null;
		String[] rentAux = null;
		
		try {
			leitor = new Scanner(entrada);

			while (leitor.hasNextLine()) {
				Rental aluguel = new Rental();
				String aux = (String) leitor.nextLine();
				rentAux = aux.split(";");

				aluguel.setRentalId(Integer.parseInt(rentAux[0]));
				aluguel.setRentalDate(new DateTime(System.currentTimeMillis()).toString());
				aluguel.setReturnDate(new DateTime(System.currentTimeMillis()+1000000L).toString());
				aluguel.setCustomerId(CustomerDAO.getInstance().buscarClienteById((short) Integer.parseInt(rentAux[3])));
				aluguel.setInventoryId(InventoryDAO.getInstance().buscarInventarioById(Integer.parseInt(rentAux[4])));
				aluguel.setStaffId(StaffDAO.getInstance().buscarFuncionarioById((short) Integer.parseInt(rentAux[5])));
				
				alugueis.add(aluguel);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		leitor.close();
		return alugueis;
	}
	
	/**
	 * * Carrega uma lista de "funcionarios" a partir do arquivo "staff.csv"
	 * 
	 * @return List
	 */
	public static List<Staff> carregarFuncionarios() {
		List<Staff> funcionarios = new ArrayList<Staff>();

		File entrada = new File("staff.csv");
		Scanner leitor = null;
		String[] staffAux = null;
		
		try {
			leitor = new Scanner(entrada);

			while (leitor.hasNextLine()) {
				Staff funcionario = new Staff();
				String aux = (String) leitor.nextLine();
				staffAux = aux.split(";");

				funcionario.setStaffId(Integer.parseInt(staffAux[0]));
				funcionario.setFirstName(staffAux[1]);
				funcionario.setLastName(staffAux[2]);
				if(staffAux[3].toString().equals("1"))
					funcionario.setActive(true);
				else
					funcionario.setActive(false);
				
				funcionario.setAddressId(AddressDAO.getInstance().buscarEnderecoById(Integer.parseInt(staffAux[4])));
				funcionario.setEmail(staffAux[5]);
				funcionario.setUsername(staffAux[6]);
				funcionario.setPassword(staffAux[7]);
				funcionario.setStoreId(StoreDAO.getInstance().buscarLojaById(Integer.parseInt(staffAux[8])));
				
				funcionarios.add(funcionario);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		leitor.close();
		return funcionarios;
	}
	
	/**
	 * * Carrega uma lista de "lojas" a partir do arquivo "store.csv"
	 * 
	 * @return List
	 */
	public static List<Store> carregarLojas() {
		List<Store> lojas = new ArrayList<Store>();

		File entrada = new File("store.csv");
		Scanner leitor = null;
		String[] lojasAux = null;
		
		try {
			leitor = new Scanner(entrada);

			while (leitor.hasNextLine()) {
				Store loja = new Store();
				String aux = (String) leitor.nextLine();
				lojasAux = aux.split(";");

				loja.setStoreId(Integer.parseInt(lojasAux[0]));
				loja.setAddressId(AddressDAO.getInstance().buscarEnderecoById(Integer.parseInt(lojasAux[2])));

				lojas.add(loja);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		leitor.close();
		return lojas;
	}

}
