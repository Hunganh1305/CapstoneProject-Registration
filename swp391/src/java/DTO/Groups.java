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
public class Groups {
    private int groupId;
    private String groupName;
    private int semId;

    public Groups() {
    }

    public Groups(int groupId, String groupName, int semId) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.semId = semId;
    }
    
    public Groups(int groupId, String groupName){
        this.groupId = groupId;
        this.groupName = groupName;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getSemId() {
        return semId;
    }

    public void setSemId(int semId) {
        this.semId = semId;
    }
    
}
