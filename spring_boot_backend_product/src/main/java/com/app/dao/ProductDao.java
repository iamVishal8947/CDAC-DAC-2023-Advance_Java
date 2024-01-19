package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Product;

public interface ProductDao extends JpaRepository<Product, Long>{

	Optional<Product> findByProductCode(String productCode);
	
	

}
