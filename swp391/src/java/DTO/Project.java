/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author HLong
 */
public class Project {
    private int projectId;
    private String description;
    private String name;
    private String sourceCode;
    private int topicId;
    private int status;
    private int groupId;
    private int lecturerId;

    public Project() {
    }

    public Project(int projectId, String description, String name, String sourceCode, int topicId, int status, int groupId) {
        this.projectId = projectId;
        this.description = description;
        this.name = name;
        this.sourceCode = sourceCode;
        this.topicId = topicId;
        this.status = status;
        this.groupId = groupId;
    }

    public Project(int projectId, String description, String name, String sourceCode, int topicId, int status, int groupId, int lecturerId) {
        this.projectId = projectId;
        this.description = description;
        this.name = name;
        this.sourceCode = sourceCode;
        this.topicId = topicId;
        this.status = status;
        this.groupId = groupId;
        this.lecturerId = lecturerId;
    }

    public int getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(int lecturerId) {
        this.lecturerId = lecturerId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
    
}
