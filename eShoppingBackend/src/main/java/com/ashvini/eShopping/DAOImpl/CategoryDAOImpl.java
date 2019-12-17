package com.ashvini.eShopping.DAOImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ashvini.eShopping.DAO.CategoryDAO;
import com.ashvini.eShopping.DTO.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	 
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		System.out.println("Inside the list()");
		String SelectActiveCategory = "From Category where active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(SelectActiveCategory);
		query.setParameter("active",true);
		
		return query.getResultList();
		}
	/* To get single category */
	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		 
		return sessionFactory.getCurrentSession().get(Category.class,Integer.valueOf(id));
		}
	@Override

	public boolean add(Category category) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	/* to update the category */
	@Override
	public boolean update(Category category) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(category);
		return true;	
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	@Override
	public boolean delete(Category category) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(category);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
			}
		
	}

}
