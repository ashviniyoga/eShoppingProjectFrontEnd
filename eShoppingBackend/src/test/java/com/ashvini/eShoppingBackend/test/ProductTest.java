package com.ashvini.eShoppingBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ashvini.eShopping.DAO.ProductDAO;
import com.ashvini.eShopping.DTO.Product;

public class ProductTest {

	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private Product product;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.ashvini.eShopping");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
		
	}
	
	@Test
	public void productTestCase() {
		product = new Product();
		System.out.println(product.getCode());
		product.setName("Samsung Galaxy");
		product.setBrand("Samsung");
		product.setDescription("Samsung phone has been added into the product list" );
		product.setCategoryID(3);
		product.setIsactive(true);
		product.setSupplierId(3);
		System.out.println("Inside Test()");
		assertEquals("Someething when wrong in adding a new Product", true, productDAO.addProduct(product));
		
		product = productDAO.get(3);
//		product.setName("Ashvini Mobile");
		
		assertEquals("Something went wrong in updating", true,productDAO.updateProduct(product));
		
		assertEquals("Someting went wrong in deleting", true, productDAO.deleteProduct(product));
		
		assertEquals("Something went wrong in list",9, productDAO.list().size());
	}
}
