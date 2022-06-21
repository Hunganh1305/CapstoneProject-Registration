/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Department;
import DTO.Groups;
import DTO.Project;
import DTO.StudentGroup;
import DTO.Users;
import Utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentGroupDAO {

    public static ArrayList<StudentGroup> readAll() {
        Connection cn = null;
        ArrayList<StudentGroup> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select sg.*,dep.Name as depName,gr.groupName,u.Name as leaderName,p.status as proStatus from Users u join StudentGroup sg on u.UserId = sg.StudentId			\n" +
"										join Department dep on 	u.DepartmentId = dep.DepartmentId \n" +
"										join Project p on p.GroupId = sg.GroupId\n" +
"										join Groups gr on gr.groupId = sg.GroupId where sg.LeaderStatus = 1";
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    int ID = rs.getInt("id");
                    int stuID = rs.getInt("studentId");
                    int groupId = rs.getInt("groupId");
                    int LeaderStatus = rs.getInt("leaderStatus");
                    String leaderName = rs.getString("leaderName");
                    String depName = rs.getString("depName");
                    int proStatus = rs.getInt("proStatus");
                    String groupName = rs.getString("groupName");
                    
                    Users u = new Users();
                    u.setName(leaderName);
                    Department dep = new Department();
                    dep.setName(depName);
                    Project pro = new Project();
                    pro.setStatus(proStatus);     
                    Groups gr = new Groups();
                    gr.setGroupName(groupName);
                    StudentGroup sg = new StudentGroup(ID, stuID, groupId, LeaderStatus, u, dep, pro, gr);
                    list.add(sg);
                }
                cn.close();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return list;
    }
     public static ArrayList<StudentGroup> searchGroupByName(String name){
        Connection cn = null;
        ArrayList<StudentGroup> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select sg.*,dep.Name as depName,gr.groupName,u.Name as leaderName,p.status as proStatus "
                        +       "from Users u join StudentGroup sg on u.UserId = sg.StudentId\n" +
                                "join Department dep on u.DepartmentId = dep.DepartmentId \n" +
                                "join Project p on p.GroupId = sg.GroupId\n" +
                                "join Groups gr on gr.groupId = sg.GroupId\n" +
                                "where sg.LeaderStatus = 1 and gr.groupName like ?";
                PreparedStatement stm = cn.prepareStatement(sql);
                stm.setString(1, "%" + name + "%");
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                    int ID = rs.getInt("id");
                    int stuID = rs.getInt("studentId");
                    int groupId = rs.getInt("groupId");
                    int LeaderStatus = rs.getInt("leaderStatus");
                    String leaderName = rs.getString("leaderName");
                    String depName = rs.getString("depName");
                    int proStatus = rs.getInt("proStatus");                   
                    String groupName = rs.getString("groupName");
                    
                    Users u = new Users();
                    u.setName(leaderName);
                    Department dep = new Department();
                    dep.setName(depName);
                    Project pro = new Project();
                    pro.setStatus(proStatus);     
                    Groups gr = new Groups();
                    gr.setGroupName(groupName);
                    
                    StudentGroup sg = new StudentGroup(ID, stuID, groupId, LeaderStatus, u, dep, pro, gr);
                    list.add(sg);
                }
                cn.close();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return list;
     }
     
     public static ArrayList<StudentGroup> filterByDepartment(String name) {
        Connection cn = null;
        ArrayList<StudentGroup> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select sg.*,dep.Name as depName,gr.groupName,u.Name as leaderName,p.status as proStatus "
                        +       "from Users u join StudentGroup sg on u.UserId = sg.StudentId\n" +
                                "join Department dep on u.DepartmentId = dep.DepartmentId \n" +
                                "join Project p on p.GroupId = sg.GroupId\n" +
                                "join Groups gr on gr.groupId = sg.GroupId\n" +
                                "where sg.LeaderStatus = 1 and dep.Name like ?";
                PreparedStatement stm = cn.prepareStatement(sql);
                stm.setString(1, "%" + name + "%");
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                    int ID = rs.getInt("id");
                    int stuID = rs.getInt("studentId");
                    int groupId = rs.getInt("groupId");
                    int LeaderStatus = rs.getInt("leaderStatus");
                    String leaderName = rs.getString("leaderName");
                    String depName = rs.getString("depName");
                    int proStatus = rs.getInt("proStatus");                   
                    String groupName = rs.getString("groupName");
                    
                    Users u = new Users();
                    u.setName(leaderName);
                    Department dep = new Department();
                    dep.setName(depName);
                    Project pro = new Project();
                    pro.setStatus(proStatus);     
                    Groups gr = new Groups();
                    gr.setGroupName(groupName);
                    
                    StudentGroup sg = new StudentGroup(ID, stuID, groupId, LeaderStatus, u, dep, pro, gr);
                    list.add(sg);
                }
                cn.close();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return list;
    }
     
     public static int count() {
        Connection cn = null;
        int count = 0;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select count(GroupId) as GroupId from dbo.Groups ";
                PreparedStatement stm = cn.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                    count = rs.getInt("groups");
                }
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return count;
    }
     

    public static StudentGroup read(Object id) {
        Connection cn = null;
        StudentGroup stuGroup = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select * from dbo.StudentGroup where Id=?";
                PreparedStatement stm = cn.prepareStatement(sql);
                stm.setString(1, id.toString());
                ResultSet rs = stm.executeQuery();
                if (rs.next()) {
                    stuGroup = new StudentGroup();
                    stuGroup.setId(rs.getInt("id"));
                    stuGroup.setStudentId(rs.getInt("studentId"));
                    stuGroup.setGroupId(rs.getInt("groupId"));
                    stuGroup.setLeaderStatus(rs.getInt("leaderStatus"));
                }
                cn.close();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return stuGroup;
    }

    public static void update(StudentGroup studentGroup) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "update dbo.StudentGroup set StudentId=?,GroupId=?,LeaderStatus=? where Id=?";
                PreparedStatement stm = cn.prepareStatement(sql);
                stm.setInt(1, studentGroup.getStudentId());
                stm.setInt(2, studentGroup.getGroupId());
                stm.setInt(3, studentGroup.getLeaderStatus());
                stm.setInt(4, studentGroup.getId());
                stm.executeUpdate();
                cn.close();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

    }

    public static void create(StudentGroup studentGroup) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "insert into dbo.StudentGroup values(?, ?, ?, ?)";
                PreparedStatement stm = cn.prepareStatement(sql);
                stm.setInt(1, studentGroup.getId());
                stm.setInt(2, studentGroup.getStudentId());
                stm.setInt(3, studentGroup.getGroupId());
                stm.setInt(4, studentGroup.getLeaderStatus());
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
                String sql = "delete dbo.StudentGroup where Id=?";
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
