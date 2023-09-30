package com.learnSphere.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learnSphere.entity.Lesson;
import com.learnSphere.service.StudentServices;

@Controller
public class StudentController {
	
	@Autowired
	StudentServices service;
	@PostMapping("/goTOLesson")
	public String myLesson(@RequestParam("lessonId")int lessonId,Model model){
		
		Lesson lesson=service.getLesson(lessonId);
		model.addAttribute("lesson", lesson);
		System.out.println(lesson);
		return "myLesson";
	}

}
