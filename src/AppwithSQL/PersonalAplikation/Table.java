package AppwithSQL.PersonalAplikation;

class Table {
    private final int number;
    private boolean Free;

    public Table(int number){
        this.number = number;
        this.Free = true;
    }

    public int getNumber() {
        return number;
    }

    public boolean isFree() {
        return Free;
    }
    public void setFree(){
        this.Free = isFree();
    }
}
