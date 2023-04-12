package com.tddapirestmorse.MorseApi.model;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Morse {

    final static String FILE_PATH="C:\\Users\\jdomingo\\Downloads\\words.txt";
    final static String EMPTY_STRING="";

    static Map<String, String> map = new HashMap<>();

    static List<String> words = new ArrayList<>();

    public Morse() {

        map.put("A", ".-");
        map.put("B", "-...");
        map.put("C", "-.-.");
        map.put("D", "-..");
        map.put("E", ".");
        map.put("F", "..-.");
        map.put("G", "-..");
        map.put("H", "....");
        map.put("I", "..");
        map.put("J", ".---");
        map.put("K", "-.-");
        map.put("L", ".-..");
        map.put("M", "--");
        map.put("N", "-.");
        map.put("O", "---");
        map.put("P", ".--.");
        map.put("Q", "--.-");
        map.put("R", ".-.");
        map.put("S", "...");
        map.put("T", "-");
        map.put("U", "..-");
        map.put("V", "...-");
        map.put("W", ".--");
        map.put("X", "-..-");
        map.put("Y", "-.--");
        map.put("Z", "--..");

        readFile();

    }


    public List<String> readFile() {

        File fileToRead = null;

        FileReader fileReader = null;

        BufferedReader bufferedReader = null;

        try {

            fileToRead = new File(FILE_PATH);

            fileReader = new FileReader(fileToRead);

            bufferedReader = new BufferedReader(fileReader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {

                words.add(line);

            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (null != fileReader) {

                    fileReader.close();

                }

            } catch (Exception e) {

                e.printStackTrace();

            }

        }

        return words;

    }

    public String translateAsciiToMorse(String ascii) {

        return map.getOrDefault(ascii, EMPTY_STRING);

    }

    public String encodedMorse(String original) {

        StringBuilder encoded = new StringBuilder();

        for (int i = 0; i < original.length(); i++) {

            String mayus = String.valueOf(original.charAt(i)).toUpperCase();

            String equivalence = translateAsciiToMorse(mayus);

            encoded.append(equivalence);

        }

        return encoded.toString();

    }

    public List<String> searchWord(String wordFile, String out) {

        List<String> wordsCleaned = new ArrayList<>();

        String remaining;

        for (String word : words) {

            String translated = encodedMorse(word);

            if (wordFile.startsWith(translated)) {

                remaining = wordFile.replaceFirst(translated, EMPTY_STRING);

                wordsCleaned.addAll(combine(out + " " + word, remaining));

            }

        }

        return wordsCleaned;

    }

    public List<String> combine(String output, String input) {

        List<String> result = new ArrayList<>(searchWord(input, output));

        result.add(output);

        return result;

    }

}
