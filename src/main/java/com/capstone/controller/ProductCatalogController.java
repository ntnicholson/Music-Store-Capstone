package com.capstone.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.capstone.entity.Product;
import com.capstone.entity.User;
import com.capstone.service.ProductService;
import com.capstone.service.UserService;

@Controller
@RequestMapping("/product")
public class ProductCatalogController {

	@Autowired
	ProductService productService;
	
	@Autowired
	UserService userService;
	
	//Display
	@GetMapping("/catalog")
	public ModelAndView displayAll() {
		ModelAndView mav = new ModelAndView("ProductCatalog", "productList", productService.findAll());
		
		return mav;
	}
	@PostMapping("/catalog")
	public ModelAndView search(@RequestParam("query") String query) {
		System.out.println(query);
		ModelAndView mav = new ModelAndView("ProductCatalog", "productList", productService.search(query));
		
		return mav;
	}
	@GetMapping("/{id}")
	public ModelAndView getProductDetails(@PathVariable("id") Long id) {
		Product p = productService.findByID(id);
		ModelAndView mav = new ModelAndView("ProductDetails", "product", p);
		
		return mav;
	}
	@PostMapping("/{id}")
	@ResponseBody
	public void addtoCart(@PathVariable("id") Long id, @SessionAttribute("CURRENT_USER_ID") Long sessionID, HttpServletResponse response) throws IOException 
	{
		User u = userService.findByID(sessionID);
		Set<Product> p = u.getShoppingCart();
		p.add(productService.findByID(id));
		u.setShoppingCart(p);

		userService.addToCart(u);
		
		response.sendRedirect("/cart");
	}
}
