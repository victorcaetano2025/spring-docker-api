package com.api.apidocker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    @GetMapping("/ola")
    public String olaMundo() {
        return "Olá Mundo!";
    }
}