package com.example.touristguide2.repository;

import com.example.touristguide2.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {
    private final List<TouristAttraction> attractionList = new ArrayList<>();

    public TouristRepository() {
        places();
    }

    public void places() {
        attractionList.add(new TouristAttraction("Tivoli haven",
                "Historisk forlystelsespark med traditionel charme og moderne underholdning"));
        attractionList.add(new TouristAttraction("Segway Tours Copenhagen",
                "Miljøvenlig guidet tur, der giver unikt indblik i Københavns kultur og arkitektur."));
        attractionList.add(new TouristAttraction("Hop on – Hop off kanalrundfart",
                "Fleksibel sejltur, hvor man i eget tempo udforsker byens kanaler og vartegn."));
        attractionList.add(new TouristAttraction("Den Lille Havfrue",
                "Ikonisk bronzestatue inspireret af H.C. Andersens eventyr og Københavns kulturarv."));
        attractionList.add(new TouristAttraction("Nyhavn",
                "Farverigt havneområde med historiske facader, caféer og livlig atmosfære."));
        attractionList.add(new TouristAttraction("Fristaden Christiania",
                "Alternativ bydel med selvstyre, kreativ kultur og unik samfundsstruktur."));
        attractionList.add(new TouristAttraction("Amalienborg Slot",
                "Kongelig residens i rokokostil, centrum for ceremonielle begivenheder."));
        attractionList.add(new TouristAttraction("Rosenborg Slot",
                "Renæssanceslot og museum, der huser kongelige skatte og formidler Danmarks historie."));
    }

}
