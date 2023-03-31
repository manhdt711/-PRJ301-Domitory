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
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class De extends DBContext {
    String ID, Name;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public De() {
        connectDB();
    }

    public De(String ID, String Name) {
        this.ID = ID;
        this.Name = Name;
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
    public ArrayList<De> getAll() {
        ArrayList<De> list = new ArrayList<>();
        try {
            String strSelect = "select * from Department";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String code = rs.getString(1);
                String stunamee = rs.getString(2);
                De d = new De(code, stunamee);
                list.add(d);
            }
        } catch (Exception e) {
            System.out.print("getAll error" + e.getMessage());
        }
        return list;
    }
}
