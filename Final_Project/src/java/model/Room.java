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
public class Room extends DBContext {
    String BedId, RoomId,NameDom, Location, NumberBed, Price, Gender;

    public String getBedId() {
        return BedId;
    }

    public void setBedId(String BedId) {
        this.BedId = BedId;
    }

    public String getRoomId() {
        return RoomId;
    }

    public void setRoomId(String RoomId) {
        this.RoomId = RoomId;
    }

    public String getNameDom() {
        return NameDom;
    }

    public void setNameDom(String NameDom) {
        this.NameDom = NameDom;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getNumberBed() {
        return NumberBed;
    }

    public void setNumberBed(String NumberBed) {
        this.NumberBed = NumberBed;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public Room() {
        connectDB();
    }

    public Room(String BedId, String RoomId, String NameDom, String Location, String NumberBed, String Price, String Gender) {
        this.BedId = BedId;
        this.RoomId = RoomId;
        this.NameDom = NameDom;
        this.Location = Location;
        this.NumberBed = NumberBed;
        this.Price = Price;
        this.Gender = Gender;
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

    public ArrayList<Room> getAllRoombyGender(String gender) {
        ArrayList<Room> Roomlist = new ArrayList<>();
       try{
           String strSelect="SELECT Room.BedID, RoomID, [Name Dom],Room.Location,[Number Bed],Price,Gender FROM ROOM LEFT OUTER JOIN REGISTER ON ROOM.BedID = REGISTER.BedID WHERE REGISTER.BedID IS NULL and Gender=?";
           pstm=cnn.prepareStatement(strSelect);
           pstm.setString(1, gender);
           rs=pstm.executeQuery();
           while(rs.next()){
               this.BedId = rs.getString(1);
               this.RoomId = rs.getString(2);
               this.NameDom = rs.getString(3);
               this.Location = rs.getString(4);
               this.NumberBed = rs.getString(5);
               this.Price = rs.getString(6);
               this.Gender = rs.getString(7);
               Room r = new Room(BedId, RoomId, NameDom, Location, NumberBed, Price, Gender);
               Roomlist.add(r);
           }
       }catch(Exception e){
           System.out.println("GetAll errot:" + e.getMessage());
       }
       return Roomlist;
    }
    public void getRoombyID(String id) {
       try{
           String strSelect="select * from ROOM where BedID =?";
           pstm=cnn.prepareStatement(strSelect);
           pstm.setString(1, id);
           rs=pstm.executeQuery();
           while(rs.next()){
               this.BedId = rs.getString(1);
               this.RoomId = rs.getString(2);
               this.NameDom = rs.getString(3);
               this.Location = rs.getString(4);
               this.NumberBed = rs.getString(5);
               this.Price = rs.getString(6);
               this.Gender = rs.getString(7);
           }
       }catch(Exception e){
           System.out.println("GetAll errot:" + e.getMessage());
       }
    }
    
}
