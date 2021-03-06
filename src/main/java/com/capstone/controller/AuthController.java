package com.capstone.controller;

import java.io.IOException;
import java.util.HashSet;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.entity.ERole;
import com.capstone.entity.Role;
import com.capstone.entity.User;
import com.capstone.payload.request.LoginRequest;
import com.capstone.payload.request.SignupRequest;
import com.capstone.payload.response.JwtResponse;
import com.capstone.payload.response.MessageResponse;
import com.capstone.repository.RoleRepository;
import com.capstone.repository.UserRepository;
import com.capstone.security.jwt.JwtUtils;
import com.capstone.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin") //ResponseEntity<?>
	public void authenticateUser(@Valid LoginRequest loginRequest, HttpServletRequest request, HttpServletResponse response) throws IOException { //@RequestBody

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		Authentication a = SecurityContextHolder.getContext().getAuthentication();
		UserDetailsImpl userD = (UserDetailsImpl) a.getPrincipal();	
		
		JwtResponse head = new JwtResponse(jwt, 
				 userDetails.getId(), 
				 userDetails.getUsername(), 
				 userDetails.getEmail(), 
				 roles);
		//session
		saveSession(head, request);
		
		//cookie
		Cookie cookie = new Cookie("jwt", head.getToken() + head.getType() + head.getId() + head.getUsername() + head.getRoles()); //name and value of the cookie
		cookie.setMaxAge(6000000); //expire could be 60 (seconds)
		//cookie.setHttpOnly(true);
		cookie.setPath("/");
		
		response.addCookie(cookie);
		response.sendRedirect("/home");
//		return ResponseEntity.ok(new JwtResponse(jwt, 
//												 userDetails.getId(), 
//												 userDetails.getUsername(), 
//												 userDetails.getEmail(), 
//												 roles));
	}

	@PostMapping("/signup") //ResponseEntity<?>
	public void registerUser(@Valid SignupRequest signUpRequest, HttpServletResponse response) throws IOException {//@RequestBody
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			//response.getWriter();
			response.sendError(0, "Username exists");
//			return ResponseEntity
//					.badRequest()
//					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			response.sendError(0, "Email exists");
//			return ResponseEntity
//					.badRequest()
//					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		User user = new User(signUpRequest.getUsername(), 
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()));

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				case "mod":
					Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);

					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);
		response.sendRedirect("/login");
		//return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	private void saveSession(JwtResponse jwt, HttpServletRequest r) 
	{
		HttpSession session = r.getSession();
		session.setAttribute("SPRING_SECURITY_CONTEXT", jwt);
		session.setAttribute("CURRENT_USER_ID", jwt.getId());
		session.setMaxInactiveInterval(30000000);
	}
}