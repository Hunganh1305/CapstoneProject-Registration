/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Groups;
import DTO.Project;
import DTO.Users;
import Utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SE161740 Pham Nguyen Hung Anh
 */
public class ProjectDAO {
    
    public Groups readGroup(int id) {
        Groups group = null;
        Connection conn = null;
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                String sql = "SELECT Groups.GroupId ,Groups.GroupName\n"
                        + "from Users, StudentGroup AS StuGro, Groups\n"
                        + "WHERE Users.UserId = StuGro.StudentId and \n"
                        + "StuGro.GroupId = Groups.GroupId and Users.UserId = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    group = new Groups();
                    group.setGroupId(rs.getInt("GroupId"));
                    group.setGroupName(rs.getString("GroupName"));
                }
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

        return group;
    }

    public int readId(String email) {
        int Id = 0;
        Connection conn = null;
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                String sql = "select StudentGroup.GroupId\n"
                        + "  from Users, StudentGroup\n"
                        + "  WHERE Users.UserId = StudentGroup.StudentId and Users.Email = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, email);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Id = rs.getInt("GroupId");
                }
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return Id;
    }

    public List<Users> listUser(int Id) {

        ArrayList<Users> list = new ArrayList<>();

        String sql = "Select Users.Name\n"
                + "  from Users, StudentGroup as StuGro\n"
                + "  WHERE StuGro.StudentId = Users.UserId and StuGro.GroupId = ?";

        try {
            Connection conn = DBUtils.makeConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Users(rs.getString("Name")));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

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
