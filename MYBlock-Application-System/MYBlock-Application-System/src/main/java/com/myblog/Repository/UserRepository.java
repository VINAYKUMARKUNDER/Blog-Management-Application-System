package com.myblog.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.myblog.Model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	List<User> findByUserName(String userName);
	
	Optional<User> findByEmail(String userEmail);

}
