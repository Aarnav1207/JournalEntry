package com.example.journalApp.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelathCheck {

    @GetMapping("/Health-Check")
    public String healthcheck(){
        return "Ok";
    }
}
