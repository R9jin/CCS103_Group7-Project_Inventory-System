package main;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.TreeMap;

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
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

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
    public LinkedHashMap<String, ArrayList<String>> innerMap;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	
                	MainMenu.inventory.setEnabled(false);
                	MainMenu.inventory.setVisible(true);
                	
                    Sales frame = new Sales(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     * @param receipt 
     */
    public Sales(Receipt receipt) {
    	
    	TreeMap<String, LinkedHashMap<String, ArrayList<String>>> inventoryMap = new TreeMap<>();

        
        for (String[] row : Inventory.data) {
            String productName = row[1];
            String category = row[2];
            String subCategory = row[3];

            
            inventoryMap.putIfAbsent(category, new LinkedHashMap<>());

            
            inventoryMap.get(category).putIfAbsent(subCategory, new ArrayList<String>());

            
            inventoryMap.get(category).get(subCategory).add(productName);
        }
    	
        setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 736, 454);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(202, 210, 197));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocationRelativeTo(null);

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel header = new JPanel();
        header.setBackground(new Color(132, 169, 140));
        header.setForeground(Color.WHITE);
        header.setBounds(10, 11, 700, 62);
        contentPane.add(header);
        header.setLayout(null);

        JButton btnBack = new JButton("BACK");
        btnBack.setForeground(new Color(202, 210, 197));
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnBack.setBackground(new Color(82, 121, 111));
        btnBack.setBounds(10, 11, 101, 40);
        header.add(btnBack);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainMenu mainMenu = new MainMenu();
                mainMenu.setVisible(true);
                MainMenu.inventory.setVisible(false);
            }
        });

        JLabel lblSales = new JLabel("SALES");
        lblSales.setForeground(new Color(53, 79, 82));
        lblSales.setHorizontalAlignment(SwingConstants.CENTER);
        lblSales.setFont(new Font("Poppins", Font.BOLD, 40));
        lblSales.setBounds(283, 11, 150, 41);
        header.add(lblSales);

        JPanel customer = new JPanel();
        customer.setForeground(Color.WHITE);
        customer.setBackground(new Color(132, 169, 140));
        customer.setBounds(10, 84, 502, 62);
        contentPane.add(customer);
        customer.setLayout(null);

        JLabel lblcustom = new JLabel("Customer Details");
        lblcustom.setBackground(new Color(132, 169, 140));
        lblcustom.setHorizontalAlignment(SwingConstants.LEFT);
        lblcustom.setForeground(new Color(53, 79, 82));
        lblcustom.setFont(new Font("Poppins", Font.PLAIN, 12));
        lblcustom.setBounds(10, 0, 205, 25);
        customer.add(lblcustom);

        JLabel lblCustomName = new JLabel("Customer Name:");
        lblCustomName.setHorizontalAlignment(SwingConstants.LEFT);
        lblCustomName.setForeground(Color.WHITE);
        lblCustomName.setFont(new Font("Poppins", Font.PLAIN, 12));
        lblCustomName.setBounds(20, 27, 111, 25);
        customer.add(lblCustomName);

        customnamettfl = new JTextField();
        customnamettfl.setFont(new Font("Poppins", Font.PLAIN, 12));
        customnamettfl.setColumns(10);
        customnamettfl.setBackground(Color.WHITE);
        customnamettfl.setBounds(124, 30, 153, 20);
        customer.add(customnamettfl);

        JLabel lblContactNo = new JLabel("Contact No:");
        lblContactNo.setHorizontalAlignment(SwingConstants.LEFT);
        lblContactNo.setForeground(Color.WHITE);
        lblContactNo.setFont(new Font("Poppins", Font.PLAIN, 12));
        lblContactNo.setBounds(287, 27, 83, 25);
        customer.add(lblContactNo);

        contacttxtfl = new JTextField();
        contacttxtfl.setFont(new Font("Poppins", Font.PLAIN, 12));
        contacttxtfl.setColumns(10);
        contacttxtfl.setBackground(Color.WHITE);
        contacttxtfl.setBounds(372, 30, 120, 20);
        customer.add(contacttxtfl);

        JPanel productselection = new JPanel();
        productselection.setForeground(Color.WHITE);
        productselection.setBackground(new Color(132, 169, 140));
        productselection.setBounds(10, 157, 225, 247);
        contentPane.add(productselection);
        productselection.setLayout(null);

        JLabel lblProductSelection = new JLabel("Product Selection");
        lblProductSelection.setHorizontalAlignment(SwingConstants.CENTER);
        lblProductSelection.setForeground(new Color(53, 79, 82));
        lblProductSelection.setFont(new Font("Poppins", Font.PLAIN, 12));
        lblProductSelection.setBounds(10, 0, 205, 25);
        productselection.add(lblProductSelection);

        JLabel lblCat = new JLabel("Category");
        lblCat.setHorizontalAlignment(SwingConstants.LEFT);
        lblCat.setForeground(Color.WHITE);
        lblCat.setFont(new Font("Poppins", Font.PLAIN, 12));
        lblCat.setBounds(10, 27, 83, 16);
        productselection.add(lblCat);
        
        
        JComboBox<String> categoryBox = new JComboBox<>();
        categoryBox.setFont(new Font("Poppins", Font.PLAIN, 12));
        categoryBox.addItem("Clothes");
        categoryBox.addItem("Food");
        categoryBox.addItem("Medicine");
        categoryBox.setBounds(103, 25, 112, 22);
        productselection.add(categoryBox);

        JLabel lblsubCat = new JLabel("Sub-Category");
        lblsubCat.setHorizontalAlignment(SwingConstants.LEFT);
        lblsubCat.setForeground(Color.WHITE);
        lblsubCat.setFont(new Font("Poppins", Font.PLAIN, 11));
        lblsubCat.setBounds(10, 54, 83, 16);
        productselection.add(lblsubCat);

        
        JComboBox<String> subCategoryBox = new JComboBox<>();
        subCategoryBox.setFont(new Font("Poppins", Font.PLAIN, 12));
        subCategoryBox.setBounds(103, 52, 112, 22);
        productselection.add(subCategoryBox);

        JLabel lblproduct = new JLabel("Product");
        lblproduct.setHorizontalAlignment(SwingConstants.LEFT);
        lblproduct.setForeground(Color.WHITE);
        lblproduct.setFont(new Font("Poppins", Font.PLAIN, 12));
        lblproduct.setBounds(10, 81, 83, 16);
        productselection.add(lblproduct);

        
        JComboBox<String> productNameBox = new JComboBox<>();
        productNameBox.setFont(new Font("Poppins", Font.PLAIN, 12));
        productNameBox.setBounds(103, 79, 112, 22);
        productselection.add(productNameBox);

        JLabel lblquan = new JLabel("Quantity");
        lblquan.setHorizontalAlignment(SwingConstants.LEFT);
        lblquan.setForeground(Color.WHITE);
        lblquan.setFont(new Font("Poppins", Font.PLAIN, 12));
        lblquan.setBounds(10, 108, 83, 16);
        productselection.add(lblquan);

        quantitytxtfld = new JTextField();
        quantitytxtfld.setFont(new Font("Poppins", Font.PLAIN, 12));
        quantitytxtfld.setBackground(Color.WHITE);
        quantitytxtfld.setBounds(103, 108, 112, 20);
        productselection.add(quantitytxtfld);
        quantitytxtfld.setColumns(10);

        JLabel lblStock = new JLabel("Stock");
        lblStock.setHorizontalAlignment(SwingConstants.LEFT);
        lblStock.setForeground(Color.WHITE);
        lblStock.setFont(new Font("Poppins", Font.PLAIN, 12));
        lblStock.setBounds(10, 135, 83, 16);
        productselection.add(lblStock);

        stockLabel = new JLabel("");
        stockLabel.setFont(new Font("Poppins", Font.PLAIN, 12));
        stockLabel.setBounds(103, 137, 112, 14);
        stockLabel.setForeground(Color.WHITE);
        productselection.add(stockLabel);

        JLabel lblUnitPrice = new JLabel("Unit Price");
        lblUnitPrice.setHorizontalAlignment(SwingConstants.LEFT);
        lblUnitPrice.setForeground(Color.WHITE);
        lblUnitPrice.setFont(new Font("Poppins", Font.PLAIN, 12));
        lblUnitPrice.setBounds(10, 162, 83, 16);
        productselection.add(lblUnitPrice);

        unitPriceLabel = new JLabel("");
        unitPriceLabel.setFont(new Font("Poppins", Font.PLAIN, 12));
        unitPriceLabel.setBounds(103, 164, 112, 14);
        unitPriceLabel.setForeground(Color.WHITE);
        productselection.add(unitPriceLabel);

        JLabel lblTotalPrice = new JLabel("Total Price");
        lblTotalPrice.setHorizontalAlignment(SwingConstants.LEFT);
        lblTotalPrice.setForeground(Color.WHITE);
        lblTotalPrice.setFont(new Font("Poppins", Font.PLAIN, 12));
        lblTotalPrice.setBounds(10, 189, 83, 16);
        productselection.add(lblTotalPrice);

        totalPriceLabel = new JLabel("");
        totalPriceLabel.setFont(new Font("Poppins", Font.PLAIN, 12));
        totalPriceLabel.setBounds(103, 191, 112, 14);
        totalPriceLabel.setForeground(Color.WHITE);
        productselection.add(totalPriceLabel);

        JButton btnCart = new JButton("Add to Cart");
        btnCart.setForeground(new Color(202, 210, 197));
        btnCart.setFont(new Font("Poppins", Font.PLAIN, 12));
        btnCart.setBackground(new Color(82, 121, 111));
        btnCart.setBounds(57, 213, 89, 23);
        productselection.add(btnCart);

        JPanel cart = new JPanel();
        cart.setForeground(Color.WHITE);
        cart.setBackground(new Color(132, 169, 140));
        cart.setBounds(245, 157, 465, 247);
        contentPane.add(cart);
        cart.setLayout(null);

        JLabel lblCart = new JLabel("Cart");
        lblCart.setHorizontalAlignment(SwingConstants.LEFT);
        lblCart.setForeground(new Color(53, 79, 82));
        lblCart.setFont(new Font("Poppins", Font.PLAIN, 12));
        lblCart.setBounds(10, 0, 205, 25);
        cart.add(lblCart);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 24, 445, 194);
        cart.add(scrollPane);

        table = new JTable();
        tableModel = new DefaultTableModel(
            new Object[][] {},
            new String[] {"No.","Product Name", "Quantity", "Unit Price", "Total Price"}
        );
        table.setModel(tableModel);
        scrollPane.setViewportView(table);

        JButton btnremover = new JButton("Remove Selected");
        btnremover.setForeground(new Color(202, 210, 197));
        btnremover.setFont(new Font("Poppins", Font.PLAIN, 12));
        btnremover.setBackground(new Color(82, 121, 111));
        btnremover.setBounds(162, 223, 151, 18);
        cart.add(btnremover);

        JPanel checkout = new JPanel();
        checkout.setForeground(Color.WHITE);
        checkout.setBackground(new Color(132, 169, 140));
        checkout.setBounds(522, 84, 188, 62);
        contentPane.add(checkout);
        checkout.setLayout(null);
        
        JButton checkoutBtn = new JButton("Checkout");
        checkoutBtn.setForeground(new Color(202, 210, 197));
        checkoutBtn.setFont(new Font("Poppins", Font.PLAIN, 12));
        checkoutBtn.setBackground(new Color(82, 121, 111));
        checkoutBtn.setBounds(31, 11, 125, 40);
        checkout.add(checkoutBtn);
        
        categoryBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    
                    subCategoryBox.removeAllItems();
                    
                    
                    String selectedCategory = (String) e.getItem();
                    
                    
                    innerMap = inventoryMap.get(selectedCategory);
                    
                    
                    for (String subCategory : innerMap.keySet()) {
                        subCategoryBox.addItem(subCategory);
                    }
                }
            }
        });


        subCategoryBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    
                    productNameBox.removeAllItems();
                    
                    
                    String selectedSubCategory = (String) e.getItem();
                    
                    
                    ArrayList<String> productsMap = innerMap.get(selectedSubCategory);
                    
                    
                    if (productsMap != null) {
                        for (String product : productsMap) {
                            productNameBox.addItem(product);
                        }
                    }
                }
            }
        });
        
        productNameBox.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		if (e.getStateChange() == ItemEvent.SELECTED) {
        			String selectedProductName = (String) e.getItem();
        			
        			if (Inventory.model != null) {
        			
        				for (int i = 0; i < Inventory.model.getRowCount(); i++) {
        					String currentProductName = (String) Inventory.model.getValueAt(i, 1);
						
        					
        					if (selectedProductName.equals(currentProductName)) {
        						stockLabel.setText((String) Inventory.model.getValueAt(i, 4));
        						unitPriceLabel.setText((String) Inventory.model.getValueAt(i, 5));
        						totalPriceLabel.setText((String) Inventory.model.getValueAt(i, 6));
        						break;
        					}
        				}
        			
        			} else {
        				
                        System.err.println("Inventory.model is null. Check initialization.");
        			}
        		}
        	}
        });

        btnCart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                String productName = (String) productNameBox.getSelectedItem();
                int quantityFromSales = Integer.parseInt(quantitytxtfld.getText().isEmpty() ? "0" : quantitytxtfld.getText());

                
                double unitPrice = 0.0;
                for (int i = 0; i < Inventory.model.getRowCount(); i++) {
                    String productNameOfInventory = (String) Inventory.model.getValueAt(i, 1); 

                    if (productName.equals(productNameOfInventory)) {
                    	int stockFromInventory = Integer.parseInt(Inventory.model.getValueAt(i, 4).toString());
                        unitPrice = Double.parseDouble(Inventory.model.getValueAt(i, 5).toString()); 
                     
                        
                        if (quantityFromSales > stockFromInventory) {
                            JOptionPane.showMessageDialog(null, "Error: Insufficient Stock for " + productName + ". Please try again.");
                            return; 
                        }
                        break; 
                    }
                }

                
                double totalPrice = unitPrice * quantityFromSales;

                
                tableModel.addRow(new Object[]{"", productName, quantityFromSales, unitPrice, totalPrice});

                
                productNameBox.setSelectedIndex(0); 
                
                stockLabel.setText("");
                unitPriceLabel.setText("");
                quantitytxtfld.setText("");
                totalPriceLabel.setText("");
                updateIds(); 
            }
        });

        
        checkoutBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String customerName = customnamettfl.getText();
                String contactNumber = contacttxtfl.getText();

                if (customerName.isEmpty() || contactNumber.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter customer name and contact number.");
                    return;
                }

                
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    String productNameOfCart = (String) tableModel.getValueAt(i, 1); 

                    for (int j = 0; j < Inventory.model.getRowCount(); j++) {
                        String productNameOfInventory = (String) Inventory.model.getValueAt(j, 1); 
                        int quantitySold = Integer.parseInt(tableModel.getValueAt(i, 2).toString()); 
                        double totalPrice = Double.parseDouble(tableModel.getValueAt(i, 4).toString()); 

                        
                        if (productNameOfCart.equals(productNameOfInventory)) {
                            int stockFromInventory = Integer.parseInt(Inventory.model.getValueAt(j, 4).toString()); 
                            int updatedStock = stockFromInventory - quantitySold;

                            double totalPriceFromInventory = Double.parseDouble(Inventory.model.getValueAt(j, 6).toString()); 
                            double updatedTotalPrice = totalPriceFromInventory - totalPrice;

                            Inventory.model.setValueAt(updatedStock, j, 4);
                            Inventory.model.setValueAt(updatedTotalPrice, j, 6);
                        }
                    }
                }

                Receipt receipt = new Receipt();
                receipt.setVisible(true);

                
                Receipt.customerNametxtField.setText(customerName);
                Receipt.contactNotxtField.setText(contactNumber);
                
                LogBook.logBookModel.addRow(new Object [] {customerName, contactNumber});
                LogBook.logBookModel.addRow(new Object[] {"", "", "", "", ""});
                LogBook.logBookModel.addRow(new Object [] {"No.", "Product Name", "Quantity", "Unit Price", "Total Price"});
                
                
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    Object[] row = new Object[tableModel.getColumnCount()];
                    for (int j = 0; j < tableModel.getColumnCount(); j++) {
                        row[j] = tableModel.getValueAt(i, j);
                    }
                    LogBook.logBookModel.addRow(row);
                }

                
                LogBook.logBookModel.addRow(new Object[] {"", "", "", "", ""});
                

                
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    Object[] data = new Object[tableModel.getColumnCount()];
                    for (int j = 0; j < tableModel.getColumnCount(); j++) {
                        data[j] = tableModel.getValueAt(i, j);
                    }
                    receipt.addItemToTable(data);
                }

                
                customnamettfl.setText("");
                contacttxtfl.setText("");
                tableModel.setRowCount(0);
            }
        });



        btnremover.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    tableModel.removeRow(selectedRow);
                    updateIds();
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a row to remove.");
                }
            }
        });
    }
   
    
    private void updateIds() {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            tableModel.setValueAt(i + 1, i, 0);
        }
    }
}
