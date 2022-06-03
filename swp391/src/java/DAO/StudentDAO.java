/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Student;
import Utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author HLong
 */
public class StudentDAO {

    public static ArrayList<Student> readAll() {
        Connection cn = null;
        ArrayList<Student> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select *\n"
                        + "from dbo.Student\n";
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    int stuID = rs.getInt("StudentId");
                    String name = rs.getString("Name");
                    String password = rs.getString("Password");
                    int status = rs.getInt("Status");
                    String email = rs.getString("Email");
                    int depId = rs.getInt("DepartmentId");
                    Student stu = new Student(stuID, name, password, status, email, depId);
                    list.add(stu);
                }
                cn.close();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return list;
    }

    public static Student read(Object id) {
        Connection cn = null;
        Student student = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select * from dbo.Student where StudentId=?";
                PreparedStatement stm = cn.prepareStatement(sql);
                stm.setString(1, id.toString());
                ResultSet rs = stm.executeQuery();
                if (rs.next()) {
                    student = new Student();
                    student.setStudentId(rs.getInt("studentId"));
                    student.setName(rs.getString("name"));
                    student.setPassword(rs.getString("password"));
                    student.setStatus(rs.getInt("status"));
                    student.setEmail(rs.getString("email"));
                    student.setDepartmentId(rs.getInt("departmentId"));
                }
                cn.close();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return student;
    }

    public static void update(Student student) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "update dbo.Student set name=?,password=?,status=?,email=?,departmentId=? where StudentId=?";
                PreparedStatement stm = cn.prepareStatement(sql);
                stm.setString(1, student.getName());
                stm.setString(2, student.getPassword());
                stm.setInt(3, student.getStatus());
                stm.setString(4, student.getEmail());
                stm.setInt(5, student.getDepartmentId());
                stm.setInt(6, student.getStudentId());
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
                String sql = "delete dbo.Student where StudentId=?";
                PreparedStatement stm = cn.prepareStatement(sql);
                stm.setString(1, id.toString());
                stm.executeUpdate();
                cn.close();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void create(Student student) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "insert into dbo.Student values(?, ?, ?, ?, ?, ?)";
                PreparedStatement stm = cn.prepareStatement(sql);
                stm.setInt(1, student.getStudentId());
                stm.setString(2, student.getName());
                stm.setString(3, student.getPassword());
                stm.setInt(4,student.getStatus() );
                stm.setString(5,student.getEmail());
                stm.setInt(6, student.getDepartmentId());
                stm.executeUpdate();
                cn.close();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
