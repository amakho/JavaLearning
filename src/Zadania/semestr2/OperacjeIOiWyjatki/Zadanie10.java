package Zadania.semestr2.OperacjeIOiWyjatki;

public class Zadanie10 {
    static void main() {
        Car myCar = new Car("Mclaren", 20);
        try {
            myCar.checkFuel(1);
            myCar.start();
        } catch (EmptyFuelTank e ){
            System.out.println("Problem "+ e.getMessage());
        }
    }
}
class EmptyFuelTank extends Exception{
    public EmptyFuelTank(String messege){
        super(messege);
    }
}

abstract class Vehicle {
    private String name;
    private int yourTankL;

    public Vehicle(String name, int yourTankL){
        this.name = name;
        this.yourTankL = yourTankL;
    }
    public String getName(){
        return name;
    }
    public int getYourTankL() {
        return yourTankL;
    }
    public void checkFuel(int FuelLitrs) throws EmptyFuelTank {
        if (FuelLitrs < 2){
            throw new EmptyFuelTank("Your tank in car " + name + " has only " + yourTankL +" liters");
        }
        System.out.println("Można jechać");
    }
    public abstract void start();
}
class Car extends Vehicle {
    public Car(String name,int yourTankL){
        super(name,yourTankL);
    }
    @Override
    public void start() {
        System.out.println("Dyr,dyr,dyr,....bruuuuum");
    }
}
class Bicycle extends Vehicle {
    public Bicycle(String name, int yourFuelL){
        super(name,0);
    }
    @Override
    public void start() {
        System.out.println("..........");
    }
}

