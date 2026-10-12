package com.demo.basic_genai_project;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TwiggyController {

    private final TwiggyService twiggyService;

    public TwiggyController(TwiggyService twiggyService){
        this.twiggyService = twiggyService;
    }

    @PostMapping("/chat")
    public String summarize(@RequestBody String message){
        return twiggyService.chat(message);
    }
}
