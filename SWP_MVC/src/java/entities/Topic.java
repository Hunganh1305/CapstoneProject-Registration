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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Topic")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Topic.findAll", query = "SELECT t FROM Topic t")
    , @NamedQuery(name = "Topic.findByTopicId", query = "SELECT t FROM Topic t WHERE t.topicId = :topicId")
    , @NamedQuery(name = "Topic.findByName", query = "SELECT t FROM Topic t WHERE t.name = :name")
    , @NamedQuery(name = "Topic.findByDescription", query = "SELECT t FROM Topic t WHERE t.description = :description")})
public class Topic implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TopicId")
    private Integer topicId;
    @Column(name = "Name")
    private String name;
    @Column(name = "Description")
    private String description;
    @OneToMany(mappedBy = "topicId")
    private Collection<Semester> semesterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "topicId")
    private Collection<LecturerTopic> lecturerTopicCollection;
    @OneToMany(mappedBy = "topicId")
    private Collection<Project> projectCollection;
    @JoinColumn(name = "BusinessId", referencedColumnName = "BusinessId")
    @ManyToOne
    private Business businessId;
    @JoinColumn(name = "CategoryId", referencedColumnName = "CategoryId")
    @ManyToOne
    private Category categoryId;
    @JoinColumn(name = "DepartmentId", referencedColumnName = "DepartmentId")
    @ManyToOne
    private Department departmentId;

    public Topic() {
    }

    public Topic(Integer topicId) {
        this.topicId = topicId;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Semester> getSemesterCollection() {
        return semesterCollection;
    }

    public void setSemesterCollection(Collection<Semester> semesterCollection) {
        this.semesterCollection = semesterCollection;
    }

    @XmlTransient
    public Collection<LecturerTopic> getLecturerTopicCollection() {
        return lecturerTopicCollection;
    }

    public void setLecturerTopicCollection(Collection<LecturerTopic> lecturerTopicCollection) {
        this.lecturerTopicCollection = lecturerTopicCollection;
    }

    @XmlTransient
    public Collection<Project> getProjectCollection() {
        return projectCollection;
    }

    public void setProjectCollection(Collection<Project> projectCollection) {
        this.projectCollection = projectCollection;
    }

    public Business getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Business businessId) {
        this.businessId = businessId;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public Department getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Department departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (topicId != null ? topicId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Topic)) {
            return false;
        }
        Topic other = (Topic) object;
        if ((this.topicId == null && other.topicId != null) || (this.topicId != null && !this.topicId.equals(other.topicId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Topic[ topicId=" + topicId + " ]";
    }
    
}
