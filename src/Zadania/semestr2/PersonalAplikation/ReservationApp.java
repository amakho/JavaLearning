package Zadania.semestr2.PersonalAplikation;
import java.util.Scanner;

public class ReservationApp {
    private static final Scanner scanner = new Scanner(System.in);

     static void main(String[] args) {
         // --- 1. INICJALIZACJA SYSTEMU ---
         ResaturantSystem system = new ResaturantSystem();
         Menu menu = new Menu();

         // Dodajemy stoliki do systemu (symulacja bazy danych)
         system.addTables(new Table(1, 2));  // Stolik 2-osobowy
         system.addTables(new Table(2, 4));  // Stolik 4-osobowy
         system.addTables(new Table(3, 6));  // Stolik 6-osobowy

         System.out.println("=========================================");
         System.out.println("   WITAJ W SYSTEMIE RESTAURACJI OOP");
         System.out.println("=========================================");

         // --- 2. LOGOWANIE / TWORZENIE KLIENTA ---
         Client currentClient = null;

         // Pętla wymusza podanie poprawnych danych
         while (currentClient == null) {
             try {
                 System.out.println("\n>> REJESTRACJA KLIENTA");
                 System.out.print("Podaj imię i nazwisko: ");
                 String name = scanner.nextLine();

                 System.out.print("Podaj numer telefonu (9 cyfr): ");
                 String phone = scanner.nextLine();

                 // Tu zadziała Twoja walidacja z klasy Client
                 currentClient = new Client(name, phone);
                 System.out.println("--> Sukces! Zalogowano jako: " + currentClient.getName());

             } catch (IllegalArgumentException e) {
                 System.out.println("BŁĄD: " + e.getMessage());
                 System.out.println("Spróbuj ponownie...");
             }
         }

         // --- 3. GŁÓWNA PĘTLA PROGRAMU ---
         boolean isRunning = true;

         while (isRunning) {
             System.out.println("\n============== MENU GŁÓWNE ==============");
             System.out.println("1. Zarezerwuj stolik (Rezerwacja)");
             System.out.println("2. Zamów jedzenie do stolika (JESTEM W LOKALU)");
             System.out.println("3. Zamów na wynos (Odbiór osobisty)");
             System.out.println("4. Zamów z dostawą (Delivery)");
             System.out.println("5. Pokaż historię");
             System.out.println("-----------------------------------------");
             System.out.println("0. Wyjście");
             System.out.print("Twój wybór: ");

             String choice = scanner.nextLine();

             switch (choice) {
                 case "1":
                     handleReservation(system, currentClient);
                     break;
                 case "2":
                     handleOrderAtTable(menu);
                     break;
                 case "3":
                     handleTakeaway(menu, currentClient);
                     break;
                 case "4":
                     handleDelivery(menu);
                     break;
                 case "5":
                     showHistory(currentClient);
                     break;
                 case "0":
                     isRunning = false;
                     System.out.println("\nDo widzenia!");
                     break;
                 default:
                     System.out.println("Nie ma takiej opcji.");
             }
         }
     }


    private static void printMainMenu() {
        System.out.println("\n============== MENU GŁÓWNE ==============");
        System.out.println("1. Zarezerwuj stolik (Na miejscu)");
        System.out.println("2. Zamów na wynos (Odbiór osobisty)");
        System.out.println("3. Zamów z dostawą (Delivery)");
        System.out.println("4. Pokaż historię rezerwacji");
        System.out.println("-----------------------------------------");
        System.out.println("0. Wyjście");
        System.out.print("Twój wybór: ");
    }

    private static void handleReservation(ResaturantSystem system, Client client) {
        System.out.println("\n--- REZERWACJA STOLIKA ---");
        System.out.println("Dostępne stoliki: nr 1 (2os), nr 2 (4os), nr 3 (6os)");
        System.out.print("Wybierz numer stolika: ");

        int tableNr = getIntInput();
        if (tableNr == -1) return; // Wyjście jeśli błąd

        System.out.println("Rodzaj rezerwacji:");
        System.out.println("1 - Zwykła kolacja");
        System.out.println("2 - Impreza (Party) - wymagana zaliczka");
        System.out.print("Wybór: ");

        String typeChoice = scanner.nextLine();
        boolean isParty = typeChoice.equals("2");

        // Wywołanie logiki systemu (to tutaj sprawdzane jest czy stolik wolny)
        system.createReservation(client, tableNr, isParty);
    }
    private static void handleOrderAtTable(Menu menu) {
        System.out.println("\n--- ZAMÓWIENIE DO STOLIKA ---");

        // 1. Pytamy o numer stolika (to idzie do OrderInside)
        System.out.print("Przy jakim stoliku siedzisz? Podaj numer: ");
        int tableNr = getIntInput();
        if (tableNr <= 0) return;

        // 2. Wybieramy jedzenie
        System.out.println("Co podać?");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < menu.getRestaurantMenuSize(); i++) {
            System.out.println((i + 1) + ". " + menu.getRestaurantItem(i));
        }

        System.out.print("Wybierz numer dania: ");
        int choice = getIntInput();

        if (choice > 0 && choice <= menu.getRestaurantMenuSize()) {
            MenuItem item = menu.getRestaurantItem(choice - 1);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


            OrderInside order = new OrderInside(tableNr);

            order.processOrder(item.getName());

        } else {
            System.out.println("Nie ma takiego dania.");
        }
    }

    private static void handleTakeaway(Menu menu, Client client) {
        System.out.println("\n--- ZAMÓWIENIE NA WYNOS (ODBIÓR) ---");

        for (int i = 0; i < menu.getRestaurantMenuSize(); i++) {
            System.out.println((i + 1) + ". " + menu.getRestaurantItem(i));
        }

        System.out.print("Wybierz numer dania: ");
        int choice = getIntInput();

        if (choice > 0 && choice <= menu.getRestaurantMenuSize()) {
            MenuItem item = menu.getRestaurantItem(choice - 1); // -1 bo lista jest od 0


            OrderOutside order = new OrderOutside(client.getPhone());
            order.processOrder(item.getName());
        } else {
            System.out.println("Błąd: Nie ma takiego numeru w menu.");
        }
    }

    private static void handleDelivery(Menu menu) {
        System.out.println("\n--- ZAMÓWIENIE Z DOSTAWĄ ---");

        // Wyświetlanie menu delivery z numerkami
        for (int i = 0; i < menu.getDeliveryMenuSize(); i++) {
            System.out.println((i + 1) + ". " + menu.getDeliveryItem(i));
        }

        System.out.print("Wybierz numer dania: ");
        int choice = getIntInput();

        if (choice > 0 && choice <= menu.getDeliveryMenuSize()) {
            MenuItem item = menu.getDeliveryItem(choice - 1);

            System.out.print("Podaj adres dostawy: ");
            String address = scanner.nextLine();

            DeliveryOrder order = new DeliveryOrder(address);
            order.processOrder(item.getName());
        } else {
            System.out.println("Błąd: Nie ma takiego numeru w menu.");
        }
    }

    private static void showHistory(Client client) {
        System.out.println("\n--- HISTORIA KLIENTA ---");
        System.out.println("Klient: " + client.getName());
        System.out.println("Telefon: " + client.getPhone());
        System.out.println("(Szczegóły rezerwacji są przechowywane wewnątrz obiektu Client)");
        System.out.println("Potwierdzenie: Rezerwacje zostały zapisane w pamięci.");
    }

    private static int getIntInput() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Błąd! Musisz wpisać liczbę.");
            return -1;
        }
    }
}