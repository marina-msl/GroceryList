package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import domain.Product;

public class GroceryListTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
	private static final int PRODUCT = 0;
	private static final int PRICE = 1;
	private static final int AMOUNT = 2 ;

	private String[] columnNames = { "Product", "Price", "Amount" };
	private List <Product> products = new ArrayList<>();
	
	public GroceryListTableModel(List<Product> products) {
		this.products = products;
	}
	
	@Override
	public int getRowCount() {
		return products.size();

	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		String value = "";
		
		Product product = products.get(rowIndex);
		switch (columnIndex) {
		case 0:
			value = product.getName();
			break;
		case 1:
			value = String.valueOf(product.getPrice());
			break;
		case 2:
			value = String.valueOf(product.getAmount());
		default:
			break;
		}
		return value;
	}
	

	public int getColumnCount() {
		return columnNames.length;
	}

	public void addItem(Product product) {
		products.add(product);
		fireTableRowsInserted(0, products.size()-1);
	}

	public void clear() {
		if(getRowCount() > 0) {
			fireTableRowsDeleted(0, getRowCount() -1);
			products.clear();
		}
	}
}
