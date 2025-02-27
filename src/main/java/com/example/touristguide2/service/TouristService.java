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
    public TouristAttraction getAttractionByName(String name) {
        return touristRepository.getAttractionByName(name);
    }

    // Opdater en attraktion
    public TouristAttraction updateAttraction(String oldName, String newName, String newDescription, TouristTowns newTown, List<TouristTags> newTags) {
        return touristRepository.updateAttraction(oldName, newName, newDescription, newTown, newTags);
    }


    // Tilføj en ny attraktion
    public TouristAttraction addAttraction(String name, String description, TouristTowns town,List<TouristTags> tags, String image) {
        return touristRepository.addAttraction(name, description,town,tags,image);
    }

    // Slet en attraktion
    public boolean deleteAttraction(String name) {
        return touristRepository.deleteAttraction(name);
    }
}
