import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginRegisterApp extends JFrame {

    private JPanel mainPanel, loginPanel, registerPanel;
    private CardLayout cardLayout;

    public LoginRegisterApp() {
        setTitle("Login & Register Application");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Menggunakan CardLayout untuk beralih antara Login dan Register
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Membuat panel login dan register
        loginPanel = createLoginPanel();
        registerPanel = createRegisterPanel();

        mainPanel.add(loginPanel, "Login");
        mainPanel.add(registerPanel, "Register");

        add(mainPanel);
        cardLayout.show(mainPanel, "Login"); // Tampilkan panel login pertama kali
    }

    private JPanel createLoginPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(173, 216, 230)); // Biru muda
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Menambahkan judul Login yang lebih terlihat
        JLabel titleLabel = new JLabel("Login");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));
        titleLabel.setForeground(new Color(0, 51, 102)); // Biru tua
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);
        gbc.gridwidth = 1;

        // Label dan Field untuk Login
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        JTextField emailField = new JTextField(20);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        JPasswordField passwordField = new JPasswordField(20);

        JButton submitLoginButton = createButton("Login");
        JButton switchToRegisterButton = createButton("Register");

        submitLoginButton.addActionListener(e -> {
            if (!emailField.getText().isEmpty() && passwordField.getPassword().length > 0) {
                JOptionPane.showMessageDialog(panel, "Login anda berhasil!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(panel, "Email dan Password harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        switchToRegisterButton.addActionListener(e -> cardLayout.show(mainPanel, "Register"));

        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(emailLabel, gbc);
        gbc.gridx = 1;
        panel.add(emailField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(passwordLabel, gbc);
        gbc.gridx = 1;
        panel.add(passwordField, gbc);

        gbc.gridy++;
        panel.add(submitLoginButton, gbc);

        gbc.gridy++;
        panel.add(switchToRegisterButton, gbc);

        return panel;
    }

    private JPanel createRegisterPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(173, 216, 230)); // Biru muda
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Menambahkan judul Register yang lebih terlihat
        JLabel titleLabel = new JLabel("Register");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));
        titleLabel.setForeground(new Color(0, 51, 102)); // Biru tua
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);
        gbc.gridwidth = 1;

        // Label dan Field untuk Register
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        JTextField nameField = new JTextField(20);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        JTextField emailField = new JTextField(20);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        JPasswordField passwordField = new JPasswordField(20);

        JButton submitRegisterButton = createButton("Register");
        JButton switchToLoginButton = createButton("Login");

        submitRegisterButton.addActionListener(e -> {
            if (!nameField.getText().isEmpty() && !emailField.getText().isEmpty() && passwordField.getPassword().length > 0) {
                JOptionPane.showMessageDialog(panel, "Registrasi berhasil!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(panel, "Semua field harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        switchToLoginButton.addActionListener(e -> cardLayout.show(mainPanel, "Login"));

        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(nameLabel, gbc);
        gbc.gridx = 1;
        panel.add(nameField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(emailLabel, gbc);
        gbc.gridx = 1;
        panel.add(emailField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(passwordLabel, gbc);
        gbc.gridx = 1;
        panel.add(passwordField, gbc);

        gbc.gridy++;
        panel.add(submitRegisterButton, gbc);

        gbc.gridy++;
        panel.add(switchToLoginButton, gbc);

        return panel;
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(0, 102, 204)); // Biru tua
        button.setForeground(Color.BLACK);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setFocusPainted(false);

        // Efek hover
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(0, 153, 255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(0, 102, 204));
            }
        });

        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            LoginRegisterApp app = new LoginRegisterApp();
            app.setVisible(true);
        });
    }
}
