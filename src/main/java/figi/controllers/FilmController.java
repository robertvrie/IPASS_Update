package figi.controllers;

import figi.pojo.Film;
import figi.pojo.Kaartje;
import figi.services.FilmInfoService;
import figi.services.FilmService;
import figi.services.KaartjeService;
import figi.services.ZaalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FilmController {
    @Autowired
    public FilmService filmService;
    @Autowired
    public ZaalService zaalService;
    @Autowired
    public FilmInfoService filmInfoService;
    @Autowired
    public KaartjeService kaartjeService;

    @RequestMapping("/films/{id}")
    public String lijstFilms(Model model, @PathVariable Long id){
        model.addAttribute("films", filmService.alleFilmsOpFilmInfoId(id));
        model.addAttribute("filmNaam", filmInfoService.vindMetId(id).getNaam());
        return "film/lijst";
    }

    @RequestMapping("/film/nieuw")
    public String nieuweFilm(Model model){
        model.addAttribute("film", new Film());
        model.addAttribute("zalen", zaalService.vindAlle());
        model.addAttribute("filmInfos", filmInfoService.vindAlle());
        return "film/nieuweFilm";
    }

    @RequestMapping(value = "/films", method = RequestMethod.POST)
    public String filmOpslaan(Film film){
        filmService.opslaan(film);
        filmService.kaartjesVoorFilmMaken(film);
        return "redirect:/films/" + film.getFilmInfo();
    }

    @RequestMapping("/film/verwijder/{id}")
    public String verwijderFilm(@PathVariable Long id){
        Long redirect = filmService.vindFilmOpId(id).getFilmInfo();
        filmService.verwijder(id);
        return "redirect:/films/" + redirect;
    }

    @RequestMapping("/films/reserveren/{id}")
    public String filmReserveren(Model model, @PathVariable Long id){
        model.addAttribute("alleKaartjes",kaartjeService.reserveerPaginaLaden(id));
        model.addAttribute("kaartje",new Kaartje());
        return "film/reserveren";
    }

    @RequestMapping("/films/reserveren/opslaan")
    public String filmReserverenOpslaan(Kaartje kaartje){
        System.out.println(kaartje.getId());
        kaartjeService.kaartjeReserveren(kaartjeService.vindOpId(kaartje.getId()));
        return "redirect:/films/lijst";
    }
}
