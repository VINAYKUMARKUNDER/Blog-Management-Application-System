package com.myblog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myblog.Model.Comments;

public interface CommentsRepository extends JpaRepository<Comments, Integer>{

}
