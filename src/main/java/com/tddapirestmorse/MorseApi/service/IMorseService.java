package com.tddapirestmorse.MorseApi.service;

import java.util.List;

public interface IMorseService {

    String getEnglishToMorseCode(String input);
    List<String> getMorseCodeToEnglish(String input);

}
