package com.db.dao;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;

@Configuration
public class UserDaoFactory2 {

    @Bean
    public UserDao05WithInterface userDao05Interface() {
        return new UserDao05WithInterface(() -> {
            Map<String, String> env = System.getenv();
            String dbHost = env.get("DB_HOST");
            String dbPassword = env.get("DB_PASSWORD");

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection(
                    dbHost, "root", dbPassword);
            return c;
        });
    }

}
