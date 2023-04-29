package com.simplilearn.sportyshoes.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@NoArgsConstructor
public class ChangePassword {

    @Id
    private String oldpassword;
    private String newpassword;
    private String newpasswordagain;
}