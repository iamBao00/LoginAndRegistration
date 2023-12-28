package com.example.banvetau.services;

import com.example.banvetau.models.Users;
import org.springframework.stereotype.Service;

@Service
public interface iUserService {
    void save(Users user);
    Boolean checkPasswordUser(String userName, String password);
    Users getUserByUsername(String userName);
    Boolean checkUsernameExist(String userName);
    Boolean checkPasswordStrongEnough(String password);
}

