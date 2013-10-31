package br.com.blog.factory;

import br.com.blog.mongodb.model.Publicacao;

import com.google.code.morphia.AdvancedDatastore;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

/**
 * 
 * @author ESMAEL
 *
 */
public class ConnectionFactoryMongoDb {

	// Caminho do banco de dados.
	private static final String URL = "localhost";
	private static final String DB = "blogdb";

	/**
	 * 
	 * @return
	 */
	public static AdvancedDatastore criarConexao() {
		Mongo mongo = null;
		Morphia morphia = new Morphia();
		Datastore conexao = null;

		try {

			mongo = new MongoClient(URL);
			mongo.getDB(DB);
			conexao = null;

			morphia.mapPackage("br.com.blog.mongodb.model");
			conexao = morphia.createDatastore(mongo, DB);
			conexao.ensureIndex(Publicacao.class, "id");

		} catch (Exception e) {
			System.out.println("Erro ao criar conexao com o banco: " + URL+"/"+DB);
			e.printStackTrace();
		}

		return (AdvancedDatastore) conexao;
	}

	/**
	 * 
	 * @param conexao
	 */
	public static void fecharConexao(AdvancedDatastore conexao) {

		try {

			conexao.getMongo().close();

		} catch (Exception e) {
			System.out.println("Erro ao fechar conexao com o banco: " + URL);
		}
	}
}
