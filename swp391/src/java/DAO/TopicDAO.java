/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Category;
import DTO.Department;
import DTO.Topic;
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
public class TopicDAO {

    public static ArrayList<Topic> readAll() {
        Connection cn = null;
        ArrayList<Topic> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "  select ltt.*,d.Name as DepartmentName,u.Name as LecturerName\n"
                        + "  from (select t.*,lt.LecturerId from dbo.LecturerTopic lt join dbo.Topic t on lt.TopicId = t.TopicId) ltt \n"
                        + "  join dbo.Users u on ltt.LecturerId=u.UserId \n"
                        + "  join dbo.Department d on ltt.DepartmentId=d.DepartmentId";
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    int topicID = rs.getInt("topicId");
                    String name = rs.getString("Name");
                    int category = rs.getInt("categoryId");
                    String description = rs.getString("description");
                    int businessId = rs.getInt("businessId");
                    int depId = rs.getInt("DepartmentId");
                    String depName = rs.getString("DepartmentName");
                    String lecName = rs.getString("LecturerName");
                    Users user = new Users();
                    Department dep = new Department();
                    dep.setName(depName);
                    user.setName(lecName);
                    Topic topic = new Topic(topicID, name, category, description, businessId, depId, user, dep);
                    list.add(topic);
                }
                cn.close();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return list;
    }

    public static ArrayList<Topic> searchByName(String name) {
        Connection cn = null;
        ArrayList<Topic> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "   select ltt.*,d.Name as DepartmentName,u.Name as LecturerName\n"
                        + "  from (select t.*,lt.LecturerId from dbo.LecturerTopic lt join dbo.Topic t on lt.TopicId = t.TopicId) ltt \n"
                        + "  join dbo.Users u on ltt.LecturerId=u.UserId \n"
                        + "  join dbo.Department d on ltt.DepartmentId=d.DepartmentId\n"
                        + "  where ltt.name like ?";
                PreparedStatement stm = cn.prepareStatement(sql);
                stm.setString(1, "%" + name + "%");
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                    int topicID = rs.getInt("topicId");
                    String topicName = rs.getString("Name");
                    int category = rs.getInt("categoryId");
                    String description = rs.getString("description");
                    int businessId = rs.getInt("businessId");
                    int depId = rs.getInt("DepartmentId");
                    String depName = rs.getString("DepartmentName");
                    String lecName = rs.getString("LecturerName");
                    Users user = new Users();
                    Department dep = new Department();
                    dep.setName(depName);
                    user.setName(lecName);
                    Topic topic = new Topic(topicID, topicName, category, description, businessId, depId, user, dep);
                    list.add(topic);
                }
                cn.close();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return list;
    }

    public static ArrayList<Topic> filterByDepartment(String name) {
        Connection cn = null;
        ArrayList<Topic> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "   select ltt.*,d.Name as DepartmentName,u.Name as LecturerName\n"
                        + "  from (select t.*,lt.LecturerId from dbo.LecturerTopic lt join dbo.Topic t on lt.TopicId = t.TopicId) ltt \n"
                        + "  join dbo.Users u on ltt.LecturerId=u.UserId \n"
                        + "  join dbo.Department d on ltt.DepartmentId=d.DepartmentId\n"
                        + "  where d.Name like ?";
                PreparedStatement stm = cn.prepareStatement(sql);
                stm.setString(1, "%" + name + "%");
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                    int topicID = rs.getInt("topicId");
                    String topicName = rs.getString("Name");
                    int category = rs.getInt("categoryId");
                    String description = rs.getString("description");
                    int businessId = rs.getInt("businessId");
                    int depId = rs.getInt("DepartmentId");
                    String depName = rs.getString("DepartmentName");
                    String lecName = rs.getString("LecturerName");
                    Users user = new Users();
                    Department dep = new Department();
                    dep.setName(depName);
                    user.setName(lecName);
                    Topic topic = new Topic(topicID, topicName, category, description, businessId, depId, user, dep);
                    list.add(topic);
                }
                cn.close();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return list;
    }

    public static Category readCategoryByTopicId(int id) {
        Connection cn = null;
        Category cate = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "  select c.*\n"
                        + "  from dbo.Topic t join dbo.Category c on t.CategoryId=c.CategoryId\n"
                        + "  where t.TopicId=?";
                PreparedStatement stm = cn.prepareStatement(sql);
                stm.setInt(1, id);
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                    int cateId = rs.getInt("CategoryId");
                    String cateName = rs.getString("CategoryName");
                    cate = new Category(cateId, cateName);
                }
                cn.close();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return cate;

    }

    public static Topic readById(int id) {
        Connection cn = null;
        Topic topic = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "    select ltt.*,d.Name as DepartmentName,u.Name as LecturerName\n"
                        + "  from (select t.*,lt.LecturerId from dbo.LecturerTopic lt join dbo.Topic t on lt.TopicId = t.TopicId) ltt \n"
                        + "  join dbo.Users u on ltt.LecturerId=u.UserId \n"
                        + "  join dbo.Department d on ltt.DepartmentId=d.DepartmentId\n"
                        + "  where ltt.TopicId=?";
                PreparedStatement stm = cn.prepareStatement(sql);
                stm.setInt(1, id);
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                    int topicID = rs.getInt("topicId");
                    String topicName = rs.getString("Name");
                    int category = rs.getInt("categoryId");
                    String description = rs.getString("description");
                    int businessId = rs.getInt("businessId");
                    int depId = rs.getInt("DepartmentId");
                    String depName = rs.getString("DepartmentName");
                    String lecName = rs.getString("LecturerName");
                    Users user = new Users();
                    Department dep = new Department();
                    dep.setName(depName);
                    user.setName(lecName);
                    topic = new Topic(topicID, topicName, category, description, businessId, depId, user, dep);

                }
                cn.close();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return topic;
    }

    public static ArrayList<Topic> findRange(int n1, int n2) {
        Connection cn = null;
        ArrayList<Topic> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "  select ltt.*,d.Name as DepartmentName,u.Name as LecturerName\n"
                        + "  from (select t.*,lt.LecturerId from dbo.LecturerTopic lt join dbo.Topic t on lt.TopicId = t.TopicId) ltt \n"
                        + "  join dbo.Users u on ltt.LecturerId=u.UserId \n"
                        + "  join dbo.Department d on ltt.DepartmentId=d.DepartmentId														   \n"
                        + "  WHERE ltt.TopicId BETWEEN ? and ?";
                PreparedStatement stm = cn.prepareStatement(sql);
                stm.setInt(1, n1);
                stm.setInt(2, n2);
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                    int topicID = rs.getInt("topicId");
                    String name = rs.getString("Name");
                    int category = rs.getInt("categoryId");
                    String description = rs.getString("description");
                    int businessId = rs.getInt("businessId");
                    int depId = rs.getInt("DepartmentId");
                    String depName = rs.getString("DepartmentName");
                    String lecName = rs.getString("LecturerName");
                    Users user = new Users();
                    Department dep = new Department();
                    dep.setName(depName);
                    user.setName(lecName);
                    Topic topic = new Topic(topicID, name, category, description, businessId, depId, user, dep);
                    list.add(topic);
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
                String sql = "select count(TopicId) as topics from dbo.topic";
                PreparedStatement stm = cn.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                    count = rs.getInt("topics");
                }
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return count;
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
