package com.capstone.controller;

import java.security.Principal;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.capstone.entity.User;
import com.capstone.payload.request.LoginRequest;
import com.capstone.payload.request.SignupRequest;
import com.capstone.payload.response.JwtResponse;
import com.capstone.security.services.UserDetailsImpl;

@Controller
public class HomeController {

	
	@GetMapping(value = "/home")
	public ModelAndView home() {
		return new ModelAndView("home");
	}
	@GetMapping(value = "/login")
	public ModelAndView login() {
		return new ModelAndView("thyme/login.html", "userLogin", new LoginRequest());
	}

	@GetMapping(value = "/register")
	public ModelAndView register(Model m) {
		ModelAndView mav = new ModelAndView("thyme/register.html", "userSignup", new SignupRequest());

		return mav;
	}
	/*
	 * @GetMapping(value = "/showUser")
	 * 
	 * @ResponseBody public String show(HttpServletRequest request) {
	 * 
	 * HttpSession session = request.getSession(true);
	 * System.out.println(session.getAttribute("SPRING_SECURITY_CONTEXT"));
	 * JwtResponse jwt = (JwtResponse)
	 * session.getAttribute("SPRING_SECURITY_CONTEXT");
	 * 
	 * return jwt.getId() + " " + jwt.getUsername(); }
	 */
}
