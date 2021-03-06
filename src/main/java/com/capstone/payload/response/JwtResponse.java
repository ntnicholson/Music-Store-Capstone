package com.capstone.payload.response;

import java.util.List;

import com.capstone.entity.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter //hide type
@ToString
public class JwtResponse {
	private String token;
	
	private String type = "Bearer";
	private Long id;
	private String username;
	private String email;
	private List<String> roles;
	
	public JwtResponse(String accessToken, Long id, String username, String email, List<String> roles) {
		this.token = accessToken;
		this.id = id;
		this.username = username;
		this.email = email;
		this.roles = roles;
	}
	public boolean isEmpty() {
		if (this.id == null) {
			return true;
		}
		else {
			return false;
		}
			
			
	}
}
