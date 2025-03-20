package com.example.touristguide2.database;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseConnector {
    private final JdbcTemplate jdbcTemplate;

    public DatabaseConnector(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void testConnection() {
        String sql = "SELECT 1";
        jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println("✅ Forbindelse til MySQL virker!");
    }

}
