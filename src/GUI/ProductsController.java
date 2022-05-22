package GUI;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
	private Label productsList;
	
	@FXML
	private TextField txtProduct;
	
	@FXML
	private TextField txtPrice;
	
	@FXML
	private TextField txtAmount;
	
	@FXML
	private Button btAddProduct;
	
	@FXML
	private Button btModifyProduct;
	
	@FXML
	private Button btRemoveProduct;
	
	@FXML
	private Button btUpdateProductsList;
	
	@FXML
	private TextArea txtAreaList;

	ProductDao productDao = DaoFactory.createProductDao();
	
	@FXML
	public Product onBtAddProductAction() {
		String nameProduct = txtProduct.getText();
		double priceProduct = Double.parseDouble(txtPrice.getText());
		int amountProduct = Integer.parseInt(txtAmount.getText());
		
		Product p = new Product(nameProduct, priceProduct, amountProduct);
		productDao.insert(p);
		onBtUpdateProductsList();

		return p;
	}
	
	@FXML
	public void onBtUpdateProductsList() {
	List<Product> list = productDao.findAll();
	txtAreaList.setText("Product      Amout       Price\n");
	
	for (Product plist : list) {
		txtAreaList.appendText(plist.getName() 
				+ "      " + plist.getAmount() 
				+ "      " + plist.getPrice()
				+ "\n");
	}
		
		
	}
}
	
