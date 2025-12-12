package AppwithSQL.PersonalAplikation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ResaturantSystem {
    private List<Table> tables = new ArrayList<>();

    public void addTables(Table s){
        tables.add(s);
    }
    public void createReservation(Client c, int nrOfTable, boolean isParty){
        Table selected = null;
        for (Table s : tables){
            if (s.getNumber() == nrOfTable && s.isFree()){
                selected = s;
                break;
            }
        }
        if (selected == null){
            System.out.println("Table is not available");
            return;
        }
        Reservation newReservation;
        if (isParty){
            newReservation =  new ReservationForParty(c, selected, LocalDateTime.now());
            ((ReservationForParty) newReservation).paidAvance();
        } else {
            newReservation = new ReservationForCouple(c,selected,LocalDateTime.now());
        }
        newReservation.confirmReservation();
        c.addToHistory(newReservation);
    }
}
