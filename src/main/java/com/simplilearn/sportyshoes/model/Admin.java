package com.simplilearn.sportyshoes.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
@Data
@NoArgsConstructor
public class Admin {

    @Id
    private String username;
    private String password;
}
