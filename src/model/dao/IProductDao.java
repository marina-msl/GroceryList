package model.dao;

import java.util.List;

import model.entities.Product;

public interface IProductDao {
	
	void insert(Product obj);
	void update(Product obj);
	void deleteByName(String name);
	List<Product> findAll();
}