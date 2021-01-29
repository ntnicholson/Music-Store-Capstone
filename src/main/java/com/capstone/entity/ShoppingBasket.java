/*
 * package com.capstone.entity;
 * 
 * import javax.persistence.Entity; import javax.persistence.GeneratedValue;
 * import javax.persistence.GenerationType; import javax.persistence.Id; import
 * javax.persistence.JoinColumn; import javax.persistence.ManyToOne; import
 * javax.persistence.Table;
 * 
 * import lombok.Getter; import lombok.Setter;
 * 
 * @Entity
 * 
 * @Table(name = "Shopping_Basket")
 * 
 * @Getter
 * 
 * @Setter public class ShoppingBasket {
 * 
 * @Id @GeneratedValue(strategy = GenerationType.AUTO) private Long id;
 * 
 * @ManyToOne
 * 
 * @JoinColumn(name = "user_id") User user;
 * 
 * @ManyToOne
 * 
 * @JoinColumn(name = "product_id") Product product;
 * 
 * //LocalDateTime registeredAt; }
 */
