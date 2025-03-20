package com.example.touristguide2.controller;

import com.example.touristguide2.model.TouristAttraction;
import com.example.touristguide2.service.TouristService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(TouristController.class)
class TouristControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private TouristService service;

    @InjectMocks
    private TouristController controller;

    @Test
    void testGetAllAttractions() throws Exception {
        List<TouristAttraction> mockData = Arrays.asList(
                new TouristAttraction(1,"Test1", "Test1", "Test1", 1),
                new TouristAttraction(2,"Test2", "Test2", "Test2", 2)
        );

        when(service.getAllAttractions()).thenReturn(mockData);

        mockMvc.perform(get("/api/attractions"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].name").value((1)))
                .andExpect(jsonPath("$[1].name").value(2));
    }

    @Test
    void testGetAttractionById() throws Exception {
        TouristAttraction mockData = new TouristAttraction(1,"Test1", "Test1", "Test1", 1);

        when(service.getAttractionById(1)).thenReturn(mockData);

        mockMvc.perform(get("/api/attractions/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(1));
    }

    @Test
    void testAddAttraction() throws Exception {
        String attraction = """
                {
                    "id": 1,
                    "name": "Test1",
                    "description": "Test1",
                    "location": "Test1",
                    "rating": 1
                }
                """;

        mockMvc.perform(post("/api/attractions")
                .contentType("application/json")
                .content(attraction))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("Attraction added successfully!"));

    }

    @Test
    void testUpdateAttraction() throws Exception {
        String updatedAttraction = """
                {
                    "id": 1,
                    "name": "Test1",
                    "description": "Test1",
                    "location": "Test1",
                    "rating": 1
                }
                """;

        mockMvc.perform(put("/api/attractions/1")
                .contentType("application/json")
                .content(updatedAttraction))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("Attraction updated successfully!"));
    }

    @Test
    void testDeleteAttraction() throws Exception {
        mockMvc.perform(delete("/api/attractions/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("Attraction deleted successfully!"));
    }
}