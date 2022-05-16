package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.ProductDao;
import model.entities.Product;

public class ProductDaoJDBC implements ProductDao{
	
	private Connection conn;
	
	public ProductDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Product obj) {
		
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO product "
					+ "(NAME, PRICE, AMOUNT)"
					+ "VALUES "
					+ "(?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
					
			
			st.setString(1, obj.getName());
			st.setDouble(2, obj.getPrice());
			st.setInt(3, obj.getAmount());
			
			int rowsAffected = st.executeUpdate();
			
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
				DB.closeResultSet(rs);
			}
			else {
				throw new DbException("Unexpected error! No rows affected.");
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally { 
			DB.closeStatement(st); 
		}
				
	}

	@Override
	public void update(Product obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product> findAll() {
		
		PreparedStatement st = null;
		ResultSet rs = null;

		try{
		
			st = conn.prepareStatement("select * from product");
			rs = st.executeQuery();
			
			List<Product> list = new ArrayList<>();
		
			while (rs.next()) {
				Product obj = new Product(null, 0, 0);
				obj.setId(rs.getInt("id"));
				obj.setName(rs.getString("name"));
				obj.setPrice(rs.getDouble("price"));
				obj.setAmount(rs.getInt("amount"));
				list.add(obj);
			}
			return list;
		}
		catch(SQLException e){
			throw new DbException(e.getMessage());
		}
		finally	{
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}
	
	

}
