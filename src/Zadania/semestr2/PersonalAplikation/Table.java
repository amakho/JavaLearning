package Zadania.semestr2.PersonalAplikation;
 public class Table {
    private int number;
    private int countOfPlaces;
    private boolean Free;

    public Table(int number, int countOfPlaces){
        this.number = number;
        this.countOfPlaces = countOfPlaces;
        this.Free = true;
    }

    public int getNumber() {
        return number;
    }

    public boolean isFree() {
        return Free;
    }
    public void setFree(boolean isFree){
        this.Free = isFree;
    }
}