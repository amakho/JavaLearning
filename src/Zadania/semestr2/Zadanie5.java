package Zadania.semestr2;

public class Zadanie5 {
    /*Wybór między **ArrayList** a **LinkedList** zależy od przewagi operacji:
      **ArrayList** jest szybsza do **odczytu** elementów z losowych pozycji
      * dzięki implementacji opartej na tablicy (**dostęp O(1)**),
      * natomiast **LinkedList** jest wydajniejsza przy częstym **dodawaniu i usuwaniu** elementów,
      * zwłaszcza na końcach listy, ponieważ oparta jest na dwukierunkowej liście połączonej
      * (**dodawanie/usuwanie O(1)** po znalezieniu pozycji).*/

    class Zadanie6{
        /*
         * Różnice między Setami (poza tym, że przechowują tylko unikalne elementy):
         * 1. HashSet: Jest najszybszy (O(1)) i nie gwarantuje żadnej kolejności.
         * 2. LinkedHashSet: Jest prawie tak samo szybki (O(1)), ale zachowuje kolejność wstawiania (insertion order).
         * 3. TreeSet: Jest najwolniejszy (O(log N)), ale automatycznie sortuje elementy (naturalny porządek lub Comparator).
         *
         * Najszybciej będzie działać HashSet, ponieważ bazuje na tablicy hashującej, oferując stały czas (O(1)) dostępu i modyfikacji,
         * kosztem braku gwarancji kolejności.
         */

    }
}

