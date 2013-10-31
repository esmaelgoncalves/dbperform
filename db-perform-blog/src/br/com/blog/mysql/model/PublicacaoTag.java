/**
 * 
 */
package br.com.blog.mysql.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ESMAEL
 *
 */

@Entity
@Table(name = "publicacao_tag")
public class PublicacaoTag implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "Publicacao_id_publicacao")
    private int id_publicacao;
	@Id
	@Column(name = "tags_id_tag")
    private int id_tag;
	
	public int getId_publicacao() {
		return id_publicacao;
	}
	public void setId_publicacao(int id_publicacao) {
		this.id_publicacao = id_publicacao;
	}
	public int getId_tag() {
		return id_tag;
	}
	public void setId_tag(int id_tag) {
		this.id_tag = id_tag;
	}


	
}
