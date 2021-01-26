package com.capstone.entity;

import java.util.Set;

import javax.persistence.OneToMany;


public class User {

	
	@OneToMany(mappedBy = "product")
    Set<ShoppingBasket> items;
}
