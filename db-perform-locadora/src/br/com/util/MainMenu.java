package br.com.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Menu Principal Aplicação DBPERFORM. Contém as possíveis opções para
 * utilização da aplicação.
 * 
 * @author ESMAEL
 * 
 */
public class MainMenu {

	/**
	 * Menu Principal
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		Scanner teclado = new Scanner(System.in);
		int opcaoMenu;

		do {
			System.out
					.println("\n******************** TESTES 'DBPERFORM' LOCADORA ********************\n");

			System.out.println("Escolha uma Opção:");
			System.out.println("(1) Testes Locadora com MongoDB.");
			System.out.println("(2) Testes Locadora com MySQL.");
			System.out.println("(0) Encerrar o Programa.");
			System.out
					.println("'________________________________________________________'.\n");

			System.out.print("Digite sua opção: ");
			opcaoMenu = teclado.nextInt();

			if (opcaoMenu == 0) {
				System.out
						.println("A Aplicação Será Encerrada em 5 Segundos. Aguarde... \n");
				Thread.sleep(5000);
			} else if (opcaoMenu == 1) {
				int opcao;
				do {
					System.out
							.println("\n******************** TESTES LOCADORA COM MONGODB ********************\n");
					System.out.println("Escolha uma Opção:");
					System.out
							.println("(1) Realizar primeira Carga de Dados (Completa).");
					System.out
							.println("(2) Realizar primeira Carga de Dados (Sem Locações/Pagamentos/Inventarios).");
					System.out.println("(3) Buscar Todos os Clientes");
					System.out.println("(4) Buscar Clientes Ativos.");
					System.out
							.println("(5) Buscar Clientes de Uma Loja Especifica.");
					System.out.println("(6) Buscar Filmes por Categoria.");
					System.out.println("(7) Buscar Atores de um Filme.");
					System.out.println("(8) Buscar Locações de um Cliente.");
					System.out.println("(9) Buscar Pagamentos de um Cliente.");
					System.out.println("(10) Clientes por Valor Total Pago.");
					System.out.println("(11) Atualizar Clientes por Status.");
					System.out.println("(12) Remover Clientes por Email.");

					System.out.println("(0) Voltar ao Menu Anterior.");
					System.out
							.println("'________________________________________________________'.\n");

					System.out.print("Digite sua opção: ");
					opcao = teclado.nextInt();

					if (opcao == 0) {

					} else if (opcao == 1) {

						System.out
								.println("***************************************************************************");
						System.out.println("PREPARANDO CARGA DE DADOS");
						System.out.println("Tempo Total CARGA DE DADOS: "
								+ (TestesLocadoraMongoDB.firstLoadFull())
								+ "/ms");
						System.out
								.println("***************************************************************************");

					} else if (opcao == 2) {
						System.out
								.println("***************************************************************************");
						System.out.println("PREPARANDO CARGA DE DADOS");
						System.out.println("Tempo Total CARGA DE DADOS: "
								+ (TestesLocadoraMongoDB.firstLoad()) + "/ms");
						System.out
								.println("***************************************************************************");

					} else if (opcao == 3) {
						System.out
								.println("***************************************************************************");
						System.out.println("PREPARANDO BUSCA");
						List<Long> tempoExecucao = new ArrayList<Long>();
						long tempoMedio = 0;

						for (int x = 0; x < 150; x++) {
							tempoExecucao.add(TestesLocadoraMongoDB
									.getAllCustomers());
						}

						try {
							salvarResultados(tempoExecucao,
									"03 - getAllCustomersMongoDB.csv");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						for (int i = 0; i < tempoExecucao.size(); i++) {
							tempoMedio += tempoExecucao.get(i);
						}

						tempoMedio = tempoMedio / tempoExecucao.size();
						System.out
								.println("Tempo Médio das Execuções Total BUSCAR TODOS OS CLIENTES: "
										+ (tempoMedio) + "/ms");
						System.out
								.println("***************************************************************************");

					} else if (opcao == 4) {
						System.out
								.println("***************************************************************************");
						System.out.println("PREPARANDO BUSCA");
						List<Long> tempoExecucao = new ArrayList<Long>();
						long tempoMedio = 0;

						for (int x = 0; x < 150; x++) {
							tempoExecucao.add(TestesLocadoraMongoDB
									.getCustomersByActiveStatus());
						}

						try {
							salvarResultados(tempoExecucao,
									"04 - getCustomersByActiveStatusMongoDB.csv");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						for (int i = 0; i < tempoExecucao.size(); i++) {
							tempoMedio += tempoExecucao.get(i);
						}

						tempoMedio = tempoMedio / tempoExecucao.size();
						System.out
								.println("Tempo Médio das Execuções Total BUSCAR OS CLIENTES ATIVOS: "
										+ (tempoMedio) + "/ms");
						System.out
								.println("***************************************************************************");
					} else if (opcao == 5) {
						System.out
								.println("***************************************************************************");
						System.out.println("PREPARANDO BUSCA");
						List<Long> tempoExecucao = new ArrayList<Long>();
						long tempoMedio = 0;

						for (int x = 0; x < 150; x++) {
							tempoExecucao.add(TestesLocadoraMongoDB
									.getCustomerByStore());
						}

						try {
							salvarResultados(tempoExecucao,
									"05 - getCustomerByStoreMongoDB.csv");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						for (int i = 0; i < tempoExecucao.size(); i++) {
							tempoMedio += tempoExecucao.get(i);
						}

						tempoMedio = tempoMedio / tempoExecucao.size();
						System.out
								.println("Tempo Médio das Execuções Total BUSCAR TODOS OS CLIENTES UMA LOJA: "
										+ (tempoMedio) + "/ms");
						System.out
								.println("***************************************************************************");
					} else if (opcao == 6) {
						System.out
								.println("***************************************************************************");
						System.out.println("PREPARANDO BUSCA");
						List<Long> tempoExecucao = new ArrayList<Long>();
						long tempoMedio = 0;

						for (int x = 0; x < 150; x++) {
							tempoExecucao.add(TestesLocadoraMongoDB
									.getFilmByCategory());
						}

						try {
							salvarResultados(tempoExecucao,
									"06 - getFilmByCategoryMongoDB.csv");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						for (int i = 0; i < tempoExecucao.size(); i++) {
							tempoMedio += tempoExecucao.get(i);
						}

						tempoMedio = tempoMedio / tempoExecucao.size();
						System.out
								.println("Tempo Médio das Execuções Total BUSCAR FILMES POR CATEGORIA: "
										+ (tempoMedio) + "/ms");
						System.out
								.println("***************************************************************************");
					} else if (opcao == 7) {
						System.out
								.println("***************************************************************************");
						System.out.println("PREPARANDO BUSCA");
						List<Long> tempoExecucao = new ArrayList<Long>();
						long tempoMedio = 0;

						for (int x = 0; x < 150; x++) {
							tempoExecucao.add(TestesLocadoraMongoDB
									.getActorsByFilm());
						}

						try {
							salvarResultados(tempoExecucao,
									"07 - getActorsByFilmMongoDB.csv");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						for (int i = 0; i < tempoExecucao.size(); i++) {
							tempoMedio += tempoExecucao.get(i);
						}

						tempoMedio = tempoMedio / tempoExecucao.size();
						System.out
								.println("Tempo Médio das Execuções Total BUSCAR ATORES DE UM FILME: "
										+ (tempoMedio) + "/ms");
						System.out
								.println("***************************************************************************");

					} else if (opcao == 8) {
						System.out
								.println("***************************************************************************");
						System.out.println("PREPARANDO BUSCA");
						List<Long> tempoExecucao = new ArrayList<Long>();
						long tempoMedio = 0;

						for (int x = 0; x < 150; x++) {
							tempoExecucao.add(TestesLocadoraMongoDB
									.getRentalsByCustomer());
						}

						try {
							salvarResultados(tempoExecucao,
									"08 - getRentalsByCustomerMongoDB.csv");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						for (int i = 0; i < tempoExecucao.size(); i++) {
							tempoMedio += tempoExecucao.get(i);
						}

						tempoMedio = tempoMedio / tempoExecucao.size();
						System.out
								.println("Tempo Médio das Execuções Total BUSCAR LOCACOES DE UM CLIENTE: "
										+ (tempoMedio) + "/ms");
						System.out
								.println("***************************************************************************");
					} else if (opcao == 9) {
						System.out
								.println("***************************************************************************");
						System.out.println("PREPARANDO BUSCA");
						List<Long> tempoExecucao = new ArrayList<Long>();
						long tempoMedio = 0;

						for (int x = 0; x < 150; x++) {
							tempoExecucao.add(TestesLocadoraMongoDB
									.getPaymentsByCustomer());
						}

						try {
							salvarResultados(tempoExecucao,
									"09 - getPaymentsByCustomeMongoDB.csv");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						for (int i = 0; i < tempoExecucao.size(); i++) {
							tempoMedio += tempoExecucao.get(i);
						}

						tempoMedio = tempoMedio / tempoExecucao.size();
						System.out
								.println("Tempo Médio das Execuções Total BUSCAR PAGAMENTOS DE UM CLIENTE: "
										+ (tempoMedio) + "/ms");
						System.out
								.println("***************************************************************************");
					} else if (opcao == 10) {
						System.out
								.println("***************************************************************************");
						System.out.println("PREPARANDO BUSCA");
						List<Long> tempoExecucao = new ArrayList<Long>();
						long tempoMedio = 0;

						for (int x = 0; x < 150; x++) {
							tempoExecucao.add(TestesLocadoraMongoDB
									.getCustomersByTotalPayment());
						}

						try {
							salvarResultados(tempoExecucao,
									"10 - getCustomersByTotalPaymentMongoDB.csv");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						for (int i = 0; i < tempoExecucao.size(); i++) {
							tempoMedio += tempoExecucao.get(i);
						}

						tempoMedio = tempoMedio / tempoExecucao.size();
						System.out
								.println("Tempo Médio das Execuções Total BUSCAR CLIENTES: "
										+ (tempoMedio) + "/ms");
						System.out
								.println("***************************************************************************");
					} else if (opcao == 11) {
						System.out
								.println("***************************************************************************");
						System.out.println("PREPARANDO UPDATE");
						List<Long> tempoExecucao = new ArrayList<Long>();
						long tempoMedio = 0;

						for (int x = 0; x < 150; x++) {
							tempoExecucao.add(TestesLocadoraMongoDB
									.updateCustomersByNonActiveStatus());
						}

						try {
							salvarResultados(tempoExecucao,
									"11 - updateCustomersByActiveStatusMongoDB.csv");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						for (int i = 0; i < tempoExecucao.size(); i++) {
							tempoMedio += tempoExecucao.get(i);
						}

						tempoMedio = tempoMedio / tempoExecucao.size();
						System.out
								.println("Tempo Médio das Execuções Total ATUALIZAR CLIENTES: "
										+ (tempoMedio) + "/ms");
						System.out
								.println("***************************************************************************");
					} else if (opcao == 12) {
						System.out
								.println("***************************************************************************");
						System.out.println("PREPARANDO REMOÇÃO");
						List<Long> tempoExecucao = new ArrayList<Long>();
						long tempoMedio = 0;

						for (int x = 0; x < 150; x++) {
							tempoExecucao.add(TestesLocadoraMongoDB
									.removeCustomerByEmail());
						}

						try {
							salvarResultados(tempoExecucao,
									"12 - removeCustomerByEmailMongoDB.csv");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						for (int i = 0; i < tempoExecucao.size(); i++) {
							tempoMedio += tempoExecucao.get(i);
						}

						tempoMedio = tempoMedio / tempoExecucao.size();
						System.out
								.println("Tempo Médio das Execuções Total EXCLUIR CLIENTES: "
										+ (tempoMedio) + "/ms");
						System.out
								.println("***************************************************************************");
					} else {
						System.out
								.println("Opção Inválida! Escolha um Opção Para Continuar, ou (0) Para Voltar Ao Menu Principal!");
					}

				} while (opcao != 0);

			} else if (opcaoMenu == 2) {
				int opcao;
				do {
					System.out
							.println("\n******************** TESTES LOCADORA COM MYSQL ********************\n");
					System.out.println("Escolha uma Opção:");
					System.out
							.println("(1) Realizar primeira Carga de Dados (Completa).");
					System.out
							.println("(2) Realizar primeira Carga de Dados (Sem Locações/Pagamentos/Inventarios).");
					System.out.println("(3) Buscar Todos os Clientes");
					System.out.println("(4) Buscar Clientes Ativos.");
					System.out
							.println("(5) Buscar Clientes de Uma Loja Especifica.");
					System.out.println("(6) Buscar Filmes por Categoria.");
					System.out.println("(7) Buscar Atores de um Filme.");
					System.out.println("(8) Buscar Locações de um Cliente.");
					System.out.println("(9) Buscar Pagamentos de um Cliente.");
					System.out.println("(10) Clientes por Valor Total Pago.");
					System.out.println("(11) Atualizar Clientes por Status.");
					System.out.println("(12) Remover Clientes por Email.");

					System.out.println("(0) Voltar ao Menu Anterior.");
					System.out
							.println("'________________________________________________________'.\n");

					System.out.print("Digite sua opção: ");
					opcao = teclado.nextInt();

					if (opcao == 0) {

					} else if (opcao == 1) {

						System.out
								.println("***************************************************************************");
						System.out.println("PREPARANDO CARGA DE DADOS");
						System.out
								.println("Tempo Total CARGA DE DADOS: "
										+ (TestesLocadoraMySQL.firstLoadFull())
										+ "/ms");
						System.out
								.println("***************************************************************************");

					} else if (opcao == 2) {
						System.out
								.println("***************************************************************************");
						System.out.println("PREPARANDO CARGA DE DADOS");
						System.out.println("Tempo Total CARGA DE DADOS: "
								+ (TestesLocadoraMySQL.firstLoad()) + "/ms");
						System.out
								.println("***************************************************************************");

					} else if (opcao == 3) {
						System.out
								.println("***************************************************************************");
						System.out.println("PREPARANDO BUSCA");
						List<Long> tempoExecucao = new ArrayList<Long>();
						long tempoMedio = 0;

						for (int x = 0; x < 150; x++) {
							tempoExecucao.add(TestesLocadoraMySQL
									.getAllCustomers());
						}

						try {
							salvarResultados(tempoExecucao,
									"03 - getAllCustomersMySql.csv");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						for (int i = 0; i < tempoExecucao.size(); i++) {
							tempoMedio += tempoExecucao.get(i);
						}

						tempoMedio = tempoMedio / tempoExecucao.size();
						System.out
								.println("Tempo Médio das Execuções Total BUSCAR TODOS OS CLIENTES: "
										+ (tempoMedio) + "/ms");
						System.out
								.println("***************************************************************************");

					} else if (opcao == 4) {
						System.out
								.println("***************************************************************************");
						System.out.println("PREPARANDO BUSCA");
						List<Long> tempoExecucao = new ArrayList<Long>();
						long tempoMedio = 0;

						for (int x = 0; x < 150; x++) {
							tempoExecucao.add(TestesLocadoraMySQL
									.getCustomersByActiveStatus());
						}

						try {
							salvarResultados(tempoExecucao,
									"04 - getCustomersByActiveStatusMySql.csv");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						for (int i = 0; i < tempoExecucao.size(); i++) {
							tempoMedio += tempoExecucao.get(i);
						}

						tempoMedio = tempoMedio / tempoExecucao.size();
						System.out
								.println("Tempo Médio das Execuções Total BUSCAR OS CLIENTES ATIVOS: "
										+ (tempoMedio) + "/ms");
						System.out
								.println("***************************************************************************");
					} else if (opcao == 5) {
						System.out
								.println("***************************************************************************");
						System.out.println("PREPARANDO BUSCA");
						List<Long> tempoExecucao = new ArrayList<Long>();
						long tempoMedio = 0;

						for (int x = 0; x < 150; x++) {
							tempoExecucao.add(TestesLocadoraMySQL
									.getCustomerByStore());
						}

						try {
							salvarResultados(tempoExecucao,
									"05 - getCustomerByStoreMySql.csv");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						for (int i = 0; i < tempoExecucao.size(); i++) {
							tempoMedio += tempoExecucao.get(i);
						}

						tempoMedio = tempoMedio / tempoExecucao.size();
						System.out
								.println("Tempo Médio das Execuções Total BUSCAR TODOS OS CLIENTES UMA LOJA: "
										+ (tempoMedio) + "/ms");
						System.out
								.println("***************************************************************************");
					} else if (opcao == 6) {
						System.out
								.println("***************************************************************************");
						System.out.println("PREPARANDO BUSCA");
						List<Long> tempoExecucao = new ArrayList<Long>();
						long tempoMedio = 0;

						for (int x = 0; x < 150; x++) {
							tempoExecucao.add(TestesLocadoraMySQL
									.getFilmByCategory());
						}

						try {
							salvarResultados(tempoExecucao,
									"06 - getFilmByCategoryMySql.csv");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						for (int i = 0; i < tempoExecucao.size(); i++) {
							tempoMedio += tempoExecucao.get(i);
						}

						tempoMedio = tempoMedio / tempoExecucao.size();
						System.out
								.println("Tempo Médio das Execuções Total BUSCAR FILMES POR CATEGORIA: "
										+ (tempoMedio) + "/ms");
						System.out
								.println("***************************************************************************");
					} else if (opcao == 7) {
						System.out
								.println("***************************************************************************");
						System.out.println("PREPARANDO BUSCA");
						List<Long> tempoExecucao = new ArrayList<Long>();
						long tempoMedio = 0;

						for (int x = 0; x < 150; x++) {
							tempoExecucao.add(TestesLocadoraMySQL
									.getActorsByFilm());
						}

						try {
							salvarResultados(tempoExecucao,
									"07 - getActorsByFilmMySql.csv");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						for (int i = 0; i < tempoExecucao.size(); i++) {
							tempoMedio += tempoExecucao.get(i);
						}

						tempoMedio = tempoMedio / tempoExecucao.size();
						System.out
								.println("Tempo Médio das Execuções Total BUSCAR ATORES DE UM FILME: "
										+ (tempoMedio) + "/ms");
						System.out
								.println("***************************************************************************");

					} else if (opcao == 8) {
						System.out
								.println("***************************************************************************");
						System.out.println("PREPARANDO BUSCA");
						List<Long> tempoExecucao = new ArrayList<Long>();
						long tempoMedio = 0;

						for (int x = 0; x < 150; x++) {
							tempoExecucao.add(TestesLocadoraMySQL
									.getRentalsByCustomer());
						}

						try {
							salvarResultados(tempoExecucao,
									"08 - getRentalsByCustomerMySql.csv");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						for (int i = 0; i < tempoExecucao.size(); i++) {
							tempoMedio += tempoExecucao.get(i);
						}

						tempoMedio = tempoMedio / tempoExecucao.size();
						System.out
								.println("Tempo Médio das Execuções Total BUSCAR LOCACOES DE UM CLIENTE: "
										+ (tempoMedio) + "/ms");
						System.out
								.println("***************************************************************************");
					} else if (opcao == 9) {
						System.out
								.println("***************************************************************************");
						System.out.println("PREPARANDO BUSCA");
						List<Long> tempoExecucao = new ArrayList<Long>();
						long tempoMedio = 0;

						for (int x = 0; x < 150; x++) {
							tempoExecucao.add(TestesLocadoraMySQL
									.getPaymentsByCustomer());
						}

						try {
							salvarResultados(tempoExecucao,
									"09 - getPaymentsByCustomeMySql.csv");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						for (int i = 0; i < tempoExecucao.size(); i++) {
							tempoMedio += tempoExecucao.get(i);
						}

						tempoMedio = tempoMedio / tempoExecucao.size();
						System.out
								.println("Tempo Médio das Execuções Total BUSCAR PAGAMENTOS DE UM CLIENTE: "
										+ (tempoMedio) + "/ms");
						System.out
								.println("***************************************************************************");
					} else if (opcao == 10) {
						System.out
								.println("***************************************************************************");
						System.out.println("PREPARANDO BUSCA");
						List<Long> tempoExecucao = new ArrayList<Long>();
						long tempoMedio = 0;

						for (int x = 0; x < 150; x++) {
							tempoExecucao.add(TestesLocadoraMySQL
									.getCustomersByTotalPayment());
						}

						try {
							salvarResultados(tempoExecucao,
									"10 - getCustomersByTotalPaymentMySql.csv");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						for (int i = 0; i < tempoExecucao.size(); i++) {
							tempoMedio += tempoExecucao.get(i);
						}

						tempoMedio = tempoMedio / tempoExecucao.size();
						System.out
								.println("Tempo Médio das Execuções Total BUSCAR CLIENTES: "
										+ (tempoMedio) + "/ms");
						System.out
								.println("***************************************************************************");
					} else if (opcao == 11) {
						System.out
								.println("***************************************************************************");
						System.out.println("PREPARANDO UPDATE");
						List<Long> tempoExecucao = new ArrayList<Long>();
						long tempoMedio = 0;

						for (int x = 0; x < 150; x++) {
							tempoExecucao.add(TestesLocadoraMySQL
									.updateCustomersByNonActiveStatus());
						}

						try {
							salvarResultados(tempoExecucao,
									"11 - updateCustomersByActiveStatusMySql.csv");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						for (int i = 0; i < tempoExecucao.size(); i++) {
							tempoMedio += tempoExecucao.get(i);
						}

						tempoMedio = tempoMedio / tempoExecucao.size();
						System.out
								.println("Tempo Médio das Execuções Total ATUALIZAR CLIENTES: "
										+ (tempoMedio) + "/ms");
						System.out
								.println("***************************************************************************");
					} else if (opcao == 12) {
						System.out
								.println("***************************************************************************");
						System.out.println("PREPARANDO REMOÇÃO");
						List<Long> tempoExecucao = new ArrayList<Long>();
						long tempoMedio = 0;

						for (int x = 0; x < 150; x++) {
							tempoExecucao.add(TestesLocadoraMySQL
									.removeCustomerByEmail());
						}

						try {
							salvarResultados(tempoExecucao,
									"12 - removeCustomerByEmailMySql.csv");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						for (int i = 0; i < tempoExecucao.size(); i++) {
							tempoMedio += tempoExecucao.get(i);
						}

						tempoMedio = tempoMedio / tempoExecucao.size();
						System.out
								.println("Tempo Médio das Execuções Total EXCLUIR CLIENTES: "
										+ (tempoMedio) + "/ms");
						System.out
								.println("***************************************************************************");
					} else {
						System.out
								.println("Opção Inválida! Escolha um Opção Para Continuar, ou (0) Para Voltar Ao Menu Principal!");
					}

				} while (opcao != 0);
			} else {
				System.out
						.println("Opção Inválida! Escolha um Opção Para Continuar, ou (0) Para Encerrar!");
			}

		} while (opcaoMenu != 0);

		teclado.close();
		System.out
				.println("\n******************** APLICAÇÃO FINALIZADA ********************\n");

	}

	private static void salvarResultados(List<Long> tempoExecucao, String string)
			throws IOException {
		File file = new File(string);
		FileWriter saida = new FileWriter(file);
		saida.append("Execucões;Tempo em ms \n");

		for (int i = 0; i < tempoExecucao.size(); i++) {
			saida.append("" + (i + 1) + ";" + tempoExecucao.get(i) + "\n");
		}
		/*
		 * for (Long long1 : tempoExecucao) { saida.append(String.valueOf(long1)
		 * + "\n"); }
		 */

		saida.flush();
		saida.close();

	}

}
