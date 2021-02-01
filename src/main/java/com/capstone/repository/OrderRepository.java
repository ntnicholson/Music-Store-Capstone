package com.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.entity.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

	
}
