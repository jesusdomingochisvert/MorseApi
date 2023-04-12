package com.tddapirestmorse.MorseApi.model;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Morse {

    final static String MORSE = "--.--.---.......-.---.-.-.-..-.....--..-....-.-----..-";

    static Map<String, String> map = new HashMap<>();

    static List<String> words = new ArrayList<>();

    static String out;

    static Morse morse = new Morse();

    public static void main(String[] args) {

        List<String> r = morse.searchWord(MORSE, out);

        morse.filterResultWords(r);

    }

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

    public List<String> filterResultWords(List<String> result) {

        for (int i = 0; i < result.size(); i++) {

            if (result.get(i).length() <= 30) {

                System.out.println(result.get(i));

            }

        }

        return result;

    }

    public List<String> readFile() {

        File f = null;

        FileReader fr = null;

        BufferedReader br = null;

        try {

            f = new File("C:\\Users\\jdomingo\\Downloads\\words.txt");

            fr = new FileReader(f);

            br = new BufferedReader(fr);

            String line;

            while ((line = br.readLine()) != null) {

                words.add(line);

            }

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (null != fr) {

                    fr.close();

                }

            } catch (Exception e) {

                e.printStackTrace();

            }

        }

        return words;

    }

    public String translateAsciiToMorse(String ascii) {

        return map.getOrDefault(ascii, "");

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

        String remaining = "";

        for (String w : words) {

            String translated = encodedMorse(w);

            if (wordFile.startsWith(translated)) {

                remaining = wordFile.replaceFirst(translated, "");

                wordsCleaned.addAll(combine(out + " " + w, remaining));

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
