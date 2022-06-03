/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.StudentGroup;
import Utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
