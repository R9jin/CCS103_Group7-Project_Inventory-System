package inventoryTracker;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogBook extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel logBook;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
//		Starting data try
		String[] header = {"Product Name","Quantity", "Item Price", "Total Price"};
 		
//		Table Model
		logBook = new DefaultTableModel();
		logBook.setColumnIdentifiers(header);
		
//		Table
		table = new JTable(logBook);
		table.setBounds(10, 10, 414, 174);
		contentPane.add(table);
		
//      Scroll Pane
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(table.getBounds());
		contentPane.add(scroll);
		
		
		JButton delButton = new JButton("Delete");
		delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logBook.removeRow(table.getSelectedRow());
			}
		});
		delButton.setBounds(10, 210, 89, 23);
		contentPane.add(delButton);
		
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logBook.setRowCount(0);
			}
		});
		clearButton.setBounds(335, 210, 89, 23);
		contentPane.add(clearButton);
	}
	
	public void addItemToTable(Object[] data) {
		logBook.addRow(data);
	}

}
