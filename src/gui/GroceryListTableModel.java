package gui;

import javax.swing.table.AbstractTableModel;

public class GroceryListTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private String[] columnNames = { "Product", "Price", "Amount" };
	private Object[][] data = { 
			{ "Strawberries", "8", "10"}, 
			{ "Blueberries", "8", "10"}, 
			{ "Raspberries", "8", "10"}, 
			{ "Pringles", "8", "10"}, 
			{ "Bananas", "3.2", "6" },
			{ "Beans canned", "1.3", "3" } };

	public int getRowCount() {
		return data.length;
	}


	public Object getValueAt(int rowIndex, int columnIndex) {
		return data[rowIndex][columnIndex];
	}
	
	@Override
	public String getColumnName(int rowIndex) {
		return columnNames[rowIndex];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return super.isCellEditable(rowIndex, columnIndex);
	}

	public int getColumnCount() {
		return columnNames.length;
	}

}
