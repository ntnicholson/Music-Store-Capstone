package com.capstone.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capstone.entity.Product;
import com.capstone.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);
	
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
	
	@Query("SELECT u.shoppingCart FROM User u WHERE u.id = :id")
	Set<Product> getShoppingCartByUserID(@Param("id") Long id);
}
