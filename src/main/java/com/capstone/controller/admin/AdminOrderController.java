package com.capstone.controller.admin;


import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.capstone.entity.Orders;
import com.capstone.service.OrderService;

@RestController
@RequestMapping("/admin/orders")
public class AdminOrderController {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	EntityManager em;
	
	//Display
	@GetMapping("/manage")
	public ModelAndView displayAll() {
		ModelAndView mav = new ModelAndView("ManageOrders", "orderList", orderService.findAll());
		
		return mav;
	}
	
	@GetMapping(value="/update/{id}")
	public ModelAndView updateOrder(@PathVariable("id") Long id) 
	{
		Orders o = orderService.findById(id);
		return new ModelAndView("UpdateOrder", "order", o);
	}
	@PostMapping(value="/update/{id}") @Transactional
	public void updateOrder(@Valid @ModelAttribute("order") Orders o, BindingResult bindingResult, 
			Model model, HttpServletResponse response) throws IOException {
		
		em.merge(o);
		response.sendRedirect("/admin/orders/manage");
	}
}
