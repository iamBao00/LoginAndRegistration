package com.example.banvetau.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/login").permitAll() // Cho phép truy cập vào trang đăng nhập tùy chỉnh
                .antMatchers("/registration").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable(); // Tắt CSRF protection (nếu cần)
    }
}