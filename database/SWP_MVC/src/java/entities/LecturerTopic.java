/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SE161740 Pham Nguyen Hung Anh
 */
@Entity
@Table(name = "LecturerTopic")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LecturerTopic.findAll", query = "SELECT l FROM LecturerTopic l")
    , @NamedQuery(name = "LecturerTopic.findById", query = "SELECT l FROM LecturerTopic l WHERE l.id = :id")})
public class LecturerTopic implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "LecturerId", referencedColumnName = "LecturerId")
    @ManyToOne(optional = false)
    private Lecturer lecturerId;
    @JoinColumn(name = "TopicId", referencedColumnName = "TopicId")
    @ManyToOne(optional = false)
    private Topic topicId;

    public LecturerTopic() {
    }

    public LecturerTopic(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Lecturer getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(Lecturer lecturerId) {
        this.lecturerId = lecturerId;
    }

    public Topic getTopicId() {
        return topicId;
    }

    public void setTopicId(Topic topicId) {
        this.topicId = topicId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LecturerTopic)) {
            return false;
        }
        LecturerTopic other = (LecturerTopic) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.LecturerTopic[ id=" + id + " ]";
    }
    
}
