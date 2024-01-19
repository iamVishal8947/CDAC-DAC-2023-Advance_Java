package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//eg : course title(unique) , start date , end date , fees , min score
@Entity
@Table(name = "courses")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Course extends BaseEntity {
	@Column(unique = true,name = "course_name",nullable = false,length = 50)
	private String title;
	@Column(name = "start_date",nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "end_date",nullable = false)
	private LocalDate endDate;
	@Column(nullable = false)
	private double fees;
	@Column(nullable = false)
	private double minScore;
	@OneToMany(mappedBy = "course",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
	private List<Student> students=new ArrayList<Student>();
	
	//helper method 
	public void addStudent(Student newStudent)
	{
		students.add(newStudent); //course-->student
		newStudent.setCourse(this);//student--->course
	}
	public void removeStudent(Student student)
	{
		students.remove(student);
		student.setCourse(null);
	}

	
}
