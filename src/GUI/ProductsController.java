package GUI;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.dao.DaoFactory;
import model.dao.ProductDao;
import model.entities.Product;

public class ProductsController {
	
	ObservableList  list = FXCollections.observableArrayList();
	
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
	private Button PdfFileGenerator;
	
	@FXML
	private Button TxtFileGenerator;
	
	@FXML 
	private ListView<Product> productList;
	
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
		
		JOptionPane.showMessageDialog(null, "Produto " + p.getName() + " inserido na lista!");

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
	
	@FXML
	public void onBtRemoveProduct() {
		
	}
	
	@FXML
	public void onBtModifyProduct() {
		String nameProduct = txtProduct.getText();
		double priceProduct = Double.parseDouble(txtPrice.getText());
		int amountProduct = Integer.parseInt(txtAmount.getText());
		Product p = new Product(nameProduct, priceProduct, amountProduct);
		productDao.update(p);
	}
	
	private void loadData() {
		list.removeAll(list);
		String a = "Abacate";
		String b = "Banana";
	}
	
	@FXML
	public void onBtPdfFileGenerator() {
		
		JOptionPane.showMessageDialog(null, "Hello PDF file!", "PDF creator", JOptionPane.QUESTION_MESSAGE);

	}
	
	@FXML
	public void onBtTxtFileGenerator() {
		String path = "C:\\Users\\mleide\\tmp\\files\\GroceyList.txt";
		List<Product> list = productDao.findAll();
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
			for (Product product : list ) {
				bw.write(product.getName());
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JOptionPane.showMessageDialog(null, "Text file criated in " + path, "txt creator", JOptionPane.QUESTION_MESSAGE);

	}
	
}
	
