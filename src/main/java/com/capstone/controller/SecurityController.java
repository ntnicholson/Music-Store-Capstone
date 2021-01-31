package com.capstone.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurityController {

	@GetMapping("/accessdenied")
	public ModelAndView accessDenied403(HttpServletResponse response) {
		return new ModelAndView("th/accessDenied");
	}
}
