package figi.services;

import figi.pojo.Kaartje;

import java.util.ArrayList;

public interface KaartjeService {
    ArrayList<Kaartje> kaartjeVoorGebruiker();

    Kaartje vindOpId(Long id);

    ArrayList<Kaartje> kaartjesVoorFilm(Long film);

    Kaartje nieuwKaartje(Long film, int rij, int stoel);

    void kaartjeReserveren(Kaartje kaartje);

    ArrayList<Kaartje> reserveerPaginaLaden(Long film);

    void verwijder(Kaartje kaartje);

    void verwijderReservering(Kaartje kaartje);
}
