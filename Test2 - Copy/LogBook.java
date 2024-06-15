package Test2;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class LogBook extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static DefaultTableModel logBookModel;
	public static JTable logBookTable;
	
	String[] header = {"Customer Name", "Contact No.", "", "", ""};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogBook frame = new LogBook();
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
	public LogBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel receiptHeader = new JLabel("LOGBOOK");
	    receiptHeader.setBounds(10, 11, 458, 41);
	    receiptHeader.setFont(new Font("Verdana", Font.PLAIN, 50));
	    receiptHeader.setHorizontalAlignment(SwingConstants.CENTER);
	    contentPane.add(receiptHeader);
	    
	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBounds(10, 84, 458, 516);
	    contentPane.add(scrollPane);
	        
	    logBookModel = new DefaultTableModel();
	    logBookModel.setColumnIdentifiers(header);
	    
	    logBookTable = new JTable(logBookModel);
	    scrollPane.setViewportView(logBookTable);
	    
        JButton backBtn = new JButton("Back");
        backBtn.setBounds(10, 22, 89, 23);
        contentPane.add(backBtn);
        
        backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                MainMenu mainMenu = new MainMenu();
                mainMenu.setVisible(true);
                MainMenu.sales.setVisible(false);
                MainMenu.inventory.setVisible(false);
            }
        });

	}
}
