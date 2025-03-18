package com.example.touristguide2.repository;

import com.example.touristguide2.database.DatabaseConnector;
import com.example.touristguide2.model.TouristAttraction;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {

    public List<TouristAttraction> getAllAttractions() {
        List<TouristAttraction> attractions = new ArrayList<>();
        String sql = "SELECT name, description FROM TouristAttraction";

        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                attractions.add(new TouristAttraction(name, description));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attractions;
    }

    public TouristAttraction getAttractionByName(String name) {
        String sql = "SELECT name, description FROM TouristAttraction WHERE name = ?";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new TouristAttraction();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addAttraction(TouristAttraction attraction) {
        String sql = "INSERT INTO TouristAttraction (name, description) VALUES (?, ?)";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, attraction.getName());
            stmt.setString(2, attraction.getDescription());

            return stmt.executeUpdate() > 0; // Returnerer true, hvis en række blev indsat
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteAttraction(String name) {
        String sql = "DELETE FROM TouristAttraction WHERE name = ?";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

