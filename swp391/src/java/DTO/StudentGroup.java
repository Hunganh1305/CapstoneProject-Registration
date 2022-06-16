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
public class StudentGroup {
    private int id;
    private int studentId;
    private int groupId;
    private int leaderStatus;
    private Users leaderName;
    private Department depName;
    private Project proStatus;
    private Groups groupName;

    public StudentGroup() {
    }

    public StudentGroup(int id, int studentId, int groupId, int leaderStatus, Users leaderName, Department depName, Project proStatus, Groups groupName) {
        this.id = id;
        this.studentId = studentId;
        this.groupId = groupId;
        this.leaderStatus = leaderStatus;
        this.leaderName = leaderName;
        this.depName = depName;
        this.proStatus = proStatus;
        this.groupName = groupName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getLeaderStatus() {
        return leaderStatus;
    }

    public void setLeaderStatus(int leaderStatus) {
        this.leaderStatus = leaderStatus;
    }

    public Users getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(Users leaderName) {
        this.leaderName = leaderName;
    }

    public Department getDepName() {
        return depName;
    }

    public void setDepName(Department depName) {
        this.depName = depName;
    }

    public Project getProStatus() {
        return proStatus;
    }

    public void setProStatus(Project proStatus) {
        this.proStatus = proStatus;
    }

    public Groups getGroupName() {
        return groupName;
    }

    public void setGroupName(Groups groupName) {
        this.groupName = groupName;
    }
    
}

   