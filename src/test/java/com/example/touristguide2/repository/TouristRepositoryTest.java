package com.example.touristguide2.repository;

import com.example.touristguide2.model.TouristAttraction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class TouristRepositoryTest {

    private JdbcTemplate jdbcTemplate;
    private TouristRepository touristRepository;

    @BeforeEach
    void setUp() {
        jdbcTemplate = mock(JdbcTemplate.class);
        touristRepository = new TouristRepository(jdbcTemplate);
    }

    @Test
    void testFindAll() {
        // Simuler database returnering
        List<TouristAttraction> mockData = Arrays.asList(
                new TouristAttraction(1,"Test1", "Test1", "Test1", 1),
                new TouristAttraction(2,"Test2", "Test2", "Test2", 2)
        );

        when(jdbcTemplate.query(anyString(), any(RowMapper.class))).thenReturn(mockData);

        List<TouristAttraction> result = touristRepository.findAll();

        assertEquals(2, result.size());
        assertEquals(2, result.get(0).getName());
        assertEquals(2, result.get(1).getName());

    }

    @Test
    void testSave() {
        TouristAttraction attraction = new TouristAttraction(1,"Test1", "Test1", "Test1", 1);

        touristRepository.save(attraction);

        verify(jdbcTemplate, times(1)).update(
                anyString(), eq("Test1"), eq("Test1"), eq("Test1"), eq(1)
        );
    }

    @Test
    void testFindById() {
        TouristAttraction mockData = new TouristAttraction(1,"Test1", "Test1", "Test1", 1);

        when(jdbcTemplate.queryForObject(anyString(), any(RowMapper.class), eq(1))).thenReturn(mockData);

        TouristAttraction result = touristRepository.findById(1);

        assertEquals(1, result.getId());
    }

    @Test
    void testUpdate() {
        TouristAttraction attraction = new TouristAttraction(1,"Test1", "Test1", "Test1", 1);

        touristRepository.update(1, attraction);

        verify(jdbcTemplate, times(1)).update(
                anyString(), eq("Test1"), eq("Test1"), eq("Test1"), eq(1), eq(1)
        );
    }

    @Test
    void testDeleteById() {
        touristRepository.deleteById(1);

        verify(jdbcTemplate, times(1)).update(
                anyString(), eq(1)
        );
    }
}