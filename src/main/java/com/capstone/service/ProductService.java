package com.capstone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.entity.Genre;
import com.capstone.repository.GenreRepository;

@Service
public class ProductService {

	@Autowired
	GenreRepository genreRepo;
	
	public Genre findByID(Long id) {
		return genreRepo.getOne(id);
	}
	public List<Genre> findAll(){
		return genreRepo.findAll();
	}
	public void save(Genre g) {
		genreRepo.save(g);
	}
	public void delete(Long id) {
		genreRepo.deleteById(id);
	}
}
