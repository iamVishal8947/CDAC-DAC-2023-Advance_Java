package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ProductDto;
import com.app.entities.Product;
import com.app.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/products")
	ResponseEntity<String> addProducts(@RequestBody ProductDto productdto) {

		try {
			Product product = new Product(productdto.getName(), productdto.getProductCode(),
					productdto.getManufacturingDate(), productdto.getCategory());
			productService.addProduct(product);

			return new ResponseEntity<>("Products added Successfully", HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	@GetMapping("/products/{productCode}")
	public ResponseEntity<Product> getProductByProductCode(@PathVariable String productCode) {
	    Optional<Product> product = productService.getProductByProductCode(productCode);
	    if (product.isPresent()) {
	        return new ResponseEntity<>(product.get(), HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> products = productService.getAllProducts();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

}
