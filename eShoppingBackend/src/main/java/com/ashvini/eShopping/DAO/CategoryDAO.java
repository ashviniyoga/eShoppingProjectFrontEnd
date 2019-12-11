package com.ashvini.eShopping.DAO;

import java.util.List;

import com.ashvini.eShopping.DTO.Category;

public interface CategoryDAO {
	
	List<Category> list();
	Category get(int id);
	

}
