package Final_Vers_StockSync_Ticao_1CS_B;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inventory extends JFrame {

    private static final long serialVersionUID = 1L;
    public static JPanel contentPane;
    public static JTable productTable;
    public static DefaultTableModel model;

    public static String[][] data = {
    	    {"", "Tenacity Pants", "Clothes", "Pants", "100", "29.99", "2999.00"},
    	    {"", "Hunter Pants", "Clothes", "Pants", "80", "35.99", "2879.20"},
    	    {"", "Royal Pants", "Clothes", "Pants", "60", "40.00", "2400.00"},
    	    
    	    {"", "Cotton Shirt", "Clothes", "Shirts", "150", "19.99", "2998.50"},
    	    {"", "Silk Shirt", "Clothes", "Shirts", "120", "29.99", "3598.80"},
    	    {"", "Linen Shirt", "Clothes", "Shirts", "100", "30.00", "3000.00"},
    	    
    	    {"", "Winter Jacket", "Clothes", "Jackets", "50", "59.99", "2999.50"},
    	    {"", "Rain Jacket", "Clothes", "Jackets", "70", "49.99", "3499.30"},
    	    {"", "Windbreaker", "Clothes", "Jackets", "90", "45.00", "4050.00"},
    	    
    	    {"", "Apple", "Food", "Fruits", "200", "1.99", "398.00"},
    	    {"", "Banana", "Food", "Fruits", "300", "0.99", "297.00"},
    	    {"", "Orange", "Food", "Fruits", "250", "1.49", "372.50"},
    	    
    	    {"", "Carrot", "Food", "Vegetables", "180", "0.59", "106.20"},
    	    {"", "Broccoli", "Food", "Vegetables", "160", "1.20", "192.00"},
    	    {"", "Spinach", "Food", "Vegetables", "200", "1.00", "200.00"},
    	    
    	    {"", "Chips", "Food", "Snacks", "300", "2.49", "747.00"},
    	    {"", "Cookies", "Food", "Snacks", "280", "3.00", "840.00"},
    	    {"", "Candy", "Food", "Snacks", "320", "1.99", "636.80"},
    	    
    	    {"", "Paracetamol", "Medicine", "Painkillers", "120", "5.99", "718.80"},
    	    {"", "Ibuprofen", "Medicine", "Painkillers", "110", "7.99", "878.90"},
    	    {"", "Aspirin", "Medicine", "Painkillers", "130", "8.50", "1105.00"},
    	    
    	    {"", "Amoxicillin", "Medicine", "Antibiotics", "90", "12.99", "1169.10"},
    	    {"", "Ciprofloxacin", "Medicine", "Antibiotics", "70", "15.99", "1119.30"},
    	    {"", "Azithromycin", "Medicine", "Antibiotics", "60", "10.00", "600.00"},
    	    
    	    {"", "Vitamin C", "Medicine", "Vitamins", "200", "9.99", "1998.00"},
    	    {"", "Vitamin D", "Medicine", "Vitamins", "220", "8.99", "1977.80"},
    	    {"", "Multivitamin", "Medicine", "Vitamins", "180", "11.50", "2070.00"}};

    
    String [] header = {"No.", "Product Name", "Category", "Sub-Category", "Stock", "Unit Price", "Total Price"};
    
    private JTextField productNameTxtField;
    private JTextField stockTxtField;
    private JTextField priceTxtField;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Inventory frame = new Inventory();
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
    public Inventory() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 963, 687);
        setTitle("StockSync | Inventory");
        setResizable(false);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(202, 210, 197));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        model = new DefaultTableModel(data, header);

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(132, 169, 140));
        headerPanel.setBounds(23, 11, 906, 69);
        contentPane.add(headerPanel);
        headerPanel.setLayout(null);

        JLabel ìnventoryHeader = new JLabel("INVENTORY");
        ìnventoryHeader.setForeground(new Color(53, 79, 82));
        ìnventoryHeader.setBounds(253, 11, 449, 41);
        headerPanel.add(ìnventoryHeader);
        ìnventoryHeader.setFont(new Font("Poppins", Font.BOLD, 40));
        ìnventoryHeader.setHorizontalAlignment(SwingConstants.CENTER);

        JButton backBtn = new JButton("Back");
        backBtn.setBackground(new Color(82, 121, 111));
        backBtn.setForeground(new Color(202, 210, 197));
        backBtn.setFont(new Font("Poppins", Font.PLAIN, 26));
        backBtn.setBounds(10, 11, 137, 41);
        headerPanel.add(backBtn);
        backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainMenu mainMenu = new MainMenu();
                mainMenu.setVisible(true);
            }
        });

        JPanel productListPanel = new JPanel();
        productListPanel.setBackground(new Color(132, 169, 140));
        productListPanel.setBounds(23, 91, 619, 546);
        contentPane.add(productListPanel);
        productListPanel.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 40, 599, 495);
        productListPanel.add(scrollPane);
        scrollPane.getViewport().setBackground(Color.WHITE);

        productTable = new JTable(model);
        productTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        scrollPane.setViewportView(productTable);

        JLabel productListLbl = new JLabel("Product List");
        productListLbl.setForeground(new Color(53, 79, 82));
        productListLbl.setHorizontalAlignment(SwingConstants.CENTER);
        productListLbl.setFont(new Font("Poppins", Font.PLAIN, 26));
        productListLbl.setBounds(234, 12, 171, 18);
        productListPanel.add(productListLbl);

        JPanel addProductPanel = new JPanel();
        addProductPanel.setBackground(new Color(132, 169, 140));
        addProductPanel.setBounds(652, 91, 277, 143);
        contentPane.add(addProductPanel);
        addProductPanel.setLayout(null);

        JButton addProductBtn = new JButton("ADD PRODUCT");
        addProductBtn.setForeground(new Color(202, 210, 197));
        addProductBtn.setBackground(new Color(82, 121, 111));
        addProductBtn.setFont(new Font("Poppins", Font.PLAIN, 26));
        addProductBtn.setBounds(10, 28, 253, 83);
        addProductPanel.add(addProductBtn);

        JPanel optionsPanel = new JPanel();
        optionsPanel.setBackground(new Color(132, 169, 140));
        optionsPanel.setBounds(652, 245, 277, 392);
        contentPane.add(optionsPanel);
        optionsPanel.setLayout(null);

        JLabel productNameLbl = new JLabel("Product Name");
        productNameLbl.setForeground(new Color(53, 79, 82));
        productNameLbl.setHorizontalAlignment(SwingConstants.CENTER);
        productNameLbl.setFont(new Font("Poppins", Font.PLAIN, 24));
        productNameLbl.setBounds(55, 46, 171, 18);
        optionsPanel.add(productNameLbl);

        JLabel stockLbl = new JLabel("Stock");
        stockLbl.setForeground(new Color(53, 79, 82));
        stockLbl.setHorizontalAlignment(SwingConstants.CENTER);
        stockLbl.setFont(new Font("Poppins", Font.PLAIN, 24));
        stockLbl.setBounds(30, 157, 86, 18);
        optionsPanel.add(stockLbl);

        JLabel priceLbl = new JLabel("Price");
        priceLbl.setForeground(new Color(53, 79, 82));
        priceLbl.setHorizontalAlignment(SwingConstants.CENTER);
        priceLbl.setFont(new Font("Poppins", Font.PLAIN, 24));
        priceLbl.setBounds(177, 157, 60, 18);
        optionsPanel.add(priceLbl);

        productNameTxtField = new JTextField();
        productNameTxtField.setFont(new Font("Poppins", Font.PLAIN, 12));
        productNameTxtField.setBounds(10, 75, 257, 37);
        optionsPanel.add(productNameTxtField);
        productNameTxtField.setColumns(10);

        stockTxtField = new JTextField();
        stockTxtField.setFont(new Font("Poppins", Font.PLAIN, 12));
        stockTxtField.setHorizontalAlignment(SwingConstants.LEFT);
        stockTxtField.setBounds(10, 186, 125, 20);
        optionsPanel.add(stockTxtField);
        stockTxtField.setColumns(10);

        priceTxtField = new JTextField();
        priceTxtField.setFont(new Font("Poppins", Font.PLAIN, 12));
        priceTxtField.setColumns(10);
        priceTxtField.setBounds(145, 186, 122, 20);
        optionsPanel.add(priceTxtField);

        JPanel options = new JPanel();
        options.setBackground(new Color(202, 210, 197));
        options.setBounds(10, 217, 257, 135);
        optionsPanel.add(options);
        options.setLayout(new GridLayout(1, 0, 5, 5));

        JButton updateBtn = new JButton("Update Product");
        updateBtn.setForeground(new Color(202, 210, 197));
        updateBtn.setBackground(new Color(82, 121, 111));
        options.add(updateBtn);
        updateBtn.setFont(new Font("Poppins", Font.PLAIN, 11));

        JButton deleteBtn = new JButton("Delete Product");
        deleteBtn.setForeground(new Color(202, 210, 197));
        deleteBtn.setBackground(new Color(82, 121, 111));
        options.add(deleteBtn);
        deleteBtn.setFont(new Font("Poppins", Font.PLAIN, 11));

        addProductBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AddProduct().setVisible(true);
            }
        });

        productTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = productTable.getSelectedRow();
                if (selectedRow != -1) {
                    String productName = (String) model.getValueAt(selectedRow, 1);
                    int stock = Integer.parseInt((String) model.getValueAt(selectedRow, 4)); 
                    double price = Double.parseDouble((String) model.getValueAt(selectedRow, 5)); 

                    productNameTxtField.setText(productName);
                    stockTxtField.setText(Integer.toString(stock));
                    priceTxtField.setText(Double.toString(price));
                }
            }
        });

        deleteBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = productTable.getSelectedRow();
                if (selectedRow != -1) {
                    model.removeRow(selectedRow);
                    JOptionPane.showMessageDialog(null, "Row " + (selectedRow + 1) + " has been deleted");
                    updateIds();
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a row to delete.");
                }
            }
        });

        updateBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = productTable.getSelectedRow();
                if (selectedRow != -1) {
                    String productName = productNameTxtField.getText();
                    int stock = Integer.parseInt(stockTxtField.getText());
                    double price = Double.parseDouble(priceTxtField.getText());

                    // Update table model with new values
                    model.setValueAt(productName, selectedRow, 1); 
                    model.setValueAt(stock, selectedRow, 4); 
                    model.setValueAt(price, selectedRow, 5); 

                    double totalPrice = stock * price;
                    model.setValueAt(totalPrice, selectedRow, 6); 

                    JOptionPane.showMessageDialog(null, "Product updated successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a row to update.");
                }
            }
        });

        updateIds(); 
    }
    private void updateIds() {
        for (int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt(i + 1, i, 0);
        }
        
    
    }
}
