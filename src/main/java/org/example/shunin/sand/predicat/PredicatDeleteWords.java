package org.example.shunin.sand.predicat;

import java.util.ArrayList;
import java.util.List;

public class PredicatDeleteWords {
    private static List<String> text = new ArrayList<>(List.of("Hello everybody, how are you \n\rWhat do you prefer" +
            " in this evening \n\rcoffe or tea?"));
    public static void main(String[] args) {

        System.out.println(text);

    }

    public static  boolean predicDelete(String word) {
        for (String temp: text
             ) {

        }
        return true;
    }
}
