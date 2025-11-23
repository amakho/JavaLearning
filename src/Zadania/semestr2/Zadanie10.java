package Zadania.semestr2;

import java.util.*;

public class Zadanie10 {
    public static void main(String[] args) {

        Map<String, Integer> scores = new HashMap<>();
        scores.put("Anton", 22);
        scores.put("Kacper", 23);
        scores.put("Piotr", 32);
        scores.put("Maciej", 19);

        System.out.println("1. Oryginalna HashMap: " + scores);


        Map<String, Integer> sortedByKeys = new TreeMap<>(scores);

        System.out.println("\n2. Mapa posortowana po Kluczu (TreeMap): " + sortedByKeys);


        Map<String, Integer> sortedKeysReverse = new TreeMap<>(String.CASE_INSENSITIVE_ORDER.reversed());
        sortedKeysReverse.putAll(scores);

        System.out.println("3. Mapa posortowana po Kluczu (odwrotnie): " + sortedKeysReverse);
    }
}
