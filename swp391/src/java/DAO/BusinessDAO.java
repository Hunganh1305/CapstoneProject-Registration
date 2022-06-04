/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Business;
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
public class BusinessDAO {
    
    public static ArrayList<Business> readAll() {
        Connection cn = null;
        ArrayList<Business> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select *\n"
                        + "from dbo.Business\n";
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    int businessId = rs.getInt("BusinessId");
                    String name = rs.getString("Name");
                    String password = rs.getString("Password");
                    String email = rs.getString("email");
                    Business business = new Business(businessId, name, password, email);
                    list.add(business);
                }
                cn.close();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return list;
    }
    
    public static Business read(Object id) {
        Connection cn = null;
        Business business = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select * from dbo.Business where BusinessId=?";
                PreparedStatement stm = cn.prepareStatement(sql);
                stm.setString(1, id.toString());
                ResultSet rs = stm.executeQuery();
                if (rs.next()) {
                    business = new Business();
                    business.setBusinessId(rs.getInt("BusinessId"));
                    business.setName(rs.getString("Name"));
                    business.setPassword(rs.getString("Password"));
                    business.setEmail(rs.getString("Email"));
                }
                cn.close();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return business;
    }
    
    public static void create(Business business) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "insert into dbo.Business values(?, ?, ?, ?)";
                PreparedStatement stm = cn.prepareStatement(sql);
                stm.setInt(1, business.getBusinessId());
                stm.setString(2, business.getName());
                stm.setString(3, business.getPassword());
                stm.setString(4, business.getEmail());
                stm.executeUpdate();
                cn.close();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
    
    public static void update(Business business) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "update dbo.Business set Name=?,Password=?,Email=? where BusinessId=?";
                PreparedStatement stm = cn.prepareStatement(sql);
                stm.setString(1, business.getName());
                stm.setString(2, business.getPassword());
                stm.setString(3, business.getEmail());
                stm.setInt(4, business.getBusinessId());

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
                String sql = "delete dbo.Business where BusinessId=?";
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
