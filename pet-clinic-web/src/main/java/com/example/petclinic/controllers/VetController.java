package com.example.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {
    
    @RequestMapping({"/vet"})
    public String vetsList() {
        return "vets/index";
    }
}
