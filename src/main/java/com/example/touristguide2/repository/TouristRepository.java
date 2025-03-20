package com.example.touristguide2.repository;
import com.example.touristguide2.model.TouristAttraction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TouristRepository {

    private final JdbcTemplate jdbcTemplate;

    public TouristRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Defineret RowMapper separat for at undgå ambiguitet
    private final RowMapper<TouristAttraction> rowMapper = (rs, rowNum) -> new TouristAttraction(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("description"),
            rs.getString("location"),
            rs.getInt("category_id")
    );

    // Hent alle attraktioner
   public List<TouristAttraction> findAll() {
        String sql = "SELECT * FROM tourist_attractions";
        return jdbcTemplate.query(sql, rowMapper);
   }

   // Hent en specifik attraktion baseret på ID
    public TouristAttraction findById(int id) {
        String sql = "SELECT * FROM tourist_attractions WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    // Indsæt en ny attraktion i databasen
   public void save(TouristAttraction attraction) {
        String sql = "INSERT INTO tourist_attractions (name, description, location, category_id) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, attraction.getName(), attraction.getDescription()
                , attraction.getLocation(), attraction.getCategoryId());
   }

    // Opdater en eksisterende attraktion
    public void update(int id, TouristAttraction attraction) {
        String sql = "UPDATE tourist_attractions SET name = ?, description = ?, location = ?, category_id = ? WHERE id = ?";
        jdbcTemplate.update(sql, attraction.getName(), attraction.getDescription()
                , attraction.getLocation(), attraction.getCategoryId(), attraction.getId());
    }

    // Slet en attraktion baseret på ID
    public void deleteById(int id) {
        String sql = "DELETE FROM tourist_attractions WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

}

