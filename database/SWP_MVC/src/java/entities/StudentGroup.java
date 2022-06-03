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
@Table(name = "StudentGroup")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentGroup.findAll", query = "SELECT s FROM StudentGroup s")
    , @NamedQuery(name = "StudentGroup.findById", query = "SELECT s FROM StudentGroup s WHERE s.id = :id")
    , @NamedQuery(name = "StudentGroup.findByLeaderStatus", query = "SELECT s FROM StudentGroup s WHERE s.leaderStatus = :leaderStatus")})
public class StudentGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "LeaderStatus")
    private Integer leaderStatus;
    @JoinColumn(name = "GroupId", referencedColumnName = "GroupId")
    @ManyToOne(optional = false)
    private Groups groupId;
    @JoinColumn(name = "StudentId", referencedColumnName = "StudentId")
    @ManyToOne(optional = false)
    private Student studentId;

    public StudentGroup() {
    }

    public StudentGroup(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLeaderStatus() {
        return leaderStatus;
    }

    public void setLeaderStatus(Integer leaderStatus) {
        this.leaderStatus = leaderStatus;
    }

    public Groups getGroupId() {
        return groupId;
    }

    public void setGroupId(Groups groupId) {
        this.groupId = groupId;
    }

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
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
        if (!(object instanceof StudentGroup)) {
            return false;
        }
        StudentGroup other = (StudentGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.StudentGroup[ id=" + id + " ]";
    }
    
}
