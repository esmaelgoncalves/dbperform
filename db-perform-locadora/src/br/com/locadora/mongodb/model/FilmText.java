/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.mongodb.model;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;


/**
 *
 * @author ESMAEL
 */
@Entity
public class FilmText {
	@Id
    private Integer filmId;
    private String title;
    private String description;

    public FilmText() {
    }

    public FilmText(Integer filmId) {
        this.filmId = filmId;
    }

    public FilmText(Integer filmId, String title) {
        this.filmId = filmId;
        this.title = title;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (filmId != null ? filmId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FilmText)) {
            return false;
        }
        FilmText other = (FilmText) object;
        if ((this.filmId == null && other.filmId != null) || (this.filmId != null && !this.filmId.equals(other.filmId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.locadora.mysql.model.FilmText[ filmId=" + filmId + " ]";
    }
    
}
