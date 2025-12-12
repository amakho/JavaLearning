package Zadania.semestr2.PersonalAplikation;

import java.util.ArrayList;
import java.util.List;

class MenuItem {
    private final String name;
    private final double price;
    private final boolean isDeliveryAvailable;

    public MenuItem(String name, double price, boolean isDeliveryAvailable) {
        this.name = name;
        this.price = price;
        this.isDeliveryAvailable = isDeliveryAvailable;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        String deliveryInfo = isDeliveryAvailable ? "(Delivery)" : "(Only inside)";
        return String.format("%-25s | %6.2f PLN | %s", name, price, deliveryInfo);
    }
}

public class Menu {
    private final List<MenuItem> restaurantMenu;
    private final List<MenuItem> deliveryMenu;

    public Menu() {
        this.restaurantMenu = new ArrayList<>();
        this.deliveryMenu = new ArrayList<>();

        // Automatyczne załadowanie dań przy starcie
        initializeDefaultMenu();
    }

    private void initializeDefaultMenu() {
        addToRestaurant(new MenuItem("Pizza Margherita", 32.00, true)); // true = też na dowóz
        addToRestaurant(new MenuItem("Pizza New York", 35.00, true));
        addToRestaurant(new MenuItem("Zupa Dnia", 12.00, false));
        addToRestaurant(new MenuItem("Coca Cola",8.00, true));// false = tylko lokal

        addToDelivery(new MenuItem("Burger Chicago", 24.00, true));
        addToDelivery(new MenuItem("Burger Vege", 21.00, true));
        addToDelivery(new MenuItem("Burger Cheese",25.00,true));
    }

    public void addToRestaurant(MenuItem item) {
        restaurantMenu.add(item);
    }

    public void addToDelivery(MenuItem item) {
        deliveryMenu.add(item);
    }

    public void printRestaurantMenu() {
        System.out.println("\n--- MENU W LOKALU ---");
        for (MenuItem item : restaurantMenu) {
            System.out.println(item);
        }
    }

    public void printDeliveryMenu() {
        System.out.println("\n--- MENU NA DOWÓZ ---");
        for (MenuItem item : deliveryMenu) {
            System.out.println(item);
        }
    }

    public MenuItem findItem(String name) {
        for (MenuItem item : restaurantMenu) {
            if (item.getName().equalsIgnoreCase(name)) return item;
        }
        for (MenuItem item : deliveryMenu) {
            if (item.getName().equalsIgnoreCase(name)) return item;
        }
        return null;
    }
    public MenuItem getRestaurantItem(int index) {
        if (index >= 0 && index < restaurantMenu.size()) {
            return restaurantMenu.get(index);
        }
        return null;
    }

    public MenuItem getDeliveryItem(int index) {
        if (index >= 0 && index < deliveryMenu.size()) {
            return deliveryMenu.get(index);
        }
        return null;
    }

    public int getRestaurantMenuSize() {
        return restaurantMenu.size();
    }

    public int getDeliveryMenuSize() {
        return deliveryMenu.size();
    }
}