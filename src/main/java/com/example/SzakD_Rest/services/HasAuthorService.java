package com.example.SzakD_Rest.services;


import com.example.SzakD_Rest.entities.HasAuthor;
import com.example.SzakD_Rest.exceptions.NotFoundEntityException;
import com.example.SzakD_Rest.repositories.HasAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;


@Service
@ManagedBean(name = "hasAuthorService", eager = true)
@SessionScoped
public class HasAuthorService {

    private final HasAuthorRepository hasAuthorRepository;
    public HasAuthor author = new HasAuthor();

    public HasAuthor getAuthor() {
        return author;
    }

    public String setHasAuthorToEdit(Long id) {
        this.author = findById(id);
        return "editAuthor.xhtml";
    }

    @Autowired
    public HasAuthorService(HasAuthorRepository r){this.hasAuthorRepository = r;}


    public List<HasAuthor> getAllHasAuthors(){return hasAuthorRepository.findAll();}

    public HasAuthor newHasAuthor(HasAuthor h){
        HasAuthor tmp = new HasAuthor();
        tmp.setAuthor(h.getAuthor());
        return hasAuthorRepository.save(tmp);}

    public HasAuthor findById(Long id){
        return hasAuthorRepository.findById(id)
                .orElseThrow(()->new NotFoundEntityException(id));
    }

    public void deleteHasAuthor(Long id){hasAuthorRepository.deleteById(id); }

    public HasAuthor updateHasAuthor(HasAuthor newHasAuthor, Long id){
        return hasAuthorRepository.findById(id)
                .map(hasAuthor -> {
                    hasAuthor.setAuthor(newHasAuthor.getAuthor());
                    return hasAuthorRepository.save(hasAuthor);
                })
                .orElseGet(()->{
                    newHasAuthor.setId(id);
                    return hasAuthorRepository.save(newHasAuthor);
                });
    }
}
