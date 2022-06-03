/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Topic;
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
public class TopicDAO {

    public static ArrayList<Topic> readAll() {
        Connection cn = null;
        ArrayList<Topic> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select *\n"
                        + "from dbo.Topic\n";
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    int topicID = rs.getInt("topicId");
                    String name = rs.getString("Name");
                    int category = rs.getInt("categoryId");
                    String description = rs.getString("description");
                    int businessId = rs.getInt("businessId");
                    int depId = rs.getInt("DepartmentId");
                    Topic topic = new Topic(topicID, name, category, description, businessId, depId);
                    list.add(topic);
                }
                cn.close();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return list;
    }

    public static Topic read(Object id) {
        Connection cn = null;
        Topic topic = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select * from dbo.Topic where TopicId=?";
                PreparedStatement stm = cn.prepareStatement(sql);
                stm.setString(1, id.toString());
                ResultSet rs = stm.executeQuery();
                if (rs.next()) {
                    topic = new Topic();
                    topic.setTopicId(rs.getInt("topicId"));
                    topic.setName(rs.getString("name"));
                    topic.setCatergoryId(rs.getInt("categoryId"));
                    topic.setDescription(rs.getString("description"));
                    topic.setBusinessId(rs.getInt("businessId"));
                    topic.setDepartmentId(rs.getInt("departmentId"));
                }
                cn.close();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return topic;
    }

    public static void create(Topic topic) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "insert into dbo.Topic values(?, ?, ?, ?, ?, ?)";
                PreparedStatement stm = cn.prepareStatement(sql);
                stm.setInt(1, topic.getTopicId());
                stm.setString(2, topic.getName());
                stm.setInt(3, topic.getCatergoryId());
                stm.setString(4, topic.getDescription());
                stm.setInt(5, topic.getBusinessId());
                stm.setInt(6, topic.getDepartmentId());
                stm.executeUpdate();
                cn.close();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void update(Topic topic) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "update dbo.Topic set Name=?,CategoryId=?,Description=?,BusinessId=?,DepartmentId=? where TopicId=?";
                PreparedStatement stm = cn.prepareStatement(sql);
                stm.setString(1, topic.getName());
                stm.setInt(2, topic.getCatergoryId());
                stm.setString(3, topic.getDescription());
                stm.setInt(4, topic.getBusinessId());
                stm.setInt(5, topic.getDepartmentId());
                stm.setInt(6, topic.getTopicId());
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
                String sql = "delete dbo.Topic where TopicId=?";
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
