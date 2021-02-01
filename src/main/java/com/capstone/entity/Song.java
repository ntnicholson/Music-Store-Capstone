package com.capstone.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "song_id")
public class Song extends Product { //extends Product

//	public Song(Long id, String name, String condition, String description, double price, byte[] image,
//			String base64Image, Integer inventoryCount, Set<User> productInCart, String artist, String style, String format) {
//		super(id, name, condition, description, price, image, base64Image, inventoryCount, productInCart);
//		this.artist = artist;
//		this.style = style;
//		this.format = format;
//	}
//	@ManyToOne
//	@JoinColumn(name="product_id")
//	private Product product;	
	//@Id @GeneratedValue(strategy = GenerationType.AUTO)
	//private long id;
	//private String title;
	private String artist;
	private String style;
	private String format;
	
	

}
