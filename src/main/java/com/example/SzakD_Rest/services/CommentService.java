package com.example.SzakD_Rest.services;


import com.example.SzakD_Rest.entities.Comment;
import com.example.SzakD_Rest.exceptions.NotFoundEntityException;
import com.example.SzakD_Rest.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import java.util.List;


@Service
@ManagedBean(name = "commentService", eager = true)
@ViewScoped
public class CommentService{

    private final CommentRepository commentRepository;


    @Autowired
    public CommentService(CommentRepository r){this.commentRepository = r;}

    public List<Comment> getAllComments(){
        return commentRepository.findAll();
    }


    public Comment newComment(Comment c){
        Comment tmp = new Comment();
        tmp = c;
        tmp.setId(null);
        return commentRepository.save(tmp);
    }


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
