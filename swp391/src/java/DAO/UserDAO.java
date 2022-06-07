/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Users;
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
public class UserDAO {
    public static ArrayList<Users> readAll() {
        Connection cn = null;
        ArrayList<Users> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select *\n"
                        + "from dbo.Users\n";
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    int userID = rs.getInt("UserId");
                    String name = rs.getString("Name");
                    String password = rs.getString("Password");
                    int status = rs.getInt("Status");
                    int departmentId = rs.getInt("DepartmentId");
                    String email = rs.getString("Email");
                    int roleId = rs.getInt("RoleId");
                    Users user = new Users(userID, name, password, status, departmentId, email, roleId);
                    list.add(user);
                }
                cn.close();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return list;
    }
    
    public static Users read(Object id) {
        Connection cn = null;
        Users user = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select * from dbo.Users where UserId=?";
                PreparedStatement stm = cn.prepareStatement(sql);
                stm.setString(1, id.toString());
                ResultSet rs = stm.executeQuery();
                if (rs.next()) {
                    user = new Users();
                    user.setUserId(rs.getInt("UserId"));
                    user.setName("Name");
                    user.setPassword("Password");
                    user.setStatus(rs.getInt("Status"));
                    user.setDepartmentId(rs.getInt("DepartmentId"));
                    user.setName("Email");
                    user.setRoleId(rs.getInt("RoleId"));
                }
                cn.close();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return user;
    }
    
    public static void create(Users user) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "insert into dbo.Users values(?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement stm = cn.prepareStatement(sql);
                stm.setInt(1, user.getUserId());
                stm.setString(2, user.getName());
                stm.setString(3, user.getPassword());
                stm.setInt(4, user.getStatus());
                stm.setInt(5, user.getDepartmentId());
                stm.setString(6, user.getEmail());
                stm.setInt(7, user.getRoleId());
                stm.executeUpdate();
                cn.close();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
    
    public static void update(Users user) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "update dbo.Users set Name=?, Password=?,Status=?,DepartmentId=?,Email=?,RoleId=? where UserId=?";
                PreparedStatement stm = cn.prepareStatement(sql);
                stm.setString(1, user.getName());
                stm.setString(2, user.getPassword());
                stm.setInt(3, user.getStatus());
                stm.setInt(4, user.getDepartmentId());
                stm.setString(5, user.getEmail());
                stm.setInt(6, user.getRoleId());
                stm.setInt(7, user.getUserId());
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
                String sql = "delete dbo.Users where UserId=?";
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
