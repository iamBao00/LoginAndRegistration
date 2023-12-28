package com.example.banvetau;

import com.example.banvetau.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

@SpringBootApplication
@EnableJpaRepositories
public class BanVeTauApplication {

    public static void main(String[] args) {
        SpringApplication.run(BanVeTauApplication.class, args);
    }

    @Bean
    BCryptPasswordEncoder brBCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
