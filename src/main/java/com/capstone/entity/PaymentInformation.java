package com.capstone.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
@Table(name = "payment_information")
public class PaymentInformation {

	private Long id;
	private Long user_id;
	private Integer cardNumber;
}
