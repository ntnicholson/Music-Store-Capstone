package com.capstone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.capstone.entity.Product;
import com.capstone.service.UserService;

@Controller
public class UserDashboard {

	@Autowired
	UserService uService;

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

}
