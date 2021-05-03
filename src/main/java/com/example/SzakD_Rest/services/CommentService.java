package com.example.SzakD_Rest.services;

import com.example.SzakD_Rest.entities.Blog;
import com.example.SzakD_Rest.entities.Comment;
import com.example.SzakD_Rest.exceptions.NotFoundEntityException;
import com.example.SzakD_Rest.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService{

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository r){this.commentRepository = r;}


    public List<Comment> getAllComments(){return commentRepository.findAll();}

    public Comment newComment(Comment c){return commentRepository.save(c);}

    public Comment findById(Long id){
        return commentRepository.findById(id)
                .orElseThrow(()->new NotFoundEntityException(id));
    }

    public void deleteComment(Long id){commentRepository.deleteById(id); }


    public Comment updateComment(Comment newComment, Long id){
        return commentRepository.findById(id)
                .map(comment -> {
                    comment.setContent(newComment.getContent());
                    comment.setAuthor(newComment.getAuthor());
                    return commentRepository.save(comment);

                })
                .orElseGet(()->{
                    newComment.setId(id);
                    return commentRepository.save(newComment);
                });
    }
}
