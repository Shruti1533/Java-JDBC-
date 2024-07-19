import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class FirstScreen {
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

        // Buttons
        JButton signInButton = new JButton("Sign In");
        JButton signUpButton = new JButton("Sign Up");

        // Add action listeners
        signInButton.addActionListener(e -> openFrame("Sign In"));
        signUpButton.addActionListener(e -> openFrame("Sign Up"));

        // Add components to main panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
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

    private static void openFrame(String action) {
        JFrame newFrame = new JFrame(action);
        newFrame.setSize(400, 300);
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.LIGHT_GRAY);

        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");

        // Set label properties
        usernameLabel.setForeground(Color.BLACK);
        passwordLabel.setForeground(Color.BLACK);
        Font labelFont = new Font("Arial", Font.BOLD, 16);
        usernameLabel.setFont(labelFont);
        passwordLabel.setFont(labelFont);

        JTextField usernameField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);

        JButton actionButton = new JButton(action);

        // Add components to panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(usernameLabel, gbc);

        gbc.gridx = 1;
        panel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        panel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(actionButton, gbc);

        newFrame.add(panel);
        newFrame.setVisible(true);
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



