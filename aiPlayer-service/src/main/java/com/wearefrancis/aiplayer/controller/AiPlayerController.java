package com.wearefrancis.aiplayer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AiPlayerController {

    @GetMapping
    public String test() {
        return "TEST";
    }
}
