package com.example.touristguide2.controller;


import com.example.touristguide2.model.TouristAttraction;
import com.example.touristguide2.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/attractions")
public class TouristController {

    @Autowired
    private final TouristService service;

    public TouristController(TouristService service) {
        this.service = service;
    }

    // 📌 Hent alle attraktioner
    @GetMapping
    public ResponseEntity<List<TouristAttraction>> getAllAttractions() {
        List<TouristAttraction> attractions = service.getAllAttractions();
        return ResponseEntity.ok(attractions);
    }

    // 📌 Hent en attraktion baseret på ID
    @GetMapping("/{id}")
    public ResponseEntity<TouristAttraction> getAttractionById(@PathVariable int id) {
        TouristAttraction attraction = service.getAttractionById(id);
        return attraction != null ? ResponseEntity.ok(attraction) : ResponseEntity.notFound().build();
    }

    // 📌 Tilføj en ny attraktion
    @PostMapping
    public ResponseEntity<String> addAttraction(@RequestBody TouristAttraction attraction) {
        service.addAttraction(attraction);
        return ResponseEntity.ok("Attraction added successfully!");
    }

    // 📌 Opdater en eksisterende attraktion
    @PutMapping("/{id}")
    public ResponseEntity<String> updateAttraction(@PathVariable int id, @RequestBody TouristAttraction attraction) {
        service.updateAttraction(id, attraction);
        return ResponseEntity.ok("Attraction updated successfully!");
    }

    // 📌 Slet en attraktion
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAttraction(@PathVariable int id) {
        service.deleteAttraction(id);
        return ResponseEntity.ok("Attraction deleted successfully!");
    }
}
