package figi.controllers;

import figi.pojo.Gebruiker;
import figi.pojo.GebruikerDto;
import figi.services.GebruikerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class GebruikerController {
    @Autowired
    private GebruikerService gebruikerService;

    @RequestMapping("/profiel")
    public String profielLaden(Model model){
        model.addAttribute("gebruiker", gebruikerService.ingelogdeGebruiker());
        return "gebruiker/profiel";
    }

    @RequestMapping("/registreren")
    public String aanmelden(Model model){
        model.addAttribute("gebruiker", new GebruikerDto());
        return "gebruiker/nieuweGebruiker";
    }

    @RequestMapping("/registreren/opslaan")
    public String opslaan(@Valid GebruikerDto gebruiker, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "gebruiker/nieuweGebruiker";
        }
        gebruikerService.opslaan(gebruiker);
        return "redirect:/home";
    }

    @RequestMapping("/profiel/verwijderen")
    public String verwijderAccount(){
        //TODO Kaartjes van account ook verwijderen
        gebruikerService.verwijder();
        return "redirect:/loguit";
    }
}
