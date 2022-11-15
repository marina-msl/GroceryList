package controller;

import java.util.List;

import domain.Product;
import gui.IProduct;
import repository.ProductDao;

public class ProductController {
	
	private IProduct view;
	//private GroceryListTableModel model = new GroceryListTableModel();
	
	
	public ProductController(IProduct view) {
		this.view = view;
		
	}

	public void loadDataInTable() {
		//model.clear();
		List<Product> products = ProductDao.getInstance().findAll();
		
		for(Product product: products) {
			//model.addItem(product);
		}
	}
	
	public void onSetProduct() {
		Product product = view.getProduct();
		ProductDao.getInstance().saveProduct(product);
		//model.addItem(product);
	}
}
