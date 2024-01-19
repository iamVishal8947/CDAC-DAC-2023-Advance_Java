package com.app.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.app.enums.Category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@RequiredArgsConstructor

public class ProductDto {

	
	@NotBlank
	private String name;
	@NotBlank
	@Column(unique = true)
	private String productCode;
	@NotNull
	private LocalDate manufacturingDate;
	@Enumerated(EnumType.STRING)
	private Category category;
}
