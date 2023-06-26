package com.example.registerjugadordotaweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controller")
public class JugadorDotaController {
    @GetMapping("/metodo")
    public String getPost() {

        return "Funciona bien";
    }
}
