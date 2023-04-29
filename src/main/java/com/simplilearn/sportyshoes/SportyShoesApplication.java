package com.simplilearn.sportyshoes;

import com.simplilearn.sportyshoes.repo.ShoeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SportyShoesApplication {

    @Autowired
    private static ShoeRepository shoeRepository;

    public static void main(String[] args) {
        SpringApplication.run(SportyShoesApplication.class, args);
    }


}
