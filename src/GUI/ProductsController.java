package GUI;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.dao.DaoFactory;
import model.dao.ProductDao;
import model.entities.Product;

public class ProductsController {
	
	@FXML
	private Label product;
	
	@FXML
	private Label price;
	
	@FXML
	private Label amount;
	
	
	@FXML
	private TextField txtProduct;
	
	@FXML
	private TextField txtPrice;
	
	@FXML
	private TextField txtAmount;
	
	@FXML
	private Button btAddProduct;
	
	
	@FXML
	public void onBtAddProductAction() {
		ProductDao productDao = DaoFactory.createProductDao();
		System.out.println("Click");
		
		String nameProduct = txtProduct.getText();
		double priceProduct = Double.parseDouble(txtPrice.getText());
		int amountProduct = Integer.parseInt(txtAmount.getText());
		Product p = new Product(nameProduct, priceProduct, amountProduct);
		productDao.insert(p);
		
		 System.out.println("Inserted! New product " + p.getName() + " id: " + p.getId());
			
			
		// --------------> Recovering data
		 System.out.println("Product List");
		List<Product> list = productDao.findAll();
		for (Product plist : list) {
			System.out.println(plist.getName());
		
		}
	}
}
	
