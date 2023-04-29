package com.simplilearn.sportyshoes.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "reports")
@Data
@Entity
@NoArgsConstructor
public class PurchaseReport {

    @Id
    private int id;
    @Column(name = "product_name")
    private String productname;
    private int price;
    private String category;
    @Column(name = "bought_by")
    private String boughtby;
    @Column(name = "date")
    private String orderdate;
}
