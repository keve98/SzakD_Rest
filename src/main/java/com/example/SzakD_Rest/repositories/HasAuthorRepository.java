package com.example.SzakD_Rest.repositories;




import com.example.SzakD_Rest.entities.HasAuthor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HasAuthorRepository extends JpaRepository<HasAuthor, Long>{
}
