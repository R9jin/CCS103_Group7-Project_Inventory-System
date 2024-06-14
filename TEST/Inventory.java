package TEST;

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
    private JPanel contentPane;
    public static JTable productTable;
    public static DefaultTableModel model;

    String [][] data = {{"", "Lotion", "Cosmetics", "Face", "1000", "129.0", "129000.00"},
                        {"", "Lip Balm", "Cosmetics", "Lips", "600", "33.0", "19800.00"},
                        {"", "Hair Gel", "Cosmetics", "Hair", "780", "50.5", "39390.00"}};
    String [] header = {"No.", "Product Name", "Category", "Sub-Category", "Quantity", "Unit Price", "Total Price"};
    private JTextField productNameTxtField;
    private JTextField quantityTxtField;
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
        setBounds(100, 100, 963, 426);
        setTitle("Inventory");
        setResizable(false);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        model = new DefaultTableModel(data, header);

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(192, 192, 192));
        headerPanel.setBounds(23, 11, 906, 69);
        contentPane.add(headerPanel);
        headerPanel.setLayout(null);

        JLabel ìnventoryHeader = new JLabel("INVENTORY");
        ìnventoryHeader.setBounds(210, 11, 449, 41);
        headerPanel.add(ìnventoryHeader);
        ìnventoryHeader.setFont(new Font("Verdana", Font.PLAIN, 50));
        ìnventoryHeader.setHorizontalAlignment(SwingConstants.CENTER);

        JButton backBtn = new JButton("Back");
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
        productListPanel.setBackground(new Color(192, 192, 192));
        productListPanel.setBounds(23, 91, 619, 285);
        contentPane.add(productListPanel);
        productListPanel.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 40, 599, 234);
        productListPanel.add(scrollPane);
        scrollPane.getViewport().setBackground(Color.WHITE);

        productTable = new JTable(model);
        productTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        productTable.setAutoCreateRowSorter(true);
        scrollPane.setViewportView(productTable);

        JLabel productListLbl = new JLabel("Product List");
        productListLbl.setHorizontalAlignment(SwingConstants.CENTER);
        productListLbl.setFont(new Font("Verdana", Font.PLAIN, 21));
        productListLbl.setBounds(200, 11, 171, 18);
        productListPanel.add(productListLbl);

        JPanel addProductPanel = new JPanel();
        addProductPanel.setBackground(new Color(192, 192, 192));
        addProductPanel.setBounds(652, 91, 277, 69);
        contentPane.add(addProductPanel);
        addProductPanel.setLayout(null);

        JButton addProductBtn = new JButton("ADD PRODUCT");
        addProductBtn.setFont(new Font("Verdana", Font.PLAIN, 21));
        addProductBtn.setBounds(10, 11, 253, 47);
        addProductPanel.add(addProductBtn);

        JPanel optionsPanel = new JPanel();
        optionsPanel.setBackground(new Color(192, 192, 192));
        optionsPanel.setBounds(652, 171, 277, 205);
        contentPane.add(optionsPanel);
        optionsPanel.setLayout(null);

        JLabel productNameLbl = new JLabel("Product Name");
        productNameLbl.setHorizontalAlignment(SwingConstants.CENTER);
        productNameLbl.setFont(new Font("Verdana", Font.PLAIN, 21));
        productNameLbl.setBounds(54, 11, 171, 18);
        optionsPanel.add(productNameLbl);

        JLabel quantityLbl = new JLabel("Quantity");
        quantityLbl.setHorizontalAlignment(SwingConstants.CENTER);
        quantityLbl.setFont(new Font("Verdana", Font.PLAIN, 11));
        quantityLbl.setBounds(29, 83, 86, 14);
        optionsPanel.add(quantityLbl);

        JLabel priceLbl = new JLabel("Price");
        priceLbl.setHorizontalAlignment(SwingConstants.CENTER);
        priceLbl.setFont(new Font("Verdana", Font.PLAIN, 11));
        priceLbl.setBounds(175, 83, 60, 14);
        optionsPanel.add(priceLbl);

        productNameTxtField = new JTextField();
        productNameTxtField.setBounds(40, 40, 195, 37);
        optionsPanel.add(productNameTxtField);
        productNameTxtField.setColumns(10);

        quantityTxtField = new JTextField();
        quantityTxtField.setHorizontalAlignment(SwingConstants.LEFT);
        quantityTxtField.setBounds(10, 108, 125, 20);
        optionsPanel.add(quantityTxtField);
        quantityTxtField.setColumns(10);

        priceTxtField = new JTextField();
        priceTxtField.setColumns(10);
        priceTxtField.setBounds(145, 108, 122, 20);
        optionsPanel.add(priceTxtField);

        JPanel options = new JPanel();
        options.setBackground(new Color(192, 192, 192));
        options.setBounds(10, 147, 257, 29);
        optionsPanel.add(options);
        options.setLayout(new GridLayout(1, 0, 5, 5));

        JButton updateBtn = new JButton("Update Product");
        options.add(updateBtn);
        updateBtn.setFont(new Font("Verdana", Font.PLAIN, 11));

        JButton deleteBtn = new JButton("Delete Product");
        options.add(deleteBtn);
        deleteBtn.setFont(new Font("Verdana", Font.PLAIN, 11));

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
                    int quantity = Integer.parseInt((String) model.getValueAt(selectedRow, 4)); // Parsing quantity as an integer
                    double price = Double.parseDouble((String) model.getValueAt(selectedRow, 5)); // Parsing price as a double

                    productNameTxtField.setText(productName);
                    quantityTxtField.setText(Integer.toString(quantity));
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
                    int quantity = Integer.parseInt(quantityTxtField.getText());
                    double price = Double.parseDouble(priceTxtField.getText());

                    // Update table model with new values
                    model.setValueAt(productName, selectedRow, 1); // Product Name column
                    model.setValueAt(quantity, selectedRow, 4); // Quantity column
                    model.setValueAt(price, selectedRow, 5); // Unit Price column

                    double totalPrice = quantity * price;
                    model.setValueAt(totalPrice, selectedRow, 6); // Total Price column

                    JOptionPane.showMessageDialog(null, "Product updated successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a row to update.");
                }
            }
        });

        updateIds(); // Initialize row numbers
    }

    private void updateIds() {
        for (int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt(i + 1, i, 0);
        }
    }
}