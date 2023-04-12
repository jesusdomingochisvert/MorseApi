package com.tddapirestmorse.MorseApi.service;

import com.tddapirestmorse.MorseApi.model.Morse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class MorseServiceImplTest {

    @MockBean
    IMorseService service;

    @BeforeEach
    void setUp() {

    }

    @Test
    void getEnglishToMorseCodeTest() {

        //when

        when(service.getEnglishToMorseCode("hello")).thenReturn("......-...-..---");

        //test

        assertEquals("......-...-..---", service.getEnglishToMorseCode("hello"));

    }

    @Test
    void getMorseCodeToEnglishTest() {

        //when

        when(service.getMorseCodeToEnglish("......-...-..---")).thenReturn(List.of("hello"));

        //test

        assertEquals(List.of("hello"), service.getMorseCodeToEnglish("......-...-..---"));

    }

}
