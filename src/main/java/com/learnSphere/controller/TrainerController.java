package com.learnSphere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learnSphere.entity.Course;
import com.learnSphere.entity.Lesson;
import com.learnSphere.service.TrainerService;

@Controller
public class TrainerController {
	@Autowired
	TrainerService tService;
	@PostMapping("/addCourse")
	public String addCourse(@RequestParam ("courseId")int courseId,
				@RequestParam("courseName")String courseName,
				@RequestParam("coursePrice")int coursePrice) {
//		System.out.println(courseId+courseName+coursePrice);
		Course course=new Course();
		course.setCourseId(courseId);
		course.setCourseName(courseName);
		course.setCoursePrice(coursePrice);
		
		tService.addCourse(course);
		return "redirect:/";
	}
	
	@PostMapping("/lesson")
	public String lesson(@RequestParam("courseId")int courseId,
				@RequestParam("lessonId")int lessonId,
				@RequestParam("lessonName")String lessonName,
				@RequestParam("lessonTopics")String lessonTopics,
				@RequestParam("link")String link) {
		System.out.println(courseId+lessonId+lessonName+lessonTopics+link);
		Course course=tService.getCourse(courseId);
		
		Lesson lesson = new Lesson(lessonId,lessonName,lessonTopics,link,course);
		tService.addLesson(lesson);
		course.getLessons().add(lesson);
		
		return "redirect:/";
		
	}

	@GetMapping("/showCourses")
	public String showCourses(Model model) {
		List<Course> courseList=tService.courseList();
		model.addAttribute("courseList", courseList);
//		System.out.println(courseList);
		return "courses";
	}
}
