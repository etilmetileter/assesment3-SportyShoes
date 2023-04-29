package com.simplilearn.sportyshoes.service;

import com.simplilearn.sportyshoes.model.Shoe;
import com.simplilearn.sportyshoes.repo.ShoeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoeService {

    @Autowired
    private ShoeRepository shoeRepository;

    public List<Shoe> getShoes() {
        return shoeRepository.findAll();
    }

    public Shoe getShoeById(int id) {
        return shoeRepository.findById(id).orElse(null);
    }

    public Shoe addProduct(Shoe shoe) {
        return shoeRepository.save(shoe);
    }

}
