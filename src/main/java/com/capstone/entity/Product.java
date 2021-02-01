package com.capstone.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

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
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String condition;
	private String description;
	private double price;
	@Lob @Nullable
	private byte[] image;
	@Lob @Nullable
	private String base64Image;
	private Integer inventoryCount;
//	private boolean available;
	
	@ManyToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL)
	private Set<User> productInCart = new HashSet<>();
	
//	@OneToMany(mappedBy = "product")
//	private Set<Song> song = new HashSet<>();
	
}
