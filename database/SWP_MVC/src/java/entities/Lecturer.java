/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "Lecturer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lecturer.findAll", query = "SELECT l FROM Lecturer l")
    , @NamedQuery(name = "Lecturer.findByLecturerId", query = "SELECT l FROM Lecturer l WHERE l.lecturerId = :lecturerId")
    , @NamedQuery(name = "Lecturer.findByName", query = "SELECT l FROM Lecturer l WHERE l.name = :name")
    , @NamedQuery(name = "Lecturer.findByPassword", query = "SELECT l FROM Lecturer l WHERE l.password = :password")
    , @NamedQuery(name = "Lecturer.findByStatus", query = "SELECT l FROM Lecturer l WHERE l.status = :status")
    , @NamedQuery(name = "Lecturer.findByEmail", query = "SELECT l FROM Lecturer l WHERE l.email = :email")})
public class Lecturer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "LecturerId")
    private Integer lecturerId;
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @Column(name = "Password")
    private String password;
    @Column(name = "Status")
    private Integer status;
    @Column(name = "Email")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lecturerId")
    private Collection<ProjectLecturer> projectLecturerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lecturerId")
    private Collection<LecturerTopic> lecturerTopicCollection;

    public Lecturer() {
    }

    public Lecturer(Integer lecturerId) {
        this.lecturerId = lecturerId;
    }

    public Lecturer(Integer lecturerId, String password) {
        this.lecturerId = lecturerId;
        this.password = password;
    }

    public Integer getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(Integer lecturerId) {
        this.lecturerId = lecturerId;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<ProjectLecturer> getProjectLecturerCollection() {
        return projectLecturerCollection;
    }

    public void setProjectLecturerCollection(Collection<ProjectLecturer> projectLecturerCollection) {
        this.projectLecturerCollection = projectLecturerCollection;
    }

    @XmlTransient
    public Collection<LecturerTopic> getLecturerTopicCollection() {
        return lecturerTopicCollection;
    }

    public void setLecturerTopicCollection(Collection<LecturerTopic> lecturerTopicCollection) {
        this.lecturerTopicCollection = lecturerTopicCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lecturerId != null ? lecturerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lecturer)) {
            return false;
        }
        Lecturer other = (Lecturer) object;
        if ((this.lecturerId == null && other.lecturerId != null) || (this.lecturerId != null && !this.lecturerId.equals(other.lecturerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Lecturer[ lecturerId=" + lecturerId + " ]";
    }
    
}
