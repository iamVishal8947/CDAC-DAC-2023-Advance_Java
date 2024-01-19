package com.app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// first name , last name , email , course id,score obtained.

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentRespDto {
	
	private int id;
	@NotBlank(message = "name should not be blank")
	@Length(min = 2,max = 50,message = "name should be between 2 and 50 char lenght")
	private String firstName;
	@NotBlank(message = "name should not be blank")
	private String lastName;
	@Email(message = "email should be in correct format")
	private String email;
	@Min(value = 33,message = "min score 33")
	@Max(value = 100,message = "max score 100")
	private double score;
	
	
}
