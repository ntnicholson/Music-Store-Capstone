package com.capstone.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "USER_ORDERS",
	joinColumns = @JoinColumn(name = "user_id"), 
	inverseJoinColumns = @JoinColumn(name = "product_id"))
	private Set<Product> orders = new HashSet<>();
	
	private String status;
	
	

}
