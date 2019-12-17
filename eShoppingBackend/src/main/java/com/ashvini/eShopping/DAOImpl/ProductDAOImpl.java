package com.ashvini.eShopping.DAOImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ashvini.eShopping.DAO.ProductDAO;
import com.ashvini.eShopping.DTO.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public Product get(int productId) {
		// TODO Auto-generated method stub
		try {
			return sessionfactory.getCurrentSession().get(Product.class,Integer.valueOf(productId));
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<Product> list() {
		// TODO Auto-generated method stub
		try {
			return sessionfactory.getCurrentSession().createQuery("from Product",Product.class).getResultList();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Inside try block addProduct()");
			sessionfactory.getCurrentSession().persist(product);  //persis is used to add new product
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		try {
			sessionfactory.getCurrentSession().update(product);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteProduct(Product product) {
		// TODO Auto-generated method stub
		try {
			product.setIsactive(false);
			return this.updateProduct(product);
			}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	
	
	@Override
	public List<Product> listActiveProduct() {
		// TODO Auto-generated method stub
		String selectActiveProducts = "From Product where isactive = :active";
		return sessionfactory.getCurrentSession().
				createQuery(selectActiveProducts, Product.class)
				.setParameter("active", true).getResultList();
	}

	@Override
	public List<Product> listActiveProductByCategory(int categoryId) {
		String listActiveProductCategory = "From Product where isactive=:active and categoryID = :cid ";
			return sessionfactory.getCurrentSession()
						.createQuery(listActiveProductCategory, Product.class)
							.setParameter("active", true)
							.setParameter("cid",categoryId).getResultList();
	}

	@Override
	public List<Product> getLatestActiveProduct(int count) {
		// TODO Auto-generated method stub
		String latestActiveProduct = "From Product where isactive=:active Order by id";
		return sessionfactory.getCurrentSession().createQuery(latestActiveProduct, Product.class)
				.setParameter("active",true)
				.setFirstResult(0)
				.setMaxResults(count)
				.getResultList();
	}

}
