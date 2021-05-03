package com.example.SzakD_Rest.services;


import com.example.SzakD_Rest.entities.Blog;
import com.example.SzakD_Rest.entities.Post;
import com.example.SzakD_Rest.exceptions.NotFoundEntityException;
import com.example.SzakD_Rest.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository r){this.postRepository = r;}


    public List<Post> getAllPosts(){return postRepository.findAll();}

    public Post newPost(Post p){return postRepository.save(p);}

    public Post findById(Long id){
        return postRepository.findById(id)
                .orElseThrow(()->new NotFoundEntityException(id));
    }

    public void deletePost(Long id){postRepository.deleteById(id); }

    public Post updateBlog(Post newPost, Long id){
        return postRepository.findById(id)
                .map(post -> {
                    postRepository.delete(post);
                    return postRepository.save(newPost);
                })
                .orElseGet(()->{
                    newPost.setId(id);
                    return postRepository.save(newPost);
                });

    }
}
