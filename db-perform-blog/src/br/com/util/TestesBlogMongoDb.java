package br.com.util;

import java.util.List;
import java.util.Random;

import br.com.blog.mongodb.controller.PublicacaoController;
import br.com.blog.mongodb.controller.UsuarioController;
import br.com.blog.mongodb.model.Comentario;
import br.com.blog.mongodb.model.Publicacao;
import br.com.blog.mongodb.model.Usuario;

/**
 * Classe que contém todos os testes para o Modelo de Dados BLOG em MongoDB.
 * A classe contém os seguintes métodos:
 * 
 * insertUser()
 * insertUsersOneConnection()
 * getAllUsers()
 * getUserByEmail
 * getUsersByName
 * getUserByName
 * 
 * insertPublications()
 * insertPublicationsDBREF()
 * insertPublicationsOneConnection()
 * insertPublicationsWhitComments()
 * insertPublicationsOneConnectionWhitComments()
 * getAllPublications()
 * getPublicationByTag()
 * getPublicationsByTag()
 * getPublicationsByUserReference()
 * 
 * @author ESMAEL
 * 
 */
public class TestesBlogMongoDb {

	/*
	 * public static void main(String[] args) {
	 * 
	 * // insertUser(); // insertUsersOneConnection(); // getAllUsers(); //
	 * getUserByEmail(); // getUserByName(); // getUsersByName();
	 * 
	 * 
	 * // insertPublicacoesDBREF(); // insertPublicacoes(); //
	 * insertPublicacoesOneConnection(); // getAllPublication(); //
	 * getPublicationByTag(); // getPublicationByUserReference();
	 * 
	 * }
	 */

	/**
	 * Método responsável por preparar a inserção de usuarios no banco de dados.
	 * São realizadas diversas chamadas ao banco de dados na utilização desse
	 * método.
	 * 
	 * @return long
	 */
	public static long insertUser() {
		List<Usuario> usuarios;

		// CARREGA USUARIOS
		usuarios = LoadHelper.carregarUsuarios();

		System.out
				.println("***************************************************************************");
		System.out.println("Inicio INSERT USUARIOS");

		// INICIA CONTAGEM DO TEMPO
		long inicio = System.currentTimeMillis();

		// INSERE OS USUARIOS
		for (Usuario usuario : usuarios) {

			new UsuarioController().novoUsuario(usuario);
		}

		// FINALIZA CONTAGEM DO TEMPO
		long total = System.currentTimeMillis() - inicio;

		// TEMPO TOTAL DA OPERAÇÃO
		System.out.println("Total Inserido: " + usuarios.size());
		System.out.println("Tempo Total INSERT USUARIOS: " + (total) + "/ms");
		System.out
				.println("***************************************************************************");

		return total;
	}

	/**
	 * Método responsável por preparar a consulta a todos os usuários do banco
	 * de dados.
	 * 
	 * @return long
	 */
	public static long getAllUsers() {
		List<Usuario> usuarios;

		System.out
				.println("***************************************************************************");
		System.out.println("Inicio GET ALL USERS");

		// INICIA CONTAGEM DO TEMPO
		long inicio = System.currentTimeMillis();

		// REALIZAR A BUSCA
		usuarios = new UsuarioController().listarTodos();

		// FINALIZA CONTAGEM DO TEMPO
		long total = (System.currentTimeMillis() - inicio);

		// IMPRIME OS USUARIOS
		for (Usuario usuario : usuarios) {
			System.out.println(usuario);
		}
		
		System.out.println("Usuários recuperadas: "+ usuarios.size());
		// TEMPO TOTAL DA OPERAÇÃO (SEM CONTAR O TEMPO DE IMPRESSÃO)
		System.out.println("Tempo Total GET ALL USERS : " + (total) + "/ms");
		System.out
				.println("***************************************************************************");

		return total;
	}

	/**
	 * Método responsável por preparar a busca de um usuário no banco de dados.
	 * É feita a consulta após ser selecionado um email aleatóriamente.
	 * 
	 * @return long
	 */
	public static long getUserByEmail() {
		Usuario usuario;
		List<String> emails;
		Random random = new Random();
		String email;

		// CARREGA EMAILS
		emails = LoadHelper.carregarEmails();

		// SELECIONA UM EMAIL ALEATÓRIO
		email = emails.get(random.nextInt(emails.size()));

		System.out
				.println("***************************************************************************");
		System.out.println("Inicio GET USER BY MAIL");

		// INICIA CONTAGEM DO TEMPO
		long inicio = System.currentTimeMillis();

		// REALIZA BUSCA
		usuario = new UsuarioController().buscarUsuarioByMail(email);

		// FINALIZA CONTAGEM DO TEMPO
		long total = (System.currentTimeMillis() - inicio);

		// IMPRIME USUARIO
		System.out.println(usuario);

		// TEMPO TOTAL DA OPERAÇÃO (SEM CONTAR O TEMPO DE IMPRESSÃO)
		System.out.println("Tempo Total GET USER BY MAIL: " + (total) + "/ms");
		System.out
				.println("***************************************************************************");

		return total;
	}

	/**
	 * Método responsável por preparar a busca de um usuário no banco de dados.
	 * É feita a consulta após ser selecionado um nome aleatóriamente.
	 * 
	 * @return long
	 */
	public static long getUserByName() {
		Usuario usuario;
		List<String> nomes;
		Random random = new Random();
		String nome;

		// CARREGA EMAILS
		nomes = LoadHelper.carregarNomes();

		// SELECIONA UM EMAIL ALEATÓRIO
		nome = nomes.get(random.nextInt(nomes.size()));

		System.out
				.println("***************************************************************************");
		System.out.println("Inicio GET USER BY NAME");

		// INICIA CONTAGEM DO TEMPO
		long inicio = System.currentTimeMillis();

		// REALIZA BUSCA
		usuario = new UsuarioController().buscarUsuarioByNome(nome);

		// FINALIZA CONTAGEM DO TEMPO
		long total = (System.currentTimeMillis() - inicio);

		// IMPRIME USUARIO
		System.out.println(usuario);

		// TEMPO TOTAL DA OPERAÇÃO (SEM CONTAR O TEMPO DE IMPRESSÃO)
		System.out.println("Tempo Total GET USER BY NAME: " + (total) + "/ms");
		System.out
				.println("***************************************************************************");

		return total;
	}

	/**
	 * Método responsável por preparar a busca de uma lista de usuários no banco
	 * de dados. É feita a consulta após ser selecionado um nome aleatóriamente.
	 * 
	 * @return long
	 */
	public static long getUsersByName() {
		List<Usuario> usuarios;
		List<String> nomes;
		Random random = new Random();
		String nome;

		// CARREGA EMAILS
		nomes = LoadHelper.carregarNomes();

		// SELECIONA UM EMAIL ALEATÓRIO
		nome = nomes.get(random.nextInt(nomes.size()));

		System.out
				.println("***************************************************************************");
		System.out.println("Inicio GET USERS BY NAME");

		// INICIA CONTAGEM DO TEMPO
		long inicio = System.currentTimeMillis();

		// REALIZA BUSCA
		usuarios = new UsuarioController().buscarUsuariosByNome(nome);

		// FINALIZA CONTAGEM DO TEMPO
		long total = (System.currentTimeMillis() - inicio);

		// IMPRIME OS USUARIOS
		for (Usuario usuario : usuarios) {
			System.out.println(usuario);
		}
		
		System.out.println("Usuários recuperadas: "+ usuarios.size());
		// TEMPO TOTAL DA OPERAÇÃO (SEM CONTAR O TEMPO DE IMPRESSÃO)
		System.out.println("Tempo Total GET USERS BY NAME: " + (total) + "/ms");
		System.out
				.println("***************************************************************************");

		return total;
	}

	/**
	 * Método responsável por preparar a inserção de publicações no banco de
	 * dados. São inseridas as publicações utilizando o DBREF do MongoDB
	 * 
	 * @return long
	 */
	public static long insertPublicationsDBREF() {
		List<Publicacao> publicacoes;
		List<String> emails;
		Random random = new Random();
		String email;

		// CARREGA USUARIOS
		publicacoes = LoadHelper.carregarPublicacoesDBREF();
		emails = LoadHelper.carregarEmails();

		System.out
				.println("***************************************************************************");
		System.out.println("Inicio INSERT PUBLICATIONS + DBREF");

		// INICIA CONTAGEM DO TEMPO
		long inicio = System.currentTimeMillis();

		// INSERE OS USUARIOS
		for (Publicacao publicacao : publicacoes) {
			email = emails.get(random.nextInt(emails.size()));
			new PublicacaoController().novaPublicacaoDBREF(publicacao, email);
		}

		// FINALIZA CONTAGEM DO TEMPO
		long total = System.currentTimeMillis() - inicio;

		// TEMPO TOTAL DA OPERAÇÃO
		System.out.println("Total Inserido: " + publicacoes.size());
		System.out.println("Tempo Total INSERT PUBLICATIONS + DBREF: " + (total)
				+ "/ms");
		System.out
				.println("***************************************************************************");

		return total;
	}

	/**
	 * Método responsável por preparar a inserção de publicações no banco de
	 * dados. São inseridas as publicações sem a utilização do DBREF do MongoDB
	 * 
	 * @return long
	 */
	public static long insertPublications() {
		List<Publicacao> publicacoes;

		// CARREGA USUARIOS
		publicacoes = LoadHelper.carregarPublicacoes();

		System.out
				.println("***************************************************************************");
		System.out.println("Inicio INSERT PUBLICATIONS");

		// INICIA CONTAGEM DO TEMPO
		long inicio = System.currentTimeMillis();

		// INSERE OS USUARIOS
		for (Publicacao publicacao : publicacoes) {
			new PublicacaoController().novaPublicacao(publicacao);
		}

		// FINALIZA CONTAGEM DO TEMPO
		long total = System.currentTimeMillis() - inicio;

		// TEMPO TOTAL DA OPERAÇÃO
		System.out.println("Total Inserido: " + publicacoes.size());
		System.out
				.println("Tempo Total INSERT PUBLICATIONS: " + (total) + "/ms");
		System.out
				.println("***************************************************************************");

		return total;
	}

	/**
	 * Método responsável por preparar a consulta a todos as publicações do
	 * banco de dados.
	 * 
	 * @return long
	 */
	public static long getAllPublication() {
		List<Publicacao> publicacoes;

		System.out
				.println("***************************************************************************");
		System.out.println("Inicio GET ALL PUBLICATIONS");

		// INICIA CONTAGEM DO TEMPO
		long inicio = System.currentTimeMillis();

		// REALIZAR A BUSCA
		publicacoes = new PublicacaoController().listarTodas();

		// FINALIZA CONTAGEM DO TEMPO
		long total = (System.currentTimeMillis() - inicio);

		/* IMPRIME AS PUBLICACÇÕES
		for (Publicacao publicacao : publicacoes) {
			System.out.println(publicacao);
		}*/
		
		System.out.println("Publicações recuperadas: "+ publicacoes.size());
		// TEMPO TOTAL DA OPERAÇÃO (SEM CONTAR O TEMPO DE IMPRESSÃO)
		System.out
				.println("Tempo Total GET ALL PUBLICATIONS : " + (total) + "/ms");
		System.out
				.println("***************************************************************************");

		return total;
	}

	/**
	 * Método responsável por preparar a busca de uma publicação no banco de dados.
	 * É feita a consulta após ser selecionado uma tag aleatóriamente.
	 * 
	 * @return long
	 */
	public static long getPublicationByTag() {
		Publicacao publicacao;
		List<String> tags;
		Random random = new Random();
		String tag;

		// CARREGA EMAILS
		tags = LoadHelper.carregarTags();

		// SELECIONA UM EMAIL ALEATÓRIO
		tag = tags.get(random.nextInt(tags.size()));

		System.out
				.println("***************************************************************************");
		System.out.println("Inicio GET PUBLICATION BY MAIL");

		// INICIA CONTAGEM DO TEMPO
		long inicio = System.currentTimeMillis();

		// REALIZA BUSCA
		publicacao = new PublicacaoController().buscarPublicacaoByTag(tag);

		// FINALIZA CONTAGEM DO TEMPO
		long total = (System.currentTimeMillis() - inicio);

		// IMPRIME USUARIO
		System.out.println(publicacao);

		// TEMPO TOTAL DA OPERAÇÃO (SEM CONTAR O TEMPO DE IMPRESSÃO)
		System.out.println("Tempo Total GET PUBLICATION BY MAIL: " + (total) + "/ms");
		System.out
				.println("***************************************************************************");

		return total;
	}

	/**
	 * Método responsável por preparar a busca de uma lista de publicacões no banco de dados.
	 * É feita a consulta após ser selecionado uma tag aleatóriamente.
	 * 
	 * @return long
	 */
	public static long getPublicationsByTag() {
		List<Publicacao> publicacoes;
		List<String> tags;
		Random random = new Random();
		String tag;

		// CARREGA EMAILS
		tags = LoadHelper.carregarTags();

		// SELECIONA UM EMAIL ALEATÓRIO
		tag = tags.get(random.nextInt(tags.size()));

		System.out
				.println("***************************************************************************");
		System.out.println("Inicio GET PUBLICATIONS BY TAG");

		// INICIA CONTAGEM DO TEMPO
		long inicio = System.currentTimeMillis();

		// REALIZA BUSCA
		publicacoes = new PublicacaoController().buscarPublicacoesByTag(tag);

		// FINALIZA CONTAGEM DO TEMPO
		long total = (System.currentTimeMillis() - inicio);

		// IMPRIME AS PUBLICAÇÕES
		for (Publicacao publicacao : publicacoes) {
			System.out.println(publicacao);
		}
		
		System.out.println("Publicações recuperadas: "+ publicacoes.size());
		// TEMPO TOTAL DA OPERAÇÃO (SEM CONTAR O TEMPO DE IMPRESSÃO)
		System.out.println("Tempo Total GET PUBLICATIONS BY TAG: " + (total)
				+ "/ms");
		System.out
				.println("***************************************************************************");

		return total;
	}
	
	/**
	  * Método responsável por preparar a busca de uma lista de publicacões no banco de dados.
	 *  É feita a consulta após ser selecionado um email para referência aleatóriamente.
	 * 
	 * @return long
	 */
	public static long getPublicationsByUserReference() {
		List<Publicacao> publicacoes;
		List<String> emails;
		Random random = new Random();
		String userReference;

		// CARREGA EMAILS
		emails = LoadHelper.carregarEmails();

		// SELECIONA UM EMAIL ALEATÓRIO
		userReference = emails.get(random.nextInt(emails.size()));

		System.out
				.println("***************************************************************************");
		System.out.println("Inicio GET PUBLICATIONS BY USER REFERENCE");

		// INICIA CONTAGEM DO TEMPO
		long inicio = System.currentTimeMillis();

		// REALIZA BUSCA
		publicacoes = new PublicacaoController().buscarPublicacoesByUserReference(userReference);

		// FINALIZA CONTAGEM DO TEMPO
		long total = (System.currentTimeMillis() - inicio);

		//IMPRIME AS PUBLICAÇÕES
		for (Publicacao publicacao : publicacoes) {
			System.out.println(publicacao);
		}
		
		System.out.println("Publicações recuperadas: "+ publicacoes.size());
				
		// TEMPO TOTAL DA OPERAÇÃO (SEM CONTAR O TEMPO DE IMPRESSÃO)
		System.out.println("Tempo Total GET PUBLICATIONS BY USER REFERENCE: " + (total)
				+ "/ms");
		System.out
				.println("***************************************************************************");

		return total;
	}
	
	/**
	 * Método responsável por preparar a inserção de publicações no banco de
	 * dados. São inseridas as publicações sem a utilização do DBREF do MongoDB
	 * 
	 * @return long
	 */
	public static long insertPublicationsWhitComments() {
		List<Publicacao> publicacoes;
		List<Comentario> comentarios;

		// CARREGA PUBLICACOES
		publicacoes = LoadHelper.carregarPublicacoes();
		//CARREGA COMENTARIOS
		comentarios = LoadHelper.carregarComentarios();

		System.out
				.println("***************************************************************************");
		System.out.println("Inicio INSERT PUBLICATIONS WHIT COMMENTS");

		// INICIA CONTAGEM DO TEMPO
		long inicio = System.currentTimeMillis();

		// INSERE OS USUARIOS
		for (Publicacao publicacao : publicacoes) {
			publicacao.setComentarios(comentarios);
			new PublicacaoController().novaPublicacaoComComentários(publicacao);
		}

		// FINALIZA CONTAGEM DO TEMPO
		long total = System.currentTimeMillis() - inicio;

		// TEMPO TOTAL DA OPERAÇÃO
		System.out.println("Total Inserido: " + publicacoes.size());
		System.out
				.println("Tempo Total INSERT PUBLICATIONS WHIT COMMENTS: " + (total) + "/ms");
		System.out
				.println("***************************************************************************");

		return total;
	}
	
	public static long removePublicationsByUser() {
		List<Usuario> usuarios;
		Random random = new Random();
		Usuario usuario;

		//CARREGA EMAILS
		usuarios = LoadHelper.carregarUsuarios();

		// SELECIONA UM EMAIL ALEATÓRIO
		usuario = usuarios.get(random.nextInt(usuarios.size()));
		System.out.println("Cliente Utilizado na Pesquisa: "+usuario.getNome());
		
		System.out
				.println("***************************************************************************");
		System.out.println("Inicio REMOVE PUBLICATION BY USER");

		// INICIA CONTAGEM DO TEMPO
		long inicio = System.currentTimeMillis();

		// REALIZA BUSCA
		new PublicacaoController().removePublicacaoByUserEmail(usuario.getEmail());

		// FINALIZA CONTAGEM DO TEMPO
		long total = (System.currentTimeMillis() - inicio);

		/* IMPRIME AS PUBLICAÇÕES
		for (Customer cliente : clientes) {
			System.out.println(cliente);
		}

				System.out.println("Clientes recuperados: " + clientes.size());*/
		System.out.println("Tempo REMOVE PUBLICATION BY USER "
				+ (total) + "/ms");
		System.out
				.println("***************************************************************************");

		return total;
	}
	
	public static long updateUserByUserEmail() {
		List<Usuario> usuarios;
		Random random = new Random();
		Usuario usuario;

		//CARREGA EMAILS
		usuarios = LoadHelper.carregarUsuarios();

		// SELECIONA UM EMAIL ALEATÓRIO
		usuario = usuarios.get(random.nextInt(usuarios.size()));
		System.out.println("Cliente Utilizado na Pesquisa: "+usuario.getNome());
		
		System.out
				.println("***************************************************************************");
		System.out.println("Inicio UPDATE USER BY EMAIL");

		// INICIA CONTAGEM DO TEMPO
		long inicio = System.currentTimeMillis();

		// REALIZA BUSCA
		new PublicacaoController().atualizaUsuarioByEmail(usuario.getEmail(),usuario.getApelido().concat(" ALTERADO"));

		// FINALIZA CONTAGEM DO TEMPO
		long total = (System.currentTimeMillis() - inicio);

		/* IMPRIME AS PUBLICAÇÕES
		for (Customer cliente : clientes) {
			System.out.println(cliente);
		}

				System.out.println("Clientes recuperados: " + clientes.size());*/
		System.out.println("Tempo UPDATE USER BY EMAIL "
				+ (total) + "/ms");
		System.out
				.println("***************************************************************************");

		return total;
	}
	
	public static long firstLoadWhitoutDBREFPlusComments() {
		long tempoTotal = 0;
		
		tempoTotal += TestesBlogMongoDb.insertUser();
		tempoTotal += TestesBlogMongoDb.insertPublicationsWhitComments();
		
		return tempoTotal;
	}

	public static long firstLoadWhitDBREFWhitoutComments() {
		long tempoTotal = 0;
		
		tempoTotal += TestesBlogMongoDb.insertUser();
		tempoTotal += TestesBlogMongoDb.insertPublicationsDBREF();
		
		return tempoTotal;
	}

	public static long firstLoadWhitoutDBREFWhitoutComments() {
		long tempoTotal = 0;
		
		tempoTotal += TestesBlogMongoDb.insertUser();
		tempoTotal += TestesBlogMongoDb.insertPublications();
		
		return tempoTotal;
	}

	
	

}
