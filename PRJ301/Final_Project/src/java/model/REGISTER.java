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
public class REGISTER extends DBContext{
    String RoomID, StudentID, Checkin;

    public String getRoomID() {
        return RoomID;
    }

    public void setRoomID(String RoomID) {
        this.RoomID = RoomID;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String StudentID) {
        this.StudentID = StudentID;
    }

    public String getCheckin() {
        return Checkin;
    }

    public void setCheckin(String Checkin) {
        this.Checkin = Checkin;
    }

    public REGISTER() {
        connectDB();
    }

    public REGISTER(String RoomID, String StudentID, String Checkin) {
        this.RoomID = RoomID;
        this.StudentID = StudentID;
        this.Checkin = Checkin;
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
    public boolean checklogin(String Id) {
        try{
            String strSelect="select * from REGISTER where StudentID=?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, Id);
            rs = pstm.executeQuery();
            while(rs.next()){
                //tài khoản tồn tại
                return true;
            }    
        }catch(Exception e){
            System.out.println("Login error : " + e.getMessage());  
        }   
        return false;
}
    public void insert(String RoomID, String StudentID, String Checkin) {
        try{
            String strSelect="insert into REGISTER " 
                    + "values(?,?,?) ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, RoomID);
            pstm.setString(2, StudentID);
            pstm.setString(3, Checkin);
            pstm.execute();    
        }catch(Exception e){
            System.out.println("update error : " + e.getMessage());     
            
        }
    }
        public void getResbyID(String id) {
       try{
           String strSelect="select * from REGISTER where StudentID =?";
           pstm=cnn.prepareStatement(strSelect);
           pstm.setString(1, id);
           rs=pstm.executeQuery();
           while(rs.next()){
               this.RoomID = rs.getString(1);
               this.StudentID = rs.getString(2);
               this.Checkin = rs.getString(3);
           }
       }catch(Exception e){
           System.out.println("GetAll errot:" + e.getMessage());
       }
    }
        
}
