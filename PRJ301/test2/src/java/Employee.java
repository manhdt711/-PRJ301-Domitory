
import dal.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class Employee extends DBContext{
    String id, name, gender, more;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getMore() {
        return more;
    }

    public void setMore(String more) {
        this.more = more;
    }

    public Employee() {
        connectDB();
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

    public Employee(String id, String name, String gender, String more) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.more = more;
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

    ArrayList<Employee> getAll() {
       ArrayList<Employee> list = new ArrayList<>();
       try{
           
           String strSelect="select * from Employee";
           pstm=cnn.prepareStatement(strSelect);
           rs=pstm.executeQuery();
           while(rs.next()){
               String id = rs.getString(1);
               String Name = rs.getString(2);
               String gender = rs.getString(3);
               String more = rs.getString(4);
               Employee e = new Employee(id, Name, gender, more);
               list.add(e);
           }
       }catch(Exception e){
           System.out.println("GetAll errot:" + e.getMessage());
       }
        return list;
    }
    
}
