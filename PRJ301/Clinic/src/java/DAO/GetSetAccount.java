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
import model.Account;

/**
 *
 * @author ADMIN
 */
public class GetSetAccount extends DBContext{
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
    //lay tat ca tai khoan
    public ArrayList<Account> getAllAccount() {
        connectDB();
         ArrayList<Account> AccountList = new ArrayList<>();
       try{
           String strSelect="select * from [login]";
           pstm=cnn.prepareStatement(strSelect);
           rs=pstm.executeQuery();
           while(rs.next()){
               Account account = new Account(rs.getString(2), rs.getString(3), rs.getString(4));
               AccountList.add(account);
           }
       }catch(Exception e){
           System.out.println("GetAll errot:" + e.getMessage());
       }
       return AccountList;
    }
    //tao tai khoan
    public void insert(String AccName, String Password, String Role, ArrayList<Account> acc) {
        connectDB();
        try{
            int raiseId = acc.size()+1;
            String strSelect="insert into [login] " 
                    + "values(?,?,?,?) ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, "acc - "+String.valueOf(raiseId));
            pstm.setString(2, AccName);
            pstm.setString(3, Password);
            pstm.setString(4, Role);
            pstm.execute();    
        }catch(Exception e){
            System.out.println("insert error : " + e.getMessage());     
        }
    }
    //kiem tra ten tai khoan da ton tai chua
    public boolean checkExistAccount(String acc) {
        connectDB();
        try {
            String strSelect = "select * from [login] "
                    + "where Acc= ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, acc);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //tài khoản tồn tại
                return true;
            }
        } catch (Exception e) {
            System.out.println("Login error : " + e.getMessage());
        }
        return false;
    }
    public String checkRoleAccount(String acc) {
        String role="";
        connectDB();
        try {
            String strSelect = "select [Role] from [login] "
                    + "where Acc= ?";
            pstm=cnn.prepareStatement(strSelect);
           pstm.setString(1, acc);
           rs=pstm.executeQuery();
           while(rs.next()){
               role = rs.getString(1);
               }
        } catch (Exception e) {
            System.out.println("Get role error : " + e.getMessage());
        }
        return role;
    }
}
