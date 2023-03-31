/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Patient;

/**
 *
 * @author ADMIN
 */
public class GetSetPatient extends DBContext{
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
    public ArrayList<Patient> getPatient() {
        connectDB();
        ArrayList<Patient> User = new ArrayList<>();
       try{
           String strSelect=" select idP, fullname, email from [Patient]";
           pstm=cnn.prepareStatement(strSelect);
           rs=pstm.executeQuery();
           while(rs.next()){
              String id = rs.getString(1);
              String name = rs.getString(2);
              String email = rs.getString(3);
               Patient p = new Patient(id, name, email);
               User.add(p);
           }
       }catch(Exception e){
           System.out.println("GetAll errot:" + e.getMessage());
       }
       return User;
    }
}
