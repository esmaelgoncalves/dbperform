/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.mysql.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author ESMAEL
 */
@Entity
public class Inventory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Integer inventoryId;
    private Date lastUpdate = new Date();
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Store storeId;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Film filmId;

    public Inventory() {
    }

    public Inventory(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Inventory(Integer inventoryId, Date lastUpdate) {
        this.inventoryId = inventoryId;
        this.lastUpdate = lastUpdate;
    }

    public Integer getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Store getStoreId() {
        return storeId;
    }

    public void setStoreId(Store storeId) {
        this.storeId = storeId;
    }

    public Film getFilmId() {
        return filmId;
    }

    public void setFilmId(Film filmId) {
        this.filmId = filmId;
    }

	@Override
	public String toString() {
		return "Inventory [inventoryId=" + inventoryId + ", lastUpdate="
				+ lastUpdate + ", storeId=" + storeId + ", filmId=" + filmId
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((filmId == null) ? 0 : filmId.hashCode());
		result = prime * result
				+ ((inventoryId == null) ? 0 : inventoryId.hashCode());
		result = prime * result
				+ ((lastUpdate == null) ? 0 : lastUpdate.hashCode());
		result = prime * result + ((storeId == null) ? 0 : storeId.hashCode());
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
		Inventory other = (Inventory) obj;
		if (filmId == null) {
			if (other.filmId != null)
				return false;
		} else if (!filmId.equals(other.filmId))
			return false;
		if (inventoryId == null) {
			if (other.inventoryId != null)
				return false;
		} else if (!inventoryId.equals(other.inventoryId))
			return false;
		if (lastUpdate == null) {
			if (other.lastUpdate != null)
				return false;
		} else if (!lastUpdate.equals(other.lastUpdate))
			return false;
		if (storeId == null) {
			if (other.storeId != null)
				return false;
		} else if (!storeId.equals(other.storeId))
			return false;
		return true;
	}

}
