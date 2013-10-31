package br.com.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Menu Principal Aplica��o DBPERFORM. Cont�m as poss�veis op��es para
 * utiliza��o da aplica��o.
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
					.println("\n******************** TESTES 'DBPERFORM' BLOG ********************\n");

			System.out.println("Escolha uma Op��o:");
			System.out.println("(1) Testes Blog com MongoDB.");
			System.out.println("(2) Testes Blog com MySQL.");
			System.out.println("(0) Encerrar o Programa.");
			System.out
					.println("'________________________________________________________'.\n");

			System.out.print("Digite sua op��o: ");
			opcaoMenu = teclado.nextInt();

			if (opcaoMenu == 0) {
				System.out
						.println("A Aplica��o Ser� Encerrada em 5 Segundos. Aguarde... \n");
				Thread.sleep(5000);
			} else if (opcaoMenu == 1) {
				int opcao;
				do {
					System.out
							.println("\n******************** TESTES BLOG COM MONGODB ********************\n");
					System.out.println("Escolha uma Op��o:");

					System.out
							.println("(1) Realizar primeira Carga de Dados (Com DBREF + Sem Coment�rios).");
					System.out
							.println("(2) Realizar primeira Carga de Dados (Sem DBREF + Sem Coment�rios).");
					System.out
							.println("(3) Realizar primeira Carga de Dados (Sem DBREF + Com Coment�rios).");
					System.out.println("(4) Buscar Todos os Usu�rios");
					System.out.println("(5) Buscar Usu�rio por email.");
					System.out
							.println("(6) Buscar Usu�rio por nome (�nico Usu�rio).");
					System.out
							.println("(7) Buscar Usu�rio por nome (Lista de Usu�rios).");
					System.out.println("(8) Buscar Todas as Publica��es.");
					System.out
							.println("(9) Buscar Publica��o por tag (�nica Publica��o).");
					System.out
							.println("(10) Buscar Publica��o por tag (Lista de Publica�oes).");
					System.out
							.println("(11) Buscar Publica��o por usu�rio (Lista de Publica�oes de Um Usuario).");
					System.out.println("(12) Atualizar Usu�rio por email");
					System.out.println("(13) Remover Publica��es de um usuario");
			
					System.out.println("(0) Voltar ao Menu Anterior.");
					System.out
							.println("'________________________________________________________'.\n");

					System.out.print("Digite sua op��o: ");
					opcao = teclado.nextInt();

					if (opcao == 0) {

					} else if (opcao == 1) {

						System.out
								.println("***************************************************************************");
						System.out.println("PREPARANDO CARGA DE DADOS");
						System.out.println("Tempo Total CARGA DE DADOS: "
								+ (TestesBlogMongoDb
										.firstLoadWhitDBREFWhitoutComments())
								+ "/ms");
						System.out
								.println("***************************************************************************");

					} else if (opcao == 2) {

						System.out
								.println("***************************************************************************");
						System.out.println("PREPARANDO CARGA DE DADOS");
						System.out
								.println("Tempo Total CARGA DE DADOS: "
										+ (TestesBlogMongoDb
												.firstLoadWhitoutDBREFWhitoutComments())
										+ "/ms");
						System.out
								.println("***************************************************************************");

					} else if (opcao == 3) {

						System.out
								.println("***************************************************************************");
						System.out.println("PREPARANDO CARGA DE DADOS");
						System.out.println("Tempo Total CARGA DE DADOS: "
								+ (TestesBlogMongoDb
										.firstLoadWhitoutDBREFPlusComments())
								+ "/ms");
						System.out
								.println("***************************************************************************");

					} else if (opcao == 4) {
						System.out
								.println("***************************************************************************");
						System.out.println("PREPARANDO BUSCA");
						List<Long> tempoExecucao = new ArrayList<Long>();
						long tempoMedio = 0;

						for (int x = 0; x < 150; x++) {
							tempoExecucao.add(TestesBlogMongoDb.getAllUsers());
						}

						try {
							salvarResultados(tempoExecucao,
									"getAllUsersMongo.csv");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						for (int i = 0; i < tempoExecucao.size(); i++) {
							tempoMedio += tempoExecucao.get(i);
						}

						tempoMedio = tempoMedio / tempoExecucao.size();

						System.out
								.println("Tempo M�dio das Execu��es Total BUSCAR TODOS OS USU�RIOS: "
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
							tempoExecucao.add(TestesBlogMongoDb
									.getUserByEmail());
						}

						try {
							salvarResultados(tempoExecucao,
									"getAllUserByEmail.csv");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						for (int i = 0; i < tempoExecucao.size(); i++) {
							tempoMedio += tempoExecucao.get(i);
						}

						tempoMedio = tempoMedio / tempoExecucao.size();
						System.out
								.println("Tempo M�dio das Execu��es Total BUSCAR USU�RIO POR EMAIL: "
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
							tempoExecucao
									.add(TestesBlogMongoDb.getUserByName());
						}

						try {
							salvarResultados(tempoExecucao,
									"getUserByNameMongo.csv");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						for (int i = 0; i < tempoExecucao.size(); i++) {
							tempoMedio += tempoExecucao.get(i);
						}

						tempoMedio = tempoMedio / tempoExecucao.size();
						System.out
								.println("Tempo M�dio das Execu��es Total BUSCAR USU�RIO POR NOME: "
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
							tempoExecucao.add(TestesBlogMongoDb
									.getUsersByName());
						}

						try {
							salvarResultados(tempoExecucao,
									"getUsersByNameMongo.csv");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						for (int i = 0; i < tempoExecucao.size(); i++) {
							tempoMedio += tempoExecucao.get(i);
						}

						tempoMedio = tempoMedio / tempoExecucao.size();
						System.out
								.println("Tempo M�dio das Execu��es Total BUSCAR USU�RIOS POR NOME: "
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
							tempoExecucao.add(TestesBlogMongoDb
									.getAllPublication());
						}

						try {
							salvarResultados(tempoExecucao,
									"getAllPublicationsMongo.csv");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						for (int i = 0; i < tempoExecucao.size(); i++) {
							tempoMedio += tempoExecucao.get(i);
						}

						tempoMedio = tempoMedio / tempoExecucao.size();
						System.out
								.println("Tempo M�dio das Execu��es Total BUSCAR TODAS AS PUBLICA��ES: "
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
							tempoExecucao.add(TestesBlogMongoDb
									.getPublicationByTag());
						}

						try {
							salvarResultados(tempoExecucao,
									"getPublicationByTagMongo.csv");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						for (int i = 0; i < tempoExecucao.size(); i++) {
							tempoMedio += tempoExecucao.get(i);
						}

						tempoMedio = tempoMedio / tempoExecucao.size();
						System.out
								.println("Tempo M�dio das Execu��es Total BUSCAR PUBLICA��O POR TAG: "
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
							tempoExecucao.add(TestesBlogMongoDb
									.getPublicationsByTag());
						}

						try {
							salvarResultados(tempoExecucao,
									"getPublicatinsByTagMongo.csv");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						for (int i = 0; i < tempoExecucao.size(); i++) {
							tempoMedio += tempoExecucao.get(i);
						}

						tempoMedio = tempoMedio / tempoExecucao.size();
						System.out
								.println("Tempo M�dio das Execu��es Total BUSCAR PUBLICA��ES POR TAG: "
										+ (tempoMedio) + "/ms");
						System.out
								.println("***************************************************************************");

					} else if (opcao == 11) {

						System.out
								.println("***************************************************************************");
						System.out.println("PREPARANDO BUSCA");
						List<Long> tempoExecucao = new ArrayList<Long>();
						long tempoMedio = 0;

						for (int x = 0; x < 150; x++) {
							tempoExecucao.add(TestesBlogMongoDb
									.getPublicationsByUserReference());
						}

						try {
							salvarResultados(tempoExecucao,
									"getPublicationsByUserReferenceMongo.csv");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						for (int i = 0; i < tempoExecucao.size(); i++) {
							tempoMedio += tempoExecucao.get(i);
						}

						tempoMedio = tempoMedio / tempoExecucao.size();
						System.out
								.println("Tempo M�dio das Execu��es Total BUSCAR PUBLICA��ES POR REFER�NCIA DE USU�RIO: "
										+ (tempoMedio) + "/ms");
						System.out
								.println("***************************************************************************");

					} else if (opcao == 12) {

						System.out
								.println("***************************************************************************");
						System.out.println("PREPARANDO BUSCA");
						List<Long> tempoExecucao = new ArrayList<Long>();
						long tempoMedio = 0;

						for (int x = 0; x < 150; x++) {
							tempoExecucao.add(TestesBlogMongoDb
									.updateUserByUserEmail());
						}

						try {
							salvarResultados(tempoExecucao,
									"updateUserByUserEmailMongo.csv");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						for (int i = 0; i < tempoExecucao.size(); i++) {
							tempoMedio += tempoExecucao.get(i);
						}

						tempoMedio = tempoMedio / tempoExecucao.size();
						System.out
								.println("Tempo M�dio das Execu��es Total ATUALIZAR USU�RIO POR EMAIL: "
										+ (tempoMedio) + "/ms");
						System.out
								.println("***************************************************************************");

					}else if (opcao == 13) {

						System.out
								.println("***************************************************************************");
						System.out.println("PREPARANDO BUSCA");
						List<Long> tempoExecucao = new ArrayList<Long>();
						long tempoMedio = 0;

						for (int x = 0; x < 150; x++) {
							tempoExecucao.add(TestesBlogMongoDb
									.removePublicationsByUser());
						}

						try {
							salvarResultados(tempoExecucao,
									"removePublicationsByUserMongo.csv");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						for (int i = 0; i < tempoExecucao.size(); i++) {
							tempoMedio += tempoExecucao.get(i);
						}

						tempoMedio = tempoMedio / tempoExecucao.size();
						System.out
								.println("Tempo M�dio das Execu��es Total REMOVER PUBLICA��ES POR REFER�NCIA DE USU�RIO: "
										+ (tempoMedio) + "/ms");
						System.out
								.println("***************************************************************************");

					}else {
						System.out
								.println("Op��o Inv�lida! Escolha um Op��o Para Continuar, ou (0) Para Voltar Ao Menu Principal!");
					}

				} while (opcao != 0);

			} else if (opcaoMenu == 2) {
				int opcao;
				do {
					System.out
							.println("\n******************** TESTES BLOG COM MYSQL ********************\n");
					System.out.println("Escolha uma Op��o:");
					System.out
							.println("(1) Realizar primeira Carga de Dados (Sem Coment�rios).");
					System.out
							.println("(2) Realizar primeira Carga de Dados (Com Coment�rios).");
					System.out.println("(3) Buscar Todos os Usu�rios");
					System.out.println("(4) Buscar Usu�rio por email.");
					System.out
							.println("(5) Buscar Usu�rio por nome (�nico Usu�rio).");
					System.out
							.println("(6) Buscar Usu�rio por nome (Lista de Usu�rios).");
					System.out.println("(7) Buscar Todas as Publica��es.");
					System.out
							.println("(8) Buscar Publica��o por tag (�nica Publica��o).");
					System.out
							.println("(9) Buscar Publica��o por tag (Lista de Publica�oes).");
					System.out
							.println("(10) Buscar Publica��o por usu�rio (Lista de Publica�oes de Um Usu�rio).");
					System.out.println("(11) Atualizar Usu�rio por email");
					System.out.println("(12) Remover Publica��es de um usuario");

					System.out.println("(0) Voltar ao Menu Anterior.");
					System.out
							.println("'________________________________________________________'.\n");

					System.out.print("Digite sua op��o: ");
					opcao = teclado.nextInt();

					if (opcao == 0) {

					} else if (opcao == 1) {

						System.out
								.println("***************************************************************************");
						System.out.println("PREPARANDO CARGA DE DADOS");
						System.out.println("Tempo Total CARGA DE DADOS: "
								+ (TestesBlogMySQL.firstLoadWhitoutComments())
								+ "/ms");
						System.out
								.println("***************************************************************************");

					} else if (opcao == 2) {

						System.out
								.println("***************************************************************************");
						System.out.println("PREPARANDO CARGA DE DADOS");
						System.out.println("Tempo Total CARGA DE DADOS: "
								+ (TestesBlogMySQL.firstLoadPlusComments())
								+ "/ms");
						System.out
								.println("***************************************************************************");

					} else if (opcao == 3) {

						System.out
								.println("***************************************************************************");
						System.out.println("PREPARANDO BUSCA");
						List<Long> tempoExecucao = new ArrayList<Long>();
						long tempoMedio = 0;

						for (int x = 0; x < 150; x++) {
							tempoExecucao.add(TestesBlogMySQL.getAllUsers());
						}

						try {
							salvarResultados(tempoExecucao,
									"getAllUsersMySql.csv");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						for (int i = 0; i < tempoExecucao.size(); i++) {
							tempoMedio += tempoExecucao.get(i);
						}

						tempoMedio = tempoMedio / tempoExecucao.size();
						System.out
								.println("Tempo M�dio das Execu��es Total BUSCAR TODOS OS USU�RIOS: "
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
							tempoExecucao.add(TestesBlogMySQL.getUserByEmail());
						}

						try {
							salvarResultados(tempoExecucao,
									"getUserByEmailMySql.csv");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						for (int i = 0; i < tempoExecucao.size(); i++) {
							tempoMedio += tempoExecucao.get(i);
						}

						tempoMedio = tempoMedio / tempoExecucao.size();
						System.out
								.println("Tempo M�dio das Execu��es Total BUSCAR USU�RIO POR EMAIL: "
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
							tempoExecucao.add(TestesBlogMySQL.getUserByName());
						}

						try {
							salvarResultados(tempoExecucao,
									"getUserByNameMySql.csv");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						for (int i = 0; i < tempoExecucao.size(); i++) {
							tempoMedio += tempoExecucao.get(i);
						}

						tempoMedio = tempoMedio / tempoExecucao.size();
						System.out
								.println("Tempo M�dio das Execu��es Total BUSCAR USU�RIO POR NOME: "
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
							tempoExecucao.add(TestesBlogMySQL.getUsersByName());
						}

						try {
							salvarResultados(tempoExecucao,
									"getUsersByNameMySql.csv");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						for (int i = 0; i < tempoExecucao.size(); i++) {
							tempoMedio += tempoExecucao.get(i);
						}

						tempoMedio = tempoMedio / tempoExecucao.size();
						System.out
								.println("Tempo M�dio das Execu��es Total BUSCAR USU�RIOS POR NOME: "
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
							tempoExecucao.add(TestesBlogMySQL
									.getAllPublication());
						}

						try {
							salvarResultados(tempoExecucao,
									"getAllPublicationMySql.csv");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						for (int i = 0; i < tempoExecucao.size(); i++) {
							tempoMedio += tempoExecucao.get(i);
						}

						tempoMedio = tempoMedio / tempoExecucao.size();
						System.out
								.println("Tempo M�dio das Execu��es Total BUSCAR TODAS AS PUBLICA��ES: "
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
							tempoExecucao.add(TestesBlogMySQL
									.getPublicationByTag());
						}

						try {
							salvarResultados(tempoExecucao,
									"getPublicationByTagMySql.csv");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						for (int i = 0; i < tempoExecucao.size(); i++) {
							tempoMedio += tempoExecucao.get(i);
						}

						tempoMedio = tempoMedio / tempoExecucao.size();
						System.out
								.println("Tempo M�dio das Execu��es Total BUSCAR PUBLICA��O POR TAG: "
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
							tempoExecucao.add(TestesBlogMySQL
									.getPublicationsByTag());
						}

						try {
							salvarResultados(tempoExecucao,
									"getPublicationsByTagMySql.csv");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						for (int i = 0; i < tempoExecucao.size(); i++) {
							tempoMedio += tempoExecucao.get(i);
						}

						tempoMedio = tempoMedio / tempoExecucao.size();
						System.out
								.println("Tempo M�dio das Execu��es Total BUSCAR PUBLICA��ES POR TAG: "
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
							tempoExecucao.add(TestesBlogMySQL
									.getPublicationsByUserReference());
						}

						try {
							salvarResultados(tempoExecucao,
									"getPublicationsByUserReferencesMySql.csv");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						for (int i = 0; i < tempoExecucao.size(); i++) {
							tempoMedio += tempoExecucao.get(i);
						}

						tempoMedio = tempoMedio / tempoExecucao.size();
						System.out
								.println("Tempo M�dio das Execu��es Total BUSCAR PUBLICA��ES POR REFER�NCIA DE USU�RIO: "
										+ (tempoMedio) + "/ms");
						System.out
								.println("***************************************************************************");

					} else if (opcao == 11) {

						System.out
								.println("***************************************************************************");
						System.out.println("PREPARANDO BUSCA");
						List<Long> tempoExecucao = new ArrayList<Long>();
						long tempoMedio = 0;

						for (int x = 0; x < 150; x++) {
							tempoExecucao.add(TestesBlogMySQL
									.getPublicationsByUserReference());
						}

						try {
							salvarResultados(tempoExecucao,
									"getPublicationsByUserReferencesMySql.csv");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						for (int i = 0; i < tempoExecucao.size(); i++) {
							tempoMedio += tempoExecucao.get(i);
						}

						tempoMedio = tempoMedio / tempoExecucao.size();
						System.out
								.println("Tempo M�dio das Execu��es Total BUSCAR PUBLICA��ES POR REFER�NCIA DE USU�RIO: "
										+ (tempoMedio) + "/ms");
						System.out
								.println("***************************************************************************");

					} else if (opcao == 12) {

						System.out
								.println("***************************************************************************");
						System.out.println("PREPARANDO BUSCA");
						List<Long> tempoExecucao = new ArrayList<Long>();
						long tempoMedio = 0;

						for (int x = 0; x < 150; x++) {
							tempoExecucao.add(TestesBlogMySQL
									.getPublicationsByUserReference());
						}

						try {
							salvarResultados(tempoExecucao,
									"getPublicationsByUserReferencesMySql.csv");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						for (int i = 0; i < tempoExecucao.size(); i++) {
							tempoMedio += tempoExecucao.get(i);
						}

						tempoMedio = tempoMedio / tempoExecucao.size();
						System.out
								.println("Tempo M�dio das Execu��es Total BUSCAR PUBLICA��ES POR REFER�NCIA DE USU�RIO: "
										+ (tempoMedio) + "/ms");
						System.out
								.println("***************************************************************************");

					} else {
						System.out
								.println("Op��o Inv�lida! Escolha um Op��o Para Continuar, ou (0) Para Voltar Ao Menu Principal!");
					}

				} while (opcao != 0);
			} else {
				System.out
						.println("Op��o Inv�lida! Escolha um Op��o Para Continuar, ou (0) Para Encerrar!");
			}

		} while (opcaoMenu != 0);

		teclado.close();
		System.out
				.println("\n******************** APLICA��O FINALIZADA ********************\n");

	}

	private static void salvarResultados(List<Long> tempoExecucao, String string)
			throws IOException {
		File file = new File(string);
		FileWriter saida = new FileWriter(file);
		saida.append("Execuc�es;Tempo em ms \n");
		
		for (int i = 0; i < tempoExecucao.size(); i++) {
			saida.append(""+(i+1) +";"+tempoExecucao.get(i) + "\n");
		}
		/*for (Long long1 : tempoExecucao) {
			saida.append(String.valueOf(long1) + "\n");
		}*/

		saida.flush();
		saida.close();

	}

}
