/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Student;
import Utils.DBUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author HLong
 */
public class StudentDAO {
    public static ArrayList<Student> getStudents(){
        Connection cn=null;
        ArrayList<Student> list=new ArrayList<>();
        try {
            cn=DBUtils.makeConnection();
            if(cn!=null){
                String sql="select *\n"
                        +"from dbo.Student\n";
                Statement st=cn.createStatement();
                ResultSet rs=st.executeQuery(sql);
                while (rs.next()) {                    
                    int stuID=rs.getInt("StudentId");
                    String name=rs.getString("Name");
                    String password=rs.getString("Password");
                    int status=rs.getInt("Status");
                    String email=rs.getString("Email");
                    int depId=rs.getInt("DepartmentId");
                    Student stu=new Student(stuID, name, password, status, email, depId);
                    list.add(stu);
                }
                cn.close();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return list;
    }
}
