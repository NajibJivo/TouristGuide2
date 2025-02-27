package com.example.touristguide2.service;

import com.example.touristguide2.model.TouristAttraction;
import com.example.touristguide2.model.TouristTags;
import com.example.touristguide2.model.TouristTowns;
import com.example.touristguide2.repository.TouristRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class TouristService {

    private final TouristRepository touristRepository;

    public TouristService(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    //Getter
    public List<TouristAttraction> getAllAttractions() {
        return touristRepository.getAttractionList();
    }

    // Getter
    public TouristAttraction getAttractionById(int id) {
        return touristRepository.showSpecificAttraction(id);
    }

    // Opdater en attraktion
    public TouristAttraction updateAttraction(int id, String newName, String newDescription, TouristTowns newCity, List<TouristTags> newTags) {
        return touristRepository.updateAttraction(id, newName, newDescription, newCity, newTags);
    }


    // Tilføj en ny attraktion
    public TouristAttraction addAttraction(String name, String description, TouristTowns city,List<TouristTags> tags, String image) {
        return touristRepository.addAttraction(name, description,city,tags,image);
    }

    // Slet en attraktion
    public boolean deleteAttraction(int id) {
        return touristRepository.deleteAttraction(id);
    }
}
