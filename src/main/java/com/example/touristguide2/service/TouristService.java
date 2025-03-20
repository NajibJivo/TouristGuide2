package com.example.touristguide2.service;


import com.example.touristguide2.model.TouristAttraction;
import com.example.touristguide2.repository.TouristRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService {

    private final TouristRepository repository;

    public TouristService(TouristRepository repository) {
        this.repository = repository;
    }

    public List<TouristAttraction> getAllAttractions() {
        return repository.findAll();
    }

    public TouristAttraction getAttractionById(int id) {
        return repository.findById(id);
    }

    public void addAttraction(TouristAttraction attraction) {
        repository.save(attraction);
    }

    public void updateAttraction(int id, TouristAttraction attraction) {
        repository.update(id, attraction);
    }

    public void deleteAttraction(int id) {
        repository.deleteById(id);
    }
}