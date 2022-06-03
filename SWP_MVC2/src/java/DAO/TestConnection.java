/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Student;
import java.util.ArrayList;

/**
 *
 * @author HLong
 */
public class TestConnection {
    public static void main(String[] args) {
        ArrayList<Student> list=StudentDAO.getStudents();
        for (Student student : list) {
            System.out.println(student.getStudentId()+","+student.getName()+","+student.getPassword()+","+student.getStatus()+","+student.getEmail()+","+student.getDepartmentId());
        }
    }
}
