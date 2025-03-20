package com.example.touristguide2.service;

import com.example.touristguide2.model.TouristAttraction;
import com.example.touristguide2.repository.TouristRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class TouristServiceTest {
    private TouristRepository repository;
    private TouristService touristService;

    @BeforeEach
    void setUp() {
        repository = mock(TouristRepository.class);
        touristService = new TouristService(repository);
    }

    @Test
    void testGetAllAttractions() {
        List<TouristAttraction> mockData = Arrays.asList(
                new TouristAttraction(1,"Test1", "Test1", "Test1", 1),
                new TouristAttraction(2,"Test2", "Test2", "Test2", 2)
        );

        when(repository.findAll()).thenReturn(mockData);

        List<TouristAttraction> result = touristService.getAllAttractions();

        assertEquals(2, result.size());
        assertEquals(1, result.get(0).getId());
        assertEquals(2, result.get(1).getId());

    }

    @Test
    void testAddAttraction() {
        TouristAttraction attraction = new TouristAttraction(1,"Test1", "Test1", "Test1", 1);

        touristService.addAttraction(attraction);

        // Verifies that the save method was called once with the given attraction
        // as an argument
        // This is done by calling the save method on the mock repository object
        // and then verifying that the save method was called once with the given attraction
        // as an argument
        verify(repository, times(1)).save(attraction);
    }
}