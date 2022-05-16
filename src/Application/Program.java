// TODO
// 1 - Organizing classes -> DB
// 3 - Code IHM
// 4 - Organizing classes -> GUI

package Application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import GUI.ProductsView;
import db.DB;
import db.DbException;
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
		
		Connection conn = null;
		
		Statement st = null;
		ResultSet rs = null;

			try{
				conn = DB.getConnection();
				st = conn.createStatement();
				rs = st.executeQuery("select * from product");
		
				while (rs.next()) {
					System.out.println("Name product: " + rs.getString("NAME") + "\nAmount product: "
							+ rs.getInt("AMOUNT") + "\nPrice product: " + rs.getDouble("PRICE"));
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			finally	{
				DB.closeResultSet(rs);
				DB.closeStatement(st);
				DB.closeConnection();
			}
			
			
			// ----------------> Requesting which product should be delete in database
		}
	}	
