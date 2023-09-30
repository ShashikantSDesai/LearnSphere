package com.learnSphere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learnSphere.entity.Comments;
import com.learnSphere.entity.Users;
import com.learnSphere.service.CommentService;
import com.learnSphere.service.userService;

@Controller
public class ServiceController {
	@Autowired
	userService uService;
	
	@Autowired
	CommentService cService;
	
	@PostMapping("/addUser")
	public String addUser(@RequestParam("name")String name,
			@RequestParam("email")String email,
			@RequestParam("password")String password,
			@RequestParam("role")String role)
	{
		//		System.out.println(name+email+password+role);

		boolean emailExist=uService.checkEmail(email);
		if(emailExist==false) {
			Users user = new Users();
			user.setName(name);
			user.setEmail(email);
			user.setPassword(password);
			user.setRole(role);
			uService.addUser(user);

			System.out.println("User registered successfully!");
			return "redirect:/login";
		}
		else {
			System.out.println("User already exist!");
			return "redirect:/register";
		}
	}

	@PostMapping("/validate")
	public String validate(@RequestParam("email")String email,
				@RequestParam("password")String password) {
		boolean val=uService.validate(email, password);
		//if user is valid
		if(val==true) {
			if(uService.getUserRole(email).equals("trainer")) {
			  //System.out.println("login successful!");
				return "trainerhome";
		
			}
			else {
				return "studentHome";
			}
		}
		else {
			System.out.println("incorrect credentials, try again!");
			return "login";
		}
	}
	
	@PostMapping("/addComment")
	public String comments(@RequestParam("comment")String comment
						,Model model) {
		Comments c=new Comments();
		c.setComment(comment);
		cService.addComment(c);
		
		List<Comments> commentsList=cService.commentList();
		model.addAttribute("comments",commentsList);
		
		return "redirect:/";
	}
}

