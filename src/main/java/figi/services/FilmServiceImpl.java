package figi.services;

import figi.pojo.Film;
import figi.pojo.Kaartje;
import figi.pojo.Zaal;
import figi.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private ZaalService zaalService;
    @Autowired
    private FilmInfoService filmInfoService;
    @Autowired
    private KaartjeService kaartjeService;

    @Override
    public List<Film> alleFilmsOpFilmInfoId(Long id){
        List<Film> alleFilms = alleFilms();
        List<Film> films = new ArrayList<Film>();
        for (Film film:alleFilms
             ) {
            if(film.getFilmInfo() == id){
                films.add(film);
            }
        }
        return films;
    }

    @Override
    public List<Film> alleFilms(){
        return (List<Film>) filmRepository.findAll();
    }

    @Override
    public Film vindFilmOpId(Long id){
        return filmRepository.findById(id).orElse(null);
    }

    @Override
    public void opslaan(Film film){
        filmRepository.save(film);
    }

    @Override
    public void verwijder(Long id){
        for(Kaartje kaartje: kaartjeService.kaartjesVoorFilm(id)){
            kaartjeService.verwijder(kaartje);
        }
        filmRepository.deleteById(id);
    }

    @Override
    public void kaartjesVoorFilmMaken(Film film){
        Long filmId = film.getId();
        Zaal zaal = zaalService.vindOpId(film.getZaal());
        int rijen = zaal.getAantalRijen();
        int stoelenPerRij = zaal.getAantalStoelenPerRij();
        for(int rij = 0; rij < rijen; rij++){
            for(int stoel = 0; stoel < stoelenPerRij; stoel++){
                kaartjeService.nieuwKaartje(filmId, rij + 1, stoel + 1);
            }
        }
    }
}