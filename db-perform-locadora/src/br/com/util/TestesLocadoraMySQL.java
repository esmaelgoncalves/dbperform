package br.com.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.locadora.mysql.controller.ActorController;
import br.com.locadora.mysql.controller.AddressController;
import br.com.locadora.mysql.controller.CategoryController;
import br.com.locadora.mysql.controller.CityController;
import br.com.locadora.mysql.controller.CountryController;
import br.com.locadora.mysql.controller.CustomerController;
import br.com.locadora.mysql.controller.FilmController;
import br.com.locadora.mysql.controller.InventoryController;
import br.com.locadora.mysql.controller.LanguageController;
import br.com.locadora.mysql.controller.PaymentController;
import br.com.locadora.mysql.controller.RentalController;
import br.com.locadora.mysql.controller.StaffController;
import br.com.locadora.mysql.controller.StoreController;
import br.com.locadora.mysql.model.Actor;
import br.com.locadora.mysql.model.Address;
import br.com.locadora.mysql.model.Category;
import br.com.locadora.mysql.model.City;
import br.com.locadora.mysql.model.Country;
import br.com.locadora.mysql.model.Customer;
import br.com.locadora.mysql.model.Film;
import br.com.locadora.mysql.model.Inventory;
import br.com.locadora.mysql.model.Language;
import br.com.locadora.mysql.model.Payment;
import br.com.locadora.mysql.model.Rental;
import br.com.locadora.mysql.model.Staff;
import br.com.locadora.mysql.model.Store;


/**
 * Classe que contém todos os testes para o Modelo de Dados LOCADORA em MySQL. A
 * classe contém os seguintes métodos:
 * 
 * 
 * @author ESMAEL
 * 
 */
public class TestesLocadoraMySQL {


	public static long carregarAtores() {
		List<Actor> atores;

		// CARREGA USUARIOS
		atores = LoadHelperMySQL.carregarAtores();

		System.out
				.println("***************************************************************************");
		System.out.println("Inicio INSERT ATORES");

		// INICIA CONTAGEM DO TEMPO
		long inicio = System.currentTimeMillis();

		// INSERE OS ATORES
		for (Actor ator : atores) {

			new ActorController().novoAtor(ator);
		}

		// FINALIZA CONTAGEM DO TEMPO
		long total = System.currentTimeMillis() - inicio;

		// TEMPO TOTAL DA OPERAÇÃO
		System.out.println("Total Inserido: " + atores.size());
		System.out.println("Tempo Total INSERT ATORES: " + (total) + "/ms");
		System.out
				.println("***************************************************************************");

		return total;

	}

	public static long carregarEnderecos() {
		List<Address> enderecos;

		// CARREGA USUARIOS
		enderecos = LoadHelperMySQL.carregarEnderecos();

		System.out
				.println("***************************************************************************");
		System.out.println("Inicio INSERT ENDERECOS");

		// INICIA CONTAGEM DO TEMPO
		long inicio = System.currentTimeMillis();

		// INSERE OS ENDEREÇOS
		for (Address endereco : enderecos) {

			new AddressController().novoEndereco(endereco);
		}

		// FINALIZA CONTAGEM DO TEMPO
		long total = System.currentTimeMillis() - inicio;

		// TEMPO TOTAL DA OPERAÇÃO
		System.out.println("Total Inserido: " + enderecos.size());
		System.out.println("Tempo Total INSERT ENDERECOS: " + (total) + "/ms");
		System.out
				.println("***************************************************************************");

		return total;
	}

	public static long carregarCategorias() {
		List<Category> categorias;

		// CARREGA USUARIOS
		categorias = LoadHelperMySQL.carregarCategorias();

		System.out
				.println("***************************************************************************");
		System.out.println("Inicio INSERT CATEGORIAS");

		// INICIA CONTAGEM DO TEMPO
		long inicio = System.currentTimeMillis();

		// INSERE OS CIDADES
		for (Category categoria : categorias) {

			new CategoryController().novaCategoria(categoria);
		}

		// FINALIZA CONTAGEM DO TEMPO
		long total = System.currentTimeMillis() - inicio;

		// TEMPO TOTAL DA OPERAÇÃO
		System.out.println("Total Inserido: " + categorias.size());
		System.out.println("Tempo Total INSERT CATEGORIAS: " + (total) + "/ms");
		System.out
				.println("***************************************************************************");

		return total;
	}


	public static long carregarCidades() {
		List<City> cidades;

		// CARREGA USUARIOS
		cidades = LoadHelperMySQL.carregarCidades();

		System.out
				.println("***************************************************************************");
		System.out.println("Inicio INSERT CIDADES");

		// INICIA CONTAGEM DO TEMPO
		long inicio = System.currentTimeMillis();

		// INSERE OS CIDADES
		for (City cidade : cidades) {

			new CityController().novaCidade(cidade);
		}

		// FINALIZA CONTAGEM DO TEMPO
		long total = System.currentTimeMillis() - inicio;

		// TEMPO TOTAL DA OPERAÇÃO
		System.out.println("Total Inserido: " + cidades.size());
		System.out.println("Tempo Total INSERT CIDADES: " + (total) + "/ms");
		System.out
				.println("***************************************************************************");

		return total;
	}


	public static long carregarPaises() {
		List<Country> paises;

		// CARREGA USUARIOS
		paises = LoadHelperMySQL.carregarPaises();

		System.out
				.println("***************************************************************************");
		System.out.println("Inicio INSERT PAISES");

		// INICIA CONTAGEM DO TEMPO
		long inicio = System.currentTimeMillis();

		// INSERE OS PAISES
		for (Country pais : paises) {

			new CountryController().novoPais(pais);
		}

		// FINALIZA CONTAGEM DO TEMPO
		long total = System.currentTimeMillis() - inicio;

		// TEMPO TOTAL DA OPERAÇÃO
		System.out.println("Total Inserido: " + paises.size());
		System.out.println("Tempo Total INSERT PAISES: " + (total) + "/ms");
		System.out
				.println("***************************************************************************");

		return total;
	}
	

	public static long carregarClientes() {
		List<Customer> clientes;

		// CARREGA USUARIOS
		clientes = LoadHelperMySQL.carregarClientes();

		System.out
				.println("***************************************************************************");
		System.out.println("Inicio INSERT CLIENTES");

		// INICIA CONTAGEM DO TEMPO
		long inicio = System.currentTimeMillis();

		// INSERE OS CLIENTES
		for (Customer cliente : clientes) {

			new CustomerController().novoCliente(cliente);
		}

		// FINALIZA CONTAGEM DO TEMPO
		long total = System.currentTimeMillis() - inicio;

		// TEMPO TOTAL DA OPERAÇÃO
		System.out.println("Total Inserido: " + clientes.size());
		System.out.println("Tempo Total INSERT CLIENTES: " + (total) + "/ms");
		System.out
				.println("***************************************************************************");

		return total;
	}
	
	
	public static long carregarFilmes() {
		List<Film> filmes;

		// CARREGA USUARIOS
		filmes = LoadHelperMySQL.carregarFilmes();

		System.out
				.println("***************************************************************************");
		System.out.println("Inicio INSERT FILMES");

		// INICIA CONTAGEM DO TEMPO
		long inicio = System.currentTimeMillis();

		// INSERE OS ATORES
		for (Film filme : filmes) {

			new FilmController().novoFilme(filme);
		}

		// FINALIZA CONTAGEM DO TEMPO
		long total = System.currentTimeMillis() - inicio;

		// TEMPO TOTAL DA OPERAÇÃO
		System.out.println("Total Inserido: " + filmes.size());
		System.out.println("Tempo Total INSERT FILMES: " + (total) + "/ms");
		System.out
				.println("***************************************************************************");

		return total;
	}
	

	public static long carregarInventarios() {
		List<Inventory> inventarios;

		// CARREGA USUARIOS
		inventarios = LoadHelperMySQL.carregarInventarios();

		System.out
				.println("***************************************************************************");
		System.out.println("Inicio INSERT INVENTARIOS");

		// INICIA CONTAGEM DO TEMPO
		long inicio = System.currentTimeMillis();

		// INSERE OS ATORES
		for (Inventory inventario : inventarios) {

			new InventoryController().novoInventario(inventario);
		}

		// FINALIZA CONTAGEM DO TEMPO
		long total = System.currentTimeMillis() - inicio;

		// TEMPO TOTAL DA OPERAÇÃO
		System.out.println("Total Inserido: " + inventarios.size());
		System.out.println("Tempo Total INSERT INVENTARIOS: " + (total) + "/ms");
		System.out
				.println("***************************************************************************");

		return total;
	}
	

	public static long carregarIdiomas() {
		List<Language> idiomas;

		// CARREGA USUARIOS
		idiomas = LoadHelperMySQL.carregarIdiomas();

		System.out
				.println("***************************************************************************");
		System.out.println("Inicio INSERT IDIOMAS");

		// INICIA CONTAGEM DO TEMPO
		long inicio = System.currentTimeMillis();

		// INSERE OS ATORES
		for (Language idioma : idiomas) {

			new LanguageController().novoIdioma(idioma);
		}

		// FINALIZA CONTAGEM DO TEMPO
		long total = System.currentTimeMillis() - inicio;

		// TEMPO TOTAL DA OPERAÇÃO
		System.out.println("Total Inserido: " + idiomas.size());
		System.out.println("Tempo Total INSERT IDIOMAS: " + (total) + "/ms");
		System.out
				.println("***************************************************************************");

		return total;
	}
	

	public static long carregarPagamentos() {
		List<Payment> pagamentos;

		// CARREGA USUARIOS
		pagamentos = LoadHelperMySQL.carregarPagamentos();

		System.out
				.println("***************************************************************************");
		System.out.println("Inicio INSERT PAGAMENTOS");

		// INICIA CONTAGEM DO TEMPO
		long inicio = System.currentTimeMillis();

		// INSERE OS ATORES
		for (Payment pagamento : pagamentos) {

			new PaymentController().novoPagemento(pagamento);
		}

		// FINALIZA CONTAGEM DO TEMPO
		long total = System.currentTimeMillis() - inicio;

		// TEMPO TOTAL DA OPERAÇÃO
		System.out.println("Total Inserido: " + pagamentos.size());
		System.out.println("Tempo Total INSERT PAGAMENTOS: " + (total) + "/ms");
		System.out
				.println("***************************************************************************");

		return total;
	}
	

	public static long carregarLocacoes() {
		List<Rental> locacoes;

		// CARREGA USUARIOS
		locacoes = LoadHelperMySQL.carregarLocacoes();

		System.out
				.println("***************************************************************************");
		System.out.println("Inicio INSERT LOCACOES");

		// INICIA CONTAGEM DO TEMPO
		long inicio = System.currentTimeMillis();

		// INSERE OS ATORES
		for (Rental locacao : locacoes) {

			new RentalController().novaLocacao(locacao);
		}

		// FINALIZA CONTAGEM DO TEMPO
		long total = System.currentTimeMillis() - inicio;

		// TEMPO TOTAL DA OPERAÇÃO
		System.out.println("Total Inserido: " + locacoes.size());
		System.out.println("Tempo Total INSERT LOCACOES: " + (total) + "/ms");
		System.out
				.println("***************************************************************************");

		return total;
	}
	

	public static long carregarFuncionarios() {
		List<Staff> funcionarios;

		// CARREGA USUARIOS
		funcionarios = LoadHelperMySQL.carregarFuncionarios();

		System.out
				.println("***************************************************************************");
		System.out.println("Inicio INSERT FUNCIONARIOS");

		// INICIA CONTAGEM DO TEMPO
		long inicio = System.currentTimeMillis();

		// INSERE OS ATORES
		for (Staff funcionario : funcionarios) {

			new StaffController().novoFuncionario(funcionario);
		}

		// FINALIZA CONTAGEM DO TEMPO
		long total = System.currentTimeMillis() - inicio;

		// TEMPO TOTAL DA OPERAÇÃO
		System.out.println("Total Inserido: " + funcionarios.size());
		System.out.println("Tempo Total INSERT FUNCIONARIOS: " + (total) + "/ms");
		System.out
				.println("***************************************************************************");

		return total;
	}
	

	public static long carregarLojas() {
		List<Store> lojas;

		// CARREGA USUARIOS
		lojas = LoadHelperMySQL.carregarLojas();

		System.out
				.println("***************************************************************************");
		System.out.println("Inicio INSERT LOJAS");

		// INICIA CONTAGEM DO TEMPO
		long inicio = System.currentTimeMillis();

		// INSERE OS ATORES
		for (Store loja : lojas) {

			new StoreController().novaLoja(loja); 
		}

		// FINALIZA CONTAGEM DO TEMPO
		long total = System.currentTimeMillis() - inicio;

		// TEMPO TOTAL DA OPERAÇÃO
		System.out.println("Total Inserido: " + lojas.size());
		System.out.println("Tempo Total INSERT LOJAS: " + (total) + "/ms");
		System.out
				.println("***************************************************************************");

		return total;
	}
	
	public static long getAllCustomers() {
		List<Customer> clientes;
		
		System.out
				.println("***************************************************************************");
		System.out.println("Inicio GET ALL CUSTOMERS");

		// INICIA CONTAGEM DO TEMPO
		long inicio = System.currentTimeMillis();

		// REALIZA BUSCA
		clientes = new CustomerController().buscarTodosClientes();

		// FINALIZA CONTAGEM DO TEMPO
		long total = (System.currentTimeMillis() - inicio);

		
		System.out.println("Clientes recuperadoss: " + clientes.size());

		// TEMPO TOTAL DA OPERAÇÃO (SEM CONTAR O TEMPO DE IMPRESSÃO)
		System.out.println("Tempo Total GET ALL CUSTOMERS: "
				+ (total) + "/ms");
		System.out
				.println("***************************************************************************");

		return total;
	}
	
	public static long getCustomersByActiveStatus() {
		List<Customer> clientes;
		
		System.out
				.println("***************************************************************************");
		System.out.println("Inicio GET CUSTOMERS BY ACTIVE STATUS");

		// INICIA CONTAGEM DO TEMPO
		long inicio = System.currentTimeMillis();

		// REALIZA BUSCA
		clientes = new CustomerController().buscarClienteByStatus(true);

		// FINALIZA CONTAGEM DO TEMPO
		long total = (System.currentTimeMillis() - inicio);

		/* IMPRIME AS PUBLICAÇÕES
		for (Customer cliente : clientes) {
			System.out.println(cliente);
		}*/

		System.out.println("Clientes recuperados: " + clientes.size());

		// TEMPO TOTAL DA OPERAÇÃO (SEM CONTAR O TEMPO DE IMPRESSÃO)
		System.out.println("Tempo Total GET CUSTOMERS BY ACTIVE STATUS: "
				+ (total) + "/ms");
		System.out
				.println("***************************************************************************");

		return total;
	}
	
	public static long getCustomerByStore() {
		List<Customer> clientes;
		List<Store> lojas;
		Random random = new Random();
		Store loja;

		// CARREGA EMAILS
		lojas = LoadHelperMySQL.carregarLojas();

		// SELECIONA UM EMAIL ALEATÓRIO
		loja = lojas.get(random.nextInt(lojas.size()));
		System.out.println("Loja Utilizada na Pesquisa: " + loja.getStoreId());
		
		System.out
				.println("***************************************************************************");
		System.out.println("Inicio GET CUSTOMER BY STORE");

		// INICIA CONTAGEM DO TEMPO
		long inicio = System.currentTimeMillis();

		// REALIZA BUSCA
		clientes = new CustomerController().buscarClienteByStore(loja.getStoreId());

		// FINALIZA CONTAGEM DO TEMPO
		long total = (System.currentTimeMillis() - inicio);

		/* IMPRIME AS PUBLICAÇÕES
		for (Customer cliente : clientes) {
			System.out.println(cliente);
		}*/

		
		System.out.println("Clientes recuperados: " + clientes.size());

		// TEMPO TOTAL DA OPERAÇÃO (SEM CONTAR O TEMPO DE IMPRESSÃO)
		System.out.println("Tempo Total GET CUSTOMER BY STORE "
				+ (total) + "/ms");
		System.out
				.println("***************************************************************************");

		return total;
	}
	
	public static long getFilmByCategory() {
		List<Film> filmes;
		List<Category> categorias;
		Random random = new Random();
		Category categoria;

		// CARREGA EMAILS
		categorias = LoadHelperMySQL.carregarCategorias();

		// SELECIONA UM EMAIL ALEATÓRIO
		categoria = categorias.get(random.nextInt(categorias.size()));
		System.out.println("Categoria Utilizada na Pesquisa: " + categoria.getName());
		
		System.out
				.println("***************************************************************************");
		System.out.println("Inicio GET FILM BY CATEGORY");

		// INICIA CONTAGEM DO TEMPO
		long inicio = System.currentTimeMillis();

		// REALIZA BUSCA
		filmes = new FilmController().buscarFilmeByCategory(categoria.getName());

		// FINALIZA CONTAGEM DO TEMPO
		long total = (System.currentTimeMillis() - inicio);

		/* IMPRIME AS PUBLICAÇÕES
		for (Film filme : filmes) {
			System.out.println(filme);
		}*/

		
		System.out.println("Filmes recuperados: " + filmes.size());

		// TEMPO TOTAL DA OPERAÇÃO (SEM CONTAR O TEMPO DE IMPRESSÃO)
		System.out.println("Tempo Total GET FILM BY CATEGORY "
				+ (total) + "/ms");
		System.out
				.println("***************************************************************************");

		return total;
	}
	
	public static long getActorsByFilm() {
		List<Actor> atores;
		List<Film> filmes;
		Random random = new Random();
		Film filme;

		// CARREGA EMAILS
		filmes = LoadHelperMySQL.carregarFilmes();

		// SELECIONA UM EMAIL ALEATÓRIO
		filme = filmes.get(random.nextInt(filmes.size()));
		System.out.println("Filme Utilizado na Pesquisa: " + filme.getTitle());
		
		System.out
				.println("***************************************************************************");
		System.out.println("Inicio GET ACTORS BY FILM");

		// INICIA CONTAGEM DO TEMPO
		long inicio = System.currentTimeMillis();

		// REALIZA BUSCA
		atores = new ActorController().buscarAtoresByFilm(filme.getTitle());

		// FINALIZA CONTAGEM DO TEMPO
		long total = (System.currentTimeMillis() - inicio);

		// IMPRIME AS PUBLICAÇÕES
		for (Actor ator : atores) {
			System.out.println(ator);
		}

		
		System.out.println("Atores recuperados: " + atores.size());

		// TEMPO TOTAL DA OPERAÇÃO (SEM CONTAR O TEMPO DE IMPRESSÃO)
		System.out.println("Tempo Total GET ACTORS BY FILM "
				+ (total) + "/ms");
		System.out
				.println("***************************************************************************");

		return total;
	}
	
	public static long getRentalsByCustomer() {
		List<Rental> locacoes;
		List<Customer> clientes;
		Random random = new Random();
		Customer cliente;

		/* CARREGA EMAILS
		clientes = LoadHelperMySQL.carregarClientes();

		// SELECIONA UM EMAIL ALEATÓRIO
		cliente = clientes.get(random.nextInt(clientes.size()));*/
		System.out.println("Cliente Utilizado na Pesquisa: SUE.PETERS@sakilacustomer.org");
		
		System.out
				.println("***************************************************************************");
		System.out.println("Inicio GET RENTALS BY CUSTOMER");

		// INICIA CONTAGEM DO TEMPO
		long inicio = System.currentTimeMillis();

		// REALIZA BUSCA
		locacoes = new RentalController().buscarLocacaoByUser("SUE.PETERS@sakilacustomer.org");

		// FINALIZA CONTAGEM DO TEMPO
		long total = (System.currentTimeMillis() - inicio);

		// IMPRIME AS PUBLICAÇÕES
		for (Rental locacao : locacoes) {
			System.out.println(locacao);
		}

		
		System.out.println("Locacoes recuperados: " + locacoes.size());

		// TEMPO TOTAL DA OPERAÇÃO (SEM CONTAR O TEMPO DE IMPRESSÃO)
		System.out.println("Tempo Total GET RENTALS BY CUSTOMER "
				+ (total) + "/ms");
		System.out
				.println("***************************************************************************");

		return total;
	}
	
	public static long getPaymentsByCustomer() {
		List<Payment> pagamentos;
		List<Customer> clientes;
		Random random = new Random();
		Customer cliente;

		/* CARREGA EMAILS
		clientes = LoadHelperMySQL.carregarClientes();

		// SELECIONA UM EMAIL ALEATÓRIO
		cliente = clientes.get(random.nextInt(clientes.size()));*/
		System.out.println("Cliente Utilizado na Pesquisa: ELIZABETH.BROWN@sakilacustomer.org");
		
		System.out
				.println("***************************************************************************");
		System.out.println("Inicio GET PAYMENTS BY CUSTOMER");

		// INICIA CONTAGEM DO TEMPO
		long inicio = System.currentTimeMillis();

		// REALIZA BUSCA
		pagamentos = new PaymentController().buscarPagamentosByUser("ELIZABETH.BROWN@sakilacustomer.org");

		// FINALIZA CONTAGEM DO TEMPO
		long total = (System.currentTimeMillis() - inicio);

		// IMPRIME AS PUBLICAÇÕES
		for (Payment pagamento : pagamentos) {
			System.out.println(pagamento);
		}

		
		System.out.println("Locacoes recuperados: " + pagamentos.size());

		// TEMPO TOTAL DA OPERAÇÃO (SEM CONTAR O TEMPO DE IMPRESSÃO)
		System.out.println("Tempo Total GET PAYMENTS BY CUSTOMER "
				+ (total) + "/ms");
		System.out
				.println("***************************************************************************");

		return total;
	}
	
	public static long getCustomersByTotalPayment() {
		List<Customer> clientes;
		List<Double> valores = new ArrayList<Double>();
		Random random = new Random();
		double valor;

		// CARREGA EMAILS
		valores.add(50.00);
		valores.add(100.00);
		valores.add(150.00);
		valores.add(200.00);
		valores.add(250.00);
		valores.add(300.00);
		

		// SELECIONA UM EMAIL ALEATÓRIO
		valor = valores.get(random.nextInt(valores.size()));
		System.out.println("Valor Utilizado na Pesquisa: " + valor);
		
		System.out
				.println("***************************************************************************");
		System.out.println("Inicio GET CUSTOMER BY STORE");

		// INICIA CONTAGEM DO TEMPO
		long inicio = System.currentTimeMillis();

		// REALIZA BUSCA
		clientes = new CustomerController().buscarClienteByTotalPayment(valor);

		// FINALIZA CONTAGEM DO TEMPO
		long total = (System.currentTimeMillis() - inicio);

		/* IMPRIME AS PUBLICAÇÕES
		for (Customer cliente : clientes) {
			System.out.println(cliente);
		}*/

		
		System.out.println("Clientes recuperados: " + clientes.size());

		// TEMPO TOTAL DA OPERAÇÃO (SEM CONTAR O TEMPO DE IMPRESSÃO)
		System.out.println("Tempo Total GET CUSTOMER BY STORE "
				+ (total) + "/ms");
		System.out
				.println("***************************************************************************");

		return total;
	}	
	
	public static long updateCustomersByNonActiveStatus() {
				
		System.out
				.println("***************************************************************************");
		System.out.println("Inicio UPDATE CUSTOMERS BY NON ACTIVE STATUS");

		// INICIA CONTAGEM DO TEMPO
		long inicio = System.currentTimeMillis();

		// REALIZA BUSCA
		new CustomerController().atualizarClienteByStatus(false,true);

		// FINALIZA CONTAGEM DO TEMPO
		long total = (System.currentTimeMillis() - inicio);

		/* IMPRIME AS PUBLICAÇÕES
		for (Customer cliente : clientes) {
			System.out.println(cliente);
		}

		System.out.println("Clientes recuperados: " + clientes.size());*/

		// TEMPO TOTAL DA OPERAÇÃO (SEM CONTAR O TEMPO DE IMPRESSÃO)
		System.out.println("Tempo Total UPDATE CUSTOMERS BY NON ACTIVE STATUS: "
				+ (total) + "/ms");
		System.out
				.println("***************************************************************************");

		return total;
	}
	
	public static long removeCustomerByEmail() {
		List<Customer> clientes;
		Random random = new Random();
		Customer cliente;

		//CARREGA EMAILS
		clientes = LoadHelperMySQL.carregarClientes();

		// SELECIONA UM EMAIL ALEATÓRIO
		cliente = clientes.get(random.nextInt(clientes.size()));
		System.out.println("Cliente Utilizado na Pesquisa: "+cliente.getFirstName()+" "+cliente.getLastName());
		
		System.out
				.println("***************************************************************************");
		System.out.println("Inicio GET CUSTOMER BY STORE");

		// INICIA CONTAGEM DO TEMPO
		long inicio = System.currentTimeMillis();

		// REALIZA BUSCA
		new CustomerController().removeClienteByEmail(cliente.getEmail());

		// FINALIZA CONTAGEM DO TEMPO
		long total = (System.currentTimeMillis() - inicio);

		/* IMPRIME AS PUBLICAÇÕES
		for (Customer cliente : clientes) {
			System.out.println(cliente);
		}

				System.out.println("Clientes recuperados: " + clientes.size());*/
		System.out.println("Tempo Total GET CUSTOMER BY STORE "
				+ (total) + "/ms");
		System.out
				.println("***************************************************************************");

		return total;
	}
	

	/**
	 * @return
	 */
	public static long  firstLoadFull() {

		long tempoTotal = 0;
		
		tempoTotal += TestesLocadoraMySQL.carregarPaises();
		tempoTotal += TestesLocadoraMySQL.carregarCidades();
		tempoTotal += TestesLocadoraMySQL.carregarEnderecos();
		tempoTotal += TestesLocadoraMySQL.carregarIdiomas();
		tempoTotal += TestesLocadoraMySQL.carregarLojas();
		tempoTotal += TestesLocadoraMySQL.carregarFuncionarios();
		tempoTotal += TestesLocadoraMySQL.carregarClientes();		
		tempoTotal += TestesLocadoraMySQL.carregarCategorias();
		tempoTotal += TestesLocadoraMySQL.carregarAtores();
		tempoTotal += TestesLocadoraMySQL.carregarFilmes();
		tempoTotal += TestesLocadoraMySQL.carregarInventarios();
		tempoTotal += TestesLocadoraMySQL.carregarLocacoes();
		tempoTotal += TestesLocadoraMySQL.carregarPagamentos();
		
		return tempoTotal;
	}
	
	public static long  firstLoad() {

		long tempoTotal = 0;
		
		tempoTotal += TestesLocadoraMySQL.carregarPaises();
		tempoTotal += TestesLocadoraMySQL.carregarCidades();
		tempoTotal += TestesLocadoraMySQL.carregarEnderecos();
		tempoTotal += TestesLocadoraMySQL.carregarIdiomas();
		tempoTotal += TestesLocadoraMySQL.carregarLojas();
		tempoTotal += TestesLocadoraMySQL.carregarFuncionarios();
		tempoTotal += TestesLocadoraMySQL.carregarClientes();		
		tempoTotal += TestesLocadoraMySQL.carregarCategorias();
		tempoTotal += TestesLocadoraMySQL.carregarAtores();
		tempoTotal += TestesLocadoraMySQL.carregarFilmes();
		
		return tempoTotal;
	}

}
