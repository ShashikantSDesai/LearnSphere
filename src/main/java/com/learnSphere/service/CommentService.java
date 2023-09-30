package com.learnSphere.service;

import java.util.List;

import com.learnSphere.entity.Comments;

public interface CommentService {
	List<Comments> commentList();
	String addComment(Comments comment);
}
