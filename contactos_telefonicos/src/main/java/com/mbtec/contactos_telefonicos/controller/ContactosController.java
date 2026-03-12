package com.mbtec.contactos_telefonicos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contact")
public class ContactosController {

    @GetMapping("/greating")
    public String grreating(){
        return "Um prazer fazer parte da familia MBTEC";
    }
}
