package com.capstone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.capstone.payload.request.SignupRequest;

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
	@GetMapping(value = "/register")
	public ModelAndView register(Model m) {
		ModelAndView mav = new ModelAndView("register.html", "userSignup", new SignupRequest());

		return mav;
	}
}
