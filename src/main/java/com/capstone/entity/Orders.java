package com.capstone.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Orders {

	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
//	@ManyToOne()
//	private User u;
//
//	private Set<Product> orders;
	
	private String status;
	
	

}
