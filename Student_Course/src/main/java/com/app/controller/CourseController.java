package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CourseReqDto;
import com.app.entities.Course;
import com.app.services.CourseServices;

@RestController
@RequestMapping(path = "/courses")
@CrossOrigin(origins = "http://localhost:5106")
public class CourseController {
	@Autowired
	private CourseServices cs;
	
	
	@PostMapping
	public ResponseEntity<?> insertCourse(@RequestBody @Valid CourseReqDto newCourse)
	{	String msg=null;
	Course course=null;
		try {
			course=cs.addCourse(newCourse);
			
		}
		catch(Exception ex)
		{
		return	ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(course);
	}
	@PutMapping("/{courseId}/fees/{fees}")
	public ResponseEntity<?> updateFee(@PathVariable int courseId,@PathVariable double fees)
	{	String msg=null;
		try {
			msg=cs.setFee(courseId, fees);
			
		}
		catch(Exception ex)
		{
		return	ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(ex.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(msg);
	}
	@DeleteMapping("/{courseId}/students/{studentId}")
	public ResponseEntity<?> deleteStudent(@PathVariable int courseId,@PathVariable int studentId)
	{	String msg=null;
		try {
			msg=cs.removeStudent(courseId, studentId);
			
		}
		catch(Exception ex)
		{
		return	ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(msg);
	}
}
