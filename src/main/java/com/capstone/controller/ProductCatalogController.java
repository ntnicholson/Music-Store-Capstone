package com.capstone.controller;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.capstone.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductCatalogController {

	@Autowired
	ProductService productService;
	
	//Display
	@GetMapping("/catalog/{id}")
	public ModelAndView displayAll() {
		ModelAndView mav = new ModelAndView("ManageProduct", "productList", productService.findAll());
		
		return mav;
	}
}
