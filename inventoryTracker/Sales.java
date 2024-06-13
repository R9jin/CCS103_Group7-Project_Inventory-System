package inventoryTracker;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;

public class Sales extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField customnamettfl;
    private JTextField contacttxtfl;
    private JTextField quantitytxtfld;
    private JLabel stockLabel;
    private JLabel unitPriceLabel;
    private JLabel totalPriceLabel;
    private JTable table;
    private DefaultTableModel tableModel;

    private final String[] categories = {"Clothes", "Food", "Medicine"};
    private final String[][] subCategories = {
        {"Pants", "Shirts", "Jackets"},
        {"Fruits", "Vegetables", "Snacks"},
        {"Painkillers", "Antibiotics", "Vitamins"}
    };
    private final String[][][] products = {
        {{"Tenacity Pants", "Hunter Pants", "Royal Pants"}, {"Cotton Shirt", "Silk Shirt", "Linen Shirt"}, {"Winter Jacket", "Rain Jacket", "Windbreaker"}},
        {{"Apple", "Banana", "Orange"}, {"Carrot", "Broccoli", "Spinach"}, {"Chips", "Cookies", "Candy"}},
        {{"Paracetamol", "Ibuprofen", "Aspirin"}, {"Amoxicillin", "Ciprofloxacin", "Azithromycin"}, {"Vitamin C", "Vitamin D", "Multivitamin"}}
    };
    private final double[][][] prices = {
        {{29.99, 35.99, 40.00}, {19.99, 24.99, 30.00}, {59.99, 49.99, 45.00}},
        {{1.99, 0.99, 1.49}, {0.59, 1.20, 1.00}, {2.49, 3.00, 1.99}},
        {{5.99, 7.99, 8.50}, {12.99, 15.99, 10.00}, {9.99, 8.99, 11.50}}
    };
    private final int[][][] stocks = {
        {{100, 80, 60}, {150, 120, 100}, {50, 70, 90}},
        {{200, 300, 250}, {180, 160, 200}, {300, 280, 320}},
        {{120, 110, 130}, {90, 70, 60}, {200, 220, 180}}
    };

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	LogBook logbook = new LogBook();
                	logbook.setVisible(true);
                    Sales frame = new Sales(logbook);
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
    public Sales(LogBook logbook) {
        setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 736, 454);
        contentPane = new JPanel();
        contentPane.setBackground(Color.BLACK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel header = new JPanel();
        header.setBackground(Color.DARK_GRAY);
        header.setForeground(Color.WHITE);
        header.setBounds(10, 11, 700, 62);
        contentPane.add(header);
        header.setLayout(null);

        JButton btnBack = new JButton("BACK");
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnBack.setBackground(Color.CYAN);
        btnBack.setBounds(10, 11, 101, 40);
        header.add(btnBack);

        JLabel lblSales = new JLabel("SALES");
        lblSales.setForeground(Color.CYAN);
        lblSales.setHorizontalAlignment(SwingConstants.CENTER);
        lblSales.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblSales.setBounds(256, 11, 150, 40);
        header.add(lblSales);

        JPanel customer = new JPanel();
        customer.setForeground(Color.WHITE);
        customer.setBackground(Color.DARK_GRAY);
        customer.setBounds(10, 84, 502, 62);
        contentPane.add(customer);
        customer.setLayout(null);

        JLabel lblcustom = new JLabel("Customer Details");
        lblcustom.setHorizontalAlignment(SwingConstants.LEFT);
        lblcustom.setForeground(Color.CYAN);
        lblcustom.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblcustom.setBounds(10, 0, 205, 25);
        customer.add(lblcustom);

        JLabel lblCustomName = new JLabel("Customer Name:");
        lblCustomName.setHorizontalAlignment(SwingConstants.LEFT);
        lblCustomName.setForeground(Color.WHITE);
        lblCustomName.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblCustomName.setBounds(20, 27, 111, 25);
        customer.add(lblCustomName);

        customnamettfl = new JTextField();
        customnamettfl.setColumns(10);
        customnamettfl.setBackground(Color.WHITE);
        customnamettfl.setBounds(124, 30, 153, 20);
        customer.add(customnamettfl);

        JLabel lblContactNo = new JLabel("Contact No:");
        lblContactNo.setHorizontalAlignment(SwingConstants.LEFT);
        lblContactNo.setForeground(Color.WHITE);
        lblContactNo.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblContactNo.setBounds(287, 27, 83, 25);
        customer.add(lblContactNo);

        contacttxtfl = new JTextField();
        contacttxtfl.setColumns(10);
        contacttxtfl.setBackground(Color.WHITE);
        contacttxtfl.setBounds(372, 30, 120, 20);
        customer.add(contacttxtfl);

        JPanel productselection = new JPanel();
        productselection.setForeground(Color.WHITE);
        productselection.setBackground(Color.DARK_GRAY);
        productselection.setBounds(10, 157, 225, 247);
        contentPane.add(productselection);
        productselection.setLayout(null);

        JLabel lblProductSelection = new JLabel("Product Selection");
        lblProductSelection.setHorizontalAlignment(SwingConstants.CENTER);
        lblProductSelection.setForeground(Color.CYAN);
        lblProductSelection.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblProductSelection.setBounds(10, 0, 205, 25);
        productselection.add(lblProductSelection);

        JLabel lblCat = new JLabel("Category");
        lblCat.setHorizontalAlignment(SwingConstants.LEFT);
        lblCat.setForeground(Color.WHITE);
        lblCat.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblCat.setBounds(10, 27, 83, 16);
        productselection.add(lblCat);

        JComboBox<String> catcmbbox = new JComboBox<>(categories);
        catcmbbox.setBounds(103, 25, 112, 22);
        productselection.add(catcmbbox);

        JLabel lblsubCat = new JLabel("Sub-Category");
        lblsubCat.setHorizontalAlignment(SwingConstants.LEFT);
        lblsubCat.setForeground(Color.WHITE);
        lblsubCat.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblsubCat.setBounds(10, 54, 83, 16);
        productselection.add(lblsubCat);

        JComboBox<String> subcatcmbbox = new JComboBox<>();
        subcatcmbbox.setBounds(103, 52, 112, 22);
        productselection.add(subcatcmbbox);

        JLabel lblproduct = new JLabel("Product");
        lblproduct.setHorizontalAlignment(SwingConstants.LEFT);
        lblproduct.setForeground(Color.WHITE);
        lblproduct.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblproduct.setBounds(10, 81, 83, 16);
        productselection.add(lblproduct);

        JComboBox<String> prodcmbbox = new JComboBox<>();
        prodcmbbox.setBounds(103, 79, 112, 22);
        productselection.add(prodcmbbox);

        JLabel lblquan = new JLabel("Quantity");
        lblquan.setHorizontalAlignment(SwingConstants.LEFT);
        lblquan.setForeground(Color.WHITE);
        lblquan.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblquan.setBounds(10, 108, 83, 16);
        productselection.add(lblquan);

        quantitytxtfld = new JTextField();
        quantitytxtfld.setBackground(Color.WHITE);
        quantitytxtfld.setBounds(103, 108, 112, 20);
        productselection.add(quantitytxtfld);
        quantitytxtfld.setColumns(10);

        JLabel lblStock = new JLabel("Stock");
        lblStock.setHorizontalAlignment(SwingConstants.LEFT);
        lblStock.setForeground(Color.WHITE);
        lblStock.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblStock.setBounds(10, 135, 83, 16);
        productselection.add(lblStock);

        stockLabel = new JLabel("");
        stockLabel.setBounds(103, 137, 112, 14);
        productselection.add(stockLabel);

        JLabel lblUnitPrice = new JLabel("Unit Price");
        lblUnitPrice.setHorizontalAlignment(SwingConstants.LEFT);
        lblUnitPrice.setForeground(Color.WHITE);
        lblUnitPrice.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblUnitPrice.setBounds(10, 162, 83, 16);
        productselection.add(lblUnitPrice);

        unitPriceLabel = new JLabel("");
        unitPriceLabel.setBounds(103, 164, 112, 14);
        productselection.add(unitPriceLabel);

        JLabel lblTotalPrice = new JLabel("Total Price");
        lblTotalPrice.setHorizontalAlignment(SwingConstants.LEFT);
        lblTotalPrice.setForeground(Color.WHITE);
        lblTotalPrice.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblTotalPrice.setBounds(10, 189, 83, 16);
        productselection.add(lblTotalPrice);

        totalPriceLabel = new JLabel("");
        totalPriceLabel.setBounds(103, 191, 112, 14);
        productselection.add(totalPriceLabel);

        JButton btnCart = new JButton("Add to Cart");
        btnCart.setFont(new Font("Tahoma", Font.PLAIN, 10));
        btnCart.setBackground(Color.CYAN);
        btnCart.setBounds(57, 213, 89, 23);
        productselection.add(btnCart);

        JPanel cart = new JPanel();
        cart.setForeground(Color.WHITE);
        cart.setBackground(Color.DARK_GRAY);
        cart.setBounds(245, 157, 465, 247);
        contentPane.add(cart);
        cart.setLayout(null);

        JLabel lblCart = new JLabel("Cart");
        lblCart.setHorizontalAlignment(SwingConstants.LEFT);
        lblCart.setForeground(Color.CYAN);
        lblCart.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblCart.setBounds(10, 0, 205, 25);
        cart.add(lblCart);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 24, 445, 194);
        cart.add(scrollPane);

        table = new JTable();
        tableModel = new DefaultTableModel(
            new Object[][] {},
            new String[] {"Product Name", "Quantity", "Unit Price", "Total Price"}
        );
        table.setModel(tableModel);
        scrollPane.setViewportView(table);

        JButton btnremover = new JButton("Remove Selected");
        btnremover.setFont(new Font("Tahoma", Font.PLAIN, 10));
        btnremover.setBackground(Color.CYAN);
        btnremover.setBounds(162, 223, 151, 18);
        cart.add(btnremover);

        JPanel checkout = new JPanel();
        checkout.setForeground(Color.WHITE);
        checkout.setBackground(Color.DARK_GRAY);
        checkout.setBounds(522, 84, 188, 62);
        contentPane.add(checkout);
        checkout.setLayout(null);
        
        JButton btnNewButton = new JButton("Checkout");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
//					Sign Off
        		Object[] signoff = {"Customer Name:", "", "Contact No:", ""};

//        		Gap
        		Object[] gap = {"", "", "", ""};
        		signoff[1] = customnamettfl.getText();
    			signoff[3] = contacttxtfl.getText();
    			
    			logbook.addItemToTable(signoff);
    			
        		for(int i=0;i<tableModel.getRowCount();i++) {
//        			Blank Object
        			Object[] data = new Object[tableModel.getColumnCount()];       				        			
        			for(int j=0;j<tableModel.getColumnCount();j++) {
        				
//        				Add each column to a data object
        				data[j] = tableModel.getValueAt(i, j);
        			}
        			
        			logbook.addItemToTable(data);
        		}
        		logbook.addItemToTable(gap);
        		customnamettfl.setText("");
        		contacttxtfl.setText(getName());
        		tableModel.setRowCount(0);
        	}
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton.setBackground(Color.CYAN);
        btnNewButton.setBounds(31, 11, 125, 40);
        checkout.add(btnNewButton);

        catcmbbox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedCategoryIndex = catcmbbox.getSelectedIndex();
                subcatcmbbox.removeAllItems();
                for (String subCategory : subCategories[selectedCategoryIndex]) {
                    subcatcmbbox.addItem(subCategory);
                }
            }
        });
        subcatcmbbox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedCategoryIndex = catcmbbox.getSelectedIndex();
                int selectedSubCategoryIndex = subcatcmbbox.getSelectedIndex();
                prodcmbbox.removeAllItems();
                if (selectedSubCategoryIndex >= 0) {
                    for (String product : products[selectedCategoryIndex][selectedSubCategoryIndex]) {
                        prodcmbbox.addItem(product);
                    }
                }
            }
        });
        prodcmbbox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedCategoryIndex = catcmbbox.getSelectedIndex();
                int selectedSubCategoryIndex = subcatcmbbox.getSelectedIndex();
                int selectedProductIndex = prodcmbbox.getSelectedIndex();
                if (selectedProductIndex >= 0) {
                    double unitPrice = prices[selectedCategoryIndex][selectedSubCategoryIndex][selectedProductIndex];
                    int stock = stocks[selectedCategoryIndex][selectedSubCategoryIndex][selectedProductIndex];
                    unitPriceLabel.setText(String.valueOf(unitPrice));
                    stockLabel.setText(String.valueOf(stock));
                    int quantity = Integer.parseInt(quantitytxtfld.getText().isEmpty() ? "0" : quantitytxtfld.getText());
                    double totalPrice = unitPrice * quantity;
                    totalPriceLabel.setText(String.valueOf(totalPrice));
                }
            }
        });
        quantitytxtfld.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedCategoryIndex = catcmbbox.getSelectedIndex();
                int selectedSubCategoryIndex = subcatcmbbox.getSelectedIndex();
                int selectedProductIndex = prodcmbbox.getSelectedIndex();
                if (selectedProductIndex >= 0) {
                    double unitPrice = prices[selectedCategoryIndex][selectedSubCategoryIndex][selectedProductIndex];
                    int quantity = Integer.parseInt(quantitytxtfld.getText().isEmpty() ? "0" : quantitytxtfld.getText());
                    double totalPrice = unitPrice * quantity;
                    totalPriceLabel.setText(String.valueOf(totalPrice));
                }
            }
        });
        btnCart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedCategoryIndex = catcmbbox.getSelectedIndex();
                int selectedSubCategoryIndex = subcatcmbbox.getSelectedIndex();
                int selectedProductIndex = prodcmbbox.getSelectedIndex();
                if (selectedProductIndex >= 0) {
                    String productName = products[selectedCategoryIndex][selectedSubCategoryIndex][selectedProductIndex];
                    int quantity = Integer.parseInt(quantitytxtfld.getText().isEmpty() ? "0" : quantitytxtfld.getText());
                    double unitPrice = prices[selectedCategoryIndex][selectedSubCategoryIndex][selectedProductIndex];
                    double totalPrice = unitPrice * quantity;

                    tableModel.addRow(new Object[]{productName, quantity, unitPrice, totalPrice});

                    // Clear the input fields
                    quantitytxtfld.setText("");
                    totalPriceLabel.setText("");
                }
            }
        });
        btnremover.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    tableModel.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a row to remove.");
                }
            }
        });
    }
}