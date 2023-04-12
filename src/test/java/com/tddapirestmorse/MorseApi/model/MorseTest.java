package com.tddapirestmorse.MorseApi.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MorseTest {

    Morse morse;

    StringBuilder sb;

    String out;

    @BeforeEach
    void setUp() {

        morse = new Morse();

        sb = new StringBuilder();

    }

    @Test
    void readFileTest() {

        assertEquals(morse.words, morse.readFile());

    }

    @Test
    void transalteWordsOfFileReadedTest() {

        //given

        String ascii = "A";

        String translate = morse.map.getOrDefault("A", "");

        //test

        assertEquals(translate, morse.translateAsciiToMorse(ascii));
        assertEquals("", morse.translateAsciiToMorse(""));

    }

    @Test
    void encodedMorseTest() {

        //given

        String original = "may";

        //when

        for (int i = 0; i < original.length(); i++) {

            String mayus = String.valueOf(original.charAt(i)).toUpperCase();

            String equivalence = morse.translateAsciiToMorse(mayus);

            sb.append(equivalence);

        }

        //test

        assertEquals(sb.toString(), morse.encodedMorse(original));

    }

    @Test
    @DisplayName("Combinatorics with string empty and with non string empty.")
    void combineWithEmptyWithNonEmptyTest() {

        //given

        String input = "TEST";

        List<String> result = morse.combine(out, input);

        //test

        assertEquals(1, result.size());
        assertEquals("TEST ", result.get(0));

    }

    @Test
    @DisplayName("Combinatorics with non string empty and with string empty.")
    void combineWithNonEmptyWithEmptyTest() {

        //given

        String input = "";

        sb.append("TEST ");

        List<String> result = morse.combine(out, input);

        //test

        assertEquals(1, result.size());
        assertEquals("TEST ", result.get(0));

    }

    @Test
    @DisplayName("Combinatorics two strings non empty")
    void combineTwoNonEmptyTest() {

        //given

        String input = "ING";

        sb.append("TES ");

        List<String> result = morse.combine(out, input);

        //test

        assertEquals(2, result.size());
        assertEquals("TES ING ", result.get(0));
        assertEquals("TESING ", result.get(1));

    }

    @Test
    @DisplayName("Test search word with valid morse code")
    void searchWordWithValidMorseCodeTest() {

        //given

        String morseCode = "-....---..-.-..-...";

        List<String> result = morse.searchWord(morseCode, out);

        //test

        assertEquals(1, result.size());
        assertEquals("HOUR", result.get(0));
        assertEquals("HOUR ", sb.toString());

    }

    @Test
    @DisplayName("Test search word with invalid morse code")
    void searchWordWithInvalidMorseCodeTest() {

        //given

        String morseCode = "-....---..-..-..-...";

        List<String> result = morse.searchWord(morseCode, out);

        //test

        assertTrue(result.isEmpty());
        assertTrue(sb.toString().isEmpty());

    }

    @Test
    @DisplayName("Test search word with empty morse code")
    void searchWordWithEmptyMorseCodeTest() {

        //given

        String morseCode = "";

        List<String> result = morse.searchWord(morseCode, out);

        //test

        assertTrue(result.isEmpty());
        assertTrue(sb.toString().isEmpty());

    }

    @Test
    void filterResultWordsTest() {

        //given

        List<String> result = List.of("HELLO", "WORLD");
        List<String> filtered = morse.filterResultWords(result);

        //test

        assertEquals(List.of("HELLO", "WORLD"), filtered);

    }

}