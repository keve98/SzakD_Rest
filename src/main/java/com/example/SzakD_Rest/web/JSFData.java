package com.example.SzakD_Rest.web;


import com.example.SzakD_Rest.entities.Blog;
import com.example.SzakD_Rest.entities.Comment;
import com.example.SzakD_Rest.entities.HasAuthor;
import com.example.SzakD_Rest.entities.Post;
import com.example.SzakD_Rest.repositories.BlogRepository;
import com.example.SzakD_Rest.repositories.CommentRepository;
import com.example.SzakD_Rest.repositories.HasAuthorRepository;
import com.example.SzakD_Rest.repositories.PostRepository;
import com.example.SzakD_Rest.services.BlogService;
import com.example.SzakD_Rest.services.CommentService;
import com.example.SzakD_Rest.services.HasAuthorService;
import com.example.SzakD_Rest.services.PostService;
import org.apache.tomcat.JarScanFilter;
import org.hibernate.secure.internal.JaccSecurityListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@Service
@ManagedBean(name = "JSFData", eager = true)
@SessionScoped
public class JSFData {
    private final BlogRepository blogRepository;
    private final CommentRepository commentRepository;
    private final HasAuthorRepository hasAuthorRepository;
    private final PostRepository postRepository;
    public BlogService blogService;
    public PostService postService;
    public HasAuthorService hasAuthorService;
    public CommentService commentService;

    public Blog blog = new Blog();
    public Comment comment = new Comment();
    public HasAuthor author = new HasAuthor();
    public Post post = new Post();
    Long blogid;
    Long postid;
    String authorname;

    @Autowired
    public JSFData(BlogRepository b, CommentRepository c, HasAuthorRepository h, PostRepository p){
        this.blogRepository = b;
        this.commentRepository = c;
        this.hasAuthorRepository = h;
        this.postRepository = p;
        this.blogService = new BlogService(this.blogRepository);
        this.postService = new PostService(this.postRepository);
        this.hasAuthorService = new HasAuthorService(this.hasAuthorRepository);
        this.commentService = new CommentService(this.commentRepository);
    }



    //getters, setters
    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public Comment getComment(){
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public HasAuthor getAuthor() {
        return author;
    }

    public void setAuthor(HasAuthor author) {
        this.author = author;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Long getBlogid() {
        return blogid;
    }

    public void setBlogid(Long blogid) {
        this.blogid = blogid;
    }

    public Long getPostid() {
        return postid;
    }

    public void setPostid(Long postid) {
        this.postid = postid;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    //edits
    public String setBlogToEdit(Long id) {
        this.blog = this.blogService.findById(id);
        return "editBlog.xhtml";
    }

    public String setCommentToEdit(Long id) {
        this.comment = this.commentService.findById(id);
        return "editComment.xhtml";
    }

    public String setHasAuthorToEdit(Long id) {
        this.author = this.hasAuthorService.findById(id);
        return "editAuthor.xhtml";
    }

    public String setPostToEdit(Long id) {
        this.post = this.postService.findById(id);
        return "editPost.xhtml";
    }

    //add new
    public Blog newBlog(Blog b){
        return blogService.newBlog(b);
    }

    public Comment newComment(Comment c){
        if(postid != null) {
            Post p = postService.findById(postid);
            p.getComments().add(c);
        }
        c.setAuthor(authorname);
        return commentService.newComment(c);
    }

    public HasAuthor newHasAuthor(HasAuthor h){
        return hasAuthorService.newHasAuthor(h);
    }


    public Post newPost(Post p){
        if(blogid != null) {
            Blog newBlog = this.blogService.findById(blogid);
            newBlog.addPost(p);
        }
        p.setAuthor(authorname);
        return postService.newPost(p);
    }


    //updates
    public Blog updateBlog(Blog b, Long id){
        return blogService.updateBlog(b, id);
    }

    public Comment updateComment(Comment c, Long id){
        return commentService.updateComment(c, id);
    }

    public HasAuthor updateHasAuthor(HasAuthor h, Long id){
        return hasAuthorService.updateHasAuthor(h, id);
    }

    public Post updatePost(Post p, Long id){
        return postService.updatePost(p, id);
    }



    //deletes
    public void deleteBlog(Long id){
        this.blogService.deleteBlog(id);
    }
    public void deleteComment(Long id){
        this.commentService.deleteComment(id);
    }
    public void deleteHasAuthor(Long id){
        this.hasAuthorService.deleteHasAuthor(id);
    }
    public void deletePost(Long id){
        this.postService.deletePost(id);
    }







}
