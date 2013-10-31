/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.mysql.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ESMAEL
 */
@Entity
@Table(name = "film_actor")
public class FilmActor implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "filmActorList_actorId")
    private short actorId;
    @Id
    @Column(name = "Film_filmId")
    private short filmId;
    private Date lastUpdate = new Date();
    

    public FilmActor() {
    }

    

    public short getActorId() {
		return actorId;
	}



	public void setActorId(short actorId) {
		this.actorId = actorId;
	}



	public short getFilmId() {
		return filmId;
	}



	public void setFilmId(short filmId) {
		this.filmId = filmId;
	}



	public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }



	@Override
	public String toString() {
		return "FilmActor [actorId=" + actorId + ", filmId=" + filmId
				+ ", lastUpdate=" + lastUpdate + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + actorId;
		result = prime * result + filmId;
		result = prime * result
				+ ((lastUpdate == null) ? 0 : lastUpdate.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FilmActor other = (FilmActor) obj;
		if (actorId != other.actorId)
			return false;
		if (filmId != other.filmId)
			return false;
		if (lastUpdate == null) {
			if (other.lastUpdate != null)
				return false;
		} else if (!lastUpdate.equals(other.lastUpdate))
			return false;
		return true;
	}
    
}
