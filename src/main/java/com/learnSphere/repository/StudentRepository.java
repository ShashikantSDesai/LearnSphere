package com.learnSphere.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnSphere.entity.Lesson;

public interface StudentRepository extends JpaRepository<Lesson, Integer> {

}
