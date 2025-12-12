package Zadania.semestr2.PersonalAplikation;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String name;
    private String phone;
    private List<Reservation> reservationsHistory;

    public Client(String name, String phone){
        if (!phone.matches("\\d{9}")){
            throw new IllegalArgumentException("Błąd: Numer telefonu musi składać się z 9 cyfr!");
        }
        this.name = name;
        this.phone = phone;
        this.reservationsHistory = new ArrayList<>();
    }

    public String getName(){
        return name;
    }
    public String getPhone(){return phone;
    }

    public void addToHistory(Reservation reservation){
        reservationsHistory.add(reservation);
        System.out.println(reservationsHistory);
    }
}
