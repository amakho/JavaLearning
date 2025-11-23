package Zadania.semestr2;
import java.util.*;
import java.util.concurrent.TimeUnit;
public class Zadanie4 {
    public static void main(String[] args) {
        final int size = 1000000;
        Random rand = new Random();
        List<Integer> list = new ArrayList<>(size);


        System.out.println("Tworzenie listy 1,000,000 losowych liczb...");
        for (int i = 0; i < size; i++) {
            list.add(rand.nextInt(10) + 1);
        }

        Set<Integer> set = new HashSet<>(list);

        long startList = System.nanoTime();
        long sumList = 0;
        for (int i : list) {
            sumList += i;
        }
        long endList = System.nanoTime();
        long timeList = endList - startList;

        long startSet = System.nanoTime();
        long sumSet = 0;
        for (int i : set) {
            sumSet += i;
        }
        long endSet = System.nanoTime();
        long timeSet = endSet - startSet;

        System.out.println("Lista ma elementów: " + list.size());
        System.out.println("Suma elementów: " + sumList);
        System.out.println("Czas sumowania: " + TimeUnit.NANOSECONDS.toMillis(timeList) + " ms");

        System.out.println("Set ma elementów: " + set.size() + " (tylko 10 unikalnych liczb)");
        System.out.println("Suma elementów: " + sumSet);
        System.out.println("Czas sumowania: " + TimeUnit.NANOSECONDS.toMillis(timeSet) + " ms");

        System.out.println("Porównanie Sum");
        if (sumList != sumSet) {
            System.out.println("Suma Listy jest wieksza od Sumy Seta.");
        } else {
            System.out.println("Sumy są identyczne (co jest mało prawdopodobne dla losowych danych).");
        }
    }
}

