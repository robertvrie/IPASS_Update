package figi.services;

import figi.pojo.Kaartje;
import figi.repositories.KaartjeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class KaartjeServiceImpl implements KaartjeService {
    @Autowired
    KaartjeRepository kaartjeRepository;
    @Autowired
    GebruikerService gebruikerService;

    @Override
    public ArrayList<Kaartje> kaartjeVoorGebruiker() {
        return kaartjeRepository.findByGebruiker(gebruikerService.ingelogdeGebruiker().getId());
    }

    @Override
    public Kaartje vindOpId(Long id){
        return kaartjeRepository.findById(id).orElse(null);
    }

    @Override
    public ArrayList<Kaartje> kaartjesVoorFilm(Long film) {
        ArrayList<Kaartje> kaartjes = new ArrayList<Kaartje>();
        for (Kaartje kaartje : kaartjeRepository.findAll()) {
            if (kaartje.getFilm() == film) {
                kaartjes.add(kaartje);
            }
        }
        return kaartjes;
    }

    @Override
    public Kaartje nieuwKaartje(Long film, int rij, int stoel) {
        Kaartje kaartje = new Kaartje();
        kaartje.setFilm(film);
        kaartje.setRij(rij);
        kaartje.setStoel(stoel);
        kaartjeRepository.save(kaartje);
        return kaartje;
    }

    @Override
    public void kaartjeReserveren(Kaartje kaartje) {
        kaartje.setGebruiker(gebruikerService.ingelogdeGebruiker().getId());
    }

    @Override
    public ArrayList<Kaartje> reserveerPaginaLaden(Long film) {
        ArrayList<Kaartje> alleKaartjes = kaartjesVoorFilm(film);
        ArrayList<Kaartje> returnKaartjes = new ArrayList<Kaartje>();

        for (Kaartje kaartje : alleKaartjes) {
            if (kaartje.getGebruiker() == null) {
                returnKaartjes.add(kaartje);
            }
        }
        return returnKaartjes;
    }

    @Override
    public void verwijder (Kaartje kaartje){
        kaartjeRepository.delete(kaartje);
    }

    @Override
    public void verwijderReservering (Kaartje kaartje){
        kaartje.setGebruiker(null);
    }
}
