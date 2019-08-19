package figi.controllers;

import figi.pojo.Zaal;
import figi.services.ZaalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class ZaalController {
    @Autowired
    private ZaalService zaalService;

    @RequestMapping("/zaal")
    public String vindAlleZalen(Model model){
        model.addAttribute("zalen",zaalService.vindAlle());
        return "zaal/zaalOverzicht";
    }

    @RequestMapping("/zaal/verwijder/{id}")
    public String verwijderZaal(@PathVariable Long id){
        zaalService.verwijder(id);
        return "redirect:/zaal";
    }

    @RequestMapping("/zaal/toevoegen")
    public String voegZaalToe(Model model){
        model.addAttribute("zaal", new Zaal());
        return "zaal/nieuweZaal";
    }

    @RequestMapping("/zaal/toevoegen/opslaan")
    public String slaZaalOp(@Valid Zaal zaal, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "zaal/nieuweZaal";
        }
        zaalService.opslaan(zaal);
        return "redirect:/zaal";
    }
}
