package com.app.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//eg : course title(unique) , start date , end date , fees , min score

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CourseReqDto {
	
	@NotBlank(message = "name should not be blank")
	@Length(min = 2,max = 50,message = "title should be between 2 and 50 char lenght")
	private String title;
	@Future(message = "date should be in future")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Future(message = "date should be in future")
	private LocalDate endDate;
	@Min(value = 1)
	private double fees;
	@Min(value = 33)
	@Max(value = 100)
	private double minScore;
	
	
	
	
}
