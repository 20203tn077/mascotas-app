package mx.edu.utez.mascotasapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class MainController {
    @RequestMapping("")
    public String index() {
        return "index";
    }
}
