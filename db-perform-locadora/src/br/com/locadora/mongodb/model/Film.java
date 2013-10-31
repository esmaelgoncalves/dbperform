/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.mongodb.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Reference;

/**
 *
 * @author ESMAEL
 */
@Entity
public class Film {
	@Id
    private Integer filmId;
    private String title;
    private String description;
    private String releaseYear;
    private Integer rentalDuration;
    private BigDecimal rentalRate;
    private Integer length;
    private BigDecimal replacementCost;
    private String rating;
    private String specialFeatures;
    private Date lastUpdate;
    private Language originalLanguageId;
    private Language languageId;
    private List<Actor> filmActorList;
    @Reference
    private Category filmCategory;

    public Film() {
    }

    public Film(Integer filmId) {
        this.filmId = filmId;
    }

    public Film(Integer filmId, String title, Integer rentalDuration, BigDecimal rentalRate, BigDecimal replacementCost, Date lastUpdate) {
        this.filmId = filmId;
        this.title = title;
        this.rentalDuration = rentalDuration;
        this.rentalRate = rentalRate;
        this.replacementCost = replacementCost;
        this.lastUpdate = lastUpdate;
    }

    
    
    public Category getFilmCategory() {
		return filmCategory;
	}

	public void setFilmCategory(Category filmCategory) {
		this.filmCategory = filmCategory;
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

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String filmAux) {
        this.releaseYear = filmAux;
    }

    public Integer getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(Integer rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public BigDecimal getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(BigDecimal rentalRate) {
        this.rentalRate = rentalRate;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public BigDecimal getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(BigDecimal replacementCost) {
        this.replacementCost = replacementCost;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Language getOriginalLanguageId() {
        return originalLanguageId;
    }

    public void setOriginalLanguageId(Language originalLanguageId) {
        this.originalLanguageId = originalLanguageId;
    }

    public Language getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Language languageId) {
        this.languageId = languageId;
    }

    public List<Actor> getFilmActorList() {
        return filmActorList;
    }

    public void setFilmActorList(List<Actor> filmActorList) {
        this.filmActorList = filmActorList;
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
        if (!(object instanceof Film)) {
            return false;
        }
        Film other = (Film) object;
        if ((this.filmId == null && other.filmId != null) || (this.filmId != null && !this.filmId.equals(other.filmId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.locadora.mysql.model.Film[ filmId=" + filmId + " ]";
    }
    
}
