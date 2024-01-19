package com.app.services;

import java.util.List;

import com.app.dto.StudentReqDto;
import com.app.dto.StudentRespDto;
import com.app.entities.Student;
import com.app.exception.CDACException;

public interface StudentService {

	Student addStudent(StudentReqDto newStudent)throws CDACException;
	List<StudentRespDto> getAllStudentsByCourseId(int id)throws CDACException;
}
