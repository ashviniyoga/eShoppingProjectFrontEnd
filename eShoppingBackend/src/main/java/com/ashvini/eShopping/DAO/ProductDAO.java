package com.ashvini.eShopping.DAO;

import java.util.List;

import com.ashvini.eShopping.DTO.Product;

public interface ProductDAO {

	Product get(int productId);
	List<Product> list();
	boolean addProduct(Product product);
	boolean updateProduct(Product product);
	boolean deleteProduct(Product product);
	
	List<Product> listActiveProduct();
	List<Product> listActiveProductByCategory(int categoryId);
	List<Product> getLatestActiveProduct(int count);
}
