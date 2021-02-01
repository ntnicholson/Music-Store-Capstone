package com.capstone.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.capstone.entity.Product;
import com.capstone.service.ProductService;
import com.capstone.service.UserService;

@Controller
public class UserDashboard {

	@Autowired
	UserService uService;

	@Autowired
	ProductService pService;
	
	@GetMapping("/dashboard")
	public String dashboard() {
		return "Dashboard";
	}

	@GetMapping("/cart")
	public ModelAndView cart(@SessionAttribute("CURRENT_USER_ID") Long sessionID) {
		
		ModelAndView mav = new ModelAndView("ShoppingCart", "productList", uService.getCartList(sessionID));
		
		for(Product p : uService.getCartList(sessionID)) {
			p.toString();
		}	

		return mav;
	}
	//Delete
	@GetMapping(value="/remove/{id}") 
	public void removeFromCart(@SessionAttribute("CURRENT_USER_ID") Long sessionID, @PathVariable("id") Long id, HttpServletResponse response) throws IOException 
	{
		uService.removeFromCart(uService.findByID(sessionID), pService.findByID(id));
		response.sendRedirect("/cart");
	}

}
