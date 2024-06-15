package main;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Color;

public class LogIn extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel logInPane;
    private JTextField txtUserId;
    private JPasswordField txtPassword;
    private JCheckBox seePass;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LogIn frame = new LogIn();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public LogIn() {
    	setResizable(false);
    	setTitle("StockSync | Log In");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        logInPane = new JPanel();
        logInPane.setBackground(new Color(202, 210, 197));
        logInPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(logInPane);
        setLocationRelativeTo(null);
        logInPane.setLayout(null);

        JLabel lblUserLogInHeader = new JLabel("STOCKSYNC | LOG IN");
        lblUserLogInHeader.setBackground(new Color(37, 87, 122));
        lblUserLogInHeader.setForeground(new Color(53, 79, 82));
        lblUserLogInHeader.setHorizontalAlignment(SwingConstants.CENTER);
        lblUserLogInHeader.setFont(new Font("Poppins", Font.BOLD, 30));
        lblUserLogInHeader.setBounds(10, 28, 416, 40);
        logInPane.add(lblUserLogInHeader);

        JLabel lblUserId = new JLabel("USER ID : ");
        lblUserId.setBorder(null);
        lblUserId.setForeground(new Color(53, 79, 82));
        lblUserId.setHorizontalAlignment(SwingConstants.LEFT);
        lblUserId.setFont(new Font("Poppins", Font.PLAIN, 20));
        lblUserId.setBounds(10, 78, 126, 40);
        logInPane.add(lblUserId);

        JLabel lblPassword = new JLabel("PASSWORD : ");
        lblPassword.setBorder(null);
        lblPassword.setForeground(new Color(53, 79, 82));
        lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
        lblPassword.setFont(new Font("Poppins", Font.PLAIN, 20));
        lblPassword.setBounds(10, 128, 126, 40);
        logInPane.add(lblPassword);

        txtUserId = new JTextField();
        txtUserId.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtUserId.setBounds(146, 78, 279, 40);
        logInPane.add(txtUserId);
        txtUserId.setColumns(10);

        txtPassword = new JPasswordField();
        txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtPassword.setColumns(10);
        txtPassword.setBounds(146, 128, 279, 40);
        logInPane.add(txtPassword);

        JButton btnLogIn = new JButton("Log In");
        btnLogIn.setForeground(new Color(202, 210, 197));
        btnLogIn.setBackground(new Color(53, 79, 82));
        btnLogIn.setFont(new Font("Poppins", Font.PLAIN, 20));
        btnLogIn.setBounds(220, 204, 150, 33);
        logInPane.add(btnLogIn);

        seePass = new JCheckBox("Show password");
        seePass.setForeground(new Color(53, 79, 82));
        seePass.setBackground(new Color(202, 210, 197));
        seePass.setFont(new Font("Tahoma", Font.PLAIN, 20));
        seePass.setBounds(146, 178, 280, 19);
        seePass.addActionListener(this);
        logInPane.add(seePass);

        btnLogIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String username = txtUserId.getText();
                String password = new String(txtPassword.getPassword());

                if ("admin".equals(username) && "password".equals(password)) {
                    JOptionPane.showMessageDialog(null, "Login successful!");
                    LogIn.this.dispose();  
                    MainMenu mainMenu = new MainMenu();
                    mainMenu.setVisible(true);  
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password", "error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == seePass) {
            if (seePass.isSelected()) {
                txtPassword.setEchoChar((char) 0);
            } else {
                txtPassword.setEchoChar('*');
            }
        }
    }
}
