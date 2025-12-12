package AppwithSQL.PersonalAplikation;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private final String name;
    private final String phone;
    private final List<Reservation> reservationsHistory;

    public Client(String name, String phone){
        this.name = name;
        this.phone = phone;
        this.reservationsHistory = new ArrayList<>();
    }

    public String getName(){
        return name;
    }
    public String getPhone(){
        return phone;
    }

    public void addToHistory(Reservation reservation){
        reservationsHistory.add(reservation);
    }
}
