package com.example.banvetau.controller;


import com.example.banvetau.models.Users;
import com.example.banvetau.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class UserRegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String showRegistrationForm(){
        return "/registration";
    }

    @PostMapping("/registration")
    public String registerUser(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               @RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName,
                               @RequestParam("address") String address,
                               Model model) {
        if(userService.checkUsernameExist(username)){
            model.addAttribute("error", "Username Đã Tồn Tại");
            return "registration";
        }
        else if(!userService.checkPasswordStrongEnough(password)){
            model.addAttribute("error", "Password yếu");
            return "registration";
        }
        Users temp = new Users(username,password, firstName, lastName, address, "");

        userService.save(temp);
        return "register-success";
    }
}
