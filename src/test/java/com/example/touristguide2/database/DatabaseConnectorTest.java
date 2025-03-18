package com.example.touristguide2.database;

import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseConnectorTest {

    @Test
    void testDatabaseConnection() {

        try(Connection conn = DatabaseConnector.getConnection()) {
            assertNotNull(conn, "Forbindelsen burde ikke være null");
            System.out.println("✅ Forbindelsen til MySQL oprettet");
        } catch (SQLException e) {
            fail("❌ Kunne ikke oprette forbindelse" + e.getMessage());
        }
    }

}