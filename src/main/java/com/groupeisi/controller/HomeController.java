package com.groupeisi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping( "/prototype")
    public String prototype(Model model){
        return "index";
    }
    @GetMapping("/home")
    public String welcome(Model model){return "accueil";}
}
