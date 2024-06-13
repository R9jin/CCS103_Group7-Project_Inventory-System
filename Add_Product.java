package Finals_Inventory_Tracker;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Add_Product extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField productNameTxtField;
	private JTextField categoryNameTxtField;
	private JTextField unitPriceTxtField;
	private JTextField quantityTxtField;
	private JTextField subCategoryTxtField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Product frame = new Add_Product();
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
	public Add_Product() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 300);
		setTitle("Add Product");
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBackground(new Color(192, 192, 192));
		headerPanel.setBounds(10, 11, 545, 62);
		contentPane.add(headerPanel);
		headerPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADD PRODUCT");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(134, 11, 263, 40);
		headerPanel.add(lblNewLabel);
		
		JPanel textFieldsPanel = new JPanel();
		textFieldsPanel.setBackground(new Color(192, 192, 192));
		textFieldsPanel.setBounds(10, 84, 413, 166);
		contentPane.add(textFieldsPanel);
		textFieldsPanel.setLayout(null);
		
		JLabel productNameLbl = new JLabel("Product Name");
		productNameLbl.setFont(new Font("Verdana", Font.PLAIN, 11));
		productNameLbl.setBounds(10, 11, 152, 14);
		textFieldsPanel.add(productNameLbl);
		
		JLabel categoryNameLbl = new JLabel("Category Name");
		categoryNameLbl.setFont(new Font("Verdana", Font.PLAIN, 11));
		categoryNameLbl.setBounds(10, 59, 152, 14);
		textFieldsPanel.add(categoryNameLbl);
		
		JLabel subCategoryLbl = new JLabel("Sub-Category Name");
		subCategoryLbl.setBounds(221, 59, 152, 14);
		subCategoryLbl.setFont(new Font("Verdana", Font.PLAIN, 11));
		textFieldsPanel.add(subCategoryLbl);
		
		JLabel unitPriceLbl = new JLabel("Unit Price");
		unitPriceLbl.setBounds(10, 113, 152, 14);
		unitPriceLbl.setFont(new Font("Verdana", Font.PLAIN, 11));
		textFieldsPanel.add(unitPriceLbl);
		
		JLabel quantityLbl = new JLabel("Quantity");
		quantityLbl.setBounds(221, 113, 152, 14);
		quantityLbl.setFont(new Font("Verdana", Font.PLAIN, 11));
		textFieldsPanel.add(quantityLbl);
		
		productNameTxtField = new JTextField();
		productNameTxtField.setBounds(10, 28, 393, 20);
		textFieldsPanel.add(productNameTxtField);
		productNameTxtField.setColumns(10);
		
		categoryNameTxtField = new JTextField();
		categoryNameTxtField.setBounds(10, 84, 183, 20);
		textFieldsPanel.add(categoryNameTxtField);
		categoryNameTxtField.setColumns(10);
		
		unitPriceTxtField = new JTextField();
		unitPriceTxtField.setBounds(10, 135, 183, 20);
		textFieldsPanel.add(unitPriceTxtField);
		unitPriceTxtField.setColumns(10);
		
		quantityTxtField = new JTextField();
		quantityTxtField.setColumns(10);
		quantityTxtField.setBounds(220, 135, 183, 20);
		textFieldsPanel.add(quantityTxtField);
		
		subCategoryTxtField = new JTextField();
		subCategoryTxtField.setColumns(10);
		subCategoryTxtField.setBounds(220, 84, 183, 20);
		textFieldsPanel.add(subCategoryTxtField);
		
		JPanel optionPanel = new JPanel();
		optionPanel.setBackground(new Color(192, 192, 192));
		optionPanel.setBounds(433, 84, 122, 166);
		contentPane.add(optionPanel);
		optionPanel.setLayout(null);
		
		JPanel options = new JPanel();
		options.setBackground(new Color(192, 192, 192));
		options.setBounds(10, 11, 102, 144);
		optionPanel.add(options);
		options.setLayout(new GridLayout(0, 1, 5, 5));
		
		JButton addBtn = new JButton("ADD");

		options.add(addBtn);
		
		JButton clrBtn = new JButton("CLEAR");		
		options.add(clrBtn);
		
		//"No.", "Product Name", "Category", "Sub-Category", "Quantity", "Unit Price", "Total Price"
		
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String productName = productNameTxtField.getText();
				String categoryName = categoryNameTxtField.getText();
				String subCategoryName = subCategoryTxtField.getText();
				int quantity = Integer.parseInt(quantityTxtField.getText());
				double price = Double.parseDouble(unitPriceTxtField.getText());
				double totalPrice = quantity * price;
				
				int nextId = Inventory_Page.model.getRowCount() + 1;
				
				String [] newRow = {Integer.toString(nextId),
									productName,
									categoryName,
									subCategoryName,
									Integer.toString(quantity),
									Double.toString(price),
									Double.toString(totalPrice)};
				Inventory_Page.model.addRow(newRow);
				clearFields();
				dispose();
				
			}
		});
		
		clrBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearFields();
			}
		});
	}
	private void clearFields() {
		productNameTxtField.setText("");
		categoryNameTxtField.setText("");
		subCategoryTxtField.setText("");
		quantityTxtField.setText("");
		unitPriceTxtField.setText("");
	}
}
