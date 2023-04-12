package com.tddapirestmorse.MorseApi.controller;

import com.tddapirestmorse.MorseApi.service.MorseServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = MorseController.class)
@ExtendWith(SpringExtension.class)
public class MorseControllerTest {

    @Autowired
    MockMvc mockMvc;

    @InjectMocks
    MorseController controller;

    @BeforeEach
    void setUp() {

        controller.service = Mockito.mock(MorseServiceImpl.class);

    }

    @Test
    void routeGetEnglishToMorseCodeTest() throws Exception {

        mockMvc.perform(get("/englishToMorseCode/{input}", "hello"))
                .andExpect(status().isOk());

    }

    @Test
    void routeGetMorseCodeToEnglishTest() throws Exception {

        mockMvc.perform(get("/morseCodeToEnglish/{input}", "......-...-..---"))
                .andExpect(status().isOk());

    }

    @Test
    void getEnglishToMorseCodeTest() {

        //when

        when(controller.service.getEnglishToMorseCode("hello")).thenReturn("......-...-..---");

        //test

        assertEquals("......-...-..---", controller.getEnglishToMorseCode("hello"));

    }

    @Test
    void getMorseCodeToEnglishTest() {

        //when

        when(controller.service.getMorseCodeToEnglish("......-...-..---")).thenReturn(List.of("hello"));

        //test

        assertEquals(List.of("hello"), controller.getMorseCodeToEnglish("......-...-..---"));

    }

}
