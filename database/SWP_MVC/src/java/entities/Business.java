/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author SE161740 Pham Nguyen Hung Anh
 */
@Entity
@Table(name = "Business")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Business.findAll", query = "SELECT b FROM Business b")
    , @NamedQuery(name = "Business.findByBusinessId", query = "SELECT b FROM Business b WHERE b.businessId = :businessId")
    , @NamedQuery(name = "Business.findByName", query = "SELECT b FROM Business b WHERE b.name = :name")
    , @NamedQuery(name = "Business.findByPassword", query = "SELECT b FROM Business b WHERE b.password = :password")
    , @NamedQuery(name = "Business.findByEmail", query = "SELECT b FROM Business b WHERE b.email = :email")})
public class Business implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "BusinessId")
    private Integer businessId;
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @Column(name = "Password")
    private String password;
    @Column(name = "Email")
    private String email;
    @OneToMany(mappedBy = "businessId")
    private Collection<Topic> topicCollection;

    public Business() {
    }

    public Business(Integer businessId) {
        this.businessId = businessId;
    }

    public Business(Integer businessId, String password) {
        this.businessId = businessId;
        this.password = password;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<Topic> getTopicCollection() {
        return topicCollection;
    }

    public void setTopicCollection(Collection<Topic> topicCollection) {
        this.topicCollection = topicCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (businessId != null ? businessId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Business)) {
            return false;
        }
        Business other = (Business) object;
        if ((this.businessId == null && other.businessId != null) || (this.businessId != null && !this.businessId.equals(other.businessId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Business[ businessId=" + businessId + " ]";
    }
    
}
