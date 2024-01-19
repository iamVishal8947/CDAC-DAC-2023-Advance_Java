package com.app.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ReviewDTO {
	private Long userId;
	private Long movieId;
	private String review;
	private Integer rating;

}