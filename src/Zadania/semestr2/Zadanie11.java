package Zadania.semestr2;
import java.util.*;
public class Zadanie11 {
    public static void main(String[] args) {
        Map<String, Integer> studentScores = new HashMap<>();
        studentScores.put("Alicja", 85);
        studentScores.put("Robert", 92);
        studentScores.put("Anna", 78);
        studentScores.put("Krzysztof", 89);
        studentScores.put("Zuzanna", 85);

        System.out.println("Oryginalna Mapa (HashMap - brak kolejności):\n" + studentScores);

        List<Map.Entry<String, Integer>> list = new ArrayList<>(studentScores.entrySet());

        list.sort(Comparator.comparing(Map.Entry::getValue));

        Map<String, Integer> sortedByValues = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedByValues.put(entry.getKey(), entry.getValue());
        }

        System.out.println("\nPosortowana Mapa po Wartościach (rosnąco):\n" + sortedByValues);
    }
}
