package com.tddapirestmorse.MorseApi.service;

import com.tddapirestmorse.MorseApi.model.Morse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MorseServiceImpl implements IMorseService {

    @Override
    public String getEnglishToMorseCode(String input) {

        Morse morse = new Morse();

        return morse.encodedMorse(input);

    }

    @Override
    public List<String> getMorseCodeToEnglish(String input) {

        Morse morse = new Morse();

        String out = "";

        return morse.searchWord(input, out);

    }

}
