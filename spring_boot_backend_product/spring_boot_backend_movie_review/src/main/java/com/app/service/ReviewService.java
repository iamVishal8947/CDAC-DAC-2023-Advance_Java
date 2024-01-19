package com.app.service;

import java.util.List;

import com.app.dto.ReviewDTO;

public interface ReviewService {
	public List<ReviewDTO> getAllReviews();
	public ReviewDTO getReviewById(Long id);
	public ReviewDTO addReview(ReviewDTO reviewDTO);
	public ReviewDTO updateReview(Long id, ReviewDTO reviewDTO);
	public boolean deleteReview(Long id); 
}
