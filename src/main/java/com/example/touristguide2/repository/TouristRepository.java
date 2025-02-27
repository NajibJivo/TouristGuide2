package com.example.touristguide2.repository;

import com.example.touristguide2.model.TouristAttraction;
import com.example.touristguide2.model.TouristTags;
import com.example.touristguide2.model.TouristTowns;
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

    }

    public void places() {
        TouristAttraction tivoli = new TouristAttraction(
                "Tivoli Haven",
                "Historisk forlystelsespark med traditionel charme og moderne underholdning",
                TouristTowns.KOBENHAVN,
                Arrays.asList(TouristTags.FORLYSTELSER, TouristTags.HISTORIE, TouristTags.UNDERHOLDNING)
        );
        tivoli.setImage("tivoli.png");
        attractionList.add(tivoli);

        TouristAttraction segway = new TouristAttraction(
                "Segway Tours Copenhagen",
                "Miljøvenlig guidet tur, der giver unikt indblik i Københavns kultur og arkitektur.",
                TouristTowns.KOBENHAVN,
                Arrays.asList(TouristTags.GUIDED_TUR, TouristTags.MILJOE_VENLIG, TouristTags.KULTUR)

        );
        segway.setImage("segway.png"); // Tilføj billede
        attractionList.add(segway);

        TouristAttraction kanalrundfart = new TouristAttraction(
                "Hop on – Hop off kanalrundfart",
                "Fleksibel sejltur, hvor man i eget tempo udforsker byens kanaler og vartegn.",
                TouristTowns.KOBENHAVN,
                Arrays.asList(TouristTags.SEJLTUR, TouristTags.BYVANDRING)
        );
        kanalrundfart.setImage("rundfart.png");
        attractionList.add(kanalrundfart);

        TouristAttraction havfrue = new TouristAttraction(
                "Den Lille Havfrue",
                "Ikonisk bronzestatue inspireret af H.C. Andersens eventyr og Københavns kulturarv.",
                TouristTowns.KOBENHAVN,
                Arrays.asList(TouristTags.STATUE, TouristTags.KULTUR)
        );
        havfrue.setImage("havfrue.png");
        attractionList.add(havfrue);

        TouristAttraction nyhavn = new TouristAttraction(
                "Nyhavn",
                "Farverigt havneområde med historiske facader, caféer og livlig atmosfære.",
                TouristTowns.KOBENHAVN,
                Arrays.asList(TouristTags.HAVN, TouristTags.HISTORIE, TouristTags.CAFÉER)
        );
        nyhavn.setImage("nyhavn.png");
        attractionList.add(nyhavn);

        TouristAttraction christiania = new TouristAttraction(
                "Fristaden Christiania",
                "Alternativ bydel med selvstyre, kreativ kultur og unik samfundsstruktur.",
                TouristTowns.KOBENHAVN,
                Arrays.asList(TouristTags.ALTERNATIV, TouristTags.KREATIV, TouristTags.SAMFUND)
        );
        christiania.setImage("christania.png");
        attractionList.add(christiania);

        TouristAttraction amalienborg = new TouristAttraction(
                "Amalienborg Slot",
                "Kongelig residens i rokokostil, centrum for ceremonielle begivenheder.",
                TouristTowns.KOBENHAVN,
                Arrays.asList(TouristTags.KONGELIG, TouristTags.HISTORIE)
        );
        amalienborg.setImage("Slot.png");
        attractionList.add(amalienborg);

        TouristAttraction rosenborg = new TouristAttraction(
                "Rosenborg Slot",
                "Renæssanceslot og museum, der huser kongelige skatte og formidler Danmarks historie.",
                TouristTowns.KOBENHAVN,
                Arrays.asList(TouristTags.MUSEUM, TouristTags.HISTORIE, TouristTags.SLOT)
        );
        rosenborg.setImage("rosenborg.png");
        attractionList.add(rosenborg);
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

    public TouristAttraction updateAttraction(int id, String newName, String newDescription, TouristTowns newCity, List<TouristTags>newTags) {
        for (TouristAttraction attraction : attractionList) {
            if (attraction.getId() == id) {
                attraction.setName(newName);
                attraction.setDescription(newDescription);
                attraction.setTown(newCity);
                attraction.setTags(newTags);
                return attraction;
            }
        }
        return null;
    }


        /*En metode, der modtager de nødvendige data  ( Navn og beskrivelse) og opretter et nyt TouristAttraction-objekt.*/
        public TouristAttraction addAttraction(String newName, String newDescription, TouristTowns city, List<TouristTags> tags, String image) {
            // Opret et nyt TouristAttraction-objekt med de modtagne data
            TouristAttraction newAttraction = new TouristAttraction(newName, newDescription,city ,tags);

            // Tilføj billede
            newAttraction.setImage(image);

            attractionList.add(newAttraction);


            // Udskrive en bekræftelse og returnér objektet
            System.out.println("Ny attraktion tilføjet: " + newAttraction.getName());
            return newAttraction;


}

    //En metode til at fjerne en attraktion baseret på dens unikke ID
    public boolean deleteAttraction(int id) {
        Iterator<TouristAttraction> iterator = attractionList.iterator();
        while (iterator.hasNext()) {
            TouristAttraction attraction = iterator.next();
            if(attraction.getId() == id) {
                iterator.remove();
                System.out.println("Attraktion med følgende ID: " + id + " fjernet." );
            }
        }
        return true;
    }
}
