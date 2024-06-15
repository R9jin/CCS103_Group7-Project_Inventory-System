package Final_Vers_StockSync_Ticao_1CS_B;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Receipt extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel receipt;
    public static JTextField customerNametxtField, contactNotxtField;

    /**
     * Launch the application.
     */
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Receipt frame = new Receipt();
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
    public Receipt() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 348);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(202, 210, 197));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel receiptHeader = new JLabel("RECEIPT");
        receiptHeader.setBounds(10, 11, 412, 41);
        receiptHeader.setFont(new Font("Poppins", Font.BOLD, 50));
        receiptHeader.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(receiptHeader);

        String[] header = {"No.","Product Name","Quantity", "Unit Price", "Total Price"};

        receipt = new DefaultTableModel();
        receipt.setColumnIdentifiers(header);

        table = new JTable(receipt);
        table.setBounds(10, 10, 414, 174);
        contentPane.add(table);

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(new Rectangle(10, 131, 414, 136));
        contentPane.add(scroll);

        JButton delButton = new JButton("Delete");
        delButton.setBackground(new Color(82, 121, 111));
        delButton.setForeground(new Color(202, 210, 197));
        delButton.setFont(new Font("Poppins", Font.PLAIN, 14));
        delButton.setBounds(10, 280, 89, 23);
        contentPane.add(delButton);

        JButton clearButton = new JButton("Clear");
        clearButton.setBackground(new Color(82, 121, 111));
        clearButton.setForeground(new Color(202, 210, 197));
        clearButton.setFont(new Font("Poppins", Font.PLAIN, 14));
        clearButton.setBounds(335, 280, 89, 23);
        contentPane.add(clearButton);

        JButton backBtn = new JButton("Back");
        backBtn.setBackground(new Color(82, 121, 111));
        backBtn.setForeground(new Color(202, 210, 197));
        backBtn.setFont(new Font("Poppins", Font.PLAIN, 14));
        backBtn.setBounds(175, 280, 89, 23);
        contentPane.add(backBtn);
        
        JPanel contactInfoPanel = new JPanel();
        contactInfoPanel.setBackground(new Color(132, 169, 140));
        contactInfoPanel.setBounds(10, 64, 414, 56);
        contentPane.add(contactInfoPanel);
        contactInfoPanel.setLayout(new GridLayout(2, 2, 20, 5));
        
        JLabel lblCustomerName = new JLabel("Customer Name:");
        lblCustomerName.setForeground(new Color(53, 79, 82));
        lblCustomerName.setFont(new Font("Poppins", Font.PLAIN, 14));
        contactInfoPanel.add(lblCustomerName);
        
        JLabel lblCustomerId = new JLabel("Customer Id:");
        lblCustomerId.setForeground(new Color(53, 79, 82));
        lblCustomerId.setFont(new Font("Poppins", Font.PLAIN, 14));
        contactInfoPanel.add(lblCustomerId);
        
        customerNametxtField = new JTextField();
        customerNametxtField.setFont(new Font("Poppins", Font.PLAIN, 12));
        customerNametxtField.setEditable(false);
        contactInfoPanel.add(customerNametxtField);
        customerNametxtField.setColumns(10);
        
        contactNotxtField = new JTextField();
        contactNotxtField.setFont(new Font("Poppins", Font.PLAIN, 12));
        contactNotxtField.setEditable(false);
        contactInfoPanel.add(contactNotxtField);
        contactNotxtField.setColumns(10);
        
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                receipt.setRowCount(0);
            }
        });
        
        delButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                receipt.removeRow(table.getSelectedRow());
            }
        });
        
        backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                MainMenu mainMenu = new MainMenu();
                mainMenu.setVisible(true);
                MainMenu.sales.setVisible(false);
                MainMenu.inventory.setVisible(false);
                removeZeroStockRows();
            }
        });
        
        
    }

    public void addItemToTable(Object[] data) {
        receipt.addRow(data);
    }
    
    private void removeZeroStockRows() {
        for (int i = 0; i < Inventory.model.getRowCount(); i++) {
            int stockInCart = Integer.parseInt(Inventory.model.getValueAt(i, 4).toString()); // Quantity in cart
            if (stockInCart == 0) {
            	Inventory.model.removeRow(i);
                i--; // Adjust index after removal
            }
        }
    }
}
