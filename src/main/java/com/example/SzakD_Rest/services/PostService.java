package com.example.SzakD_Rest.services;


import com.example.SzakD_Rest.entities.Blog;
import com.example.SzakD_Rest.entities.Comment;
import com.example.SzakD_Rest.entities.Post;
import com.example.SzakD_Rest.exceptions.NotFoundEntityException;
import com.example.SzakD_Rest.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Service
@ManagedBean(name = "postService", eager = true)
@SessionScoped
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository r){this.postRepository = r;}


    public List<Post> getAllPosts(){return postRepository.findAll();}

    public Post newPost(Post p){
        Post tmp = new Post();
        tmp = p;
        tmp.setId(null);
        return postRepository.save(tmp);
    }

    public Post findById(Long id){
        return postRepository.findById(id)
                .orElseThrow(()->new NotFoundEntityException(id));
    }

    public void deletePost(Long id){postRepository.deleteById(id); }

    public Post updatePost(Post newPost, Long id){
        return postRepository.findById(id)
                .map(post -> {
                    post.setContent(newPost.getContent());
                    post.setTitle(newPost.getTitle());
                    post.getComments().clear();
                    post.getComments().addAll(newPost.getComments());
                    return postRepository.save(post);
                })
                .orElseGet(()->{
                    newPost.setId(id);
                    return postRepository.save(newPost);
                });

    }
}
