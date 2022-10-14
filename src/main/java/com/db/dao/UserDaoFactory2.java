package com.db.dao;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserDaoFactory2 {

    @Bean
    public UserDao05Interface userDao05Interface() {
        return new UserDao05Interface(() -> {
            return null;
        });
    }

}
