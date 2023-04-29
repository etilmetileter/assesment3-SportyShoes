package com.simplilearn.sportyshoes.repo;


import com.simplilearn.sportyshoes.model.Shoe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoeRepository extends JpaRepository<Shoe, Integer> {

    Shoe findByCategory(String cat);

}