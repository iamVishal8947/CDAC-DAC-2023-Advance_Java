package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CourseReqDto;
import com.app.dto.StudentReqDto;
import com.app.dto.StudentRespDto;
import com.app.entities.Student;
import com.app.services.CourseServices;
import com.app.services.StudentService;

@RestController
@RequestMapping(path = "/students")
@CrossOrigin(origins = "http://localhost:5106")
public class StudentController {

	@Autowired
	private StudentService ss;
	
	@PostMapping
	public ResponseEntity<?> insertStudent(@RequestBody @Valid StudentReqDto newStudent)
	{	String msg=null;
	Student student=null;
		try {
		

			student=ss.addStudent(newStudent);
			System.out.println("after insert : "+student.toString());
		}
		catch(Exception ex)
		{
		return	ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(student.toString());
	}
	@GetMapping("/course_title/{courseId}")
	public ResponseEntity<List<StudentRespDto>> getStudents(@PathVariable int courseId)
	{	List<StudentRespDto>list=null;
		try {
			list=ss.getAllStudentsByCourseId(courseId);
			
		}
		catch(Exception ex)
		{
		return	ResponseEntity.status(HttpStatus.BAD_REQUEST).body(list);
		}
		return ResponseEntity.status(HttpStatus.FOUND).body(list);
	}
	
}
