package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.entities.Product;

public interface ProductService {

	Product addProduct(Product product);

	List<Product> getAllProducts();

	Optional<Product> getProductByProductCode(String productCode);
}
