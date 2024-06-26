package Final_Vers_StockSync_Ticao_1CS_B;

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

public class AddProduct extends JFrame {

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
					AddProduct frame = new AddProduct();
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
	public AddProduct() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 300);
		setTitle("StockSync | Add Product");
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(202, 210, 197));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBackground(new Color(132, 169, 140));
		headerPanel.setBounds(10, 11, 545, 62);
		contentPane.add(headerPanel);
		headerPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADD PRODUCT");
		lblNewLabel.setForeground(new Color(53, 79, 82));
		lblNewLabel.setFont(new Font("Poppins", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(123, 12, 307, 40);
		headerPanel.add(lblNewLabel);
		
		JPanel textFieldsPanel = new JPanel();
		textFieldsPanel.setBackground(new Color(132, 169, 140));
		textFieldsPanel.setBounds(10, 84, 413, 166);
		contentPane.add(textFieldsPanel);
		textFieldsPanel.setLayout(null);
		
		JLabel productNameLbl = new JLabel("Product Name");
		productNameLbl.setForeground(new Color(53, 79, 82));
		productNameLbl.setFont(new Font("Poppins", Font.PLAIN, 12));
		productNameLbl.setBounds(10, 11, 152, 14);
		textFieldsPanel.add(productNameLbl);
		
		JLabel categoryNameLbl = new JLabel("Category Name");
		categoryNameLbl.setForeground(new Color(53, 79, 82));
		categoryNameLbl.setFont(new Font("Poppins", Font.PLAIN, 12));
		categoryNameLbl.setBounds(10, 59, 152, 14);
		textFieldsPanel.add(categoryNameLbl);
		
		JLabel subCategoryLbl = new JLabel("Sub-Category Name");
		subCategoryLbl.setForeground(new Color(53, 79, 82));
		subCategoryLbl.setBounds(221, 59, 152, 14);
		subCategoryLbl.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldsPanel.add(subCategoryLbl);
		
		JLabel unitPriceLbl = new JLabel("Unit Price");
		unitPriceLbl.setForeground(new Color(53, 79, 82));
		unitPriceLbl.setBounds(10, 113, 152, 14);
		unitPriceLbl.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldsPanel.add(unitPriceLbl);
		
		JLabel quantityLbl = new JLabel("Quantity");
		quantityLbl.setForeground(new Color(53, 79, 82));
		quantityLbl.setBounds(221, 113, 152, 14);
		quantityLbl.setFont(new Font("Poppins", Font.PLAIN, 12));
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
		optionPanel.setBackground(new Color(132, 169, 140));
		optionPanel.setBounds(433, 84, 122, 166);
		contentPane.add(optionPanel);
		optionPanel.setLayout(null);
		
		JPanel options = new JPanel();
		options.setBackground(new Color(132, 169, 140));
		options.setBounds(10, 11, 102, 144);
		optionPanel.add(options);
		options.setLayout(new GridLayout(0, 1, 5, 5));
		
		JButton addBtn = new JButton("ADD");
		addBtn.setForeground(new Color(202, 210, 197));
		addBtn.setBackground(new Color(82, 121, 111));

		options.add(addBtn);
		
		JButton clrBtn = new JButton("CLEAR");		
		clrBtn.setForeground(new Color(202, 210, 197));
		clrBtn.setBackground(new Color(82, 121, 111));
		options.add(clrBtn);
		
		
		
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String productName = productNameTxtField.getText();
				String categoryName = categoryNameTxtField.getText();
				String subCategoryName = subCategoryTxtField.getText();
				int quantity = Integer.parseInt(quantityTxtField.getText());
				double price = Double.parseDouble(unitPriceTxtField.getText());
				double totalPrice = quantity * price;
				
				int nextId = Inventory.model.getRowCount() + 1;
				
				String [] newRow = {Integer.toString(nextId),
									productName,
									categoryName,
									subCategoryName,
									Integer.toString(quantity),
									Double.toString(price),
									Double.toString(totalPrice)};
				Inventory.model.addRow(newRow);
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
