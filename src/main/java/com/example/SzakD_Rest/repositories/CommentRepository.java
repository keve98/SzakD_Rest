package com.example.SzakD_Rest.repositories;

import com.example.SzakD_Rest.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long>{ }
