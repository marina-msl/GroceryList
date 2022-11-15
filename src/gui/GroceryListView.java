package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controller.GroceryListTableModel;
import controller.ProductController;
import domain.Product;
import repository.ProductDao;

public class GroceryListView extends JFrame implements IProduct {

	private JLabel productLbl;
	private JTextField productNameTextField;
	private JLabel amountLbl;
	private JTextField amountTextField;
	private JLabel priceLbl;
	private JTextField priceTextField;
	private JLabel listLbl;
	private ProductController productController;
	private JTable table = new JTable();

	public GroceryListView() {
		super("Grocery List");
		config();
		buildLayout();
		pack();
		setLocationRelativeTo(null);
		
		productController = new ProductController(this);
		productController.loadDataInTable();
		setVisible(true);
	}

	private void buildLayout() {
		JPanel pane = new JPanel();
		add(pane);
		pane.setLayout(new GridBagLayout());

		productLbl = new JLabel("Product");
		GridBagConstraints c1 = createGridBagConstraints(0,0);
		c1.anchor = GridBagConstraints.SOUTH;
		pane.add(productLbl, c1);

		productNameTextField = new JTextField();
		GridBagConstraints c2 = createGridBagConstraints(0, 1);
		c2.ipadx = 100;
		//c2.ipady = 0;
		pane.add(productNameTextField, c2);

		amountLbl = new JLabel("Amount");
		GridBagConstraints c3 = createGridBagConstraints(1, 0);
		c3.anchor = GridBagConstraints.SOUTH;
		pane.add(amountLbl, c3);

		amountTextField = new JTextField();
		GridBagConstraints c4 = createGridBagConstraints(1, 1);
		c4.ipadx = 100;
		pane.add(amountTextField, c4);

		priceLbl = new JLabel("Price");
		GridBagConstraints c5 = createGridBagConstraints(2, 0);
		c5.anchor = GridBagConstraints.SOUTH;
		pane.add(priceLbl, c5);

		priceTextField = new JTextField();
		GridBagConstraints c6 = createGridBagConstraints(2, 1);
		c6.ipadx = 100;
		pane.add(priceTextField, c6);

		JButton saveProductButton = new JButton("Save Product");
		GridBagConstraints c7 = createGridBagConstraints(2, 3);
		pane.add(saveProductButton, c7);
		saveProductButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				productController.onSetProduct();
			}
		});

		

		listLbl = new JLabel("Product's List");
		GridBagConstraints c8 = createGridBagConstraints(0, 4);
		pane.add(listLbl, c8);
		List<Product> products = ProductDao.getInstance().findAll();
		GroceryListTableModel model = new GroceryListTableModel(products);
		table.setModel(model);
		table.setFillsViewportHeight(true);
		GridBagConstraints c9 = createGridBagConstraints(0, 5);
		c9.gridwidth = 3;
		c9.gridheight = 1;
		c9.fill = GridBagConstraints.BOTH;
		pane.add(new JScrollPane(table), c9);
	
		
	}

	

	private GridBagConstraints createGridBagConstraints(int coluna, int linha) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = coluna;
		gbc.gridy = linha;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.NONE;
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
		setPreferredSize(new Dimension(500, 500));
	}

	public void setProduct() {
		

		
	}

	public Product getProduct() {
		Product product = new Product();
		
		product.setName(productNameTextField.getText());
		product.setAmount(Integer.valueOf(amountTextField.getText()));
		product.setPrice(Double.valueOf(priceTextField.getText()));
		return product;
	}
}
