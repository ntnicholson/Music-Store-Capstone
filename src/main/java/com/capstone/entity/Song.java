package com.capstone.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Song { //extends Product

	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String title;
	private String artist;
	private String style;
	private String format;

}
