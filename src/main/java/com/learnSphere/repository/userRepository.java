package com.learnSphere.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnSphere.entity.Users;

public interface userRepository extends JpaRepository<Users, Integer>{
	boolean existsByEmail(String email);
	Users getByEmail(String email);

}
