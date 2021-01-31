package com.capstone.controller;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.capstone.entity.User;
import com.capstone.payload.request.LoginRequest;
import com.capstone.payload.request.SignupRequest;
import com.capstone.payload.response.JwtResponse;
import com.capstone.security.services.UserDetailsImpl;

@Controller
public class HomeController {

//    @GetMapping("/")
//    String index(Principal principal) {
//        return principal != null ? "th/home/homeSignedIn.html" : "th/home/homeNotSignedIn.html";
//    }
    
	@GetMapping(value = "/home")
	@PreAuthorize("hasRole('ROLE_USER')")
	public ModelAndView home() {
		return new ModelAndView("home");
	}
	@GetMapping(value = "/login")
	public ModelAndView login() {
		return new ModelAndView("th/login.html", "userLogin", new LoginRequest());
	}
	@GetMapping(value = "/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession s = request.getSession();
		s.invalidate();
		response.sendRedirect("/home");
	}

	@GetMapping(value = "/register")
	public ModelAndView register(Model m) {
		System.out.println("inregister");
		ModelAndView mav = new ModelAndView("th/register.html", "userSignup", new SignupRequest());

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
