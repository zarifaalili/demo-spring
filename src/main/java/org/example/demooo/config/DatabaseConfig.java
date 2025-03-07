package org.example.demooo.config;

import org.postgresql.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DatabaseConfig {

    @Bean
    public Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/student_db", "postgres", "password");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
