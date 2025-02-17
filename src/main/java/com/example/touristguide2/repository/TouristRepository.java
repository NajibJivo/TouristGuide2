package com.example.touristguide2.repository;

import com.example.touristguide2.model.TouristAttraction;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Repository
public class TouristRepository {
    private final List<TouristAttraction> attractionList = new ArrayList<>();

    public TouristRepository() {
        places();
        ;
    }

    public void places() {
        attractionList.add(new TouristAttraction(
                "Tivoli haven",
                "Historisk forlystelsespark med traditionel charme og moderne underholdning",
                "København",
                Arrays.asList("Forlystelser", "Historie", "Underholdning")
        ));

        attractionList.add(new TouristAttraction(
                "Segway Tours Copenhagen",
                "Miljøvenlig guidet tur, der giver unikt indblik i Københavns kultur og arkitektur.",
                "København",
                Arrays.asList("Guidet tur", "Miljøvenlig", "Kultur")
        ));

        attractionList.add(new TouristAttraction(
                "Hop on – Hop off kanalrundfart",
                "Fleksibel sejltur, hvor man i eget tempo udforsker byens kanaler og vartegn.",
                "København",
                Arrays.asList("Sejltur", "Byvandring")
        ));

        attractionList.add(new TouristAttraction(
                "Den Lille Havfrue",
                "Ikonisk bronzestatue inspireret af H.C. Andersens eventyr og Københavns kulturarv.",
                "København",
                Arrays.asList("Statue", "Kulturarv")
        ));

        attractionList.add(new TouristAttraction(
                "Nyhavn",
                "Farverigt havneområde med historiske facader, caféer og livlig atmosfære.",
                "København",
                Arrays.asList("Havneområde", "Historie", "Caféer")
        ));

        attractionList.add(new TouristAttraction(
                "Fristaden Christiania",
                "Alternativ bydel med selvstyre, kreativ kultur og unik samfundsstruktur.",
                "København",
                Arrays.asList("Alternativ", "Kreativ", "Samfund")
        ));

        attractionList.add(new TouristAttraction(
                "Amalienborg Slot",
                "Kongelig residens i rokokostil, centrum for ceremonielle begivenheder.",
                "København",
                Arrays.asList("Kongelig", "Historie")
        ));

        attractionList.add(new TouristAttraction(
                "Rosenborg Slot",
                "Renæssanceslot og museum, der huser kongelige skatte og formidler Danmarks historie.",
                "København",
                Arrays.asList("Museum", "Historie", "Slot")
        ));
    }


        /* En metode til at returnere hele listen af attraktioner */
    public List<TouristAttraction> getAttractionList() {
            return attractionList;
    }

        /* En metode, der modtager et ID som parameter, itererer listen og returnerer den attraktion, der matcher ID'et. */
    public TouristAttraction showSpecificAttraction ( int ID){
         for (TouristAttraction touristAttraction : attractionList) {
             if (ID == touristAttraction.getId()) {
                    return touristAttraction;
             }
         }
         return null;
    }

    public TouristAttraction updateAttractionx ( int id, String newName, String newDescription){

         for (TouristAttraction attraction : attractionList) {
             if (attraction.getId() == id) {
                    attraction.setName(newName);
                    attraction.setDescription(newDescription);
                    System.out.println("Attraktion hermed opdateret.");
                    return attraction;
             }
         }
            System.out.println("Ingen attraktion fundet med ID: " + id);
            return null;
    }


        /*En metode, der modtager de nødvendige data  ( Navn og beskrivelse) og opretter et nyt TouristAttraction-objekt.*/
    public TouristAttraction addAttraction (String newName, String newDescription){
            // Opret et nyt TouristAttraction-objekt med de modtagne data
        TouristAttraction newAttraction = new TouristAttraction();

            // Tilføje det nye objekt til listen
        newAttraction.setName(newName);
        newAttraction.setDescription(newDescription);

            // Udskrive en bekræftelse og returnér objektet
        System.out.println("Ny attraktion tilføjet: " + newAttraction.getName());
        return newAttraction;
    }

    // *En metode til at fjerne en attraktion baseret på dens unikke ID
    public boolean deleteAttraction(int id) {
        Iterator<TouristAttraction> iterator = attractionList.iterator();
        while (iterator.hasNext()) {
            TouristAttraction attraction = iterator.next();
            if(attraction.getId() == id) {
                iterator.remove();
                System.out.println("Attraktion med følgende ID: " + id + " fjernet." );
            }
        }
        return true; // Returnerer true, hvis sletningen lykkes.
    }
}
