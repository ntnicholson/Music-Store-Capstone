package com.capstone.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.capstone.entity.Genre;
import com.capstone.entity.Orders;
import com.capstone.entity.Product;
import com.capstone.entity.User;
import com.capstone.service.OrderService;
import com.capstone.service.ProductService;
import com.capstone.service.UserService;

@Controller
public class UserDashboard {

	@Autowired
	UserService uService;
	@Autowired
	OrderService oService;

	@Autowired
	EntityManager em;
	
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
	@GetMapping(value="/update/details")
	@PreAuthorize("hasRole('ROLE_USER')")
	public ModelAndView updateTask(@SessionAttribute("CURRENT_USER_ID") Long sessionID) 
	{
		User u = uService.findByID(sessionID);
		return new ModelAndView("UpdateUserDetails", "user", u);
	}
	@PostMapping(value="/update/details") @Transactional
	public void updateDetails(@Valid @ModelAttribute("user") User u, BindingResult bindingResult, 
			Model model, HttpServletResponse response) throws IOException {
		
		uService.updateDetails(u);
		response.sendRedirect("/cart");
	}
	@GetMapping(value="/confirm/details")
	public ModelAndView confirmAddress(@SessionAttribute("CURRENT_USER_ID") Long sessionID) {
		User u = uService.findByID(sessionID);
		return new ModelAndView("ConfirmUserDetails", "user", u);
	}
	@GetMapping(value="/submit/order")
	public void submitOrder(@SessionAttribute("CURRENT_USER_ID") Long sessionID, HttpServletResponse response) throws IOException {
		User u = uService.findByID(sessionID);
		Orders o = new Orders();
		Set<Product> orders = new HashSet<Product>(u.getShoppingCart());
		o.setOrders((Set<Product>) orders);
		oService.saveOrder(o);
		//empty cart
		uService.removeAllFromCart(u);
		response.sendRedirect("/cart");
	}

}
