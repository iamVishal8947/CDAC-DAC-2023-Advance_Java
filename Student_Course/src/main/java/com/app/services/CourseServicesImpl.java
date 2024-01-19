package com.app.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CourseDao;
import com.app.dao.StudentDao;
import com.app.dto.CourseReqDto;
import com.app.entities.Course;
import com.app.entities.Student;
import com.app.exception.CDACException;
@Service
@Transactional
public class CourseServicesImpl implements CourseServices {
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private CourseDao cd;
	@Autowired
	private StudentDao sd;
	
	@Override
	public Course addCourse(CourseReqDto newCourse)  {
		// TODO Auto-generated method stub
		Course course=null;
		try {
	 course=mapper.map(newCourse, Course.class);
		cd.save(course);//no any querry run here
		}
		catch(Exception e)
		{
			throw new RuntimeException("Something wrong in insertion of course !");
		}
		return course;
	}

	@Override
	public String setFee(int id, double fee)throws CDACException  {
		// TODO Auto-generated method stub
		Course course=null;
		if(fee>1)
		{
			course=cd.findById(id).orElseThrow(()->new CDACException("course not found!!"));
			course.setFees(fee);
		}
		else
		{
			throw new CDACException("invalid fee , should be > 1");
		}
		return course.toString();
	}

	@Override
	public String removeStudent(int courseId, int studentId)throws CDACException {
		// TODO Auto-generated method stub
		String msg="successfully removed";
		Course course=null;
		
		
			course=cd.findById(courseId).orElseThrow(()->new CDACException("course not found!!"));
//	List<Student>student=course.getStudents().stream().filter(s->s.getId().equals(studentId)).collect(Collectors.toList());
//			for(Student s: student)
//		course.removeStudent(s);
			Student student=sd.findById(studentId).orElseThrow(()->new CDACException("studnet not found!!"));
			course.removeStudent(student);
		return msg;
	}

}
