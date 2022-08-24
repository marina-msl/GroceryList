package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

public class GroceryListView extends JFrame {

	private JLabel productLbl;
	private JTextField productTextField;
	private JLabel amountLbl;
	private JTextField amountTextField;
	private JLabel priceLbl;
	private JTextField priceTextField;
	private JLabel listLbl;

	public GroceryListView() {
		super("Grocery List");
		config();
		buildLayout();
		pack();
		setVisible(true);
	}

	private void buildLayout() {
		JPanel pane = new JPanel();
		setContentPane(pane);
		setLayout(new BorderLayout());
		
		pane.add(createPanel(), BorderLayout.NORTH);
		pane.add(createTable(), BorderLayout.SOUTH);

	}

	private JComponent createTable() {
		JPanel pane = new JPanel();
		JTable listTable = new JTable();
		
		listLbl = new JLabel("List");
		pane.add(listLbl);
		
		GroceryListTableModel model = new GroceryListTableModel(); 
		listTable.setModel(model);
		pane.add(listTable);

		return pane;
	}

	private JComponent createPanel() {

		JPanel pane = new JPanel();
		
		productLbl = new JLabel("Product");
		pane.add(productLbl);

		productTextField = new JTextField();
		pane.add(productTextField);

		amountLbl = new JLabel("Amount");
		pane.add(amountLbl);

		amountTextField = new JTextField();
		pane.add(amountTextField);

		priceLbl = new JLabel("Price");
		pane.add(productLbl);

		priceTextField = new JTextField();
		pane.add(priceTextField);

		JButton addProductButton = new JButton("Add Product");
		pane.add(addProductButton);

		return pane;
	}

	private void config() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setPreferredSize(new Dimension(500, 500));
	}

	public static void main(String[] args) {
		new GroceryListView();
	}
}
