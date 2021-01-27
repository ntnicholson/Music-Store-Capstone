package com.capstone.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PAYMENT_INFORMATION")
public class PaymentInformation {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "card_Number")
	private Integer cardNumber;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
}
