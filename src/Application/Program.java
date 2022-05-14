// TODO
// 1 - Organizing classes
// 3 - Code IHM
// 4 - Put the code into the GIT

package Application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DB;
import db.DbException;

public class Program {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// ---------------> Inser�ao de Dados pelo usuario
		  System.out.println("Digite o nome do produto"); 
		  String name_product = sc.next();
		  
		  System.out.println("Digite a quantidade do produto"); 
		  int amount_product = sc.nextInt();
		  
		  System.out.println("Digite o pre�o do produto"); 
		  double price_product = sc.nextDouble();
		 
		
		// --------------> Inclusao dos dados no banco de dados
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DB.getConnection();
			
			st = conn.prepareStatement(
					"INSERT INTO product "
					+ "(NAME, PRICE, AMOUNT)"
					+ "VALUES "
					+ "(?, ?, ?)");
					
			
			st.setString(1, name_product);
			st.setDouble(2, price_product);
			st.setInt(3, amount_product);
			
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Done! Rows affected: " + rowsAffected);
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		/*
		 * finally { DB.closeStatement(st); DB.closeConnection(); }
		 */
		
		// --------------> Recupera��o de dados do banco de dados
		
		//Connection conn = null;
		
		Statement statement = null;
		ResultSet rs = null;

			try{
				conn = DB.getConnection();
				statement = conn.createStatement();
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
				DB.closeStatement(statement);
				DB.closeConnection();
			}
		}
	}	