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
import model.Human;

/**
 *
 * @author ADMIN
 */
public class GetSetHuman extends DBContext {

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

    public boolean checkPass2(String acc, String pass2) {
        connectDB();
        try {
            String strSelect = " select l.Acc, h.Pass2 from dbo.Human h join [login] l on h.idAcc = l.idAcc where l.Acc= ? and h.Pass2= ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, acc);
            pstm.setString(2, pass2);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //tài khoản tồn tại
                System.out.println("tai khoan nay ton tai");
                return true;
            }
        } catch (Exception e) {
            System.out.println("Login error : " + e.getMessage());
        }
        return false;
    }
    public ArrayList<Human> GetAllUserbyRole(String Role) {
        connectDB();
        ArrayList<Human> User = new ArrayList<>();
       try{
           String strSelect=" select idH, fullname, email from Human where [role]= ?";
           pstm=cnn.prepareStatement(strSelect);
           pstm.setString(1, Role);
           rs=pstm.executeQuery();
           while(rs.next()){
              String id = rs.getString(1);
              String name = rs.getString(2);
              String email = rs.getString(3);
               Human h = new Human(id, name, email);
               User.add(h);
           }
       }catch(Exception e){
           System.out.println("GetAll errot:" + e.getMessage());
       }
       return User;
    }
}
