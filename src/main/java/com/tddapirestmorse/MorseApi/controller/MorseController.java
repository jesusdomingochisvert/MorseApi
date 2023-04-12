package com.tddapirestmorse.MorseApi.controller;

import com.tddapirestmorse.MorseApi.service.IMorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MorseController {

    @Autowired
    IMorseService service;

    @CrossOrigin
    @GetMapping(value = "/englishToMorseCode/{input}")
    public String getEnglishToMorseCode(@PathVariable(value = "input") String input) {

        return service.getEnglishToMorseCode(input);

    }

    @CrossOrigin
    @GetMapping(value = "/morseCodeToEnglish/{input}")
    public List<String> getMorseCodeToEnglish(@PathVariable(value = "input") String input) {

        return service.getMorseCodeToEnglish(input);

    }

}
