// TODO
// 1 - Organizing classes -> DB
// 3 - Code IHM
// 4 - Organizing classes -> GUI

package Application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.ProductDao;
import model.entities.Product;

public class Program {
	
	public static void main(String[] args) {
		
		//ProductsView.createAndShowGUI();
		
		
		//ja esta conectado
		ProductDao productDao = DaoFactory.createProductDao();
		
		
		Scanner sc = new Scanner(System.in);
		// ---------------> Requesting data's products from users
		  System.out.println("Digite o nome do produto"); 
		  String name = sc.next();
				
		  System.out.println("Digite o preço do produto"); 
		  double price = sc.nextDouble();
		  
		  System.out.println("Digite a quantidade do produto"); 
		  int amount = sc.nextInt();
		  
		  Product p = new Product(name, price, amount);
		 
		
		// insert testing
		 productDao.insert(p);
		 System.out.println("Inserted! New product " + p.getName() + " id: " + p.getId());
		
		
		// --------------> Recovering data
		 System.out.println("Product List");
		List<Product> list = productDao.findAll();
		for (Product plist : list) {
			System.out.println(plist.getName());
		}
		
			
			
			// ----------------> Requesting which product should be delete in database
		}
	}	
