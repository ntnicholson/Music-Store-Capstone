package com.capstone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@GetMapping(value = "/home")
	public ModelAndView home() {
		return new ModelAndView("home.html");
	}
	@GetMapping(value = "/login")
	public ModelAndView login() {
		return new ModelAndView("login.html");
	}
	@GetMapping(value = "/hello")
	public ModelAndView hello() {
		return new ModelAndView("login.html");
	}
}
