package com.learnSphere.service;

import java.util.List;

import com.learnSphere.entity.Course;
import com.learnSphere.entity.Lesson;

public interface TrainerService {
	//create abstract methods 
	public String addCourse(Course course);

	public String addLesson(Lesson lesson);

	public Course getCourse(int courseId); 
	
	public List<Course> courseList();
	
	
}
