package com.example.banvetau.services;

import com.example.banvetau.helper.PasswordStrengthService;
import com.example.banvetau.models.Users;
import com.example.banvetau.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService implements iUserService{
    @Autowired
    private UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public void save(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public Boolean checkPasswordUser(String userName, String password) {
        Optional<Users> optionalObject = userRepository.findById(userName);
        if (optionalObject.isPresent()) {
            Users user = optionalObject.get();
            return passwordEncoder.matches(password, user.getPassword());
        }
        return false;
    }

    @Override
    public Users getUserByUsername(String userName) {
        Optional<Users> optionalObject = userRepository.findById(userName);
        if(optionalObject.isPresent()) {
            Users user = optionalObject.get();
            return user;
        }
        return null;
    }

    @Override
    public Boolean checkUsernameExist(String userName) {
        return userRepository.existsById(userName);
    }

    @Override
    public Boolean checkPasswordStrongEnough(String password) {
        return PasswordStrengthService.isPasswordStrongEnough(password);
    }
}
