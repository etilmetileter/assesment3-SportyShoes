package com.simplilearn.sportyshoes.controller;

import com.simplilearn.sportyshoes.model.Admin;
import com.simplilearn.sportyshoes.model.ChangePassword;
import com.simplilearn.sportyshoes.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    private String currentUser = "simplilearn";

    @GetMapping("/login")
    public String homePage(Model model) {
        Admin admin = new Admin();
        model.addAttribute("admin", admin);
        return "login";
    }

    @PostMapping("/verifyLogin")
    public String verifyLogin(Admin admin, Model model) {
        String username = admin.getUsername();
        String password = admin.getPassword();
        currentUser = username;
        if (!username.isBlank()) {
            if (adminService.loginVerify(username, password)) {
                //session.setAttribute("uname", username);
                return "adminDashboard";
            } else {
                model.addAttribute("message", "Username or password wrong");
                return "login";
            }
        } else {
            model.addAttribute("message", "User name can not be empty");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(Model model) {
        return "index";
    }

    @GetMapping("/changePassword")
    public String changePassword(Model model) {
        ChangePassword changePassword = new ChangePassword();
        model.addAttribute("changePassword", changePassword);
        return "changePassword";
    }

    @PostMapping("/changePasswordOnDb")
    public String changePassword(ChangePassword changePassword, Model model) {
        ;

        if (changePassword.getNewpassword().equals(changePassword.getNewpasswordagain())) {
            Admin admin = adminService.getCurrentUser(currentUser);

            if (changePassword.getOldpassword().equals(admin.getPassword())) {
                admin.setPassword(changePassword.getNewpassword());
                adminService.changePassword(admin);
                model.addAttribute("messageSuccess", "Your Password Succesfuly Changed!");
                return "changePassword";
            } else {
                model.addAttribute("messageFail", "Your Old Password Is Not Correct");
                return "changePassword";
            }

        } else {
            model.addAttribute("messageFail", "New Passwords Are Not Same!");
            return "changePassword";
        }
    }
}
