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

    private final static String ENG_TO_MORSE_ROUTE="/englishToMorseCode/{input}";
    private final static String MORSE_TO_ENG_ROUTE="/morseCodeToEnglish/{input}";
    private final static String VALUE="input";

    @Autowired
    IMorseService service;

    @CrossOrigin
    @GetMapping(value = ENG_TO_MORSE_ROUTE)
    public String getEnglishToMorseCode(@PathVariable(value = VALUE) String input) {

        return service.getEnglishToMorseCode(input);

    }

    @CrossOrigin
    @GetMapping(value = MORSE_TO_ENG_ROUTE)
    public List<String> getMorseCodeToEnglish(@PathVariable(value = VALUE) String input) {

        return service.getMorseCodeToEnglish(input);

    }

}
