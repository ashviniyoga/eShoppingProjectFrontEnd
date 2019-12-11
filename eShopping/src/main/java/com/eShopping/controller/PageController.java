package com.eShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ashvini.eShopping.DAO.CategoryDAO;
import com.ashvini.eShopping.DTO.Category;

@Controller
public class PageController {

	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		//mv.addObject("greeting","ASHVINI, Welcome to the Spring MVC eShopping Project");
		mv.addObject("title","Home");
		mv.addObject("Category", categoryDAO.list());
		mv.addObject("userClickHome", true);
		return mv;
	}
	
	@RequestMapping(value= "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
	 	mv.addObject("title","About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}
	
	@RequestMapping(value= "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}
	
	/*Methods to load all products*/
	@RequestMapping(value= "/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");		 
		mv.addObject("title","All Products");
		mv.addObject("Category", categoryDAO.list());
		mv.addObject("userClickAllProduct", true);
		return mv;
	}
 
	/*Methods to load Category products*/
	@RequestMapping(value= "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		System.out.println("Inside show category");
		ModelAndView mv = new ModelAndView("page");
		
		/*Category to fetch a single item */
		Category category = null;
		category= categoryDAO.get(id);
		System.out.println("Category ID " + category.getId());
		mv.addObject("title", category.getName());
		System.out.println("Category ID " + category.getName());
		mv.addObject("Category", categoryDAO.list());
		
		/* To pass a single category */
		mv.addObject("category", category );
		mv.addObject("userClickCategoryProduct", true);
		return mv;
	}
	
//	@RequestMapping(value= "/test")
//	public ModelAndView testRequestParam(@RequestParam(value="greeting",required = false)String reqPar) {
//		if(reqPar==null) {
//			reqPar = "Welcome to Page";	
//		}
//		ModelAndView mv = new ModelAndView("page");
//		System.out.println(reqPar);
//		mv.addObject("greeting", reqPar);
//		return mv;
//		
//	}
	
//	@RequestMapping(value= "/test/{greeting}")
//	public ModelAndView testRequestParam(@PathVariable("greeting")String reqPar) {
//		if(reqPar==null) {
//			reqPar = "Welcome to Page";	
//		}
//		ModelAndView mv = new ModelAndView("page");
//		System.out.println(reqPar);
//		mv.addObject("greeting", reqPar);
//		return mv;
//		
//	}
	
}
