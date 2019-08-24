package figi.controllers;

import figi.pojo.FilmInfo;
import figi.services.FilmInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class FilmInfoController {
    private FilmInfoService filmInfoService;


    @Autowired
    public void setFilmInfoService(FilmInfoService filmInfoService) {
        this.filmInfoService = filmInfoService;
    }
    
    @RequestMapping({"/filmInfo", "/home", "/"})
    public String listFilmInfo(Model model){
        model.addAttribute("filmInfos", filmInfoService.vindAlle());
        return "filmInfo/list";
    }

    @RequestMapping("/filmInfo/show/{id}")
    public String getFilmInfo(@PathVariable String id, Model model){
        model.addAttribute("filmInfo", filmInfoService.vindMetId(Long.valueOf(id)));
        return "filmInfo/show";
    }

    @RequestMapping("filmInfo/edit/{id}")
    public String edit(@PathVariable String id, Model model){
        FilmInfo filmInfo = filmInfoService.vindMetId(Long.valueOf(id));

        model.addAttribute("filmInfo", filmInfo);
        return "filmInfo/filmInfoForm";
    }

    @RequestMapping("/filmInfo/new")
    public String newFilmInfo(Model model){
        model.addAttribute("filmInfo", new FilmInfo());

        return "filmInfo/filmInfoForm";
    }

    @RequestMapping(value = "/filmInfo", method = RequestMethod.POST)
    public String saveOrUpdateFilmInfo(@Valid FilmInfo filmInfoForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "filmInfo/filmInfoForm";
        }
        filmInfoService.opslaan(filmInfoForm);

        return "redirect:/filmInfo/show/" + filmInfoForm.getId();
    }

    @RequestMapping("/filmInfo/delete/{id}")
    public String delete(@PathVariable String id){
        filmInfoService.verwijder(Long.valueOf(id));
        return "redirect:/filmInfo/list";
    }
}