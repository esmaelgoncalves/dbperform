package br.com.util;

import java.util.List;
import java.util.Random;

import br.com.blog.mongodb.controller.PublicacaoController;
import br.com.blog.mongodb.controller.UsuarioController;
import br.com.blog.mongodb.model.Comentario;
import br.com.blog.mongodb.model.Publicacao;
import br.com.blog.mongodb.model.Usuario;

/**
 * Classe que cont�m todos os testes para o Modelo de Dados BLOG em MongoDB.
 * A classe cont�m os seguintes m�todos:
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
	 * M�todo respons�vel por preparar a inser��o de usuarios no banco de dados.
	 * S�o realizadas diversas chamadas ao banco de dados na utiliza��o desse
	 * m�todo.
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

		// TEMPO TOTAL DA OPERA��O
		System.out.println("Total Inserido: " + usuarios.size());
		System.out.println("Tempo Total INSERT USUARIOS: " + (total) + "/ms");
		System.out
				.println("***************************************************************************");

		return total;
	}

	/**
	 * M�todo respons�vel por preparar a consulta a todos os usu�rios do banco
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
		
		System.out.println("Usu�rios recuperadas: "+ usuarios.size());
		// TEMPO TOTAL DA OPERA��O (SEM CONTAR O TEMPO DE IMPRESS�O)
		System.out.println("Tempo Total GET ALL USERS : " + (total) + "/ms");
		System.out
				.println("***************************************************************************");

		return total;
	}

	/**
	 * M�todo respons�vel por preparar a busca de um usu�rio no banco de dados.
	 * � feita a consulta ap�s ser selecionado um email aleat�riamente.
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

		// SELECIONA UM EMAIL ALEAT�RIO
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

		// TEMPO TOTAL DA OPERA��O (SEM CONTAR O TEMPO DE IMPRESS�O)
		System.out.println("Tempo Total GET USER BY MAIL: " + (total) + "/ms");
		System.out
				.println("***************************************************************************");

		return total;
	}

	/**
	 * M�todo respons�vel por preparar a busca de um usu�rio no banco de dados.
	 * � feita a consulta ap�s ser selecionado um nome aleat�riamente.
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

		// SELECIONA UM EMAIL ALEAT�RIO
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

		// TEMPO TOTAL DA OPERA��O (SEM CONTAR O TEMPO DE IMPRESS�O)
		System.out.println("Tempo Total GET USER BY NAME: " + (total) + "/ms");
		System.out
				.println("***************************************************************************");

		return total;
	}

	/**
	 * M�todo respons�vel por preparar a busca de uma lista de usu�rios no banco
	 * de dados. � feita a consulta ap�s ser selecionado um nome aleat�riamente.
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

		// SELECIONA UM EMAIL ALEAT�RIO
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
		
		System.out.println("Usu�rios recuperadas: "+ usuarios.size());
		// TEMPO TOTAL DA OPERA��O (SEM CONTAR O TEMPO DE IMPRESS�O)
		System.out.println("Tempo Total GET USERS BY NAME: " + (total) + "/ms");
		System.out
				.println("***************************************************************************");

		return total;
	}

	/**
	 * M�todo respons�vel por preparar a inser��o de publica��es no banco de
	 * dados. S�o inseridas as publica��es utilizando o DBREF do MongoDB
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

		// TEMPO TOTAL DA OPERA��O
		System.out.println("Total Inserido: " + publicacoes.size());
		System.out.println("Tempo Total INSERT PUBLICATIONS + DBREF: " + (total)
				+ "/ms");
		System.out
				.println("***************************************************************************");

		return total;
	}

	/**
	 * M�todo respons�vel por preparar a inser��o de publica��es no banco de
	 * dados. S�o inseridas as publica��es sem a utiliza��o do DBREF do MongoDB
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

		// TEMPO TOTAL DA OPERA��O
		System.out.println("Total Inserido: " + publicacoes.size());
		System.out
				.println("Tempo Total INSERT PUBLICATIONS: " + (total) + "/ms");
		System.out
				.println("***************************************************************************");

		return total;
	}

	/**
	 * M�todo respons�vel por preparar a consulta a todos as publica��es do
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

		/* IMPRIME AS PUBLICAC��ES
		for (Publicacao publicacao : publicacoes) {
			System.out.println(publicacao);
		}*/
		
		System.out.println("Publica��es recuperadas: "+ publicacoes.size());
		// TEMPO TOTAL DA OPERA��O (SEM CONTAR O TEMPO DE IMPRESS�O)
		System.out
				.println("Tempo Total GET ALL PUBLICATIONS : " + (total) + "/ms");
		System.out
				.println("***************************************************************************");

		return total;
	}

	/**
	 * M�todo respons�vel por preparar a busca de uma publica��o no banco de dados.
	 * � feita a consulta ap�s ser selecionado uma tag aleat�riamente.
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

		// SELECIONA UM EMAIL ALEAT�RIO
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

		// TEMPO TOTAL DA OPERA��O (SEM CONTAR O TEMPO DE IMPRESS�O)
		System.out.println("Tempo Total GET PUBLICATION BY MAIL: " + (total) + "/ms");
		System.out
				.println("***************************************************************************");

		return total;
	}

	/**
	 * M�todo respons�vel por preparar a busca de uma lista de publicac�es no banco de dados.
	 * � feita a consulta ap�s ser selecionado uma tag aleat�riamente.
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

		// SELECIONA UM EMAIL ALEAT�RIO
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

		// IMPRIME AS PUBLICA��ES
		for (Publicacao publicacao : publicacoes) {
			System.out.println(publicacao);
		}
		
		System.out.println("Publica��es recuperadas: "+ publicacoes.size());
		// TEMPO TOTAL DA OPERA��O (SEM CONTAR O TEMPO DE IMPRESS�O)
		System.out.println("Tempo Total GET PUBLICATIONS BY TAG: " + (total)
				+ "/ms");
		System.out
				.println("***************************************************************************");

		return total;
	}
	
	/**
	  * M�todo respons�vel por preparar a busca de uma lista de publicac�es no banco de dados.
	 *  � feita a consulta ap�s ser selecionado um email para refer�ncia aleat�riamente.
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

		// SELECIONA UM EMAIL ALEAT�RIO
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

		//IMPRIME AS PUBLICA��ES
		for (Publicacao publicacao : publicacoes) {
			System.out.println(publicacao);
		}
		
		System.out.println("Publica��es recuperadas: "+ publicacoes.size());
				
		// TEMPO TOTAL DA OPERA��O (SEM CONTAR O TEMPO DE IMPRESS�O)
		System.out.println("Tempo Total GET PUBLICATIONS BY USER REFERENCE: " + (total)
				+ "/ms");
		System.out
				.println("***************************************************************************");

		return total;
	}
	
	/**
	 * M�todo respons�vel por preparar a inser��o de publica��es no banco de
	 * dados. S�o inseridas as publica��es sem a utiliza��o do DBREF do MongoDB
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
			new PublicacaoController().novaPublicacaoComComent�rios(publicacao);
		}

		// FINALIZA CONTAGEM DO TEMPO
		long total = System.currentTimeMillis() - inicio;

		// TEMPO TOTAL DA OPERA��O
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

		// SELECIONA UM EMAIL ALEAT�RIO
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

		/* IMPRIME AS PUBLICA��ES
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

		// SELECIONA UM EMAIL ALEAT�RIO
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

		/* IMPRIME AS PUBLICA��ES
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
