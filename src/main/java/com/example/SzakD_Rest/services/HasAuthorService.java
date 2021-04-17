package com.example.SzakD_Rest.services;


import com.example.SzakD_Rest.entities.HasAuthor;
import com.example.SzakD_Rest.exceptions.NotFoundEntityException;
import com.example.SzakD_Rest.repositories.HasAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HasAuthorService {

    private final HasAuthorRepository hasAuthorRepository;

    @Autowired
    public HasAuthorService(HasAuthorRepository r){this.hasAuthorRepository = r;}


    public List<HasAuthor> getAllHasAuthors(){return hasAuthorRepository.findAll();}

    public HasAuthor newHasAuthor(HasAuthor h){return hasAuthorRepository.save(h);}

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
