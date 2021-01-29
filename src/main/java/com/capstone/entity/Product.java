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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String condition;
	private String description;
	private double price;
	@Lob
	private byte[] image;
	@Lob
	private String base64Image;
	private Integer inventoryCount;
//	private boolean available;
	
	@ManyToMany(mappedBy = "shoppingCart")
	private Set<User> productInCart = new HashSet<>();
//	@OneToMany(mappedBy = "product")
//    private Set<ShoppingBasket> productsInCart = new HashSet<>();
}
