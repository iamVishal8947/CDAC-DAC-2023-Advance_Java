package com.app.services;

import com.app.dto.CourseReqDto;
import com.app.entities.Course;
import com.app.exception.CDACException;

public interface CourseServices {

	Course addCourse(CourseReqDto newCourse);
	String setFee(int id,double fee)throws CDACException;
	String removeStudent(int courseId,int studentId)throws CDACException;
}
