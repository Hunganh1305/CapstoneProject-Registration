/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import DTO.Project;
import Utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author SE161740 Pham Nguyen Hung Anh
 */
public class ProjectDAO {
    public static ArrayList<Project> readAll() {
        Connection cn = null;
        ArrayList<Project> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select *\n"
                        + "from dbo.Project\n";
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    int projectId = rs.getInt("projectId");
                    String description = rs.getString("description");
                    String name = rs.getString("name");                    
                    String sourceCode = rs.getString("sourceCode");                    
                    int topicId = rs.getInt("topicId");                    
                    int status = rs.getInt("status");
                    int groupId = rs.getInt("groupId");
                    Project project = new Project(projectId, description, name, sourceCode, topicId, status, groupId);
                    list.add(project);
                }
                cn.close();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return list;
    }

    public static Project read(Object id) {
        Connection cn = null;
        Project project = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select * from dbo.Project where ProjectId=?";
                PreparedStatement stm = cn.prepareStatement(sql);
                stm.setString(1, id.toString());
                ResultSet rs = stm.executeQuery();
                if (rs.next()) {
                    project = new Project();
                    project.setProjectId(rs.getInt("projectId"));
                    project.setDescription(rs.getString("description"));
                    project.setName(rs.getString("name"));
                    project.setSourceCode(rs.getString("sourceCode"));                                        
                    project.setTopicId(rs.getInt("topicId"));
                    project.setStatus(rs.getInt("status"));
                    project.setGroupId(rs.getInt("groupId"));
                }
                cn.close();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return project;
    }

    public static void create(Project project) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "insert into dbo.Project values(?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement stm = cn.prepareStatement(sql);
                stm.setInt(1, project.getProjectId());
                stm.setString(2, project.getDescription());
                stm.setString(3, project.getName());
                stm.setString(4, project.getSourceCode());                
                stm.setInt(5, project.getTopicId());
                stm.setInt(6, project.getStatus());
                stm.setInt(7, project.getGroupId());
                stm.executeUpdate();
                cn.close();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void update(Project project) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "update dbo.Project set Description=?,Name=?,SourceCode=?,TopicId=?,Status=?,GroupId=? where ProjectId=?";
                PreparedStatement stm = cn.prepareStatement(sql);
                stm.setString(1, project.getDescription());
                stm.setString(2, project.getName());
                stm.setString(3, project.getSourceCode());                                
                stm.setInt(4, project.getTopicId());
                stm.setInt(5, project.getStatus());
                stm.setInt(6, project.getGroupId());
                stm.setInt(7, project.getProjectId());
                stm.executeUpdate();
                cn.close();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void delete(Object id) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "delete dbo.Project where ProjectId=?";
                PreparedStatement stm = cn.prepareStatement(sql);
                stm.setString(1, id.toString());
                stm.executeUpdate();
                cn.close();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
