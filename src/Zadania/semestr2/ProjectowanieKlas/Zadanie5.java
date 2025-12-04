package Zadania.semestr2.ProjectowanieKlas;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


class Autor implements Serializable {
    private String imie;
    private String nazwisko;

    public Autor(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public String getImie() { return imie; }
    public String getNazwisko() { return nazwisko; }

    public String pelneImie() {
        return imie + " " + nazwisko;
    }

    @Override
    public String toString() {
        return pelneImie();
    }
}

class Recenzja implements Serializable {
    private String komentarz;
    private int ocena; // 1-10
    private LocalDate dataDodania;

    public Recenzja(String komentarz, int ocena) {
        this.komentarz = komentarz;
        this.ocena = ocena;
        this.dataDodania = LocalDate.now();
    }

    public int getOcena() { return ocena; }

    @Override
    public String toString() {
        return "Ocena: " + ocena + "/10 (" + dataDodania + ") - " + komentarz;
    }
}


class Ksiazka implements Serializable {
    private static int nextId = 1;

    private int id;
    private String tytul;
    private Autor autor;
    private int rokWydania; // Punkt C
    private List<Recenzja> recenzje = new ArrayList<>();
    private boolean wypozyczona = false;

    public Ksiazka(String tytul, Autor autor, int rokWydania) {
        this.id = nextId++; // Automatyczne nadawanie ID
        this.tytul = tytul;
        this.autor = autor;
        this.rokWydania = rokWydania;
    }

    public void dodajRecenzje(Recenzja r) {
        recenzje.add(r);
    }

    public double pobierzSredniaOcene() {
        if (recenzje.isEmpty()) return 0.0;
        double suma = 0;
        for (Recenzja r : recenzje) {
            suma += r.getOcena();
        }
        return suma / recenzje.size();
    }

    public int getId() { return id; }
    public String getTytul() { return tytul; }
    public Autor getAutor() { return autor; }
    public List<Recenzja> getRecenzje() { return recenzje; }
    public boolean isWypozyczona() { return wypozyczona; }
    public void setWypozyczona(boolean stan) { this.wypozyczona = stan; }

    @Override
    public String toString() {
        return "ID: " + id + " | \"" + tytul + "\" (" + rokWydania + ") - " + autor.pelneImie() +
                (wypozyczona ? " [WYPOŻYCZONA]" : " [DOSTĘPNA]");
    }
}

class WpisHistorii {
    private String opis;
    private LocalDateTime dataCzas;

    public WpisHistorii(String opis) {
        this.opis = opis;
        this.dataCzas = LocalDateTime.now(); // Zapisujemy bieżący czas
    }

    public LocalDateTime getDataCzas() {
        return dataCzas;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "[" + dataCzas.format(formatter) + "] " + opis;
    }
}


public class Zadanie5 {
    static List<Ksiazka> ksiazki = new ArrayList<>();
    static List<WpisHistorii> historia = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        zainicjujDane();

        boolean dziala = true;
        while (dziala) {
            System.out.println("\n=== SYSTEM BIBLIOTECZNY ===");
            System.out.println("1. Wyświetl wszystkie książki");
            System.out.println("2. Dodaj nową książkę (Punkt C)");
            System.out.println("3. Szukaj książek po Autorze (Punkt A)");
            System.out.println("4. Szczegóły książki (Recenzje/Średnia) (Punkt B)");
            System.out.println("5. Wypożycz / Zwróć książkę");
            System.out.println("6. Pokaż całą historię (Punkt D)");
            System.out.println("7. Pokaż historię z danego dnia (Punkt E)");
            System.out.println("0. Wyjdź");
            System.out.print("Wybierz opcję: ");

            String wybor = scanner.nextLine();

            switch (wybor) {
                case "1":
                    wyswietlKsiazki(ksiazki);
                    break;
                case "2":
                    dodajKsiazke();
                    break;
                case "3":
                    filtrujPoAutorze();
                    break;
                case "4":
                    pokazSzczegolyRecenzji();
                    break;
                case "5":
                    zmienStatusKsiazki();
                    break;
                case "6":
                    historia.forEach(System.out::println);
                    break;
                case "7":
                    pokazHistorieZDanegoDnia();
                    break;
                case "0":
                    dziala = false;
                    break;
                default:
                    System.out.println("Nieznana opcja.");
            }
        }
    }


    static void filtrujPoAutorze() {
        System.out.print("Podaj nazwisko autora: ");
        String szukaneNazwisko = scanner.nextLine().toLowerCase();

        List<Ksiazka> znalezione = ksiazki.stream()
                .filter(k -> k.getAutor().getNazwisko().toLowerCase().contains(szukaneNazwisko))
                .collect(Collectors.toList());

        if (znalezione.isEmpty()) {
            System.out.println("Nie znaleziono książek tego autora.");
        } else {
            System.out.println("Znalezione książki:");
            wyswietlKsiazki(znalezione);
        }
    }

    // Punkt B: Wyświetlenie średniej i komentarzy
    static void pokazSzczegolyRecenzji() {
        System.out.print("Podaj ID książki: ");
        int id = Integer.parseInt(scanner.nextLine());
        Ksiazka k = znajdzKsiazke(id);

        if (k != null) {
            System.out.println("\n--- Szczegóły: " + k.getTytul() + " ---");
            System.out.printf("Średnia ocena: %.2f / 10\n", k.pobierzSredniaOcene());
            System.out.println("Recenzje:");
            if (k.getRecenzje().isEmpty()) {
                System.out.println(" Brak recenzji.");
            } else {
                for (Recenzja r : k.getRecenzje()) {
                    System.out.println(" - " + r);
                }
            }
        } else {
            System.out.println("Nie ma książki o takim ID.");
        }
    }

    // Punkt C: Dodawanie książki z rokiem wydania i auto-ID
    static void dodajKsiazke() {
        System.out.print("Tytuł: ");
        String tytul = scanner.nextLine();
        System.out.print("Imię autora: ");
        String imie = scanner.nextLine();
        System.out.print("Nazwisko autora: ");
        String nazwisko = scanner.nextLine();
        System.out.print("Rok wydania: ");
        int rok = Integer.parseInt(scanner.nextLine());

        Ksiazka nowa = new Ksiazka(tytul, new Autor(imie, nazwisko), rok);
        ksiazki.add(nowa);
        rejestrujHistorie("Dodano nową książkę: " + tytul + " (ID: " + nowa.getId() + ")");
        System.out.println("Dodano książkę!");
    }

    // Punkt D: Logowanie operacji z czasem
    static void zmienStatusKsiazki() {
        System.out.print("Podaj ID książki: ");
        int id = Integer.parseInt(scanner.nextLine());
        Ksiazka k = znajdzKsiazke(id);

        if (k != null) {
            if (k.isWypozyczona()) {
                k.setWypozyczona(false);
                rejestrujHistorie("Zwrócono książkę: " + k.getTytul() + " (ID: " + id + ")");
                System.out.println("Książka zwrócona.");
            } else {
                k.setWypozyczona(true);
                rejestrujHistorie("Wypożyczono książkę: " + k.getTytul() + " (ID: " + id + ")");
                System.out.println("Książka wypożyczona.");
            }
        } else {
            System.out.println("Błędne ID.");
        }
    }

    // Punkt E: Historia z dnia
    static void pokazHistorieZDanegoDnia() {
        System.out.print("Podaj datę (RRRR-MM-DD): ");
        String wejscie = scanner.nextLine();
        try {
            LocalDate szukanaData = LocalDate.parse(wejscie);

            System.out.println("Historia z dnia " + szukanaData + ":");
            boolean znaleziono = false;
            for (WpisHistorii wpis : historia) {
                if (wpis.getDataCzas().toLocalDate().equals(szukanaData)) {
                    System.out.println(wpis);
                    znaleziono = true;
                }
            }
            if (!znaleziono) System.out.println("Brak wpisów z tego dnia.");

        } catch (Exception e) {
            System.out.println("Błędny format daty! Użyj RRRR-MM-DD");
        }
    }

    static void rejestrujHistorie(String opis) {
        historia.add(new WpisHistorii(opis));
    }

    static Ksiazka znajdzKsiazke(int id) {
        for (Ksiazka k : ksiazki) {
            if (k.getId() == id) return k;
        }
        return null;
    }

    static void wyswietlKsiazki(List<Ksiazka> lista) {
        if (lista.isEmpty()) System.out.println("Lista pusta.");
        for (Ksiazka k : lista) {
            System.out.println(k);
        }
    }

    static void zainicjujDane() {
        Autor a1 = new Autor("Adam", "Mickiewicz");
        Autor a2 = new Autor("Henryk", "Sienkiewicz");
        Autor a3 = new Autor("Joan","Rowling");

        Ksiazka k1 = new Ksiazka("Pan Tadeusz", a1, 1834);
        k1.dodajRecenzje(new Recenzja("Nuda, ale klasyk.", 5));
        k1.dodajRecenzje(new Recenzja("Piękny język!", 10));

        Ksiazka k2 = new Ksiazka("Quo Vadis", a2, 1896);
        k2.dodajRecenzje(new Recenzja("Świetna historia.", 9));

        Ksiazka k3 = new Ksiazka("Dziady", a1, 1823);

        Ksiazka k4 = new Ksiazka("Harry Potter",a3, 1999);


        ksiazki.add(k1);
        ksiazki.add(k2);
        ksiazki.add(k3);
        ksiazki.add(k4);

        rejestrujHistorie("Zainicjowano system biblioteczny.");
    }
}
