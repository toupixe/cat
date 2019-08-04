package com.wyd.cat.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wyd.cat.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{

}
