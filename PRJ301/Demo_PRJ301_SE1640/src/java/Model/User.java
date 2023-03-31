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

/**
 *
 * @author ADMIN
 */
public class User extends DBContext{
    String account,password,name,gender,dob,address;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User() {
        connectDB();
    }

    public User(String account, String password, String name, String gender, String dob, String address) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
    }

    public User(String account, String password) {
        this.account = account;
        this.password = password;
        connectDB();
    }
//khai báo các thành phần
            //kết nối db
        Connection cnn;
        //thực hiện câu lệnh sql
        Statement stm;
        //lưu trữ xử lý dữ liệu
        ResultSet rs;
        
        PreparedStatement pstm;
    private void connectDB() {

        try{
            cnn=super.connection;
            System.out.println("Connect Success");
        }catch(Exception e){
            System.out.println("Connect error"+e.getMessage());
        }
    }
        public boolean checklogin(){
//        try{
//            String strSelect="select * from Users "
//                    +"where account='"+account+"' and "
//                    + "password='"+password+"'";
//            stm=cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
//            rs=stm.executeQuery(strSelect);
//            while(rs.next()){
//                return true;
//            }
//        }catch(Exception e){
//            System.out.println("Login error:"+e.getMessage());
//        }
//        return false;
//    }
try{
            String strSelect="select * from Users "
                    +"where account=? and "
                    + "password=?";
            pstm=cnn.prepareStatement(strSelect);
            pstm.setString(1, account);
            pstm.setString(2, password);
            rs=pstm.executeQuery();
            while(rs.next()){
                return true;
            }
        }catch(Exception e){
            System.out.println("Login error:"+e.getMessage());
        }
        return false;
    }
        public boolean checkUser(String account, String dob) {
        try {
            String strSelect = "select * from Users "
                    + " where account =? and "
                    + " dateofbirth =?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, account);
             pstm.setString(2,dob);
            rs =pstm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Login error : " + e.getMessage());
        }
        return false;
    
    
    }
        public void update(String account, String newpass) {
        try {
            String strSelect = "update Users "
                     + " set password =?"
                    + " where account =? ";
                   
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, newpass);
            pstm.setString(2,account);
            pstm.execute();
            
        } catch (Exception e) {
            System.out.println("Update error : " + e.getMessage());
        }
        
    
    
    }
    
}
