/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Hp
 */
public class Student extends DBContext {

    String id, name, gender, Department;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return Department;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }

    public Student() {

        connectDB();
    }

    public Student(String id, String name, String gender, String Department) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.Department = Department;
        connectDB();
    }

    Connection cnn;//ket noi db
    Statement stm;//thuc hien yeu cau lenh db
    ResultSet rs;// luu tru va su li du lieu
    PreparedStatement pstm;

    private void connectDB() {
        try {
            cnn = super.connection;
            System.out.println("connect success");
        } catch (Exception e) {
            System.out.println("Connext error " + e.getMessage());
        }
    }

    public ArrayList<Student> getAll() {
        ArrayList<Student> list = new ArrayList<>();
        try {
            String strSelect = "select * from Student";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String code = rs.getString(1);
                String stunamee = rs.getString(2);
                String stugen = "";
                if(rs.getString(3).equals("1")){
                    stugen = "true";
                }else{
                    stugen = "false";
                }
                String department = rs.getString(4);
                Student s = new Student(code, stunamee, stugen, department);
                list.add(s);
            }
        } catch (Exception e) {
            System.out.print("getAll error" + e.getMessage());
        }
        return list;
    }

    public void add(String id, String name, String gender, String department) {
    try{
            String strSelect="insert into Student " 
                    + "values(?,?,?,?) ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, id);
            pstm.setString(2, name);
            pstm.setString(3, gender);
            pstm.setString(4, department);
            pstm.executeUpdate();      
        }catch(Exception e){
            System.out.println("update error : " + e.getMessage());     
            
        }
    }
}

