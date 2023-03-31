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
public class History extends DBContext{
    String StudentId, BedId, CheckDate, Price, Semester, YearOfSemester, sta;

    public String getStudentId() {
        return StudentId;
    }

    public void setStudentId(String StudentId) {
        this.StudentId = StudentId;
    }

    public String getBedId() {
        return BedId;
    }

    public void setBedId(String BedId) {
        this.BedId = BedId;
    }

    public String getCheckDate() {
        return CheckDate;
    }

    public void setCheckDate(String CheckDate) {
        this.CheckDate = CheckDate;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String Semester) {
        this.Semester = Semester;
    }

    public String getYearOfSemester() {
        return YearOfSemester;
    }

    public void setYearOfSemester(String YearOfSemester) {
        this.YearOfSemester = YearOfSemester;
    }

    public String getSta() {
        return sta;
    }

    public void setSta(String sta) {
        this.sta = sta;
    }

    public History() {
        connectDB();
    }

    public History(String StudentId, String BedId, String CheckDate, String Price, String Semester, String YearOfSemester, String sta) {
        this.StudentId = StudentId;
        this.BedId = BedId;
        this.CheckDate = CheckDate;
        this.Price = Price;
        this.Semester = Semester;
        this.YearOfSemester = YearOfSemester;
        this.sta = sta;
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
    public void insert(String StudentId, String BedId, String CheckDate, String Price, String Semester, String YearOfSemester, String sta) {
        try{
            String strSelect="insert into [History-Res] " 
                    + "values(?,?,?,?,?,?,?) ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, StudentId);
            pstm.setString(2, BedId);
            pstm.setString(3, CheckDate);
            pstm.setString(4, Price);
            pstm.setString(5, Semester);
            pstm.setString(6, YearOfSemester);
            pstm.setString(7, sta);
            pstm.execute();    
        }catch(Exception e){
            System.out.println("update error : " + e.getMessage());     
            
        }
        
    }
    public ArrayList<History> getAllHisbyGender(String StuId) {
        ArrayList<History> HisList = new ArrayList<>();
       try{
           String strSelect="select * from [History-Res] where StudentID= ?";
           pstm=cnn.prepareStatement(strSelect);
           pstm.setString(1, StuId);
           rs=pstm.executeQuery();
           while(rs.next()){
               this.StudentId = rs.getString(1);
               this.BedId = rs.getString(2);
               this.CheckDate = rs.getString(3);
               this.Price = rs.getString(4);
               this.Semester = rs.getString(5);
               this.YearOfSemester = rs.getString(6);
               this.sta = rs.getString(7);
               History h = new History(StudentId, BedId, CheckDate, Price, Semester, YearOfSemester, sta);
               HisList.add(h);
           }
       }catch(Exception e){
           System.out.println("GetAll errot:" + e.getMessage());
       }
       return HisList;
    }
}
