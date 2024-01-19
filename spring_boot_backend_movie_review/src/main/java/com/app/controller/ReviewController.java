package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ReviewDTO;
import com.app.service.ReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@GetMapping
	public ResponseEntity<List<ReviewDTO>> getAllReviews() {
		List<ReviewDTO> reviews = reviewService.getAllReviews();
		return ResponseEntity.ok(reviews);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ReviewDTO> getReviewById(@PathVariable Long id) {
		ReviewDTO review = reviewService.getReviewById(id);
		if (review == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(review);
	}

	@PostMapping
	public ResponseEntity<ReviewDTO> addReview(@RequestBody ReviewDTO reviewDTO) {
		ReviewDTO createdReview = reviewService.addReview(reviewDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdReview);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ReviewDTO> updateReview(@PathVariable Long id, @RequestBody ReviewDTO reviewDTO) {
		ReviewDTO updatedReview = reviewService.updateReview(id, reviewDTO);
		if (updatedReview == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(updatedReview);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
		boolean isDeleted = reviewService.deleteReview(id);
		if (!isDeleted) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}
}