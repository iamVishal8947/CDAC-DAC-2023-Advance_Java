package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.app.dao.ProductDao;
import com.app.entities.Product;

@Service
@Transactional

public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	public Product addProduct(Product product) {

		Optional<Product> existingProduct = productDao.findByProductCode(product.getProductCode());
		if (existingProduct.isPresent()) {
			throw new IllegalArgumentException("Product already exist");

		} else {
			return productDao.save(product);
		}

	}

	@Override
	public List<Product> getAllProducts() {
		return productDao.findAll();

	}

	@Override
	public Optional<Product> getProductByProductCode(String productCode) {
		 return productDao.findByProductCode(productCode);
	}
	
	

}
