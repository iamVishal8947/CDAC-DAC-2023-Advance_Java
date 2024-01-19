package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// first name , last name , email , course id,score obtained.
@Entity
@Table(name = "students")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Student extends BaseEntity {
	@Column(name = "first_name",length = 50,nullable = false)
	private String firstName;
	@Column(name = "last_name",length = 50,nullable = false)
	private String lastName;
	@Column(name = "email",length = 150,nullable = false,unique = true)
	private String email;
	@Min(value = 33)
	private double score;
	@ManyToOne
	private Course course;//bi-directional relation
	
	//always write tostring by yourself
	//Tostring loop running countinously 
	@Override
	public String toString() {//Any to one ==>always eggar lodding
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", score=" + score
				+" course name :- "+course.getTitle()+" student Id :- "+this.getId()+ "]";
	}
	
	
}
