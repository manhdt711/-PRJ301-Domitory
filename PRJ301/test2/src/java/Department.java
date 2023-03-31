
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
public class Department extends DBContext {

    String Id, Dep;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getDep() {
        return Dep;
    }

    public void setDep(String Dep) {
        this.Dep = Dep;
    }

    public Department() {
        connectDB();
    }

    public Department(String Id, String Dep) {
        this.Id = Id;
        this.Dep = Dep;
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

    public ArrayList<Department> getAll() {
        ArrayList<Department> list = new ArrayList<>();
        try {

            String strSelect = "select * from Department";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String dep = rs.getString(2);
                Department p = new Department(id, dep);
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println("GetAll errot:" + e.getMessage());
        }
        return list;

    }
}
