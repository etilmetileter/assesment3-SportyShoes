package com.simplilearn.sportyshoes.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "shoes")
@Data
@Entity
@NoArgsConstructor
public class Shoe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "product_name")
    private String productname;
    @Column(name = "product_price")
    private int productprice;
    private String category;

}
