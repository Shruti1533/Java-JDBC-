import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insertion {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Student";

        String username = "root";
        String password = "new_password";
        Connection con = null;
        PreparedStatement ps = null;

        try
        {
            con = DriverManager.getConnection(url, username, password);

            String query = "INSERT INTO table1(id, name, class) VALUES (?, ?, ?)";
            ps = con.prepareStatement(query);

            ps.setInt(1, 1);
            ps.setString(2, "Abhay");
            ps.setString(3, "11");
            ps.executeUpdate();

            ps.setInt(1, 2);
            ps.setString(2, "Bob");
            ps.setString(3, "12");
            ps.executeUpdate();

            System.out.println("Data inserted successfully.");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        //To close all the resources properly
        finally
        {
            try
            {
                if (ps != null) ps.close();
                if (con != null) con.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}