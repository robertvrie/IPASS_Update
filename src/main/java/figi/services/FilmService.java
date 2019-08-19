package figi.services;

import figi.pojo.Film;

import java.util.List;

public interface FilmService {
    List<Film> alleFilmsOpFilmInfoId(Long id);

    List<Film> alleFilms();

    Film vindFilmOpId(Long id);

    void opslaan(Film film);

    void verwijder(Long id);

    void kaartjesVoorFilmMaken(Film film);
}
