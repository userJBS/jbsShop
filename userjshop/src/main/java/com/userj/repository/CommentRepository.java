package com.userj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userj.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {


}
