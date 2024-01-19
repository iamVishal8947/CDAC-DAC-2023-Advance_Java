package com.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.MovieDao;
import com.app.dao.ReviewDao;
import com.app.dao.UserDao;
import com.app.dto.ReviewDTO;
import com.app.entities.Movie;
import com.app.entities.Review;
import com.app.entities.User;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewDao reviewDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private MovieDao movieDao;

	public List<ReviewDTO> getAllReviews() {
		List<Review> reviews = reviewDao.findAll();
		List<ReviewDTO> reviewDTOs = new ArrayList<>();
		for (Review review : reviews) {
			ReviewDTO reviewDTO = new ReviewDTO();
			
			reviewDTO.setReview(review.getReview());
			reviewDTO.setRating(review.getRating());
			reviewDTO.setUserId(review.getUser().getId());
			reviewDTO.setMovieId(review.getMovie().getId());
			reviewDTOs.add(reviewDTO);
		}
		return reviewDTOs;
	}

	public ReviewDTO getReviewById(Long id) {
		Review review = reviewDao.findById(id).orElse(null);
		if (review == null) {
			return null;
		}
		ReviewDTO reviewDTO = new ReviewDTO();
		
		reviewDTO.setReview(review.getReview());
		reviewDTO.setRating(review.getRating());
		reviewDTO.setUserId(review.getUser().getId());
		reviewDTO.setMovieId(review.getMovie().getId());
		return reviewDTO;
	}

	public ReviewDTO addReview(ReviewDTO reviewDTO) {
		User user = userDao.findById(reviewDTO.getUserId()).orElse(null);
		if (user == null) {
			throw new RuntimeException("User not found");
		}
		Movie movie = movieDao.findById(reviewDTO.getMovieId()).orElse(null);
		if (movie == null) {
			throw new RuntimeException("Movie not found");
		}
		Review review = new Review();
		review.setReview(reviewDTO.getReview());
		review.setRating(reviewDTO.getRating());
		review.setUser(user);
		review.setMovie(movie);
		review = reviewDao.save(review);
	
		return reviewDTO;
	}

	public ReviewDTO updateReview(Long id, ReviewDTO reviewDTO) {
		Review review = reviewDao.findById(id).orElse(null);
		if (review == null) {
			return null;
		}
		User user = userDao.findById(reviewDTO.getUserId()).orElse(null);
		if (user == null) {
			throw new RuntimeException("User not found");
		}
		Movie movie = movieDao.findById(reviewDTO.getMovieId()).orElse(null);
		if (movie == null) {
			throw new RuntimeException("Movie not found");
		}
		review.setReview(reviewDTO.getReview());
		review.setRating(reviewDTO.getRating());
		review.setUser(user);
		review.setMovie(movie);
		review = reviewDao.save(review);
		
		return reviewDTO;
	}

	public boolean deleteReview(Long id) {
		Review review = reviewDao.findById(id).orElse(null);
		if (review == null) {
			return false;
		}
		reviewDao.delete(review);
		return true;
	}
}
