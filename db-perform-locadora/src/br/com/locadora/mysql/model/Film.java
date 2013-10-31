/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.mysql.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author ESMAEL
 */
@Entity
public class Film implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private int filmId;
    private String title;
    private String description;
    private String releaseYear;
    private short rentalDuration;
    private BigDecimal rentalRate;
    private Short length;
    private BigDecimal replacementCost;
    private String rating;
    private String specialFeatures;
    private Date lastUpdate = new Date();
    @ManyToOne(fetch = FetchType.LAZY)
    private Language originalLanguageId;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Language languageId;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Actor> filmActorList;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Category filmCategory;

    public Film() {
    }

    public Film(Short filmId) {
        this.filmId = filmId;
    }

    public Film(int filmId, String title, short rentalDuration, BigDecimal rentalRate, BigDecimal replacementCost, Date lastUpdate) {
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

	public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
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

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public short getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(short rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public BigDecimal getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(BigDecimal rentalRate) {
        this.rentalRate = rentalRate;
    }

    public Short getLength() {
        return length;
    }

    public void setLength(Short length) {
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
	public String toString() {
		return "Film [filmId=" + filmId + ", title=" + title + ", description="
				+ description + ", releaseYear=" + releaseYear
				+ ", rentalDuration=" + rentalDuration + ", rentalRate="
				+ rentalRate + ", length=" + length + ", replacementCost="
				+ replacementCost + ", rating=" + rating + ", specialFeatures="
				+ specialFeatures + ", lastUpdate=" + lastUpdate
				+ ", originalLanguageId=" + originalLanguageId
				+ ", languageId=" + languageId + ", filmActorList="
				+ filmActorList + ", filmCategory=" + filmCategory + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((filmActorList == null) ? 0 : filmActorList.hashCode());
		result = prime * result
				+ ((filmCategory == null) ? 0 : filmCategory.hashCode());
		result = prime * result + filmId;
		result = prime * result
				+ ((languageId == null) ? 0 : languageId.hashCode());
		result = prime * result
				+ ((lastUpdate == null) ? 0 : lastUpdate.hashCode());
		result = prime * result + ((length == null) ? 0 : length.hashCode());
		result = prime
				* result
				+ ((originalLanguageId == null) ? 0 : originalLanguageId
						.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result
				+ ((releaseYear == null) ? 0 : releaseYear.hashCode());
		result = prime * result + rentalDuration;
		result = prime * result
				+ ((rentalRate == null) ? 0 : rentalRate.hashCode());
		result = prime * result
				+ ((replacementCost == null) ? 0 : replacementCost.hashCode());
		result = prime * result
				+ ((specialFeatures == null) ? 0 : specialFeatures.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Film other = (Film) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (filmActorList == null) {
			if (other.filmActorList != null)
				return false;
		} else if (!filmActorList.equals(other.filmActorList))
			return false;
		if (filmCategory == null) {
			if (other.filmCategory != null)
				return false;
		} else if (!filmCategory.equals(other.filmCategory))
			return false;
		if (filmId != other.filmId)
			return false;
		if (languageId == null) {
			if (other.languageId != null)
				return false;
		} else if (!languageId.equals(other.languageId))
			return false;
		if (lastUpdate == null) {
			if (other.lastUpdate != null)
				return false;
		} else if (!lastUpdate.equals(other.lastUpdate))
			return false;
		if (length == null) {
			if (other.length != null)
				return false;
		} else if (!length.equals(other.length))
			return false;
		if (originalLanguageId == null) {
			if (other.originalLanguageId != null)
				return false;
		} else if (!originalLanguageId.equals(other.originalLanguageId))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (releaseYear == null) {
			if (other.releaseYear != null)
				return false;
		} else if (!releaseYear.equals(other.releaseYear))
			return false;
		if (rentalDuration != other.rentalDuration)
			return false;
		if (rentalRate == null) {
			if (other.rentalRate != null)
				return false;
		} else if (!rentalRate.equals(other.rentalRate))
			return false;
		if (replacementCost == null) {
			if (other.replacementCost != null)
				return false;
		} else if (!replacementCost.equals(other.replacementCost))
			return false;
		if (specialFeatures == null) {
			if (other.specialFeatures != null)
				return false;
		} else if (!specialFeatures.equals(other.specialFeatures))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
    
}
