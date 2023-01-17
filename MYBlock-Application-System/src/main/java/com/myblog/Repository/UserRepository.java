package com.myblog.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myblog.Model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	
	Optional<User> findByEmail(String userEmail);

}
