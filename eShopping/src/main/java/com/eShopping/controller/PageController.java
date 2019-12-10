package com.eShopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		//mv.addObject("greeting","ASHVINI, Welcome to the Spring MVC eShopping Project");
		mv.addObject("title","Home");
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
