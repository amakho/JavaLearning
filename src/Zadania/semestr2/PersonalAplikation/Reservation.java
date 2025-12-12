package Zadania.semestr2.PersonalAplikation;

import java.time.LocalDateTime;

abstract class Reservation {
    protected Client client;
    protected Table table;
    protected LocalDateTime dateTime;

    public Reservation(Client client,Table table, LocalDateTime dateTime){
        this.client = client;
        this.table = table;
        this.dateTime = dateTime;
    }

    public abstract void confirmReservation();
}
class ReservationForCouple extends Reservation{
    public ReservationForCouple(Client client, Table table, LocalDateTime dateTime){
        super(client,table,dateTime);
    }

    @Override
    public void confirmReservation() {
        System.out.println("Your reservation for 2 person is confirmed. \n Client " + client.getName());
        table.setFree(false);
    }
}
class ReservationForParty extends Reservation{
    private boolean depositPaid;

    public ReservationForParty(Client client,Table table,LocalDateTime dateTime){
        super(client,table,dateTime);
        this.depositPaid = false;
    }
    public void paidAvance(){
        this.depositPaid = true;
        System.out.println("Deposit is paided");
    }

    @Override
    public void confirmReservation() {
        if (depositPaid){
            System.out.println("Party confirm");
            table.setFree(false);
        } else {
            System.out.println("Please, make a payment!");
        }
    }
}
