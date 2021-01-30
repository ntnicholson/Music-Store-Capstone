package com.capstone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.entity.Category;
import com.capstone.repository.CategoryRepository;


@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepo;
	
	public Category findByID(Long id) {
		return categoryRepo.getOne(id);
	}
	public List<Category> findAll(){
		return categoryRepo.findAll();
	}
	public void save(Category g) {
		categoryRepo.save(g);
	}
	public void delete(Long id) {
		categoryRepo.deleteById(id);
	}
}
