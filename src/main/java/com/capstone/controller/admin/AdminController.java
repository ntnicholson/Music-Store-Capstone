package com.capstone.controller.admin;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin")
public class AdminController {

	@GetMapping("/dashboard")
	public String dashboard(HttpSession session) {
		return "Dashboard";
	}
	
}
