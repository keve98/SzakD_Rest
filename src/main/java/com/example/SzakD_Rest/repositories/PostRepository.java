package com.example.SzakD_Rest.repositories;



import com.example.SzakD_Rest.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post, Long>{

}
