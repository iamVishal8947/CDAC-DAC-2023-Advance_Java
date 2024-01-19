package com.app.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CourseDao;
import com.app.dao.StudentDao;
import com.app.dto.StudentReqDto;
import com.app.dto.StudentRespDto;
import com.app.entities.Course;
import com.app.entities.Student;
import com.app.exception.CDACException;
@Service
@Transactional
public class StudentServicesImpl implements StudentService {

	@Autowired
	private ModelMapper mapper;
	@Autowired
	private CourseDao cd;
	@Autowired
	private StudentDao sd;
	@Override
	public Student addStudent(StudentReqDto newStudent) throws CDACException {
		// TODO Auto-generated method stub
		Student std=null;
		try {
	 std=mapper.map(newStudent, Student.class);
	 Course course=cd.findById(newStudent.getCourseId()).orElseThrow(()->new CDACException("course not found!!"));
	 if(std.getScore()>=course.getMinScore())
	 {	course.addStudent(std);//no any querry run here
	 sd.save(std);
	 }
	 else
		 throw new CDACException("Not eligible for that course!!");
		}
		catch(Exception e)
		{
			throw new RuntimeException("Something wrong in insertion of course !");
		}
		return std;
	}

	@Override
	public List<StudentRespDto> getAllStudentsByCourseId(int id) throws CDACException {
		// TODO Auto-generated method stub
		List<Student>list=null;
		Course course=cd.findById(id).orElseThrow(()->new CDACException("course not found!!"));
		list=course.getStudents();
		list.forEach(p->p.getId());
		
		return list.stream().map(s->mapper.map(s, StudentRespDto.class)).collect(Collectors.toList());
	}

}
