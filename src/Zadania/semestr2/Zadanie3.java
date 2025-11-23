package Zadania.semestr2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Zadanie3 {
    public static void main(String[] args) {
         final int size = 1000000;
        ArrayList<Integer> arrayList = new ArrayList<>(size);
        for (int i = 1; i <= size; i++){
            arrayList.add(i);
        }
        Set<Integer> set = new HashSet<>(arrayList);
        long startList = System.nanoTime();
        long sumList = 0;
        for (int i : arrayList){
            sumList += i;
        }
        long endList = System.nanoTime();
        long timeList = endList - startList;

        long startSet = System.nanoTime();
        long sumSet = 0;
        for (int j : set){
            sumSet += j;
        }
        long endSet = System.nanoTime();
        long timeSet = endSet - startSet;

        System.out.println("Lista (ArrayList) ma elementów: " + arrayList.size());
        System.out.println("Suma elementów Listy: " + sumList);
        System.out.println("Czas sumowania Listy: " + TimeUnit.NANOSECONDS.toMillis(timeList) + " ms");

        System.out.println("\nSet (HashSet) ma elementów: " + set.size());
        System.out.println("Suma elementów Seta: " + sumSet);
        System.out.println("Czas sumowania Seta: " + TimeUnit.NANOSECONDS.toMillis(timeSet) + " ms");
    }
}
