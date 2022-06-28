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

}
