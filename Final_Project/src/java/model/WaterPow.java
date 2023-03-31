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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class WaterPow extends DBContext{
    String StuId, BedId, Type, Date, Count;

    public String getStuId() {
        return StuId;
    }

    public void setStuId(String StuId) {
        this.StuId = StuId;
    }

    public String getBedId() {
        return BedId;
    }

    public void setBedId(String BedId) {
        this.BedId = BedId;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getCount() {
        return Count;
    }

    public void setCount(String Count) {
        this.Count = Count;
    }

    public WaterPow() {
        connectDB();
    }

    public WaterPow(String StuId, String BedId, String Type, String Date, String Count) {
        this.StuId = StuId;
        this.BedId = BedId;
        this.Type = Type;
        this.Date = Date;
        this.Count = Count;
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
    public void insert(String StuId, String BedId, String Type, String Date, String Count) {
        try{
            String strSelect="insert into [Power_water] " 
                    + "values(?,?,?,?,?) ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, StuId);
            pstm.setString(2, BedId);
            pstm.setString(3, Type);
            pstm.setString(4, Date);
            pstm.setString(5, Count);
            pstm.execute();    
        }catch(Exception e){
            System.out.println("update error : " + e.getMessage());     
            
        }
    }
    public ArrayList<WaterPow> getWPbyMasv(String id) {
        ArrayList<WaterPow> WPlist = new ArrayList<>();
       try{
           String strSelect="Select * from Power_water where StudentID= ?";
           pstm=cnn.prepareStatement(strSelect);
           pstm.setString(1, id);
           rs=pstm.executeQuery();
           while(rs.next()){
               this.StuId=rs.getString(1);
               this.BedId=rs.getString(2);
               this.Type=rs.getString(3);
               this.Date=rs.getString(4);
               this.Count=rs.getString(5);
               WaterPow wp = new WaterPow(StuId, BedId, Type, Date, Count);
               WPlist.add(wp);
           }
       }catch(Exception e){
           System.out.println("GetAll errot:" + e.getMessage());
       }
       return WPlist;
    }

    public int TongDien(ArrayList<WaterPow> WPlist) {
        int sum=0;
        for(WaterPow o: WPlist){
            if(o.getType().contains("Dien")){
                sum+=Integer.parseInt(o.getCount());
            }
        }
        return sum;
    }
    public int TongNuoc(ArrayList<WaterPow> WPlist) {
        int sum=0;
        for(WaterPow o: WPlist){
            if(o.getType().contains("Nuoc")){
                sum+=Integer.parseInt(o.getCount());
            }
        }
        return sum;
    }
}
