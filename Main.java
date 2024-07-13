import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main{
    public static void main(String[] args){
        String url="jdbc:mysql://localhost:3306/Student";
        //Student- name of database created

        String username="root";
        String password="new_password";

        try{
            Connection con= DriverManager.getConnection(url,username,password);
            System.out.println("Connection to the database is successful");
        }

        catch(SQLException e){
            System.out.println("Connection to the database failed: "+e.getMessage());
        }
    }
}