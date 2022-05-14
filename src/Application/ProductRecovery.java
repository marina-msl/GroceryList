package Application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class ProductRecovery {

	public static void main(String[] args) {
		
	
	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;

		try{
			conn = DB.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select * from product");
	
			while (rs.next()) {
				System.out.println("Name product: " + rs.getString("NAME_PRODUCT") + "\nAmount product: "
						+ rs.getInt("AMOUNT_PRODUCT") + "\nPrice product: " + rs.getDouble("PRICE_PRODUCT"));
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
	}
}
