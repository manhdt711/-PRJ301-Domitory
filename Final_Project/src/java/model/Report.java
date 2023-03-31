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
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class Report extends DBContext{
    String Report_id, StuId, Bedid, Ngagy, tile, Noidung, Hianh, Status;

    public String getReport_id() {
        return Report_id;
    }

    public void setReport_id(String Report_id) {
        this.Report_id = Report_id;
    }

    public String getStuId() {
        return StuId;
    }

    public void setStuId(String StuId) {
        this.StuId = StuId;
    }

    public String getBedid() {
        return Bedid;
    }

    public void setBedid(String Bedid) {
        this.Bedid = Bedid;
    }

    public String getNgagy() {
        return Ngagy;
    }

    public void setNgagy(String Ngagy) {
        this.Ngagy = Ngagy;
    }

    public String getTile() {
        return tile;
    }

    public void setTile(String tile) {
        this.tile = tile;
    }

    public String getNoidung() {
        return Noidung;
    }

    public void setNoidung(String Noidung) {
        this.Noidung = Noidung;
    }

    public String getHianh() {
        return Hianh;
    }

    public void setHianh(String Hianh) {
        this.Hianh = Hianh;
    }

    public Connection getCnn() {
        return cnn;
    }

    public void setCnn(Connection cnn) {
        this.cnn = cnn;
    }

    public Statement getStm() {
        return stm;
    }

    public void setStm(Statement stm) {
        this.stm = stm;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public PreparedStatement getPstm() {
        return pstm;
    }

    public void setPstm(PreparedStatement pstm) {
        this.pstm = pstm;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    public Report() {
        connectDB();
    }

    public Report(String Report_id, String StuId, String Bedid, String Ngagy, String tile, String Noidung, String Hianh, String Status) {
        this.Report_id = Report_id;
        this.StuId = StuId;
        this.Bedid = Bedid;
        this.Ngagy = Ngagy;
        this.tile = tile;
        this.Noidung = Noidung;
        this.Hianh = Hianh;
        this.Status = Status;
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
    public void insert(String StuId, String Bedid, String Ngagy, String tile, String Noidung, String Hianh, String Status, ArrayList<Report> wp) {
        try{
            int Arreysize = wp.size()+1;
            String strSelect="insert into [Report] " 
                    + "values(?,?,?,?,?,?,?,?) ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, "Rp - "+String.valueOf(Arreysize));
            pstm.setString(2, StuId);
            pstm.setString(3, Bedid);
            pstm.setString(4, Ngagy);
            pstm.setString(5, tile);
            pstm.setString(6, Noidung);
            pstm.setString(7, Hianh);
            pstm.setString(8, Status);
            pstm.execute();    
        }catch(Exception e){
            System.out.println("update error : " + e.getMessage());     
            
        }
    }
    public ArrayList<Report> getAllReportbyStuID(String stuId) {
        ArrayList<Report> Reportlist = new ArrayList<>();
       try{
           String strSelect="select * from Report where StudentID=?";
           pstm=cnn.prepareStatement(strSelect);
           pstm.setString(1, stuId);
           rs=pstm.executeQuery();
           while(rs.next()){
               this.Report_id = rs.getString(1);
               this.StuId = rs.getString(2);
               this.Bedid = rs.getString(3);
               this.Ngagy = rs.getString(4);
               this.tile = rs.getString(5);
               this.Noidung = rs.getString(6);
               this.Hianh = rs.getString(7);
               this.Status = rs.getString(8);
               Report rp = new Report(Report_id, this.StuId, Bedid, Ngagy, tile, Noidung, Hianh, Status);
               Reportlist.add(rp);
           }
       }catch(Exception e){
           System.out.println("GetAll errot:" + e.getMessage());
       }
       return Reportlist;
    }

    public ArrayList<Report> getAllReport() {
         ArrayList<Report> Reportlist = new ArrayList<>();
       try{
           String strSelect="select * from Report";
           pstm=cnn.prepareStatement(strSelect);
           rs=pstm.executeQuery();
           while(rs.next()){
               this.Report_id = rs.getString(1);
               this.StuId = rs.getString(2);
               this.Bedid = rs.getString(3);
               this.Ngagy = rs.getString(4);
               this.tile = rs.getString(5);
               this.Noidung = rs.getString(6);
               this.Hianh = rs.getString(7);
               this.Status = rs.getString(8);
               Report rp = new Report(Report_id, this.StuId, Bedid, Ngagy, tile, Noidung, Hianh, Status);
               Reportlist.add(rp);
           }
       }catch(Exception e){
           System.out.println("GetAll errot:" + e.getMessage());
       }
       return Reportlist;
    }
}
