package com.demo.basic_genai_project;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SummarizeController {

    private final SummarizeService summarizeService;

    public SummarizeController(SummarizeService summarizeService){
        this.summarizeService = summarizeService;
    }

    @PostMapping("/chat")
    public String summarize(@RequestBody String message){
        return summarizeService.chat(message);
    }
}
