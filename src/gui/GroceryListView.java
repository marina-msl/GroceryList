package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.ScrollPane;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

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
		add(pane);
		pane.setLayout(new GridBagLayout());

		productLbl = new JLabel("Product");
		GridBagConstraints c1 = createGridBagConstraints(0,0);
		pane.add(productLbl, c1);

		productTextField = new JTextField();
		GridBagConstraints c2 = createGridBagConstraints(0, 1);
		pane.add(productTextField, c2);

		amountLbl = new JLabel("Amount");
		GridBagConstraints c3 = createGridBagConstraints(1, 0);
		pane.add(amountLbl, c3);

		amountTextField = new JTextField();
		GridBagConstraints c4 = createGridBagConstraints(1, 1);
		pane.add(amountTextField, c4);

		priceLbl = new JLabel("Price");
		GridBagConstraints c5 = createGridBagConstraints(2, 0);
		pane.add(priceLbl, c5);

		priceTextField = new JTextField();
		GridBagConstraints c6 = createGridBagConstraints(2, 1);
		pane.add(priceTextField, c6);

		JButton addProductButton = new JButton("Add Product");
		GridBagConstraints c7 = createGridBagConstraints(2, 3);
		pane.add(addProductButton, c7);

		JTable listTable = new JTable();

		listLbl = new JLabel("List");
		GridBagConstraints c8 = createGridBagConstraints(0, 4);
		pane.add(listLbl, c8);

		GroceryListTableModel model = new GroceryListTableModel();
		listTable.setModel(model);
		GridBagConstraints c9 = createGridBagConstraints(0, 5);
		c9.gridwidth = 3;
		c9.gridheight = 1;
		pane.add(new JScrollPane(listTable), c9);
	}

	private GridBagConstraints createGridBagConstraints(int coluna, int linha) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = coluna;
		gbc.gridy = linha;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.ipadx = 0;
		gbc.ipady = 0;
		gbc.ipady = 0;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weightx = 0.5;
		gbc.weighty = 0.5;
		return gbc;
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
