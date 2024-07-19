import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class FirstScreen {
    private static JTextField usernameField;
    private static JPasswordField passwordField;
    private static Image backgroundImage;

    public static void create() {

        // Load the background image
        try {
            backgroundImage = ImageIO.read(new File("C:\\Users\\DELL\\IdeaProjects\\JDBC Practice\\src\\welcome.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Custom panel with background image
        BackgroundPanel mainPanel = new BackgroundPanel();
        mainPanel.setLayout(new GridBagLayout());

        JFrame frame = new JFrame("The Application");
        frame.setLayout(new BorderLayout());

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // Use a proportion of the screen size (e.g., 80% of width and height)
        int width = (int) (screenSize.width * 0.8);
        int height = (int) (screenSize.height * 0.8);

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(20);
        // Password
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);

        // Set label properties
        usernameLabel.setForeground(Color.WHITE);
        passwordLabel.setForeground(Color.WHITE);
        Font labelFont = new Font("Arial", Font.BOLD, 16);
        usernameLabel.setFont(labelFont);
        passwordLabel.setFont(labelFont);

        // Buttons
        JButton signInButton = new JButton("Sign In");
        JButton signUpButton = new JButton("Sign Up");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(usernameLabel, gbc);

        gbc.gridx = 1;
        mainPanel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        mainPanel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(signInButton, gbc);

        gbc.gridx = 1;
        mainPanel.add(signUpButton, gbc);

        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setSize(width, height);

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        create();
    }

    private static class BackgroundPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }
}
