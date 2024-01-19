package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Movie;

public interface MovieDao extends JpaRepository<Movie, Long> {

}
