package com.example.SzakD_Rest.services;




import com.example.SzakD_Rest.entities.Blog;
import com.example.SzakD_Rest.exceptions.NotFoundEntityException;
import com.example.SzakD_Rest.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BlogService {

    private final BlogRepository blogRepository;

    @Autowired
    public BlogService(BlogRepository r){this.blogRepository = r;}

    public List<Blog> getAllBlogs(){return blogRepository.findAll();}

    public Blog newBlog(Blog b){return blogRepository.save(b);}

    public Blog findById(Long id){
        return blogRepository.findById(id)
                .orElseThrow(()->new NotFoundEntityException(id));
    }

    public void deleteBlog(Long id){
        blogRepository.deleteById(id);
    }

    public Blog updateBlog(Blog newBlog, Long id){
        return blogRepository.findById(id)
                .map(blog -> {
                    blogRepository.delete(blog);
                    return blogRepository.save(newBlog);
                })
                .orElseGet(()->{
                   newBlog.setId(id);
                   return blogRepository.save(newBlog);
                });
    }
}
