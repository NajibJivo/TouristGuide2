package com.example.touristguide2.service;

import com.example.touristguide2.model.TouristAttraction;
import com.example.touristguide2.model.TouristTags;
import com.example.touristguide2.model.TouristTowns;
import com.example.touristguide2.repository.TouristRepository;
import org.springframework.stereotype.Service;
import java.util.List;


public class TouristService {

    private final TouristRepository touristRepository = new TouristRepository();


    public List<TouristAttraction> getAllAttractions() {
        return touristRepository.getAllAttractions();
    }



    // Getter
    public TouristAttraction getAttractionByName(String name) {
        return touristRepository.getAttractionByName(name);
    }

    // Opdater en attraktion
    public TouristAttraction updateAttraction(TouristAttraction attraction) {
        return touristRepository.updateAttraction(attraction);
    }


    // Tilføj en ny attraktion
    public TouristAttraction addAttraction(TouristAttraction attraction) {
        return touristRepository.addAttraction(attraction);
    }

    // Slet en attraktion
    public boolean deleteAttraction(String name) {
        return touristRepository.deleteAttraction(name);
    }
    /**public List<TouristTags> getAttractionTags(String name) {
        return touristRepository.getAttractionTags(name); **/
    }
}
