package com.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
