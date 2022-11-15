package model.dao;

import java.util.List;

import domain.Product;

public interface IProductDao {
	
	void insert(Product product);
	void update(Product product);
	void deleteByName(String name);
	List<Product> findAll();
}
