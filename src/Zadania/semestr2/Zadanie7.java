package Zadania.semestr2;
import java.util.*;
public class Zadanie7 {
        /*
         * Collections.sort(List) sortuje listę w miejscu. Używa ona:
         * 1. Naturalnego porządku, jeśli elementy implementują interfejs Comparable(jak nasza klasa Game).
         * 2. Comparatora, jeśli jest przekazany jako drugi argument.
         *
         * ZADANIE: Zmieniamy TreeSet na ArrayList, sortujemy według TYTUŁU (nowy naturalny porządek)
         * i używamy Collections.reverseOrder() do sortowania malejącego po tytule.
         */
        static class Game implements Comparable<Game> {
            String title;
            int year;

            public Game(String title, int year) {
                this.title = title;
                this.year = year;
            }

            @Override
            public String toString() {
                return title + " (" + year + ")";
            }

            @Override
            public int compareTo(Game other) {
                return Integer.compare(this.year, other.year);
            }
        }

    public static void main(String[] args) {
        List<Game> gameList = new ArrayList<>();
        gameList.add(new Game("Cyberpunk 2077", 2020));
        gameList.add(new Game("Wiedźmin 3: Dziki Gon", 2015));
        gameList.add(new Game("StarCraft", 1998));
        gameList.add(new Game("Doom", 1993));

        System.out.println("Lista gier przed sortowaniem:\n" + gameList);
        System.out.println("----------------------------------------------");

        Collections.sort(gameList);
        System.out.println("1. Po Collections.sort() (rosnąco po roku wydania):\n" + gameList);

        System.out.println("----------------------------------------------");

        Collections.sort(gameList, Collections.reverseOrder());
        System.out.println("2. Po Collections.sort() z reverseOrder() (malejąco po roku wydania):\n" + gameList);
    }

    class Zadanie8{
        /*
         * Różnice między Mapami:
         * 1. HashMap: Najszybsza (O(1)), brak gwarancji kolejności kluczy.
         * 2. LinkedHashMap: Szybka (O(1)), ale zachowuje kolejność wstawiania kluczy.
         * 3. TreeMap: Najwolniejsza (O(log N)), ale klucze są automatycznie posortowane.
         * * Najszybciej działa HashMap, ponieważ opiera się na haszowaniu kluczy.
         */
    }
}
