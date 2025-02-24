package com.example.touristguide2.service;

import com.example.touristguide2.model.TouristAttraction;
import com.example.touristguide2.repository.TouristRepository;
import org.springframework.stereotype.Service;
import java.util.List;

/**  Metoderne i service-klassen kalder direkte repository-metoderne **/
@Service
public class TouristService {

    private final TouristRepository touristRepository;

    public TouristService(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    // Returner alle attraktioner
    public List<TouristAttraction> getAllAttractions() {
        return touristRepository.getAttractionList();
    }

    // Find en specifik attraktion baseret på ID
    public TouristAttraction getAttractionById(int id) {
        return touristRepository.showSpecificAttraction(id);
    }

    // Opdater en attraktion
    public TouristAttraction updateAttraction(int id, String newName, String newDescription,String newCity) {
        return touristRepository.updateAttractionx(id, newName, newDescription,newCity);
    }

    // Tilføj en ny attraktion
    public TouristAttraction addAttraction(String name, String description, String city) {
        return touristRepository.addAttraction(name, description,city);
    }

    // Slet en attraktion
    public boolean deleteAttraction(int id) {
        return touristRepository.deleteAttraction(id);
    }
}
