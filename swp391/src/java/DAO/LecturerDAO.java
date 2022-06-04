/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Lecturer;
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
public class LecturerDAO {

    public static ArrayList<Lecturer> readAll() {
        Connection cn = null;
        ArrayList<Lecturer> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select *\n"
                        + "from dbo.Lecturer\n";
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    int lecturerId = rs.getInt("lecturerId");
                    String name = rs.getString("name");
                    String password = rs.getString("password");
                    int status = rs.getInt("status");
                    String email = rs.getString("email");
                    Lecturer lecturer = new Lecturer(lecturerId, name, password, status, email);
                    list.add(lecturer);
                }
                cn.close();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return list;
    }

    public static Lecturer read(Object id) {
        Connection cn = null;
        Lecturer lecturer = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select * from dbo.Lecturer where LecturerId=?";
                PreparedStatement stm = cn.prepareStatement(sql);
                stm.setString(1, id.toString());
                ResultSet rs = stm.executeQuery();
                if (rs.next()) {
                    lecturer = new Lecturer();
                    lecturer.setLecturerId(rs.getInt("lecturerId"));
                    lecturer.setName(rs.getString("name"));
                    lecturer.setPassword(rs.getString("password"));
                    lecturer.setStatus(rs.getInt("status"));
                    lecturer.setEmail(rs.getString("email"));

                }
                cn.close();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return lecturer;
    }

    public static void create(Lecturer lecturer) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "insert into dbo.Lecturer values(?, ?, ?, ?, ?, ?)";
                PreparedStatement stm = cn.prepareStatement(sql);
                stm.setInt(1, lecturer.getLecturerId());
                stm.setString(2, lecturer.getName());
                stm.setString(3, lecturer.getPassword());
                stm.setInt(4, lecturer.getStatus());
                stm.setString(5, lecturer.getEmail());

                stm.executeUpdate();
                cn.close();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void update(Lecturer lecturer) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "update dbo.Lecturer set Name=?,Password=?,Status=?,Email=? where LecturerId=?";
                PreparedStatement stm = cn.prepareStatement(sql);
                stm.setString(1, lecturer.getName());
                stm.setString(2, lecturer.getPassword());
                stm.setInt(3, lecturer.getStatus());
                stm.setString(4, lecturer.getEmail());
                stm.setInt(5, lecturer.getLecturerId());

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
                String sql = "delete dbo.Lecturer where LecturerId=?";
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
