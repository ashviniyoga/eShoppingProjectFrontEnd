package com.ashvini.eShoppingBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ashvini.eShopping.DAO.CategoryDAO;
import com.ashvini.eShopping.DTO.Category;

public class CategoryTest {
	
	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.ashvini.*");
		context.refresh();
		//System.out.println("Inside the init ()");
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
		//System.out.println("After session factory get bean ()");
	}
	
//	@Test
//	public void addTestCategory() {
//		System.out.println("Inside @Test");
//		 category = new Category();
//		 category.setName("Tablet");
//		 category.setDescription("This is the table description");
//		 category.setImageURL("cat_111");
//		 System.out.println("after the #Test");
//		  
//		 assertEquals("Successfully added a category in database", true, categoryDAO.add(category));
//	}

//	@Test
//	public void getTestCategory() {
//		System.out.println("Inside the get Testcategory()");
//		
//		category = categoryDAO.get(3);
//		
//		assertEquals("Succesfully fetched data from the table",true, category.getName());
//	}
	
//	@Test
//	public void updateTestCategory() {
//		System.out.println("Inside the Update()");
//		
//		category = categoryDAO.get(2);
//		
//		category.setName("TV");
//		
//		assertEquals("Succesfully updated data from the table", true, categoryDAO.update(category));
//		
//	}
	
//	@Test
//	public void deleteTestCategory() {
//		System.out.println("Inside the delete()");
//		
//		category = categoryDAO.get(2);
//		
//				
//		assertEquals("Succesfully updated data from the table", true, categoryDAO.delete(category));
//		
//	}
	
	
//	@Test
//	public void listTestCategory() {
//		System.out.println("Inside the list()");
//		
//				
//		assertEquals("Succesfully fetched list data from the table", 4, categoryDAO.list().size());
//		
//	}
	
	@Test
	public void TestCRUDCategory() {
		
		category = new Category();
		category.setName("Mayur");
		category.setDescription("My Son");
		category.setImageURL("mayur1.png");
		category.setActive(true);
		
		assertEquals("Successfully inserted", true, categoryDAO.add(category));
		
		category = new Category();
		category.setName("Shreya");
		category.setDescription("My daughter");
		category.setImageURL("shreya1.png");
		assertEquals("Successfully inserted", true, categoryDAO.add(category));
		
		
		
		category = new Category();
		category = categoryDAO.get(7);
		category.setName("MayurChandra");
		
		assertEquals("Succesfully fetch data ---", true, categoryDAO.update(category));
		
		assertEquals("Succesfully deleted",true, categoryDAO.delete(category));
		
		
		
	}

}
