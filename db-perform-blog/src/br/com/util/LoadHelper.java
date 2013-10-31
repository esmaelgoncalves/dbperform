package br.com.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.joda.time.DateTime;

import br.com.blog.mongodb.model.Comentario;
import br.com.blog.mongodb.model.Publicacao;
import br.com.blog.mongodb.model.Usuario;


/**
 * Classe que contém métodos de apoio. Faz o load das informações requeridas
 * para os testes das bases de dados.
 * 
 * @author ESMAEL
 * 
 */
public class LoadHelper {

	/**
	 * Carrega uma lista de "Usuários" a partir do arquivo "usuarios.csv"
	 * 
	 * @return List
	 */
	public static List<Usuario> carregarUsuarios() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Usuario usuario;
		File entrada = new File("usuarios.csv");
		Scanner leitor = null;
		String[] userAux = null;

		try {
			leitor = new Scanner(entrada);

			while (leitor.hasNextLine()) {
				String stringAux = (String) leitor.nextLine();
				userAux = stringAux.split(";");

				usuario = new Usuario();

				usuario.setNome(userAux[0]);
				usuario.setApelido(userAux[1]);
				usuario.setEmail(userAux[2]);
				usuario.setNascimento(new DateTime(System.currentTimeMillis())
						.toString());

				usuarios.add(usuario);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		leitor.close();
		return usuarios;

	}
	

	/**
	 * Carrega uma lista de "emails" a partir do arquivo "emails.csv"
	 * 
	 * @return List
	 */
	public static List<String> carregarEmails() {
		List<String> emails = new ArrayList<String>();
		File entrada = new File("emails.csv");
		Scanner leitor = null;

		try {
			leitor = new Scanner(entrada);

			while (leitor.hasNextLine()) {
				String email = (String) leitor.nextLine();
				emails.add(email);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		leitor.close();
		return emails;
	}

	/**
	 * Carrega uma lista de "nomes" a partir do arquivo "nomes.csv"
	 * 
	 * @return List
	 */
	public static List<String> carregarNomes() {
		List<String> nomes = new ArrayList<String>();

		File entrada = new File("nomes.csv");
		Scanner leitor = null;

		try {
			leitor = new Scanner(entrada);

			while (leitor.hasNextLine()) {
				String nome = (String) leitor.nextLine();
				nomes.add(nome);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		leitor.close();
		return nomes;
	}

	/**
	 * Carrega uma lista de "Publicações" para ser utilizado com DBREF a partir do arquivo "post.csv"
	 * 
	 * @return List
	 */
	public static List<Publicacao> carregarPublicacoesDBREF() {
		List<Publicacao> publicacoes = new ArrayList<Publicacao>();
		List<String> tags = carregarTags();
		List<String> auxTags;
		Random random = new Random();

		Publicacao publicacao;

		File entrada = new File("posts.csv");
		Scanner leitor = null;
		String[] postAux = null;
		
		try {
			leitor = new Scanner(entrada);

			while (leitor.hasNextLine()) {
				String stringAux = (String) leitor.nextLine();
				postAux = stringAux.split(";");

				publicacao = new Publicacao();

				auxTags = new ArrayList<String>();

				for (int aux = 0; aux < 3; aux++) {
					auxTags.add(tags.get(random.nextInt(tags.size())));
				}

				publicacao.setTitulo(postAux[0]);
				publicacao.setPost(postAux[1]);
				publicacao.setData(new DateTime(System.currentTimeMillis())
						.toString());
				publicacao.setTags(auxTags);

				publicacoes.add(publicacao);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		leitor.close();

		return publicacoes;
	}

	/**
	 * Carrega uma lista de "Publicações" para ser utilizado sem DBREF a partir do arquivo "post.csv"
	 * 
	 * @return List
	 */
	public static List<Publicacao> carregarPublicacoes() {
		List<Publicacao> publicacoes = new ArrayList<Publicacao>();
		List<String> tags = carregarTags();
		List<String> emails = carregarEmails();
		List<String> auxTags;
		Random random = new Random();

		Publicacao publicacao;

		File entrada = new File("posts.csv");
		Scanner leitor = null;
		String[] postAux = null;

		try {
			leitor = new Scanner(entrada);

			while (leitor.hasNextLine()) {
				String stringAux = (String) leitor.nextLine();
				postAux = stringAux.split(";");

				publicacao = new Publicacao();

				auxTags = new ArrayList<String>();

				for (int aux = 0; aux < 3; aux++) {
					auxTags.add(tags.get(random.nextInt(tags.size())));
				}

				publicacao.setTitulo(postAux[0]);
				publicacao.setPost(postAux[1]);
				publicacao.setData(new DateTime(System.currentTimeMillis())
						.toString());
				publicacao.setTags(auxTags);
				publicacao.setRefenceUsuario(emails.get(random.nextInt(emails
						.size())));

				publicacoes.add(publicacao);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		leitor.close();

		return publicacoes;
	}

	/**
	 * Carrega uma lista de "tags" a partir do arquivo "tags.csv"
	 * 
	 * @return List
	 */
	public static List<String> carregarTags() {
		List<String> tags = new ArrayList<String>();

		File entrada = new File("tags.csv");
		Scanner leitor = null;

		try {
			leitor = new Scanner(entrada);

			while (leitor.hasNextLine()) {
				String tag = (String) leitor.nextLine();
				tags.add(tag);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		leitor.close();
		return tags;
	}
	
	
	/**
	 * * Carrega uma lista de "comentarios" a partir do arquivo "comentarios.csv" referenciados aleatoriamente a usuários.
	 * 
	 * @return List
	 */
	public static List<Comentario> carregarComentarios(){
		List<Comentario> comentarios = new ArrayList<Comentario>();
		List<String> emails = carregarEmails();
		Random random = new Random();
		Comentario comentario = null;

		File entrada = new File("comentarios.csv");
		Scanner leitor = null;

		try {
			leitor = new Scanner(entrada);

			while (leitor.hasNextLine()) {
				String auxCommentario = (String) leitor.nextLine();
				
				comentario = new Comentario();
				
				comentario.setComment(auxCommentario);
				comentario.setData(new DateTime(System.currentTimeMillis()).toString());
				comentario.setRefenceUsuario(emails.get(random.nextInt(emails.size())));
				
				comentarios.add(comentario);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		leitor.close();
		return comentarios;
	}

}
