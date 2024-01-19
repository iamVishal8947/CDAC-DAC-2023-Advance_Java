package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Review;

public interface ReviewDao extends JpaRepository<Review, Long> {

}
