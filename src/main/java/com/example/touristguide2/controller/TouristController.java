package com.example.touristguide2.controller;

import com.example.touristguide2.model.TouristAttraction;
import com.example.touristguide2.model.TouristTags;
import com.example.touristguide2.model.TouristTowns;
import com.example.touristguide2.service.TouristService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TouristController {
    private final TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    // Endpoint til at vise alle attraktioner (GET /attractions)
    @GetMapping("/attractions")
    public String showAttractions(Model model) {
        model.addAttribute("attractions", touristService.getAllAttractions());
        return "attractionList";
    }

    // Endpoint til at vise detaljerne for en specifik attraktion (GET /attractions/{id})
    @GetMapping("/attractions/{id}")
    public String showAttractionsDetail(@PathVariable int id, Model model) {
        TouristAttraction attraction = touristService.getAttractionById(id);
        model.addAttribute("attraction", attraction);
        return "attractionDetail";
    }

    // Endpoint til at vise en form for at tilføje en ny attraktion (GET /add)
    @GetMapping("/add")
    public String showAttractionsForm(Model model) {
        model.addAttribute("tags", TouristTags.values());
        model.addAttribute("towns", TouristTowns.values());
        model.addAttribute("attraction", new TouristAttraction());
        return "addAttraction";
    }

    // Endpoint til at gemme den nye attraktion (POST /save)
    @PostMapping("/save")
    public String saveAttraction(@ModelAttribute TouristAttraction attraction) {
        touristService.addAttraction(attraction.getName(), attraction.getDescription(), attraction.getTown(), attraction.getTags(),attraction.getImage());
        return "redirect:/attractions";
    }

    // Endpoint til at slette en attraktion (GET /attractions/{id}/delete)
    @PostMapping("attractions/delete/{id}")
    public String deleteAttractions(@PathVariable int id) {
        touristService.deleteAttraction(id);
        return "redirect:/attractions";
    }

    // Endpoint til at vise en form for opdatering af en attraktion (GET /attractions/{id}/edit)
    @GetMapping("/attractions/{id}/edit")
    public String showEditAttractionForm(@PathVariable int id, Model model) {
        TouristAttraction attraction = touristService.getAttractionById(id);
        model.addAttribute("tags", TouristTags.values());
        model.addAttribute("towns", TouristTowns.values());
        model.addAttribute("attraction", attraction);
        return "updateAttraction";
    }

    // Endpoint til at opdatere attraktionen (POST /update)
    @PostMapping("/update")
    public String updateAttraction(@ModelAttribute TouristAttraction attraction) {

        touristService.updateAttraction(attraction.getId(), attraction.getName(), attraction.getDescription(),attraction.getTown(),attraction.getTags());
        return "redirect:/attractions";
    }
}
