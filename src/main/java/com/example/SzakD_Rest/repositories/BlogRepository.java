package com.example.SzakD_Rest.repositories;


import com.example.SzakD_Rest.entities.Blog;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BlogRepository extends JpaRepository<Blog, Long> {
}
