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
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author SE161714 Ha Anh Tu
 */
public class StudentGroupDAO {

    public static ArrayList<StudentGroup> readAll() {
        Connection cn = null;
        ArrayList<StudentGroup> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select *\n"
                        + "from dbo.StudentGroup\n";
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    int ID = rs.getInt("id");
                    int stuID = rs.getInt("studentId");
                    int groupId = rs.getInt("groupId");
                    int LeaderStatus = rs.getInt("leaderStatus");
                    StudentGroup stu = new StudentGroup(stuID, stuID, groupId, LeaderStatus);
                    list.add(stu);
                }
                cn.close();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return list;
    }
     public static Map<StudentGroup,Groups> readStudentGroupName() { //GroupName 
        Map<StudentGroup,Groups> list = new HashMap<>();
        Connection cn = null;

        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = " select StudentGroup.*,gr.GroupName \n"
                        + "  from dbo.StudentGroup, select * from dbo.Groups \n"
                        + "  where Groups.GroupId = StudentGroup.GroupId";
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {                    
                    int id = rs.getInt("id");
                    int studentId = rs.getInt("studentId");                    
                    int groupId = rs.getInt("groupId");
                    int leaderStatus = rs.getInt("leaderStatus");                                                
                    String groupName = rs.getString("groupName");                                                            
                    Groups groups = new Groups();
                    groups.setGroupName(groupName);                    
                    StudentGroup sg = new StudentGroup(id, studentId, groupId, leaderStatus);                                                          ;                    
                    list.put(sg, groups);
                }
                cn.close();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return list;
    }

    public static Map<StudentGroup, Users> readStudentGroupUser() { //Name student(Leader)
        Map<StudentGroup, Users> list = new HashMap<>();
        Connection cn = null;

        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select u.*,sg.LeaderStatus from dbo.Users u join dbo.StudentGroup sg "
                        + "on u.UserId = sg.StudentId where sg.LeaderStatus = 1 ";
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    int id = rs.getInt("id");
                    int studentId = rs.getInt("studentId");                    
                    int groupId = rs.getInt("groupId");
                    int leaderStatus = rs.getInt("leaderStatus");                                                                    
                    String StuName = rs.getString("name");
                    
                    Users user = new Users();
                    user.setName(StuName);
                    StudentGroup sg = new StudentGroup(id, studentId, groupId, leaderStatus);
                    list.put(sg, user);
                }
                cn.close();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return list;
    }
    
    public static Map<StudentGroup, Department> readStudentGroupDepartment() { //Dep Name 
        Map<StudentGroup, Department> list = new HashMap<>();
        Connection cn = null;

        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select u.*,sg.LeaderStatus,dep.Name from Users u "
                        + "join StudentGroup sg on u.UserId = sg.StudentId\n" +
                            "join Department dep on u.DepartmentId = dep.DepartmentId";
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    int id = rs.getInt("id");
                    int studentId = rs.getInt("studentId");                    
                    int groupId = rs.getInt("groupId");
                    int leaderStatus = rs.getInt("leaderStatus");                                                                    
                    String depName = rs.getString("name");
                    
                    Department dep = new Department();
                    dep.setName(depName);
                    StudentGroup sg = new StudentGroup(id, studentId, groupId, leaderStatus);
                    list.put(sg, dep);
                }
                cn.close();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return list;
    }
     public static Map<StudentGroup, Project> readStudentGroupProject() { //Project status
        Map<StudentGroup, Project> list = new HashMap<>();
        Connection cn = null;

        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select * from Project p join StudentGroup sg on p.GroupId = sg.GroupId";
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    int id = rs.getInt("id");
                    int studentId = rs.getInt("studentId");                    
                    int groupId = rs.getInt("groupId");
                    int leaderStatus = rs.getInt("leaderStatus");                                                                    
                    int proStatus = rs.getInt("status");
                    
                    Project pro = new Project();
                    pro.setStatus(proStatus);
                    StudentGroup sg = new StudentGroup(id, studentId, groupId, leaderStatus);
                    list.put(sg, pro);
                }
                cn.close();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return list;
    }
    
    

    public static Map<StudentGroup, Users> readStudentGroupLeaderByName(String name) {
        Map<StudentGroup, Users> list = new HashMap<>();
        Connection cn = null;

        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select u.*,sg.LeaderStatus from Users u join StudentGroup sg "
                            + "on u.UserId = sg.StudentId where sg.LeaderStatus = 1 and u.Name like ?";
                PreparedStatement stm = cn.prepareStatement(sql);
                stm.setString(1, "%" + name + "%");
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    int studentId = rs.getInt("studentId");                    
                    int groupId = rs.getInt("groupId");
                    int leaderStatus = rs.getInt("leaderStatus");                                                                    
                    String StuName = rs.getString("name");
                    
                    Users user = new Users();
                    user.setName(StuName);
                    StudentGroup sg = new StudentGroup(id, studentId, groupId, leaderStatus);
                    list.put(sg, user);
                }
                cn.close();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return list;
    }

    public static Map<StudentGroup, Department> readStudentGroupDepartmentByName(String name) {
        Map<StudentGroup, Department> list = new HashMap<>();
        Connection cn = null;

        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select u.*,sg.LeaderStatus,dep.Name from Users u "
                        + "join StudentGroup sg on u.UserId = sg.StudentId\n" +
                        "join Department dep on u.DepartmentId = dep.DepartmentId\n" +
                        "where dep.Name like ?";
                PreparedStatement stm = cn.prepareStatement(sql);
                stm.setString(1, "%" + name + "%");
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    int studentId = rs.getInt("studentId");                    
                    int groupId = rs.getInt("groupId");
                    int leaderStatus = rs.getInt("leaderStatus");                                                                    
                    String depName = rs.getString("name");                    
                    Department dep = new Department();
                    dep.setName(depName);
                    StudentGroup sg = new StudentGroup(id, studentId, groupId, leaderStatus);
                    list.put(sg, dep);
                }
                cn.close();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return list;
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
