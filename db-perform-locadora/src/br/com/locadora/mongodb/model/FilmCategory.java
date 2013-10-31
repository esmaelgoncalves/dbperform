/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.mongodb.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ESMAEL
 */

public class FilmCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    private short actorId;
    @Id
    private short categoryId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    

    public FilmCategory() {
    }

    

    public short getActorId() {
		return actorId;
	}



	public void setActorId(short actorId) {
		this.actorId = actorId;
	}



	public short getFilmId() {
		return categoryId;
	}



	public void setFilmId(short filmId) {
		this.categoryId = filmId;
	}



	public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    
    
}
