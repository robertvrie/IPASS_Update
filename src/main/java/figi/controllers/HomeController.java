package figi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String redirToList(){
        return "redirect:/home";
    }

    @RequestMapping("/home")
    public String homePage() {
        return "home";
    }

    @RequestMapping("/login")
    public String login() { return "login"; }


}
