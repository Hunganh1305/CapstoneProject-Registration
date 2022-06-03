/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author SE161740 Pham Nguyen Hung Anh
 */
@Entity
@Table(name = "Semester")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Semester.findAll", query = "SELECT s FROM Semester s")
    , @NamedQuery(name = "Semester.findBySemesterId", query = "SELECT s FROM Semester s WHERE s.semesterId = :semesterId")
    , @NamedQuery(name = "Semester.findByName", query = "SELECT s FROM Semester s WHERE s.name = :name")
    , @NamedQuery(name = "Semester.findByStartDate", query = "SELECT s FROM Semester s WHERE s.startDate = :startDate")
    , @NamedQuery(name = "Semester.findByEndDate", query = "SELECT s FROM Semester s WHERE s.endDate = :endDate")})
public class Semester implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SemesterId")
    private Integer semesterId;
    @Column(name = "Name")
    private String name;
    @Column(name = "StartDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "EndDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @JoinColumn(name = "TopicId", referencedColumnName = "TopicId")
    @ManyToOne
    private Topic topicId;
    @OneToMany(mappedBy = "semID")
    private Collection<Groups> groupsCollection;

    public Semester() {
    }

    public Semester(Integer semesterId) {
        this.semesterId = semesterId;
    }

    public Integer getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(Integer semesterId) {
        this.semesterId = semesterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Topic getTopicId() {
        return topicId;
    }

    public void setTopicId(Topic topicId) {
        this.topicId = topicId;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection() {
        return groupsCollection;
    }

    public void setGroupsCollection(Collection<Groups> groupsCollection) {
        this.groupsCollection = groupsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (semesterId != null ? semesterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Semester)) {
            return false;
        }
        Semester other = (Semester) object;
        if ((this.semesterId == null && other.semesterId != null) || (this.semesterId != null && !this.semesterId.equals(other.semesterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Semester[ semesterId=" + semesterId + " ]";
    }
    
}
