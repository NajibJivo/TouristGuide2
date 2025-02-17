package com.example.touristguide2.controller;

import com.example.touristguide2.model.TouristAttraction;
import com.example.touristguide2.service.TouristService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
/** Controller-klassen håndterer HTTP-requests og sender data videre til Thymeleaf-skabeloner **/
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
        return "attractionList"; // Thymeleaf-template: attractionList.html
    }

    // Endpoint til at vise detaljerne for en specifik attraktion (GET /attractions/{id})
    @GetMapping("/attractions/{id}")
    public String showAttractionsDetail(@PathVariable int id, Model model) {
        TouristAttraction attraction = touristService.getAttractionById(id);
        if(attraction == null) {
            return "error";
        }
        model.addAttribute("attraction", attraction);
        return "attractionDetail"; // Thymeleaf-template: attractionDetail.html
    }

    // Endpoint til at vise en form for at tilføje en ny attraktion (GET /add)
    @GetMapping("/add")
    public String showAttractionsForm(Model model) {
        model.addAttribute("attraction", new TouristAttraction());
        return "addAttraction"; // Thymeleaf-template: addAttraction.html
    }

    // Endpoint til at gemme den nye attraktion (POST /save)
    @PostMapping("/save")
    public String saveAttraction(@ModelAttribute TouristAttraction attraction) {
        touristService.addAttraction(attraction.getName(), attraction.getDescription());
        return "redirect:/attractions";
    }

    // Endpoint til at slette en attraktion (GET /attractions/{id}/delete)
    @GetMapping("attractions/{id}/delete")
    public String deleteAttractions(@PathVariable int id) {
        touristService.deleteAttraction(id);
        return "redirect:/attractions";
    }

    // Endpoint til at vise en form for opdatering af en attraktion (GET /attractions/{id}/edit)
    @GetMapping("/attractions/{id}/edit")
    public String showEditAttractionForm(@PathVariable int id, Model model) {
        TouristAttraction attraction = touristService.getAttractionById(id);
        if(attraction == null) {
            return "error";
        }
        model.addAttribute("attraction", attraction);
        return "updateAttraction"; // Thymeleaf-template: updateAttraction.html
    }

    // Endpoint til at opdatere attraktionen (POST /update)
    @PostMapping("/update")
    public String updateAttraction(@ModelAttribute TouristAttraction attraction) {
        touristService.updateAttraction(attraction.getId(), attraction.getName(), attraction.getDescription());
        return "redirect:/attractions";
    }
}
