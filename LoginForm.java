import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class LoginForm {
    private static JTextField t1;
    private static JTextField t2;
    private static JTextField t3;
    private static JButton button;

    static final String url = "jdbc:mysql://localhost:3306/Student";
    static final String dbUsername = "root";
    static final String dbPassword = "new_password";

    public static void create() {
        JFrame frame = new JFrame("LOGIN FORM");
        frame.setLayout(null);

        JLabel l0 = new JLabel("Enter ID:");
        JLabel l1 = new JLabel("Enter name:");
        JLabel l2 = new JLabel("Enter class:");

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();

        button = new JButton("SAVE DATA");

        l0.setBounds(10, 10, 100, 30);
        l1.setBounds(10, 50, 100, 30);
        l2.setBounds(10, 90, 100, 30);

        t1.setBounds(120, 10, 200, 30);
        t2.setBounds(120, 50, 200, 30);
        t3.setBounds(120, 90, 200, 30);

        button.setBounds(120, 130, 120, 30);
        button.addActionListener(new ButtonClickListener());

        frame.add(l0);
        frame.add(l1);
        frame.add(l2);
        frame.add(t1);
        frame.add(t2);
        frame.add(t3);
        frame.add(button);

        frame.setSize(400, 250);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        create();
    }

    static class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button) {
                String id = t1.getText();
                String userName = t2.getText();
                String userClass = t3.getText();
                saveToDatabase(id, userName, userClass);
            }
        }
    }

    private static void saveToDatabase(String id, String userName, String userClass) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword);
            String query = "INSERT INTO table1 (id, name, class) VALUES (?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, id);
            pstmt.setString(2, userName);
            pstmt.setString(3, userClass);

            int result = pstmt.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Successfully inserted", "STATUS", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Unsuccessful insertion", "STATUS", JOptionPane.ERROR_MESSAGE);
            }
            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "STATUS", JOptionPane.ERROR_MESSAGE);
        }
    }
}