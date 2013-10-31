/**
 * 
 */
package br.com.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.joda.time.DateTime;

import br.com.blog.mysql.controller.TagController;
import br.com.blog.mysql.controller.UsuarioController;
import br.com.blog.mysql.model.Comentario;
import br.com.blog.mysql.model.Publicacao;
import br.com.blog.mysql.model.Tag;
import br.com.blog.mysql.model.Usuario;

/**
 * @author ESMAEL
 *
 */
public class LoadHelperMySQL {

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
	 * Carrega uma lista de "tags" a partir do arquivo "tags.csv"
	 * 
	 * @return List
	 */
	public static List<Tag> carregarTags() {
		List<Tag> tags = new ArrayList<Tag>();

		File entrada = new File("tags.csv");
		Scanner leitor = null;

		try {
			leitor = new Scanner(entrada);

			while (leitor.hasNextLine()) {
				Tag tag = new Tag();
				String aux = (String) leitor.nextLine();
				tag.setTag(aux);
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
	 * Carrega uma lista de "Publicações" para ser utilizado sem DBREF a partir do arquivo "post.csv"
	 * 
	 * @return List
	 */
	public static List<Publicacao> carregarPublicacoes() {
		List<Publicacao> publicacoes = new ArrayList<Publicacao>();
		List<String> emails = LoadHelper.carregarEmails();
		List<Tag> tags = carregarTags();
		List<Tag> auxTags;
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

				auxTags = new ArrayList<Tag>();

				for (int aux = 0; aux < 3; aux++) {
					Tag auxTag = new TagController().buscarTagByName(tags.get(random.nextInt(tags.size())).getTag());
					auxTags.add(auxTag);
				}
				
				Usuario usuario = new UsuarioController().buscarUsuarioByMail((emails.get(random.nextInt(emails.size()))));

				publicacao.setTitulo(postAux[0]);
				publicacao.setPost(postAux[1]);
				publicacao.setData(new DateTime(System.currentTimeMillis())
						.toString());
				publicacao.setTags(auxTags);
				publicacao.setUsuario(usuario);

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
	 * * Carrega uma lista de "comentarios" a partir do arquivo "comentarios.csv" referenciados aleatoriamente a usuários.
	 * 
	 * @return List
	 */
	public static List<Comentario> carregarComentarios(){
		List<Comentario> comentarios = new ArrayList<Comentario>();
		List<String> emails = LoadHelper.carregarEmails();
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
				Usuario usuario = new UsuarioController().buscarUsuarioByMail((emails.get(random.nextInt(emails.size()))));
				comentario.setUsuario(usuario);				
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
