package main;
	
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.GridLayout;
	
public class MainMenu extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel mainMenuPane;
	
	/**
	* Launch the application.
	*/
	public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	        public void run() {
	        try {
	                MainMenu frame = new MainMenu();
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
	public MainMenu() {
		setResizable(false);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 650, 500);
	        mainMenuPane = new JPanel();
	        mainMenuPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(mainMenuPane);
	        setLocationRelativeTo(null);
	        mainMenuPane.setLayout(null);
	
	        JPanel header = new JPanel();
	        header.setBackground(SystemColor.scrollbar);
	        header.setBounds(10, 10, 616, 80);
	        mainMenuPane.add(header);
	        header.setLayout(null);
	
	        JButton btnLogOut = new JButton("Log Out");
	        btnLogOut.setFocusable(false);
	        btnLogOut.setBorder(null);
	        btnLogOut.setBounds(10, 21, 109, 39);
	        header.add(btnLogOut);
	        btnLogOut.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                dispose(); 
	                LogIn logIn = new LogIn();  
	                logIn.setVisible(true);  
	            }
	        });
	        btnLogOut.setFont(new Font("Poppins", Font.PLAIN, 20));
	
	        JLabel lblUserId = new JLabel("Admin");
	        lblUserId.setBounds(540, 10, 66, 60);
	        lblUserId.setFont(new Font("Poppins", Font.PLAIN, 20));
	        header.add(lblUserId);
	
	        JLabel lblMainMenu = new JLabel("MAIN MENU");
	        lblMainMenu.setBounds(177, 10, 290, 60);
	        header.add(lblMainMenu);
	        lblMainMenu.setHorizontalAlignment(SwingConstants.CENTER);
	        lblMainMenu.setFont(new Font("Poppins", Font.BOLD, 50));
	
	        JPanel body = new JPanel();
	        body.setBounds(10, 100, 616, 353);
	        mainMenuPane.add(body);
	        body.setLayout(new GridLayout(2, 2, 5, 5));
	
	        JButton btnInventory = new JButton("INVENTORY");
	        btnInventory.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                dispose();  
	                Inventory inventory = new Inventory();  
	                inventory.setVisible(true);  
	            }
	        });
	        btnInventory.setFont(new Font("Poppins", Font.BOLD, 30));
	        body.add(btnInventory);
	
	        JButton btnLogBook = new JButton("LOG BOOK");
	        btnLogBook.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                dispose();  
	                LogBook logBook = new LogBook(); 
	                logBook.setVisible(true);  
	            }
	        });
	        btnLogBook.setFont(new Font("Poppins", Font.BOLD, 30));
	        body.add(btnLogBook);
	
	        JButton btnSales = new JButton("SALES");
	        btnSales.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                dispose(); 
	                LogBook logBook = new LogBook();  
	                Sales sales = new Sales(logBook);  
	                sales.setVisible(true);  
	            }
	        });
	        btnSales.setFont(new Font("Poppins", Font.BOLD, 30));
	        body.add(btnSales);
	
	        JButton btnExit = new JButton("EXIT");
	        btnExit.setFont(new Font("Poppins", Font.BOLD, 30));
	        body.add(btnExit);
	        btnExit.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                System.exit(0);  
	            }
	        });
	    }
	}
