package com.capstone.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.entity.Product;
import com.capstone.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepo;
	
	public Product findByID(Long id) {
		return productRepo.getOne(id);
	}
	public List<Product> findAll(){
		return productRepo.findAll();
	}
	public void save(Product g) {
		productRepo.save(g);
	}
	public void delete(Long id) {
		productRepo.deleteById(id);
	}
	public List<Product> search(String q){
		return productRepo.search(q.toLowerCase());
	}
}
