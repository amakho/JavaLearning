package Zadania.semestr2;
import java.util.*;
public class Zadanie9 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Wprowadź tekst do analizy:");

        String text = scanner.nextLine();
        scanner.close();

        Map<String, Integer> wordCount = new TreeMap<>();



        String lowerCaseText = text.toLowerCase();

        String cleanedText = lowerCaseText.replaceAll("[^a-z\\s]", "");

        String[] words = cleanedText.split("\\s+");


        for (String word : words) {
            if (!word.isEmpty()) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }


        System.out.println("\n--- Wyniki zliczania (posortowane alfabetycznie) ---");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println("Słowo '" + entry.getKey() + "' wystąpiło: " + entry.getValue() + " razy");
        }
    }
}
