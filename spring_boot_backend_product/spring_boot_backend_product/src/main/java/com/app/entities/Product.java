package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Columns;

import com.app.enums.Category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity(name = "products")
public class Product extends BaseEntity {

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
