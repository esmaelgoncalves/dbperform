package br.com.blog.mongodb.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.blog.factory.ConnectionFactoryMongoDb;
import br.com.blog.mongodb.model.Publicacao;
import br.com.blog.mongodb.model.Usuario;
import br.com.util.LoadHelper;

import com.google.code.morphia.AdvancedDatastore;
import com.google.code.morphia.query.Query;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

/**
 * 
 * @author ESMAEL
 * 
 */
public class PublicacaoDAO extends ConnectionFactoryMongoDb {

	private static PublicacaoDAO instance;
	private static AdvancedDatastore conexao;

	/**
	 * 
	 * @return
	 */
	public static PublicacaoDAO getInstance() {
		if (instance == null) {
			instance = new PublicacaoDAO();
		}
		if (conexao == null) {
			conexao = criarConexao();
		}
		return instance;
	}

	/**
	 * 
	 * @return
	 */
	public List<Publicacao> listarTodas() {
		List<Publicacao> publicacoes = null;

		publicacoes = new ArrayList<Publicacao>();
		try {

			Query<Publicacao> query = conexao.find(Publicacao.class);

			publicacoes = query.asList();

		} catch (Exception e) {
			System.out.println("Erro ao listar todas as publicacoes: " + e);
			e.printStackTrace();
		}
		return publicacoes;
	}

	/**
	 * 
	 * @param tag
	 * @return
	 */
	public Publicacao buscarPublicacaoByTag(String tag) {
		Publicacao publicacao = null;

		try {

			Query<Publicacao> query = conexao.find(Publicacao.class)
					.field("tags").contains(tag).limit(1);
			publicacao = (Publicacao) query.get();

		} catch (Exception e) {
			System.out.println("Erro ao buscar publicacao: " + e);
			e.printStackTrace();
		}
		return publicacao;
	}

	/**
	 * 
	 * @param tag
	 * @return
	 */
	public List<Publicacao> buscarPublicacoesByTag(String tag) {
		List<Publicacao> publicacoes = null;

		try {
			Query<Publicacao> query = conexao.find(Publicacao.class)
					.field("tags").contains(tag);
			publicacoes = query.asList();

		} catch (Exception e) {
			System.out.println("Erro ao buscar publicacao: " + e);
			e.printStackTrace();
		}
		return publicacoes;
	}

	/**
	 * 
	 * @param userReference
	 * @return
	 */
	public List<Publicacao> buscarPublicacoesByUserReference(
			String userReference) {
		List<Publicacao> publicacoes = null;

		try {

			Query<Publicacao> query = conexao.find(Publicacao.class).filter(
					"userReference =", userReference);
			publicacoes = query.asList();

		} catch (Exception e) {
			System.out.println("Erro ao buscar publicacao: " + e);
			e.printStackTrace();
		}
		return publicacoes;
	}

	/**
	 * 
	 * @param publicacao
	 * @param email
	 */
	public void novaPublicacaoDBREF(Publicacao publicacao, String email) {
		Usuario usuario = null;

		try {
			Query<Usuario> query = conexao.find(Usuario.class).filter(
					"email = ", email);
			usuario = (Usuario) query.get();

			publicacao.setUsuario(usuario);
			conexao.save(publicacao);

		} catch (Exception e) {
			System.out.println("Erro ao adicionar novas publicacoes: " + e);
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @param publicacao
	 */
	public void novaPublicacao(Publicacao publicacao) {
		try {
			conexao.save(publicacao);

		} catch (Exception e) {
			System.out.println("Erro ao adicionar nova publicacao: " + e);
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param publicacoes
	 */
	public void inserirPublicacoes(List<Publicacao> publicacoes) {
		try {

			for (Publicacao publicacao : publicacoes) {
				conexao.save(publicacao);
			}

		} catch (Exception e) {
			System.out.println("Erro ao adicionar nova publicacao: " + e);
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param publicacao
	 */
	public void novaPublicacaoComComentarios(Publicacao publicacao) {
		try {

			conexao.save(publicacao);

		} catch (Exception e) {
			System.out.println("Erro ao adicionar nova publicacao: " + e);
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param publicacoes
	 */
	public void inserirPublicacoesComComentarios(List<Publicacao> publicacoes) {
		try {

			for (Publicacao publicacao : publicacoes) {
				conexao.save(publicacao);

				publicacao.setComentarios(LoadHelper.carregarComentarios());
				conexao.save(publicacao);
			}

		} catch (Exception e) {
			System.out.println("Erro ao adicionar nova publicacao: " + e);
			e.printStackTrace();
		}
	}

	public void removePublicacaoByUserEmail(String email) {
		Mongo mongo = conexao.getMongo();
		
		conexao.delete(conexao.find(Publicacao.class).filter("userReference",email));
		/*
		DB mongoDb= mongo.getDB(db.getDB().getName());
		DBCollection coll = mongoDb.getCollection("Publicacao");
		
		coll.findAndRemove(new BasicDBObject("email",email));*/		
	}
	
	public void atualizaUsuarioByUserEmail(String email, String novoApelido){
		Usuario usuario = null;

		try {
				
			Mongo mongo = conexao.getMongo();
			
			DB mongoDb= mongo.getDB(conexao.getDB().getName());
			DBCollection coll = mongoDb.getCollection("usuarios");
			
			/*
			coll.findAndModify(
					new BasicDBObject("active",statusAtual), 
					null, 
					null,
					false, 
					new BasicDBObject("$set", new BasicDBObject("active",statusPosterior)),
							true, 
							true);*/
			coll.update(
					new BasicDBObject("email",email), 
					new BasicDBObject("$set", new BasicDBObject("apelido",novoApelido)),
							true, 
							true);

		} catch (Exception e) {
			System.out.println("Erro ao buscar cliente: " + e);
			e.printStackTrace();
		}
	}


}
