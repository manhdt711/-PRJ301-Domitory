/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author ADMIN
 */
public class Student extends DBContext{
    String StudentId, Name, Email, Gender, Balance;

    public String getStudentId() {
        return StudentId;
    }

    public void setStudentId(String StudentId) {
        this.StudentId = StudentId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getBalance() {
        return Balance;
    }

    public void setBalance(String Balance) {
        this.Balance = Balance;
    }

    public Student() {
        connectDB();
    }

    public Student(String StudentId, String Name, String Email, String Gender, String Balance) {
        this.StudentId = StudentId;
        this.Name = Name;
        this.Email = Email;
        this.Gender = Gender;
        this.Balance = Balance;
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
            System.out.println("Connext error "+e.getMessage());
        }
    }

    public void getin4ByMail(String email) {
       try{
           String sex;
           String strSelect="select * from STUDENT where Email=?";
           pstm=cnn.prepareStatement(strSelect);
           pstm.setString(1, email);
           rs=pstm.executeQuery();
           while(rs.next()){
               this.StudentId = rs.getString(1);
               this.Name = rs.getString(2);
               if(rs.getString(4).equals("F")){
                   sex = "Nữ(FEMALE)";
               }else{
                   sex = "Nam(MALE)";
               }
               this.Gender=sex;
               this.Balance = rs.getString(5);
           }
       }catch(Exception e){
           System.out.println("GetAll errot:" + e.getMessage());
       }
    }

    public void getStudentbyId(String id) {
        try{
           String sex;
           String strSelect="select * from STUDENT where StudentID=?";
           pstm=cnn.prepareStatement(strSelect);
           pstm.setString(1, id);
           rs=pstm.executeQuery();
           while(rs.next()){
               this.StudentId = rs.getString(1);
               this.Name = rs.getString(2);
               this.Email = rs.getString(3);
               if(rs.getString(4).equals("F")){
                   sex = "Nữ(FEMALE)";
               }else{
                   sex = "Nam(MALE)";
               }
               this.Gender=sex;
               this.Balance = rs.getString(5);
           }
       }catch(Exception e){
           System.out.println("GetAll errot:" + e.getMessage());
       }
    }

    public String getGenderbyId(String id) {
        String sex="";
       try{     
           String strSelect=" select Gender from STUDENT where StudentID=?";
           pstm=cnn.prepareStatement(strSelect);
           pstm.setString(1, id);
           rs=pstm.executeQuery();
           while(rs.next()){
               sex = rs.getString(1);
               }
       }catch(Exception e){
           System.out.println("GetAll errot:" + e.getMessage());
       }
       return sex;
    }

    public void ChangeBalance(String StudentID, int SoDu) {
        try{
            String strSelect="update STUDENT " 
                    + "set Balance=? "
                    + "where StudentID= ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, SoDu);
            pstm.setString(2, StudentID);
            pstm.execute();
            while(rs.next()){
                //tài khoản tồn tại
            }    
        }catch(Exception e){
            System.out.println("Update error : " + e.getMessage());  
        }  
    }
    
}
