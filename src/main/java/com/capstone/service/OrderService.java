package com.capstone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.entity.Orders;
import com.capstone.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepo;
	
	public Orders findById(Long id) {
		return orderRepo.getOne(id);
	}
	public void saveOrder(Orders o) {
		orderRepo.save(o);
	}
	public List<Orders> findAll() {
		return orderRepo.findAll();
	}
}
