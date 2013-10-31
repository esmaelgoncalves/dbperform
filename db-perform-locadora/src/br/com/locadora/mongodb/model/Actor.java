/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.mongodb.model;

import java.util.Date;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

/**
 *
 * @author ESMAEL
 */
@Entity
public class Actor{
	@Id
    private Integer actorId;
    private String firstName;
    private String lastName;
    private Date lastUpdate = new Date();

    public Actor() {
    }

    public Actor(Integer actorId) {
        this.actorId = actorId;
    }

    public Actor(Integer actorId, String firstName, String lastName, Date lastUpdate) {
        this.actorId = actorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastUpdate = lastUpdate;
    }

    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actorId != null ? actorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actor)) {
            return false;
        }
        Actor other = (Actor) object;
        if ((this.actorId == null && other.actorId != null) || (this.actorId != null && !this.actorId.equals(other.actorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.locadora.mysql.model.Actor[ actorId=" + actorId + " ]";
    }
    
}
