package com.simplilearn.sportyshoes.service;

import com.simplilearn.sportyshoes.model.Admin;
import com.simplilearn.sportyshoes.repo.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public boolean loginVerify(String username, String password) {

        Admin admin = adminRepository.findByUsername(username);
        if (admin == null) {
            return false;
        }
        return admin.getUsername().equals(username) && admin.getPassword().equals(password) ? true : false;

    }

    public Admin getCurrentUser(String userName) {
        Admin admin = adminRepository.findByUsername(userName);
        return admin;
    }

    public void changePassword(Admin admin) {
        adminRepository.save(admin);
    }
}
