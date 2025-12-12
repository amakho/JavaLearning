package AppwithSQL.PersonalAplikation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReservationApp {
    private static final String URL = "jdbc:postgresql://localhost:5432/restaurant";
    private static final String USER = "postgres";
    private static final String PASSWORD = "admin";

     static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("✅ Połączono z bazą danych.");
            Scanner scanner = new Scanner(System.in);

            System.out.println("\n--- WITAJ W SYSTEMIE RESTAURACJI ---");

            // --- 1. DANE KLIENTA I HISTORIA (NAPRAWIONE) ---
            System.out.print("Podaj swoje imię: ");
            String name = scanner.nextLine();

            // WALIDACJA NUMERU TELEFONU (Tylko cyfry)
            String phone;
            while (true) {
                System.out.print("Podaj numer telefonu (tylko cyfry): ");
                String input = scanner.nextLine();
                if (input.matches("\\d{9}")) { // Sprawdza czy są same cyfry
                    phone = input;
                    break;
                } else {
                    System.out.println("❌ Błąd! Numer może zawierać tylko cyfry. Spróbuj ponownie.");
                }
            }

            Client client = new Client(name, phone);

            // SPRAWDZAMY HISTORIĘ W BAZIE
            pokazHistorieKlienta(connection, phone);


            String orderType;
            String address = null;
            int tables = 0;
            boolean isParty = false;
            Order orderProcessor;

            System.out.println("\nWybierz tryb zamówienia:");
            System.out.println("1. 🛵 Dostawa do domu");
            System.out.println("2. 🍽️ W Lokalu (Rezerwacja)");
            System.out.print("Twój wybór: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                orderType = "DELIVERY";
                System.out.print("Podaj adres dostawy: ");
                address = scanner.nextLine();

                String finalAddress = address;
                orderProcessor = (contentOrders) -> {
                    try {
                        System.out.println("\n--- PRZETWARZANIE DOSTAWY ---");
                        System.out.println("Restauracja: Pakowanie zamówienia " + contentOrders);
                        Thread.sleep(2500);
                        System.out.println("Kurier: Jadę pod adres: " + finalAddress);
                        Thread.sleep(4000);
                        System.out.println("Kurier: Dostarczono! Smacznego.");
                    } catch (InterruptedException e) { e.printStackTrace(); }
                };

            } else if (choice.equals("2")) {
                // --- LOGIKA LOKALU (NAPRAWIONE STOLIKI) ---
                orderType = "DINE_IN";

                System.out.println("\nWybierz rodzaj rezerwacji:");
                System.out.println("A. Para (Automatycznie 1 stolik)");
                System.out.println("B. Rodzina (2-3 stoliki)");
                System.out.println("C. Party / Impreza (Więcej niż 3 stoliki)");
                System.out.print("Twój wybór (A/B/C): ");
                String tableChoice = scanner.nextLine().toUpperCase();

                switch (tableChoice) {
                    case "A": // PARA
                        tables = 1;
                        System.out.println("✅ Zarezerwowano 1 stolik dla pary.");
                        break;

                    case "B": // RODZINA
                        while (true) {
                            System.out.print("Ile stolików dla rodziny (2-3)?: ");
                            try {
                                int t = Integer.parseInt(scanner.nextLine());
                                if (t >= 2 && t <= 3) {
                                    tables = t;
                                    break;
                                } else {
                                    System.out.println("❌ Dla rodziny wybierz 2 lub 3 stoliki (dla 1 wybierz Parę).");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Wpisz cyfrę.");
                            }
                        }
                        break;

                    case "C": // PARTY
                        isParty = true;
                        while (true) {
                            System.out.print("Ile stolików na imprezę (>3)?: ");
                            try {
                                int t = Integer.parseInt(scanner.nextLine());
                                if (t > 3) {
                                    tables = t;
                                    break;
                                } else {
                                    System.out.println("❌ Impreza zaczyna się powyżej 3 stolików.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Wpisz cyfrę.");
                            }
                        }
                        System.out.println("ℹ️ Uwaga: Przy imprezach wymagana może być kaucja.");
                        break;

                    default:
                        System.out.println("Nieznana opcja. Ustawiam domyślnie 1 stolik.");
                        tables = 1;
                }

                int finalTables = tables;
                orderProcessor = (contentOrders) -> {
                    try {
                        System.out.println("\n--- OBSŁUGA REZERWACJI ---");
                        System.out.println("Kelner: Sprawdzam dostępność " + finalTables + " stolików...");
                        Thread.sleep(1000);
                        System.out.println("Kelner: Zapraszamy do stolika!");
                        Thread.sleep(4000);
                        System.out.println("Kuchnia: Dania (" + contentOrders + ") są gotowe.");
                        Thread.sleep(1500);
                        System.out.println("Kelner: Smacznego!");
                    } catch (InterruptedException e) { e.printStackTrace(); }
                };

            } else {
                System.out.println("Nieprawidłowy wybór.");
                return;
            }

            // --- 3. MENU I ZAMAWIANIE ---
            List<MenuItem> dbMenu = loadMenuFromDatabase(connection, orderType);
            List<MenuItem> cart = new ArrayList<>();
            double total = 0;

            while (true) {
                System.out.println("\n--- MENU ---");
                for (int i = 0; i < dbMenu.size(); i++) {
                    System.out.println((i + 1) + ". " + dbMenu.get(i).toString());
                }
                System.out.println("0. Zakończ i zapłać");
                System.out.print("Wybierz numer: ");

                String input = scanner.nextLine();

                if (input.contains(",") || input.contains(" ")) {
                    System.out.println("⚠️ Wybieraj dania POJEDYNCZO! (jedno po drugim)");
                    scanner.nextLine();
                    continue;
                }

                try {
                    int itemIndex = Integer.parseInt(input) - 1;
                    if (itemIndex == -1) break;

                    if (itemIndex >= 0 && itemIndex < dbMenu.size()) {
                        MenuItem selected = dbMenu.get(itemIndex);
                        cart.add(selected);
                        total += selected.price();
                        System.out.println("✅ Dodano: " + selected.name());
                    } else {
                        System.out.println("❌ Nieprawidłowy numer.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("❌ To nie jest liczba.");
                }
            }

            if (cart.isEmpty()) {
                System.out.println("Koszyk pusty. Do widzenia.");
                return;
            }

            saveOrderToDatabase(connection, orderType, client, address, tables, isParty, total, cart);

            StringBuilder orderSummary = new StringBuilder();
            for(MenuItem item : cart) {
                orderSummary.append(item.name()).append(", ");
            }
            if (orderSummary.length() > 2) orderSummary.setLength(orderSummary.length() - 2);

            orderProcessor.processOrder(orderSummary.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void pokazHistorieKlienta(Connection conn, String phone) throws SQLException {
        String sql = "SELECT * FROM client_orders WHERE client_phone = ? ORDER BY order_date DESC";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, phone);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("\n🔍 Sprawdzam historię klienta...");
            boolean found = false;

            // Formatowanie tabeli w konsoli
            System.out.println("-------------------------------------------------------------");
            System.out.printf("| %-10s | %-12s | %-20s | %-8s |\n", "TYP", "DATA", "SZCZEGÓŁY", "KWOTA");
            System.out.println("-------------------------------------------------------------");

            while (rs.next()) {
                found = true;
                String type = rs.getString("order_type");
                Timestamp date = rs.getTimestamp("order_date");
                double price = rs.getDouble("total_price");
                String details;

                if ("DELIVERY".equals(type)) {
                    details = "Adres: " + rs.getString("delivery_address");
                } else {
                    details = "Stolików: " + rs.getInt("number_of_tables") + (rs.getBoolean("is_party") ? " (Party)" : "");
                }

                // Skracanie adresu/szczegółów, żeby tabela się nie rozjechała
                if (details.length() > 20) details = details.substring(0, 17) + "...";

                System.out.printf("| %-10s | %-12s | %-20s | %-8.2f |\n",
                        type,
                        date.toLocalDateTime().toLocalDate(), // Pokazujemy tylko datę bez godziny dla czytelności
                        details,
                        price);
            }
            System.out.println("-------------------------------------------------------------");

            if (!found) {
                System.out.println("👋 To Twoja pierwsza wizyta! Witamy.");
            } else {
                System.out.println("👋 Witaj ponownie!");
            }
        }
    }

    private static List<MenuItem> loadMenuFromDatabase(Connection conn, String orderType) throws SQLException {
        List<MenuItem> menu = new ArrayList<>();
        String sql = "SELECT * FROM menu_items";
        if (orderType.equals("DELIVERY")) {
            sql += " WHERE is_delivery_available = TRUE";
        }
        sql += " ORDER BY id";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                menu.add(new MenuItem(rs.getString("name"), rs.getDouble("price"), rs.getBoolean("is_delivery_available")));
            }
        }
        return menu;
    }

    private static void saveOrderToDatabase(Connection conn, String type, Client client, String address, int tables, boolean isParty, double total, List<MenuItem> cart) throws SQLException {
        String insertOrderSQL = "INSERT INTO client_orders (order_type, client_name, client_phone, delivery_address, number_of_tables, is_party, total_price) VALUES (?, ?, ?, ?, ?, ?, ?) RETURNING id";

        try (PreparedStatement pstmt = conn.prepareStatement(insertOrderSQL)) {
            pstmt.setString(1, type);
            pstmt.setString(2, client.getName());
            pstmt.setString(3, client.getPhone());
            pstmt.setString(4, address);
            pstmt.setInt(5, tables);
            pstmt.setBoolean(6, isParty);
            pstmt.setDouble(7, total);

            pstmt.execute();
            ResultSet rs = pstmt.getResultSet();
            rs.next();
            int orderId = rs.getInt(1);

            String insertItemSQL = "INSERT INTO order_items (order_id, menu_item_id, quantity) VALUES (?, (SELECT id FROM menu_items WHERE name = ? LIMIT 1), ?)";
            try (PreparedStatement pstmtItem = conn.prepareStatement(insertItemSQL)) {
                for (MenuItem item : cart) {
                    pstmtItem.setInt(1, orderId);
                    pstmtItem.setString(2, item.name());
                    pstmtItem.setInt(3, 1);
                    pstmtItem.addBatch();
                }
                pstmtItem.executeBatch();
            }
        }
    }
}

