package Application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

/*
 * public class ProductRecovery {
 * 
 * public static void main(String[] args) {
 * 
 * 
 * Connection conn = null; Statement st = null; ResultSet rs = null;
 * 
 * try{ conn = DB.getConnection(); st = conn.createStatement(); rs =
 * st.executeQuery("select * from product");
 * 
 * while (rs.next()) { System.out.println("Name product: " +
 * rs.getString("NAME") + "\nAmount product: " + rs.getInt("AMOUNT") +
 * "\nPrice product: " + rs.getDouble("PRICE")); } } catch(SQLException e){
 * e.printStackTrace(); } finally { DB.closeResultSet(rs);
 * DB.closeStatement(st); DB.closeConnection(); } } }
 */
