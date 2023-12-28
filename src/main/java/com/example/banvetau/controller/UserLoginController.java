package com.example.banvetau.controller;

import com.example.banvetau.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class UserLoginController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginForm(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {
        if(userService.checkUsernameExist(username)) {
            model.addAttribute("error", "Username không Tồn Tại.");
            return "login";
        }
        if(userService.checkPasswordUser(username,password)) return "login-success";
        else {
            model.addAttribute("error", "Mật Khẩu Không Đúng.");
            return "login";
        }
    }
}
