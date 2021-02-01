package com.capstone.service;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.entity.Product;
import com.capstone.entity.User;
import com.capstone.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository uRepo;
	
	@Autowired
	EntityManager em;
	
	public User findByID(Long id){
		return uRepo.getOne(id);
	}
	@Transactional
	public void updateDetails(User u) {
		//em.
		em.merge(u);	
	}
	@Transactional
	public void addToCart(User u) {
		em.merge(u);	
	}
	@Transactional
	public void removeFromCart(User u, Product p) {
		u.getShoppingCart().remove(p);
		em.merge(u);
	}
	@Transactional
	public void removeAllFromCart(User u) {
		Set<Product> cart = u.getShoppingCart();
		u.getShoppingCart().removeAll(cart);
		//u.setShoppingCart(null);
		em.merge(u);
	}
	
	public Set<Product> getCartList(Long id){
		return uRepo.getShoppingCartByUserID(id);
	}
}
