package com.capstone.controller.admin;


import javax.servlet.http.HttpSession;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller //@Secured("ROLE_ADMIN")
@RequestMapping("/admin")
public class AdminController {

	@GetMapping("/dashboard")
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String dashboard(HttpSession session) {
		return "AdminDashboard";
	}
	
}
