package Test2;

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

public class Receipt extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel receipt;

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
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        String[] header = {"Product Name","Quantity", "Item Price", "Total Price"};

        receipt = new DefaultTableModel();
        receipt.setColumnIdentifiers(header);

        table = new JTable(receipt);
        table.setBounds(10, 10, 414, 174);
        contentPane.add(table);

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(table.getBounds());
        contentPane.add(scroll);

        JButton delButton = new JButton("Delete");
        delButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                receipt.removeRow(table.getSelectedRow());
            }
        });
        delButton.setBounds(10, 210, 89, 23);
        contentPane.add(delButton);

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                receipt.setRowCount(0);
            }
        });
        clearButton.setBounds(335, 210, 89, 23);
        contentPane.add(clearButton);

        JButton backBtn = new JButton("Back");
        backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                MainMenu mainMenu = new MainMenu();
                mainMenu.setVisible(true);
                MainMenu.sales.setVisible(false);
                MainMenu.inventory.setVisible(false);
            }
        });
        backBtn.setBounds(174, 210, 89, 23);
        contentPane.add(backBtn);
    }

    public void addItemToTable(Object[] data) {
        receipt.addRow(data);
    }
}
