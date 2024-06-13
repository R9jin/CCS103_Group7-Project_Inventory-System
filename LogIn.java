package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class LogIn extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel logInPane;
	private JTextField txtUserId;
	private JPasswordField txtPassword;
	private JFrame frame;
	 JCheckBox seePass;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		logInPane = new JPanel();
		logInPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(logInPane);
		setLocationRelativeTo(null);
		logInPane.setLayout(null);
		
		JLabel lblUserLogInHeader = new JLabel("USER LOG IN");
		lblUserLogInHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserLogInHeader.setFont(new Font("Poppins", Font.BOLD, 30));
		lblUserLogInHeader.setBounds(10, 28, 416, 40);
		logInPane.add(lblUserLogInHeader);
		
		JLabel lblUserId = new JLabel("USER ID : ");
		lblUserId.setHorizontalAlignment(SwingConstants.LEFT);
		lblUserId.setFont(new Font("Poppins", Font.PLAIN, 20));
		lblUserId.setBounds(10, 78, 126, 40);
		logInPane.add(lblUserId);
		
		JLabel lblPassword = new JLabel("PASSWORD : ");
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
		
		JButton btnLogIn = new JButton("LOG IN");
		btnLogIn.setFont(new Font("Poppins", Font.PLAIN, 20));
		btnLogIn.setBounds(146, 228, 280, 40);
		logInPane.add(btnLogIn);
		
		seePass = new JCheckBox ("Show password");
		seePass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		seePass.setBounds(146, 178, 280, 40);
		seePass.addActionListener(this);
		this.add(seePass);
		this.setVisible(true);
		 btnLogIn.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	                String username = txtUserId.getText();
	                String password = new String(txtPassword.getPassword());
	                
	                if ("admin".equals(username) && "password".equals(password)) {
	                    JOptionPane.showMessageDialog(frame, "Login successful!");
	                  
	                } else {
	                    JOptionPane.showMessageDialog(frame, "Invalid username or password", "error", JOptionPane.ERROR_MESSAGE);
	                }
	            }
		 });
	            

					
				
	        }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==seePass) {
	                	if (seePass.isSelected()) {
	                		txtPassword.setEchoChar((char)0);
	                	}
	                	else {
	                		txtPassword.setEchoChar ('*');
	                	}
	                }
		
	}
	

				
}
