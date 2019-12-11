package com.ashvini.eShopping.DAOImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ashvini.eShopping.DAO.CategoryDAO;
import com.ashvini.eShopping.DTO.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();
	
	static {
		Category c1 = new Category();
		c1.setId(1);
		c1.setName("Mobile");
		c1.setDescription("This is the description of Mobile");
		c1.setImageURL("mob1.png");
		
		categories.add(c1);
		  c1 = new Category();
			c1.setId(2);
			c1.setName("Televsion");
			c1.setDescription("This is the description of Television");
			c1.setImageURL("tv1.png");
			
			categories.add(c1);
			  c1 = new Category();
				c1.setId(3);
				c1.setName("Laptop");
				c1.setDescription("This is the description of Laptop");
				c1.setImageURL("lap1.png");
				
				categories.add(c1);
	}
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		System.out.println("Inside the list()");
		
		return categories;
	}
	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		for(Category c: categories)
		{
			if(c.getId()==id)
				return c;
		}
		return null;
	}

}
