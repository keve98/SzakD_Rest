package com.example.SzakD_Rest.services;

import com.example.SzakD_Rest.entities.Blog;
import com.example.SzakD_Rest.exceptions.NotFoundEntityException;
import com.example.SzakD_Rest.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;


@Service
@ManagedBean(name = "blogService", eager = true)
@SessionScoped
public class BlogService {

    private final BlogRepository blogRepository;

    public Blog blog = new Blog();

    public String setBlogToEdit(Long id) {
        this.blog = findById(id);
        return "editBlog.xhtml";
    }

    public Blog getBlog() {
        return blog;
    }

    @Autowired
    public BlogService(BlogRepository r){this.blogRepository = r;}

    public List<Blog> getAllBlogs(){return blogRepository.findAll();}

    public Blog newBlog(Blog b){
        Blog tmp = new Blog();
        tmp.setTitle(b.getTitle());
        return blogRepository.save(b);
    }

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
                    blog.setTitle(newBlog.getTitle());
                    blog.getPosts().clear();
                    blog.getPosts().addAll(newBlog.getPosts());
                    return blogRepository.save(blog);
                })
                .orElseGet(()->{
                   newBlog.setId(id);
                   return blogRepository.save(newBlog);
                });
    }
}
